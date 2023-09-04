package app.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import app.connection.DBConnect;
import app.model.dto.FixturesDTO;
import app.model.dto.MatchesDTO;

public class MatchesDAO {
	
	// Method to retrieve match information based on a search string
	public ArrayList<MatchesDTO> getMatchInformation(String search) throws SQLException{
		
		ArrayList<MatchesDTO> matches = new ArrayList<MatchesDTO>();
		
		// Create a database connection
		DBConnect dbconnect = new DBConnect();
		
		// Execute a SQL query to fetch match information based on a search string
		ResultSet rs = dbconnect.executeSelect("SELECT DISTINCT Match_ID, Match_Date, Format, Team_1_ID, Team_2_ID, Toss_Winner_ID, Toss_Decision, Is_Result, Win_Type, Won_By, Match_Winner_ID, Innings_1_Total, Innings_1_Overs, Innings_1_Wickets, Innings_2_Total, Innings_2_Overs, Innings_2_Wickets "
				+ "FROM tblTeams, tblMatches "
				+ "WHERE (tblMatches.Team_1_ID +\"\" = tblTeams.Team_ID OR tblMatches.Team_2_ID+\"\" = tblTeams.Team_ID) AND tblTeams.Team_Name LIKE \"*"+search+"*\";");
		
		while(rs.next()) {
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
				//Execute a SQL query to retrieves the team name and age group of the second team.
				match.setTeamName2(rs4.getString("Team_Name"));
				match.setTeamAgeGroup2(rs4.getString("Age_Group"));
			}
			
			matches.add(match);
		}
		return matches;
	}
	
	public ArrayList<FixturesDTO> getFixtureInformation(String search) throws SQLException{
		ArrayList<FixturesDTO> fixtures = new ArrayList<FixturesDTO>();
		
		// Create a database connection
		DBConnect dbconnect = new DBConnect();
		
		// Execute a SQL query to fetch fixture information based on a search string
		ResultSet rs = dbconnect.executeSelect("SELECT DISTINCT Fixtures_ID, Match_Date, Format, Team_1_ID, Team_2_ID "
				+ "FROM tblFixtures, tblTeams "
				+ "WHERE (val(tblFixtures.Team_1_ID) = val( tblTeams.Team_ID)  OR val(tblFixtures.Team_2_ID) = val( tblTeams.Team_ID)) AND tblTeams.Team_Name LIKE \"*"+search+"*\"");
		
		while(rs.next()) {
			FixturesDTO fixture = new FixturesDTO();
			
			   // Set fixture properties based on query results
			fixture.setFixtureID(rs.getString("Fixtures_ID"));
			fixture.setMatchDate(rs.getDate("Match_Date"));
			fixture.setFormat(rs.getString("Format"));
			fixture.setTeamID1(rs.getString("Team_1_ID"));
			fixture.setTeamID2(rs.getString("Team_2_ID"));
			
			//Execute a SQL query to retrieves the team name and age group of the first team.
			ResultSet rs2 = dbconnect.executeSelect("SELECT Team_Name, Age_Group FROM tblTeams WHERE Team_ID = " + fixture.getTeamID1());
			
			if(rs2.next()) {
				// Set team name and age group properties from the query results
				fixture.setTeamName1(rs2.getString("Team_Name"));
				fixture.setTeamAgeGroup1(rs2.getString("Age_Group"));
			}
			
			ResultSet rs3 = dbconnect.executeSelect("SELECT Team_Name, Age_Group FROM tblTeams WHERE Team_ID = " + fixture.getTeamID2());
			
			//Execute a SQL query to retrieves the team name and age group of the second team.
			if(rs3.next()) {
				// Set team name and age group properties from the query results
				fixture.setTeamName2(rs3.getString("Team_Name"));
				fixture.setTeamAgeGroup2(rs3.getString("Age_Group"));
			}
			
			fixtures.add(fixture);
		}
		
		return fixtures;
		
	}
}
