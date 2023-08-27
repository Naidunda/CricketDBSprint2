package app.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import app.connection.DBConnect;
import app.model.dto.PlayerSeasonsDTO;
import app.model.dto.PlayerStatisticsDTO;
import app.model.dto.PlayersDTO;
import app.model.dto.TeamPlayersDTO;

public class PlayersDAO {
	public ArrayList<PlayersDTO> getPlayerProfile(String p_player_id) throws SQLException {

		ArrayList<PlayersDTO> players = new ArrayList<PlayersDTO>();

		DBConnect dbconnect = new DBConnect();
		ResultSet rs = dbconnect.executeSelect("SELECT * FROM tblPlayers WHERE Player_ID = \"" + p_player_id + "\";");

		if (rs.next()) {
			PlayersDTO player = new PlayersDTO();

			player.setP_player_name(rs.getString("Player_Name"));

			DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			player.setP_dob(dateFormat.format(rs.getDate("DOB")));

			player.setP_batting_hand(rs.getString("Batting_Hand"));
			player.setP_bowling_skill(rs.getString("Bowling_Skill"));
			player.setP_is_keeper(rs.getBoolean("Is_Keeper"));
			String mess = player.getP_batting_hand() + " | " + player.getP_bowling_skill();

			if (player.isP_is_keeper()) {
				mess += " | Wicket-Keeper";
			}

			player.setP_role(mess);

			players.add(player);
		}
		return players;
	}

	public ArrayList<TeamPlayersDTO> getPlayerTeams(String p_player_id) throws SQLException {
		ArrayList<TeamPlayersDTO> teams = new ArrayList<TeamPlayersDTO>();

		DBConnect dbconnect = new DBConnect();
		ResultSet rs1 = dbconnect
				.executeSelect("SELECT * FROM tblTeamPlayers WHERE Player_ID = \"" + p_player_id + "\";");

		while (rs1.next()) {
			TeamPlayersDTO team = new TeamPlayersDTO();

			ResultSet rs2 = dbconnect
					.executeSelect("SELECT * FROM tblTeams WHERE Team_ID = \"" + rs1.getString("Team_ID") + "\";");
			
			if (rs2.next()) {
				team.setT_team_id(rs2.getString("Team_ID"));
				team.setT_team_name(rs2.getString("Team_Name"));
				team.setT_age_group(rs2.getString("Age_Group"));
				team.setT_location(rs2.getString("Location"));
			}
			teams.add(team);
		}

		return teams;
	}

