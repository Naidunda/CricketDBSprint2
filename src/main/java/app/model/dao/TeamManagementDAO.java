package app.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import app.connection.DBConnect;
import app.model.dto.PlayersDTO;
import app.model.dto.TeamPlayersDTO;
import app.model.dto.TeamsDTO;

public class TeamManagementDAO {

	// Method retrieves information about a specific team by its ID.
	public TeamsDTO getTeamInformation(String teamID) throws SQLException {
		TeamsDTO team = new TeamsDTO();

		// Initialize a database connection.
		DBConnect dbconnect = new DBConnect();
		
		 // Execute a SQL query to fetch team information based on the provided teamID.
		ResultSet rs = dbconnect.executeSelect("SELECT * FROM tblTeams WHERE Team_ID = \"" + teamID + "\";");

		if (rs.next()) {
			
			// Set team properties from the query results
			team.setTeamID(rs.getString("Team_ID"));
			team.setTeamName(rs.getString("Team_Name"));
			team.setAgeGroup(rs.getString("Age_Group"));
			team.setLocation(rs.getString("Location"));
			team.setClub(rs.getBoolean("isClub"));
		}
		return team;
	}
	
	 // Method retrieves information about all teams in the database.
	public ArrayList<TeamsDTO> getAllTeamInformation(String teamID) throws SQLException {
		ArrayList<TeamsDTO> teams = new ArrayList<TeamsDTO>();
		
		// Initialize a database connection.
		DBConnect dbconnect = new DBConnect();
		
		  // Execute a SQL query to fetch information about all teams.
		ResultSet rs = dbconnect.executeSelect("SELECT * FROM tblTeams");

		while (rs.next()) {
			TeamsDTO team = new TeamsDTO();
			
			// Set team properties from the query results
			team.setTeamID(rs.getString("Team_ID"));
			team.setTeamName(rs.getString("Team_Name"));
			team.setAgeGroup(rs.getString("Age_Group"));
			team.setLocation(rs.getString("Location"));
			team.setClub(rs.getBoolean("isClub"));

			teams.add(team);
		}
		return teams;
	}
	
	// Method retrieves information about players belonging to a specific team.
	public ArrayList<TeamPlayersDTO> getTeamPlayers(String teamID) throws SQLException {
		ArrayList<TeamPlayersDTO> players = new ArrayList<TeamPlayersDTO>();
		
		// Initialize a database connection.
		DBConnect dbconnect = new DBConnect();
		
		  // Execute a SQL query to fetch players belonging to the specified team.
		ResultSet rs = dbconnect.executeSelect("SELECT tblPlayers.Player_ID, Player_Name "
				+ "FROM tblPlayers, tblTeamPlayers "
				+ "WHERE VAL(tblPlayers.Player_ID) = VAL(tblTeamPlayers.Player_ID) AND Team_ID = \"" + teamID + "\";");

		while (rs.next()) {
			TeamPlayersDTO player = new TeamPlayersDTO();
			
			// Set player properties from the query results
			player.setPlayerID(rs.getString("Player_ID"));
			player.setPlayerName(rs.getString("Player_Name"));

			players.add(player);
		}

		return players;
	}

	//Method retrieves information about players who are not part of a specific team.
	 public ArrayList<TeamPlayersDTO> getNonTeamPlayers(String teamID) throws SQLException {
		 	ArrayList<TeamPlayersDTO> players = new ArrayList<TeamPlayersDTO>();
		 	
		 // Initialize a database connection.
			DBConnect dbconnect = new DBConnect();
			
			// Execute a SQL query to fetch players who are not part of the specified team.
			ResultSet rs = dbconnect.executeSelect("SELECT Player_ID, Player_Name FROM tblPlayers WHERE VAL(tblPlayers.Player_ID) <> ALL (SELECT VAL(Player_ID) FROM tblTeamPlayers WHERE Team_ID = \"" + teamID + "\");");
			
			while (rs.next()) {

				TeamPlayersDTO player = new TeamPlayersDTO();
				
				// Set player properties from the query results
				player.setPlayerID(rs.getString("Player_ID"));
				player.setPlayerName(rs.getString("Player_Name"));
	
				players.add(player);
				
			}
			return players;
	  }
}
