package app.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

import app.connection.DBConnect;
import app.model.dto.PlayerStatisticsDTO;

public class PlayerStatisticsDAO {
	
	// Method to retrieve player statistics based on a search string
	public ArrayList<PlayerStatisticsDTO> getPlayerStatistics(String search) throws SQLException {

		ArrayList<PlayerStatisticsDTO> players = new ArrayList<PlayerStatisticsDTO>();
		
		  // Create a new database connection
		DBConnect dbconnect = new DBConnect();
		
		// Execute a SQL query to retrieve player's id and name based on the search string
		ResultSet rs1 = dbconnect
				.executeSelect("SELECT Player_ID, Player_Name FROM tblPlayers WHERE Player_Name LIKE \"*" + search + "*\"");
		
		// Iterate through the query results
		while (rs1.next()) {
			PlayerStatisticsDTO player = new PlayerStatisticsDTO();
			
			// Execute a SQL query to retrieve player statistics based on Player_ID
			ResultSet rs2 = dbconnect.executeSelect(
					"SELECT * FROM tblPlayerStatistics WHERE Player_ID = \"" + rs1.getString("Player_ID") + "\"");

			if (rs2.next()) {
				  // Set player's properties from the query results
				player.setPlayerID(rs1.getString("Player_ID"));
				player.setPlayerName(rs1.getString("Player_Name"));				
				player.setMatches(rs2.getInt("Matches"));
				player.setBattingInnings(rs2.getInt("Batting_Innings"));
				player.setNotOuts(rs2.getInt("Not_Outs"));
				player.setRunsScored(rs2.getInt("Runs_Scored"));
				player.setBallsFaced(rs2.getInt("Balls_Faced"));
				player.setHighScore(rs2.getString("High_Score"));
				player.setFifties(rs2.getInt("Fifties"));
				player.setHundreds(rs2.getInt("Hundreds"));
				player.setFours(rs2.getInt("Fours"));
				player.setSixes(rs2.getInt("Sixes"));
				player.setBowlingInnings(rs2.getInt("Bowling_Innings"));
				player.setBallsBowled(rs2.getInt("Balls_Bowled"));
				player.setRunsConceded(rs2.getInt("Runs_Conceded"));
				player.setWicketsTaken(rs2.getInt("Wickets_Taken"));
				player.setBestFigures(rs2.getString("Best_Figures"));
				player.setFiveWickets(rs2.getInt("Five_Wicket_Hauls"));
				player.setRunOuts(rs2.getInt("Run_Outs"));
				player.setCatches(rs2.getInt("Catches"));
				player.setStumpings(rs2.getInt("Stumpings"));
			}

			while (rs2.next()) {
				
				 // Sums up statistics if there are multiple records for the same player
				player.setMatches(rs2.getInt("Matches") + player.getMatches());
				player.setBattingInnings(rs2.getInt("Batting_Innings") + player.getBattingInnings());
				player.setNotOuts(rs2.getInt("Not_Outs") + player.getNotOuts());
				player.setRunsScored(rs2.getInt("Runs_Scored") + player.getRunsScored());
				player.setBallsFaced(rs2.getInt("Balls_Faced") + player.getBallsFaced());
				player.setFifties(rs2.getInt("Fifties") + player.getFifties());
				player.setHundreds(rs2.getInt("Hundreds") + player.getHundreds());
				player.setFours(rs2.getInt("Fours") + player.getFours());
				player.setSixes(rs2.getInt("Sixes") + player.getSixes());
				player.setBowlingInnings(rs2.getInt("Bowling_Innings") + player.getBowlingInnings());
				player.setBallsBowled(rs2.getInt("Balls_Bowled") + player.getBallsBowled());
				player.setRunsConceded(rs2.getInt("Runs_Conceded") + player.getRunsConceded());
				player.setWicketsTaken(rs2.getInt("Wickets_Taken") + player.getWicketsTaken());
				player.setFiveWickets(rs2.getInt("Five_Wicket_Hauls") + player.getFiveWickets());
				player.setRunOuts(rs2.getInt("Run_Outs") + player.getRunOuts());
				player.setCatches(rs2.getInt("Catches") + player.getCatches());
				player.setStumpings(rs2.getInt("Stumpings") + player.getStumpings());
				
				
				// Update the best figures if a new best is found
				if (rs2.getString("Best_Figures").equals("NA") || player.getBestFigures().equals("NA")) {
					if (!(rs2.getString("Best_Figures").equals("NA")) && player.getBestFigures().equals("NA")) {
						player.setBestFigures(rs2.getString("Best_Figures"));
					}
				} else if (!(rs2.getString("Best_Figures").equals("NA") && player.getBestFigures().equals("NA"))) {

					Scanner newBestFigure = new Scanner(rs2.getString("Best_Figures")).useDelimiter("/");

					int newWickets = Integer.parseInt(newBestFigure.next());
					int newRuns = Integer.parseInt(newBestFigure.next());

					Scanner oldBestFigure = new Scanner(player.getBestFigures()).useDelimiter("/");

					int oldWickets = Integer.parseInt(oldBestFigure.next());
					int oldRuns = Integer.parseInt(oldBestFigure.next());

					if (newWickets > oldWickets) {
						player.setBestFigures(rs2.getString("Best_Figures"));
					} else if (oldWickets == newWickets) {
						if (newRuns < oldRuns) {
							player.setBestFigures(rs2.getString("Best_Figures"));
						}
					}
				}
				
				// Update the high score if a new high score is found
				if (rs2.getString("High_Score").equals("NA") || player.getHighScore().equals("NA")) {
					if (!(rs2.getString("High_Score").equals("NA")) && player.getHighScore().equals("NA")) {
						player.setHighScore(rs2.getString("High_Score"));
					}
				} else if (!(rs2.getString("High_Score").equals("NA") && player.getHighScore().equals("NA"))) {
					int oldHighScore = Integer.parseInt(player.getHighScore().replace("*", ""));
					int newHighScore = Integer.parseInt(rs2.getString("High_Score").replace("*", ""));

					if (newHighScore > oldHighScore) {
						player.setHighScore(rs2.getString("High_Score"));
					} else if (newHighScore == oldHighScore) {
						if (rs2.getString("High_Score").contains("*")) {
							player.setHighScore(rs2.getString("High_Score"));
						}
					}
				}
			}
			
			// Calculate additional statistics such as batting strike rate, batting average,
			// bowling average, bowling strike rate and economy.
			DecimalFormat f = new DecimalFormat("##.0");

			if (player.getBallsFaced() != 0) { //Prevents divide by zero error.
				player.setBattingStrikeRate(
						f.format((double) player.getRunsScored() / player.getBallsFaced() * 100) + "");
			} else {
				player.setBattingStrikeRate("NA");
			}

			if ((player.getBattingInnings() - player.getNotOuts()) != 0) { //Prevents divide by zero error.
				player.setBattingAverage(f.format(
						(double) player.getRunsScored() / (player.getBattingInnings() - player.getNotOuts()))
						+ "");
			} else {
				player.setBattingAverage("NA");
			}

			if (player.getWicketsTaken() != 0) { //Prevents divide by zero error.
				player.setBowlingAverage(
						f.format((double) player.getRunsConceded() / player.getWicketsTaken()) + "");
			} else {
				player.setBowlingAverage("NA");
			}

			if ((player.getBallsBowled() / 6) != 0) { //Prevents divide by zero error.
				player.setEconomy(f.format((double) player.getRunsConceded() / (player.getBallsBowled() / 6)) + "");
			} else {
				player.setEconomy("NA");
			}

			if (player.getWicketsTaken() != 0) { //Prevents divide by zero error.
				player.setBowlingStrikeRate(
						f.format((double) player.getBallsBowled() / player.getWicketsTaken()) + "");
			} else {
				player.setBowlingStrikeRate("NA");
			}

			players.add(player);
		}
		return players;
	}
}