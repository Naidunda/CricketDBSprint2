package app.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import app.connection.DBConnect;
import app.model.dto.PlayersDTO;
import app.model.dto.TeamPlayersDTO;
import app.model.dto.TeamsDTO;

public class TeamManagementDAO {

	public TeamsDTO getTeamInformation(String teamID) throws SQLException {
		TeamsDTO team = new TeamsDTO();

		DBConnect dbconnect = new DBConnect();
		ResultSet rs = dbconnect.executeSelect("SELECT * FROM tblTeams WHERE Team_ID = \"" + teamID + "\";");

		if (rs.next()) {
			team.setTeamID(rs.getString("Team_ID"));
			team.setTeamName(rs.getString("Team_Name"));
			team.setAgeGroup(rs.getString("Age_Group"));
			team.setLocation(rs.getString("Location"));
			team.setClub(rs.getBoolean("isClub"));
		}
		return team;
	}

	public ArrayList<TeamsDTO> getAllTeamInformation(String teamID) throws SQLException {
		ArrayList<TeamsDTO> teams = new ArrayList<TeamsDTO>();

		DBConnect dbconnect = new DBConnect();
		ResultSet rs = dbconnect.executeSelect("SELECT * FROM tblTeams");

		while (rs.next()) {
			TeamsDTO team = new TeamsDTO();

			team.setTeamID(rs.getString("Team_ID"));
			team.setTeamName(rs.getString("Team_Name"));
			team.setAgeGroup(rs.getString("Age_Group"));
			team.setLocation(rs.getString("Location"));
			team.setClub(rs.getBoolean("isClub"));

			teams.add(team);
		}
		return teams;
	}

	public ArrayList<TeamPlayersDTO> getTeamPlayers(String teamID) throws SQLException {
		ArrayList<TeamPlayersDTO> players = new ArrayList<TeamPlayersDTO>();

		DBConnect dbconnect = new DBConnect();
		ResultSet rs = dbconnect.executeSelect("SELECT tblPlayers.Player_ID, Player_Name "
				+ "FROM tblPlayers, tblTeamPlayers "
				+ "WHERE VAL(tblPlayers.Player_ID) = VAL(tblTeamPlayers.Player_ID) AND Team_ID = \"" + teamID + "\";");

		while (rs.next()) {
			TeamPlayersDTO player = new TeamPlayersDTO();

			player.setPlayerID(rs.getString("Player_ID"));
			player.setPlayerName(rs.getString("Player_Name"));

			players.add(player);
		}

		return players;
	}

	
	 public ArrayList<TeamPlayersDTO> getNonTeamPlayers(String teamID) throws SQLException {
		 	ArrayList<TeamPlayersDTO> players = new ArrayList<TeamPlayersDTO>();

			DBConnect dbconnect = new DBConnect();
			ResultSet rs = dbconnect.executeSelect("SELECT Player_ID, Player_Name FROM tblPlayers WHERE VAL(tblPlayers.Player_ID) <> ALL (SELECT VAL(Player_ID) FROM tblTeamPlayers WHERE Team_ID = \"" + teamID + "\");");
			

			while (rs.next()) {

				TeamPlayersDTO player = new TeamPlayersDTO();
	
				player.setPlayerID(rs.getString("Player_ID"));
				player.setPlayerName(rs.getString("Player_Name"));
	
				players.add(player);
				
			}
			
			System.out.println(players);

			return players;
	  }
}