	public ArrayList<PlayerStatisticsDTO>getAllPlayerStatistics(String p_player_id) throws SQLException {
		
		ArrayList<PlayerStatisticsDTO> players = new ArrayList<PlayerStatisticsDTO>();
		
		DBConnect dbconnect = new DBConnect();
		
		ResultSet rs1 = dbconnect.executeSelect("SELECT * FROM tblPlayerStatistics WHERE Player_ID = \"" + p_player_id +"\"");
		
			
		PlayerStatisticsDTO player = new PlayerStatisticsDTO();
		player.setP_player_id(p_player_id);
			
		ResultSet rs2 = dbconnect.executeSelect("SELECT Player_Name FROM tblPlayers WHERE Player_ID = \"" + p_player_id +"\"");
		
		if(rs2.next()) {
			player.setP_player_name(rs2.getString("Player_Name"));
		}
		
		if(rs1.next()) {
			player.setP_matches(rs1.getInt("Matches"));
			player.setP_batting_innings(rs1.getInt("Batting_Innings"));
			player.setP_not_outs(rs1.getInt("Not_Outs"));
			player.setP_runs_scored(rs1.getInt("Runs_Scored"));
			player.setP_balls_faced(rs1.getInt("Balls_Faced"));
			player.setP_high_score(rs1.getString("High_Score"));
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
		}



		while(rs1.next()) {
			player.setP_matches(rs1.getInt("Matches") + player.getP_matches());
			player.setP_batting_innings(rs1.getInt("Batting_Innings") + player.getP_batting_innings());
			player.setP_not_outs(rs1.getInt("Not_Outs") + player.getP_not_outs());
			player.setP_runs_scored(rs1.getInt("Runs_Scored") + player.getP_runs_scored());
			player.setP_balls_faced(rs1.getInt("Balls_Faced") + player.getP_balls_faced());
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
				
				
			if(rs1.getString("Best_Figures").equals("NA") || player.getP_best_figures().equals("NA")) {
				if(!(rs1.getString("Best_Figures").equals("NA")) && player.getP_best_figures().equals("NA")) {
					player.setP_best_figures(rs1.getString("Best_Figures"));
				}
			} else if (!(rs1.getString("Best_Figures").equals("NA") && player.getP_best_figures().equals("NA"))){
					
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
				
			if(rs1.getString("High_Score").equals("NA") || player.getP_high_score().equals("NA")) {
				if(!(rs1.getString("High_Score").equals("NA")) &&  player.getP_high_score().equals("NA")) {
					player.setP_high_score(rs1.getString("High_Score"));
				}
			} else if(!(rs1.getString("High_Score").equals("NA") && player.getP_high_score().equals("NA"))){
				int oldHighScore = Integer.parseInt(player.getP_high_score().replace("*", ""));
				int newHighScore = Integer.parseInt(rs1.getString("High_Score").replace("*", ""));

				if (newHighScore > oldHighScore) {
					player.setP_high_score(rs1.getString("High_Score"));
				} else if (newHighScore == oldHighScore) {
					if (rs1.getString("High_Score").contains("*")) {
						player.setP_high_score(rs1.getString("High_Score"));
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

		return players;
	}


	public ArrayList<PlayerStatisticsDTO> getSeasonPlayerStatistics(String p_player_id, String p_season) throws SQLException { 
		ArrayList<PlayerStatisticsDTO> players = new ArrayList<PlayerStatisticsDTO>();
  
		DBConnect dbconnect = new DBConnect();
		ResultSet rs1 = dbconnect.executeSelect("SELECT * FROM tblPlayerStatistics WHERE Player_ID = \"" +p_player_id + "\" AND Season = \"" + p_season + "\";");
		
		PlayerStatisticsDTO player = new PlayerStatisticsDTO();
		player.setP_player_id(p_player_id);
		
		ResultSet rs2 = dbconnect.executeSelect("SELECT Player_Name FROM tblPlayers WHERE Player_ID = \"" + p_player_id +"\"");
		
		if(rs2.next()) {
			player.setP_player_name(rs2.getString("Player_Name"));
		}
		
		if(rs1.next()) {
			player.setP_matches(rs1.getInt("Matches"));
			player.setP_batting_innings(rs1.getInt("Batting_Innings"));
			player.setP_not_outs(rs1.getInt("Not_Outs"));
			player.setP_runs_scored(rs1.getInt("Runs_Scored"));
			player.setP_balls_faced(rs1.getInt("Balls_Faced"));
			player.setP_high_score(rs1.getString("High_Score"));
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

		return players;
	}
	
	public ArrayList<PlayerSeasonsDTO> getSeasonsPlayed(String p_player_id) throws SQLException {
		ArrayList<PlayerSeasonsDTO> seasons = new ArrayList<PlayerSeasonsDTO>();
		
		DBConnect dbconnect = new DBConnect();
		ResultSet rs = dbconnect.executeSelect("SELECT Player_ID, Season FROM tblPlayerStatistics WHERE Player_ID = \"" + p_player_id + "\" ORDER BY Season DESC;");
		
		while(rs.next()) {
			PlayerSeasonsDTO season = new PlayerSeasonsDTO();
			season.setP_player_id(rs.getString("Player_ID"));
			season.setP_season(rs.getInt("Season") + "");
			
			seasons.add(season);
		}
		return seasons;
		
	}
}
