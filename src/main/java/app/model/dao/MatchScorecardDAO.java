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
	
	public MatchesDTO getMatchSummary(String s_match_id) throws SQLException{
		
		DBConnect dbconnect = new DBConnect();
		ResultSet rs = dbconnect.executeSelect("Select * From tblMatches WHERE Match_ID = \""+s_match_id+"\";");
		MatchesDTO match = new MatchesDTO();
		
		if(rs.next()) {
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

			ResultSet rs2 = dbconnect.executeSelect(
					"SELECT Team_Name FROM tblTeams WHERE Team_ID = " + match.getTossWinnerID() + ";");

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

			ResultSet rs3 = dbconnect.executeSelect(
					"SELECT Team_Name, Age_Group FROM tblTeams WHERE Team_ID = " + match.getTeamID1());

			if (rs3.next()) {
				match.setTeamName1(rs3.getString("Team_Name"));
				match.setTeamAgeGroup1(rs3.getString("Age_Group"));
			}

			ResultSet rs4 = dbconnect.executeSelect(
					"SELECT Team_Name, Age_Group FROM tblTeams WHERE Team_ID = " + match.getTeamID2());

			if (rs4.next()) {
				match.setTeamName2(rs4.getString("Team_Name"));
				match.setTeamAgeGroup2(rs4.getString("Age_Group"));
			}
		}

		return match;
	}
	
	public ArrayList<BattingScorecardDTO> getBattingScorecard(String s_match_id, int s_innings) throws SQLException{
		ArrayList<BattingScorecardDTO> batsmen = new ArrayList<BattingScorecardDTO>();

		DBConnect dbconnect = new DBConnect();
		
		ResultSet rs = dbconnect.executeSelect(
				"SELECT * "
				+ "FROM tblBattingScorecards "
				+ "WHERE Dismissal_Type <> \"Did Not Bat\" "
				+ "AND Innings = " + s_innings + " AND Match_ID = \"" + s_match_id + "\" ORDER BY Batting_Position;");
		
		while(rs.next()) {
			BattingScorecardDTO batsman = new BattingScorecardDTO();
			
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
			
			if(batsman.getBallsFaced() != 0) {
				batsman.setStrikeRate(f.format((double) batsman.getRunsScored() / batsman.getBallsFaced() * 100)+"");
			} else {
				batsman.setStrikeRate("NA");
			}
			
			ResultSet rs2 = dbconnect.executeSelect(
									"SELECT Player_Name "
									+ "FROM tblPlayers "
									+ "WHERE Player_ID = \"" + batsman.getBatsmanID() +"\";");
			
			rs2.next();
			
			batsman.setBatsmanName(rs2.getString("Player_Name"));
			
			
			if(batsman.getFielderID() != null) {
				ResultSet rs3 = dbconnect.executeSelect(
							"SELECT Player_Name "
							+ "FROM tblPlayers "
							+ "WHERE Player_ID = \"" + batsman.getFielderID() +"\";");
				
				rs3.next();
				batsman.setFielderName(rs3.getString("Player_Name"));
			}
			
			
			if(batsman.getBowlerID() != null) {
				ResultSet rs4 = dbconnect.executeSelect(
							"SELECT Player_Name "
							+ "FROM tblPlayers "
							+ "WHERE Player_ID = \"" + batsman.getBowlerID() +"\";");
				
				rs4.next();
						
				batsman.setBowlerName(rs4.getString("Player_Name"));
			}
			
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
	
	public ArrayList<BattingScorecardDTO> getDidNotBat(String s_match_id, int s_innings) throws SQLException{
		ArrayList<BattingScorecardDTO> batsmen = new ArrayList<BattingScorecardDTO>();

		DBConnect dbconnect = new DBConnect();
		
		ResultSet rs = dbconnect.executeSelect(
				"SELECT * "
				+ "FROM tblBattingScorecards "
				+ "WHERE Dismissal_Type = \"Did Not Bat\" "
				+ "AND Innings = " + s_innings + " AND Match_ID = \"" + s_match_id + "\" ORDER BY Batting_Position;");
		
		while(rs.next()) {
			BattingScorecardDTO batsman = new BattingScorecardDTO();
			
			batsman.setBatsmanID(rs.getString("Batsman_ID"));
			
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
	
	public ArrayList<BowlingScorecardDTO> getBowlingScorecard(String s_match_id, int s_innings) throws SQLException{
		ArrayList<BowlingScorecardDTO> bowlers = new ArrayList<BowlingScorecardDTO>();
		
		DBConnect dbconnect = new DBConnect();
		
		ResultSet rs = dbconnect.executeSelect(
				"SELECT * "
				+ "FROM tblBowlingScorecards "
				+ "WHERE Innings = " + s_innings + " AND Match_ID = \"" + s_match_id + "\";");
		
		while(rs.next()) {
			BowlingScorecardDTO bowler = new BowlingScorecardDTO();
			
			bowler.setMatchID(rs.getString("Match_ID"));
			bowler.setInnings(rs.getInt("Innings"));
			bowler.setBowlerID(rs.getString("Bowler_ID"));
			bowler.setOvers(rs.getString("Overs"));
			bowler.setMaidens(rs.getInt("Maidens"));
			bowler.setRunsConceded(rs.getInt("Runs"));
			bowler.setWicketsTaken(rs.getInt("Wickets"));
			bowler.setWide(rs.getInt("Wide"));
			bowler.setNoBalls(rs.getInt("No_Ball"));
			
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
			
			if(totalBalls / 6 != 0) {
				bowler.setEconomy(f.format((double) bowler.getRunsConceded() / (totalBalls / 6)) + "");
			} else {
				bowler.setEconomy("NA");
			}
			
			if(bowler.getWicketsTaken() != 0) {
				bowler.setAverage(f.format((double) bowler.getRunsConceded() / bowler.getWicketsTaken()) + "");
			} else {
				bowler.setAverage("NA");
			}
			bowlers.add(bowler);
		}
		return bowlers;
	}
}
