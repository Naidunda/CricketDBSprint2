package app.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

import app.connection.DBConnect;
import app.model.dto.BattingScorecardDTO;
import app.model.dto.BowlingScorecardDTO;
import app.model.dto.MatchesDTO;


public class MatchScorecardDAO {
	
	
	 // Method to retrieve a match details based on the match ID
	public MatchesDTO getMatchSummary(String s_match_id) throws SQLException{
		
		// Creates a database connection
		DBConnect dbconnect = new DBConnect();
		
		// Executes a SQL query to fetch match details
		ResultSet rs = dbconnect.executeSelect("Select * From tblMatches WHERE Match_ID = \""+s_match_id+"\";");
		MatchesDTO match = new MatchesDTO();
		
		if(rs.next()) {
			 // Set match properties based on query results
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
			
			 // Construct a win message based on match winner and match result
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
		}

		return match;
	}
	
	 // Method to retrieve batting scorecard data for a given match ID and innings
	public ArrayList<BattingScorecardDTO> getBattingScorecard(String s_match_id, int s_innings) throws SQLException{
		ArrayList<BattingScorecardDTO> batsmen = new ArrayList<BattingScorecardDTO>();
		
		// Create a database connection
		DBConnect dbconnect = new DBConnect();
		
		// Execute a SQL query to fetch batting scorecard data for the specified match ID and innings
		ResultSet rs = dbconnect.executeSelect(
				"SELECT * "
				+ "FROM tblBattingScorecards "
				+ "WHERE Dismissal_Type <> \"Did Not Bat\" "
				+ "AND Innings = " + s_innings + " AND Match_ID = \"" + s_match_id + "\" ORDER BY Batting_Position;");
		
		while(rs.next()) {
			BattingScorecardDTO batsman = new BattingScorecardDTO();
			
			// Set batsman's properties based on query results
			batsman.setMatchID(rs.getString("Match_ID"));
			batsman.setInnings(rs.getInt("Innings"));
			batsman.setBattingPosition(rs.getInt("Batting_Position"));
			batsman.setBatsmanID(rs.getString("Batsman_ID"));
			batsman.setDismissalType(rs.getString("Dismissal_Type"));
			batsman.setBowlerID(rs.getString("Bowler_ID"));
			batsman.setFielderID(rs.getString("Fielder_ID"));
			batsman.setRunsScored(rs.getInt("Runs_Scored"));
			batsman.setBallsFaced(rs.getInt("Balls_Faced"));
			batsman.setFours(rs.getInt("Fours"));
			batsman.setSixes(rs.getInt("Sixes"));
			
			batsman.setStrikeRate(rs.getString("Strike_Rate"));
			
			DecimalFormat f = new DecimalFormat("##.0");
			
			 // Calculate and set the batsman's strike rate
			if(batsman.getBallsFaced() != 0) {
				batsman.setStrikeRate(f.format((double) batsman.getRunsScored() / batsman.getBallsFaced() * 100)+"");
			} else {
				batsman.setStrikeRate("NA");
			}
			
			 // Exectues query to fetch batman's name 
			ResultSet rs2 = dbconnect.executeSelect(
									"SELECT Player_Name "
									+ "FROM tblPlayers "
									+ "WHERE Player_ID = \"" + batsman.getBatsmanID() +"\";");
			
			rs2.next();
			
			batsman.setBatsmanName(rs2.getString("Player_Name"));
			
			

            // Executes query to fetch fielder's name if available
			if(batsman.getFielderID() != null) {
				ResultSet rs3 = dbconnect.executeSelect(
							"SELECT Player_Name "
							+ "FROM tblPlayers "
							+ "WHERE Player_ID = \"" + batsman.getFielderID() +"\";");
				
				rs3.next();
				batsman.setFielderName(rs3.getString("Player_Name"));
			}
			
			
			// Executes query to fetch bowler's name if available
			if(batsman.getBowlerID() != null) {
				ResultSet rs4 = dbconnect.executeSelect(
							"SELECT Player_Name "
							+ "FROM tblPlayers "
							+ "WHERE Player_ID = \"" + batsman.getBowlerID() +"\";");
				
				rs4.next();
						
				batsman.setBowlerName(rs4.getString("Player_Name"));
			}
			
			// Construct dismissal message based on dismissal type
			if(batsman.getDismissalType().equals("Caught")) {
				batsman.setDismissalMessage("C " + batsman.getFielderName() + " B " + batsman.getBowlerName());
			} else if (batsman.getDismissalType().equals("Bowled")) {
				batsman.setDismissalMessage("B " + batsman.getBowlerName());
			} else if (batsman.getDismissalType().equals("Run Out")) {
				batsman.setDismissalMessage("Run Out (" + batsman.getFielderName() + ")");
			} else if (batsman.getDismissalType().equals("Stumping")) {
				batsman.setDismissalMessage("St " + batsman.getFielderName() + " B " + batsman.getBowlerName());
			} else if (batsman.getDismissalType().equals("LBW")) {
				batsman.setDismissalMessage("LBW B " + batsman.getBowlerName());
			} else if (batsman.getDismissalType().equals("Hit Wicket")){
				batsman.setDismissalMessage("Hit Wicket B " + batsman.getBowlerName());
			} else if (batsman.getDismissalType().equals("Retired")) {
				batsman.setDismissalMessage("Retired");
			} else {
				batsman.setDismissalMessage(batsman.getDismissalType());
			}
			batsmen.add(batsman);
		}
		return batsmen;
	}
	
