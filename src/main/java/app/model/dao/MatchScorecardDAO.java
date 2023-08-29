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
			match.setM_match_id(rs.getString("Match_ID"));
			match.setM_match_date(rs.getDate("Match_Date"));			
			match.setM_format(rs.getString("Format"));
			
			match.setM_team_1_id(rs.getString("Team_1_ID"));
			match.setM_team_2_id(rs.getString("Team_2_ID"));	
			
			match.setM_toss_winner_id(rs.getString("Toss_Winner_ID"));
			match.setM_toss_decision(rs.getString("Toss_Decision"));
			
			match.setM_is_result(rs.getBoolean("Is_Result"));
			match.setM_win_type(rs.getString("Win_Type"));
			match.setM_won_by(rs.getInt("Won_By"));
			match.setM_match_winner_id(rs.getString("Match_Winner_ID"));
			
			match.setM_innings_1_total(rs.getInt("Innings_1_Total"));
			match.setM_innings_1_overs(rs.getString("Innings_1_Overs"));
			match.setM_innings_1_wickets(rs.getInt("Innings_1_Wickets"));
			
			match.setM_innings_2_total(rs.getInt("Innings_2_Total"));
			match.setM_innings_2_overs(rs.getString("Innings_2_Overs"));
			match.setM_innings_2_wickets(rs.getInt("Innings_2_Wickets"));
			
			ResultSet rs2 = dbconnect.executeSelect("SELECT Team_Name FROM tblTeams WHERE Team_ID = " + match.getM_toss_winner_id() + ";");
			
			if(rs2.next() && match.getM_is_result() == true) {
				String tempStr = rs2.getString("Team_Name") + " won by " + match.getM_won_by() + " ";
				if(match.getM_win_type().equals("By runs")) {
					tempStr += "runs.";
				} else {
					tempStr += "wickets.";
				}
				match.setM_win_message(tempStr);
			} else {
				match.setM_win_message("Match Cancelled");
			}
			
			ResultSet rs3 = dbconnect.executeSelect("SELECT Team_Name, Age_Group FROM tblTeams WHERE Team_ID = " + match.getM_team_1_id());
			
			if(rs3.next()) {
				match.setM_team_1_team_name(rs3.getString("Team_Name"));
				match.setM_team_1_age_group(rs3.getString("Age_Group"));
			}
			
			ResultSet rs4 = dbconnect.executeSelect("SELECT Team_Name, Age_Group FROM tblTeams WHERE Team_ID = " + match.getM_team_2_id());
			
			if(rs4.next()) {
				match.setM_team_2_team_name(rs4.getString("Team_Name"));
				match.setM_team_2_age_group(rs4.getString("Age_Group"));
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
			
			batsman.setS_match_id(rs.getString("Match_ID"));
			batsman.setS_innings(rs.getInt("Innings"));
			
			batsman.setS_batting_position(rs.getInt("Batting_Position"));
			batsman.setS_batsman_id(rs.getString("Batsman_ID"));
			
			
			batsman.setS_dismissal_type(rs.getString("Dismissal_Type"));
			batsman.setS_bowler_id(rs.getString("Bowler_ID"));
			batsman.setS_fielder_id(rs.getString("Fielder_ID"));
			
			batsman.setS_runs_scored(rs.getInt("Runs_Scored"));
			batsman.setS_balls_faced(rs.getInt("Balls_Faced"));
			batsman.setS_fours(rs.getInt("Fours"));
			batsman.setS_sixes(rs.getInt("Sixes"));
			
			batsman.setS_strike_rate(rs.getString("Strike_Rate"));
			
			DecimalFormat f = new DecimalFormat("##.0");
			
			if(batsman.getS_balls_faced() != 0) {
				batsman.setS_strike_rate(f.format((double) batsman.getS_runs_scored() / batsman.getS_balls_faced() * 100)+"");
			} else {
				batsman.setS_strike_rate("NA");
			}
			
			ResultSet rs2 = dbconnect.executeSelect(
									"SELECT Player_Name "
									+ "FROM tblPlayers "
									+ "WHERE Player_ID = \"" + batsman.getS_batsman_id() +"\";");
			
			rs2.next();
			
			batsman.setS_batsman_name(rs2.getString("Player_Name"));
			
			
			if(batsman.getS_fielder_id() != null) {
				ResultSet rs3 = dbconnect.executeSelect(
							"SELECT Player_Name "
							+ "FROM tblPlayers "
							+ "WHERE Player_ID = \"" + batsman.getS_fielder_id() +"\";");
				
				rs3.next();
				batsman.setS_fielder_name(rs3.getString("Player_Name"));
			}
			
			
			if(batsman.getS_bowler_id() != null) {
				ResultSet rs4 = dbconnect.executeSelect(
							"SELECT Player_Name "
							+ "FROM tblPlayers "
							+ "WHERE Player_ID = \"" + batsman.getS_bowler_id() +"\";");
				
				rs4.next();
						
				batsman.setS_bowler_name(rs4.getString("Player_Name"));
			}
			
			if(batsman.getS_dismissal_type().equals("Caught")) {
				
				batsman.setS_dismissal_message("C " + batsman.getS_fielder_name() + " B " + batsman.getS_bowler_name());
				
			} else if (batsman.getS_dismissal_type().equals("Bowled")) {
				
				batsman.setS_dismissal_message("B " + batsman.getS_bowler_name());
				
			} else if (batsman.getS_dismissal_type().equals("Run Out")) {
				
				batsman.setS_dismissal_message("Run Out (" + batsman.getS_fielder_name() + ")");
				
			} else if (batsman.getS_dismissal_type().equals("Stumping")) {
				
				batsman.setS_dismissal_message("St " + batsman.getS_fielder_name() + " B " + batsman.getS_bowler_name());
				
			} else if (batsman.getS_dismissal_type().equals("LBW")) {
				
				batsman.setS_dismissal_message("LBW B " + batsman.getS_bowler_name());
				
			} else if (batsman.getS_dismissal_type().equals("Hit Wicket")){
				
				batsman.setS_dismissal_message("Hit Wicket B " + batsman.getS_bowler_name());
				
			} else if (batsman.getS_dismissal_type().equals("Retired")) {
				
				batsman.setS_dismissal_message("Retired");
				
			} else {
				
				batsman.setS_dismissal_message(batsman.getS_dismissal_type());
				
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
			
			batsman.setS_batsman_id(rs.getString("Batsman_ID"));
			
			ResultSet rs2 = dbconnect.executeSelect(
					"SELECT Player_Name "
					+ "FROM tblPlayers "
					+ "WHERE Player_ID = \"" + batsman.getS_batsman_id() +"\";");

			rs2.next();

			batsman.setS_batsman_name(rs2.getString("Player_Name"));
			
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
			
			bowler.setS_match_id(rs.getString("Match_ID"));
			bowler.setS_innings(rs.getInt("Innings"));
			bowler.setS_bowler_id(rs.getString("Bowler_ID"));
			bowler.setS_overs(rs.getString("Overs"));
			bowler.setS_maidens(rs.getInt("Maidens"));
			bowler.setS_runs_conceded(rs.getInt("Runs"));
			bowler.setS_wickets_taken(rs.getInt("Wickets"));
			bowler.setS_wide(rs.getInt("Wide"));
			bowler.setS_no_ball(rs.getInt("No_Ball"));
			
			ResultSet rs2 = dbconnect.executeSelect(
					"SELECT Player_Name "
					+ "FROM tblPlayers "
					+ "WHERE Player_ID = \"" + bowler.getS_bowler_id() +"\";");

			rs2.next();

			bowler.setS_bowler_name(rs2.getString("Player_Name"));
			
			DecimalFormat f = new DecimalFormat("##.0");
			
			Scanner scOvers = new Scanner(bowler.getS_overs()).useDelimiter("\\.");
			
			int overs = Integer.parseInt(scOvers.next());
			int balls = Integer.parseInt(scOvers.next());;
			
			int totalBalls = overs * 6 + balls;
			
			if(totalBalls / 6 != 0) {
				bowler.setS_economy(f.format((double) bowler.getS_runs_conceded() / (totalBalls / 6)) + "");
			} else {
				bowler.setS_economy("NA");
			}
			
			if(bowler.getS_wickets_taken() != 0) {
				bowler.setS_average(f.format((double) bowler.getS_runs_conceded() / bowler.getS_wickets_taken()) + "");
			} else {
				bowler.setS_average("NA");
			}
			
			bowlers.add(bowler);
		}
		return bowlers;
	}
}
