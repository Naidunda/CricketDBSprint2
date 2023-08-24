package app.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import app.connection.DBConnect;
import app.model.dto.PlayerStatisticsDTO;

public class PlayerStatisticsDAO {
	public ArrayList<PlayerStatisticsDTO> getPlayerStatistics() throws SQLException {

		ArrayList<PlayerStatisticsDTO> players = new ArrayList<PlayerStatisticsDTO>();

		DBConnect dbconnect = new DBConnect();

		ResultSet rs1 = dbconnect.executeSelect("SELECT * FROM tblPlayerStatistics ORDER BY Player_ID");

		String temp_id = null;

		while (rs1.next()) {
			PlayerStatisticsDTO player = new PlayerStatisticsDTO();

			temp_id = rs1.getString("Player_ID");

			player.setP_id(temp_id);

			ResultSet rs2 = dbconnect.executeSelect("SELECT Player_Name FROM tblPlayers WHERE Player_ID = " + temp_id);

			if (rs2.next()) {
				player.setP_player_name(rs2.getString("Player_Name"));
			}

			ResultSet rs3 = dbconnect.executeSelect(
					"SELECT Count(Player_ID) AS Count FROM tblPlayerStatistics WHERE Player_ID = " + temp_id);

			int loop = 0;

			if (rs3.next()) {
				loop = rs3.getInt("Count");
			}

			player.setP_player_name(rs2.getString("Player_Name"));
			player.setP_matches(rs1.getInt("Matches"));
			player.setP_batting_innings(rs1.getInt("Batting_Innings"));
			player.setP_not_outs(rs1.getInt("Not_Outs"));
			player.setP_runs_scored(rs1.getInt("Runs_Scored"));
			player.setP_balls_faced(rs1.getInt("Balls_Faced"));
			player.setP_high_score(rs1.getInt("High_Score"));
			player.setP_fifties(rs1.getInt("Fifties"));
			player.setP_hundreds(rs1.getInt("Hundreds"));
			player.setP_fours(rs1.getInt("Fours"));
			player.setP_sixes(rs1.getInt("Sixes"));
			player.setP_bowling_innings(rs1.getInt("Bowling_Innings"));
			player.setP_balls_bowled(rs1.getInt("Balls_Bowled"));
			player.setP_runs_conceded(rs1.getInt("Runs_Conceded"));
			player.setP_wickets_taken(rs1.getInt("Wickets_Taken"));
			player.setP_best_figures(rs1.getString("Best_Figures"));
			player.setP_five_wickets(rs1.getInt("Five_Wicket_Hauls"));
			player.setP_run_outs(rs1.getInt("Run_Outs"));
			player.setP_catches(rs1.getInt("Catches"));
			player.setP_stumpings(rs1.getInt("Stumpings"));

			for (int i = 1; i < loop; i++) {
				if (rs1.next()) {
					player.setP_matches(rs1.getInt("Matches") + player.getP_matches());
					player.setP_batting_innings(rs1.getInt("Batting_Innings") + player.getP_batting_innings());
					player.setP_not_outs(rs1.getInt("Not_Outs") + player.getP_not_outs());
					player.setP_runs_scored(rs1.getInt("Runs_Scored") + player.getP_runs_scored());
					player.setP_balls_faced(rs1.getInt("Balls_Faced") + player.getP_balls_faced());
					player.setP_high_score(rs1.getInt("High_Score") + player.getP_high_score());
					player.setP_fifties(rs1.getInt("Fifties") + player.getP_fifties());
					player.setP_hundreds(rs1.getInt("Hundreds") + player.getP_hundreds());
					player.setP_fours(rs1.getInt("Fours") + player.getP_fours());
					player.setP_sixes(rs1.getInt("Sixes") + player.getP_sixes());
					player.setP_bowling_innings(rs1.getInt("Bowling_Innings") + player.getP_bowling_innings());
					player.setP_balls_bowled(rs1.getInt("Balls_Bowled") + player.getP_balls_bowled());
					player.setP_runs_conceded(rs1.getInt("Runs_Conceded") + player.getP_runs_conceded());
					player.setP_wickets_taken(rs1.getInt("Wickets_Taken") + player.getP_wickets_taken());
					player.setP_five_wickets(rs1.getInt("Five_Wicket_Hauls") + player.getP_five_wickets());
					player.setP_run_outs(rs1.getInt("Run_Outs") + player.getP_run_outs());
					player.setP_catches(rs1.getInt("Catches") + player.getP_catches());
					player.setP_stumpings(rs1.getInt("Stumpings") + player.getP_stumpings());

					if (!(rs1.getString("Best_Figures").equals("NA"))) {
						Scanner newBestFigure = new Scanner(rs1.getString("Best_Figures")).useDelimiter("/");

						int newWickets = Integer.parseInt(newBestFigure.next());
						int newRuns = Integer.parseInt(newBestFigure.next());

						Scanner oldBestFigure = new Scanner(player.getP_best_figures()).useDelimiter("/");

						int oldWickets = Integer.parseInt(oldBestFigure.next());
						int oldRuns = Integer.parseInt(oldBestFigure.next());

						if (newWickets > oldWickets) {
							player.setP_best_figures(rs1.getString("Best_Figures"));
						} else if (oldWickets == newWickets) {
							if (newRuns < oldRuns) {
								player.setP_best_figures(rs1.getString("Best_Figures"));
							}
						}
					}
				}
			}

			DecimalFormat f = new DecimalFormat("##.0");

			if (player.getP_balls_faced() != 0) {
				player.setP_batting_strike_rate(
						f.format((double) player.getP_runs_scored() / player.getP_balls_faced() * 100) + "");
			} else {
				player.setP_batting_strike_rate("NA");
			}

			if ((player.getP_batting_innings() - player.getP_not_outs()) != 0) {
				player.setP_batting_average(f.format(
						(double) player.getP_runs_scored() / (player.getP_batting_innings() - player.getP_not_outs()))
						+ "");
			} else {
				player.setP_batting_average("NA");
			}

			if (player.getP_wickets_taken() != 0) {
				player.setP_bowling_average(
						f.format((double) player.getP_runs_conceded() / player.getP_wickets_taken()) + "");
			} else {
				player.setP_bowling_average("NA");
			}

			if ((player.getP_balls_bowled() / 6) != 0) {
				player.setP_economy(
						f.format((double) player.getP_runs_conceded() / (player.getP_balls_bowled() / 6)) + "");
			} else {
				player.setP_economy("NA");
			}

			if (player.getP_wickets_taken() != 0) {
				player.setP_bowling_strike_rate(
						f.format((double) player.getP_balls_bowled() / player.getP_wickets_taken()) + "");
			} else {
				player.setP_bowling_strike_rate("NA");
			}

			players.add(player);
		}

		return players;
	}

//	public static void main(String[] args) {
//
//		try {
//			ArrayList<PlayerStatisticsDTO> players = new PlayerStatisticsDAO().getPlayerStatistics();
//			System.out.println(players);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			JOptionPane.showMessageDialog(null, "Error:.\n" + e);
//		}
//	}
}