	// Method to retrieve batsmen who did not bat in a given match and innings
	public ArrayList<BattingScorecardDTO> getDidNotBat(String s_match_id, int s_innings) throws SQLException{
		ArrayList<BattingScorecardDTO> batsmen = new ArrayList<BattingScorecardDTO>();
		
		 // Create a database connection
		DBConnect dbconnect = new DBConnect();
		
		 // Execute a SQL query to fetch batsmen who did not bat in the specified match and innings
		ResultSet rs = dbconnect.executeSelect(
				"SELECT * "
				+ "FROM tblBattingScorecards "
				+ "WHERE Dismissal_Type = \"Did Not Bat\" "
				+ "AND Innings = " + s_innings + " AND Match_ID = \"" + s_match_id + "\" ORDER BY Batting_Position;");
		
		while(rs.next()) {
			BattingScorecardDTO batsman = new BattingScorecardDTO();
			
			// Set batsman's ID based on query results
			batsman.setBatsmanID(rs.getString("Batsman_ID"));
			
			//Executes query to fetch batsman's name
			ResultSet rs2 = dbconnect.executeSelect(
					"SELECT Player_Name "
					+ "FROM tblPlayers "
					+ "WHERE Player_ID = \"" + batsman.getBatsmanID() +"\";");

			rs2.next();

			batsman.setBatsmanName(rs2.getString("Player_Name"));
			
			batsmen.add(batsman);
		}
		
		return batsmen;
	}
	
	// Method to retrieve bowling scorecard data for a given match ID and innings
	public ArrayList<BowlingScorecardDTO> getBowlingScorecard(String s_match_id, int s_innings) throws SQLException{
		ArrayList<BowlingScorecardDTO> bowlers = new ArrayList<BowlingScorecardDTO>();
		
		// Create a database connection
		DBConnect dbconnect = new DBConnect();
		
		// Execute a SQL query to fetch bowling scorecard data for the specified match ID and innings
		ResultSet rs = dbconnect.executeSelect(
				"SELECT * "
				+ "FROM tblBowlingScorecards "
				+ "WHERE Innings = " + s_innings + " AND Match_ID = \"" + s_match_id + "\";");
		
		while(rs.next()) {
			BowlingScorecardDTO bowler = new BowlingScorecardDTO();
			
			// Set bowler's properties based on query results
			bowler.setMatchID(rs.getString("Match_ID"));
			bowler.setInnings(rs.getInt("Innings"));
			bowler.setBowlerID(rs.getString("Bowler_ID"));
			bowler.setOvers(rs.getString("Overs"));
			bowler.setMaidens(rs.getInt("Maidens"));
			bowler.setRunsConceded(rs.getInt("Runs"));
			bowler.setWicketsTaken(rs.getInt("Wickets"));
			bowler.setWide(rs.getInt("Wide"));
			bowler.setNoBalls(rs.getInt("No_Ball"));
			
			// Fetch bowler's name based on bowler ID
			ResultSet rs2 = dbconnect.executeSelect(
					"SELECT Player_Name "
					+ "FROM tblPlayers "
					+ "WHERE Player_ID = \"" + bowler.getBowlerID() +"\";");

			rs2.next();

			bowler.setBowlerName(rs2.getString("Player_Name"));
			
			DecimalFormat f = new DecimalFormat("##.0");
			
			Scanner scOvers = new Scanner(bowler.getOvers()).useDelimiter("\\.");
			
			int overs = Integer.parseInt(scOvers.next());
			int balls = Integer.parseInt(scOvers.next());;
			
			int totalBalls = overs * 6 + balls;
			
			// Calculate and set the bowler's economy
			if(totalBalls / 6 != 0) { //Prevents divide by zero error
				bowler.setEconomy(f.format((double) bowler.getRunsConceded() / (totalBalls / 6)) + "");
			} else {
				bowler.setEconomy("NA");
			}
			
			  // Calculate and set the bowler's average
			if(bowler.getWicketsTaken() != 0) { //Prevents divide by zero error
				bowler.setAverage(f.format((double) bowler.getRunsConceded() / bowler.getWicketsTaken()) + "");
			} else {
				bowler.setAverage("NA");
			}
			bowlers.add(bowler);
		}
		return bowlers;
	}
}
