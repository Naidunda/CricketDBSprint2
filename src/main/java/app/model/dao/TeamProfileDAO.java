package app.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import app.connection.DBConnect;
import app.model.dto.MatchesDTO;
import app.model.dto.PlayerStatisticsDTO;
import app.model.dto.PlayersDTO;
import app.model.dto.TeamsDTO;

public class TeamProfileDAO {
	
	  // Method to retrieve team information based on team ID
	public TeamsDTO getTeamsInformation(String t_team_id) throws SQLException {
		
		TeamsDTO team = new TeamsDTO();
		
		// Create a database connection
		DBConnect dbconnect = new DBConnect();
		
		// Execute a SQL query to fetch team information
		ResultSet rs = dbconnect.executeSelect("SELECT * FROM tblTeams WHERE Team_ID = \"" + t_team_id + "\"");

		
		if (rs.next()) {
			// Set team properties based on query results
			team.setTeamID(rs.getString("Team_ID"));
			team.setTeamName(rs.getString("Team_Name"));
			team.setAgeGroup(rs.getString("Age_Group"));
			team.setLocation(rs.getString("Location"));
			team.setClub(rs.getBoolean("isClub"));
		}
		return team;
	}
	
	// Method to retrieve player statistics for a given team ID
	public ArrayList<PlayerStatisticsDTO> getPlayerStatistics(String t_team_id) throws SQLException {
		
		ArrayList<PlayerStatisticsDTO> players = new ArrayList<PlayerStatisticsDTO>();
		
		// Create a database connection
		DBConnect dbconnect = new DBConnect();
		
		// Execute a SQL query to fetch player IDs for the team
		ResultSet rs1= dbconnect.executeSelect("SELECT * FROM tblTeamPlayers WHERE Team_ID = \"" + t_team_id + "\";");
		
		while (rs1.next()) {
			// Retrieve player statistics for each player in the team
			ArrayList<PlayerStatisticsDTO> playerStats = new PlayersDAO().getAllPlayerStatistics(rs1.getString("Player_ID"));
			
			players.addAll(playerStats);
		}
		return players;
	}
	
	// Method to retrieve player information for a given team ID
	public ArrayList<PlayersDTO> getPlayerInformation(String t_team_id) throws SQLException {
		
		ArrayList<PlayersDTO> players = new ArrayList<PlayersDTO>();
		
		 // Create a database connection
		DBConnect dbconnect = new DBConnect();
		
		// Execute a SQL query to fetch player IDs for the team
		ResultSet rs1= dbconnect.executeSelect("SELECT * FROM tblTeamPlayers WHERE Team_ID = \"" + t_team_id + "\";");
		
		while (rs1.next()) {
			
			// Retrieve player information for each player in the team
			PlayersDTO player = new PlayersDAO().getPlayerProfile(rs1.getString("Player_ID"));
			
			players.add(player);
		}
		return players;
	}
	
	// Method to retrieve match information a player has played in based on match ID
	public ArrayList<MatchesDTO> getMatchInforation(String t_team_id) throws SQLException {

		ArrayList<MatchesDTO> matches = new ArrayList<MatchesDTO>();
		
		// Create a new database connection
		DBConnect dbconnect = new DBConnect();
		
		 // Execute a SQL query to retrieve match information for the team
		ResultSet rs = dbconnect.executeSelect(
				"SELECT DISTINCT tblMatches.Match_ID, Match_Date, Format, Team_1_ID, Team_2_ID, Toss_Winner_ID, Toss_Decision, Is_Result, Win_Type, Won_By, Match_Winner_ID, Innings_1_Total, Innings_1_Overs, Innings_1_Wickets, Innings_2_Total, Innings_2_Overs, Innings_2_Wickets "
						+ "FROM tblMatches, tblPlayerMatches "
						+ "WHERE Val(tblMatches.Match_ID) = Val(tblPlayerMatches.Match_ID) AND tblPlayerMatches.Team_ID = \""+t_team_id+"\";");

		while (rs.next()) {
			MatchesDTO match = new MatchesDTO();
			
			// Set match properties from the query results
			match.setMatchID(rs.getString("Match_ID"));
			match.setMatchDate(rs.getDate("Match_Date"));
			match.setFormat(rs.getString("Format"));
			match.setTeamID1(rs.getString("Team_1_ID"));
			match.setTeamID2(rs.getString("Team_2_ID"));
			match.setTossWinnerID(rs.getString("Toss_Winner_ID"));
			match.setTossDecision(rs.getString("Toss_Decision"));
			match.setResult(rs.getBoolean("Is_Result"));
			match.setWinType(rs.getString("Win_Type"));
			match.setWonBy(rs.getInt("Won_By"));
			match.setMatchWinnerID(rs.getString("Match_Winner_ID"));
			match.setInningsTotal1(rs.getInt("Innings_1_Total"));
			match.setInningsOvers1(rs.getString("Innings_1_Overs"));
			match.setInningsWickets1(rs.getInt("Innings_1_Wickets"));
			match.setInningsTotal2(rs.getInt("Innings_2_Total"));
			match.setInningsOvers2(rs.getString("Innings_2_Overs"));
			match.setInningsWickets2(rs.getInt("Innings_2_Wickets"));
			
			// Execute a SQL query to retrieves the team name of the match winner
			ResultSet rs2 = dbconnect.executeSelect(
					"SELECT Team_Name FROM tblTeams WHERE Team_ID = " + match.getMatchWinnerID() + ";");
			
			// Contructs a winner's message.
			if (rs2.next() && match.isResult() == true) {
				String tempStr = rs2.getString("Team_Name") + " won by " + match.getWonBy() + " ";
				if (match.getWinType().equals("By runs")) {
					tempStr += "runs.";
				} else {
					tempStr += "wickets.";
				}
				match.setWinMessage(tempStr);
			} else {
				match.setWinMessage("Match Cancelled");
			}
			
			//Execute a SQL query to retrieves the team name and age group of the first team.
			ResultSet rs3 = dbconnect.executeSelect(
					"SELECT Team_Name, Age_Group FROM tblTeams WHERE Team_ID = " + match.getTeamID1());

			if (rs3.next()) {
				// Set team name and age group properties from the query results
				match.setTeamName1(rs3.getString("Team_Name"));
				match.setTeamAgeGroup1(rs3.getString("Age_Group"));
			}
			
			//Execute a SQL query to retrieves the team name and age group of the second team.
			ResultSet rs4 = dbconnect.executeSelect(
					"SELECT Team_Name, Age_Group FROM tblTeams WHERE Team_ID = " + match.getTeamID2());

			if (rs4.next()) {
				// Set team name and age group properties from the query results
				match.setTeamName2(rs4.getString("Team_Name"));
				match.setTeamAgeGroup2(rs4.getString("Age_Group"));
			}

			matches.add(match);
		}
		return matches;
	}
}

