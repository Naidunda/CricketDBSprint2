package app.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import app.connection.DBConnect;
import app.model.dto.MatchesDTO;
import app.model.dto.PlayerSeasonsDTO;
import app.model.dto.PlayerStatisticsDTO;
import app.model.dto.PlayersDTO;
import app.model.dto.TeamPlayersDTO;

public class PlayersDAO {
	public PlayersDTO getPlayerProfile(String player_id) throws SQLException {

		PlayersDTO player = new PlayersDTO();

		DBConnect dbconnect = new DBConnect();
		ResultSet rs = dbconnect.executeSelect("SELECT * FROM tblPlayers WHERE Player_ID = \"" + player_id + "\";");

		if (rs.next()) {
			player.setPlayerID(player_id);

			player.setPlayerName(rs.getString("Player_Name"));

			player.setDob(rs.getDate("DOB"));

			player.setBattingHand(rs.getString("Batting_Hand"));
			player.setBowlingSkill(rs.getString("Bowling_Skill"));
			player.setKeeper(rs.getBoolean("Is_Keeper"));
			String mess = player.getBattingHand() + " | " + player.getBowlingSkill();

			if (player.isKeeper()) {
				mess += " | Wicket-Keeper";
			}

			player.setRole(mess);
		}
		return player;
	}

	public ArrayList<TeamPlayersDTO> getPlayerTeams(String player_id) throws SQLException {
		ArrayList<TeamPlayersDTO> teams = new ArrayList<TeamPlayersDTO>();

		DBConnect dbconnect = new DBConnect();
		ResultSet rs1 = dbconnect
				.executeSelect("SELECT * FROM tblTeamPlayers WHERE Player_ID = \"" + player_id + "\";");

		while (rs1.next()) {
			TeamPlayersDTO team = new TeamPlayersDTO();

			ResultSet rs2 = dbconnect
					.executeSelect("SELECT * FROM tblTeams WHERE Team_ID = \"" + rs1.getString("Team_ID") + "\";");

			if (rs2.next()) {
				team.setTeamID(rs2.getString("Team_ID"));
				team.setTeamName(rs2.getString("Team_Name"));
				team.setAgeGroup(rs2.getString("Age_Group"));
				team.setLocation(rs2.getString("Location"));
			}
			teams.add(team);
		}

		return teams;
	}

	public ArrayList<PlayerStatisticsDTO> getAllPlayerStatistics(String player_id) throws SQLException {

		ArrayList<PlayerStatisticsDTO> players = new ArrayList<PlayerStatisticsDTO>();

		DBConnect dbconnect = new DBConnect();

		ResultSet rs1 = dbconnect
				.executeSelect("SELECT * FROM tblPlayerStatistics WHERE Player_ID = \"" + player_id + "\"");

		PlayerStatisticsDTO player = new PlayerStatisticsDTO();
		player.setPlayerID(player_id);

		ResultSet rs2 = dbconnect
				.executeSelect("SELECT Player_Name FROM tblPlayers WHERE Player_ID = \"" + player_id + "\"");

		if (rs2.next()) {
			player.setPlayerName(rs2.getString("Player_Name"));
		}

		if (rs1.next()) {
			player.setMatches(rs1.getInt("Matches"));
			player.setBattingInnings(rs1.getInt("Batting_Innings"));
			player.setNotOuts(rs1.getInt("Not_Outs"));
			player.setRunsScored(rs1.getInt("Runs_Scored"));
			player.setBallsFaced(rs1.getInt("Balls_Faced"));
			player.setHighScore(rs1.getString("High_Score"));
			player.setFifties(rs1.getInt("Fifties"));
			player.setHundreds(rs1.getInt("Hundreds"));
			player.setFours(rs1.getInt("Fours"));
			player.setSixes(rs1.getInt("Sixes"));
			player.setBowlingInnings(rs1.getInt("Bowling_Innings"));
			player.setBallsBowled(rs1.getInt("Balls_Bowled"));
			player.setRunsConceded(rs1.getInt("Runs_Conceded"));
			player.setWicketsTaken(rs1.getInt("Wickets_Taken"));
			player.setBestFigures(rs1.getString("Best_Figures"));
			player.setFiveWickets(rs1.getInt("Five_Wicket_Hauls"));
			player.setRunOuts(rs1.getInt("Run_Outs"));
			player.setCatches(rs1.getInt("Catches"));
			player.setStumpings(rs1.getInt("Stumpings"));
		}

		while (rs1.next()) {
			player.setMatches(rs1.getInt("Matches") + player.getMatches());
			player.setBattingInnings(rs1.getInt("Batting_Innings") + player.getBattingInnings());
			player.setNotOuts(rs1.getInt("Not_Outs") + player.getNotOuts());
			player.setRunsScored(rs1.getInt("Runs_Scored") + player.getRunsScored());
			player.setBallsFaced(rs1.getInt("Balls_Faced") + player.getBallsFaced());
			player.setFifties(rs1.getInt("Fifties") + player.getFifties());
			player.setHundreds(rs1.getInt("Hundreds") + player.getHundreds());
			player.setFours(rs1.getInt("Fours") + player.getFours());
			player.setSixes(rs1.getInt("Sixes") + player.getSixes());
			player.setBowlingInnings(rs1.getInt("Bowling_Innings") + player.getBowlingInnings());
			player.setBallsBowled(rs1.getInt("Balls_Bowled") + player.getBallsBowled());
			player.setRunsConceded(rs1.getInt("Runs_Conceded") + player.getRunsConceded());
			player.setWicketsTaken(rs1.getInt("Wickets_Taken") + player.getWicketsTaken());
			player.setFiveWickets(rs1.getInt("Five_Wicket_Hauls") + player.getFiveWickets());
			player.setRunOuts(rs1.getInt("Run_Outs") + player.getRunOuts());
			player.setCatches(rs1.getInt("Catches") + player.getCatches());
			player.setStumpings(rs1.getInt("Stumpings") + player.getStumpings());

			if (rs1.getString("Best_Figures").equals("NA") || player.getBestFigures().equals("NA")) {
				if (!(rs1.getString("Best_Figures").equals("NA")) && player.getBestFigures().equals("NA")) {
					player.setBestFigures(rs1.getString("Best_Figures"));
				}
			} else if (!(rs1.getString("Best_Figures").equals("NA") && player.getBestFigures().equals("NA"))) {

				Scanner newBestFigure = new Scanner(rs1.getString("Best_Figures")).useDelimiter("/");

				int newWickets = Integer.parseInt(newBestFigure.next());
				int newRuns = Integer.parseInt(newBestFigure.next());

				Scanner oldBestFigure = new Scanner(player.getBestFigures()).useDelimiter("/");

				int oldWickets = Integer.parseInt(oldBestFigure.next());
				int oldRuns = Integer.parseInt(oldBestFigure.next());

				if (newWickets > oldWickets) {
					player.setBestFigures(rs1.getString("Best_Figures"));
				} else if (oldWickets == newWickets) {
					if (newRuns < oldRuns) {
						player.setBestFigures(rs1.getString("Best_Figures"));
					}
				}
			}

			if (rs1.getString("High_Score").equals("NA") || player.getHighScore().equals("NA")) {
				if (!(rs1.getString("High_Score").equals("NA")) && player.getHighScore().equals("NA")) {
					player.setHighScore(rs1.getString("High_Score"));
				}
			} else if (!(rs1.getString("High_Score").equals("NA") && player.getHighScore().equals("NA"))) {
				int oldHighScore = Integer.parseInt(player.getHighScore().replace("*", ""));
				int newHighScore = Integer.parseInt(rs1.getString("High_Score").replace("*", ""));

				if (newHighScore > oldHighScore) {
					player.setHighScore(rs1.getString("High_Score"));
				} else if (newHighScore == oldHighScore) {
					if (rs1.getString("High_Score").contains("*")) {
						player.setHighScore(rs1.getString("High_Score"));
					}
				}
			}
		}

		DecimalFormat f = new DecimalFormat("##.0");

		if (player.getBallsFaced() != 0) {
			player.setBattingStrikeRate(
					f.format((double) player.getRunsScored() / player.getBallsFaced() * 100) + "");
		} else {
			player.setBattingStrikeRate("NA");
		}

		if ((player.getBattingInnings() - player.getNotOuts()) != 0) {
			player.setBattingAverage(f.format(
					(double) player.getRunsScored() / (player.getBattingInnings() - player.getNotOuts()))
					+ "");
		} else {
			player.setBattingAverage("NA");
		}

		if (player.getWicketsTaken() != 0) {
			player.setBowlingAverage(
					f.format((double) player.getRunsConceded() / player.getWicketsTaken()) + "");
		} else {
			player.setBowlingAverage("NA");
		}

		if ((player.getBallsBowled() / 6) != 0) {
			player.setEconomy(f.format((double) player.getRunsConceded() / (player.getBallsBowled() / 6)) + "");
		} else {
			player.setEconomy("NA");
		}

		if (player.getWicketsTaken() != 0) {
			player.setBowlingStrikeRate(
					f.format((double) player.getBallsBowled() / player.getWicketsTaken()) + "");
		} else {
			player.setBowlingStrikeRate("NA");
		}

		players.add(player);

		return players;
	}

	public ArrayList<PlayerStatisticsDTO> getSeasonPlayerStatistics(String player_id, String p_season)
			throws SQLException {
		ArrayList<PlayerStatisticsDTO> players = new ArrayList<PlayerStatisticsDTO>();

		DBConnect dbconnect = new DBConnect();
		ResultSet rs1 = dbconnect.executeSelect("SELECT * FROM tblPlayerStatistics WHERE Player_ID = \"" + player_id
				+ "\" AND Season = \"" + p_season + "\";");

		PlayerStatisticsDTO player = new PlayerStatisticsDTO();
		player.setPlayerID(player_id);

		ResultSet rs2 = dbconnect
				.executeSelect("SELECT Player_Name FROM tblPlayers WHERE Player_ID = \"" + player_id + "\"");

		if (rs2.next()) {
			player.setPlayerName(rs2.getString("Player_Name"));
		}

		if (rs1.next()) {
			player.setMatches(rs1.getInt("Matches"));
			player.setBattingInnings(rs1.getInt("Batting_Innings"));
			player.setNotOuts(rs1.getInt("Not_Outs"));
			player.setRunsScored(rs1.getInt("Runs_Scored"));
			player.setBallsFaced(rs1.getInt("Balls_Faced"));
			player.setHighScore(rs1.getString("High_Score"));
			player.setFifties(rs1.getInt("Fifties"));
			player.setHundreds(rs1.getInt("Hundreds"));
			player.setFours(rs1.getInt("Fours"));
			player.setSixes(rs1.getInt("Sixes"));
			player.setBowlingInnings(rs1.getInt("Bowling_Innings"));
			player.setBallsBowled(rs1.getInt("Balls_Bowled"));
			player.setRunsConceded(rs1.getInt("Runs_Conceded"));
			player.setWicketsTaken(rs1.getInt("Wickets_Taken"));
			player.setBestFigures(rs1.getString("Best_Figures"));
			player.setFiveWickets(rs1.getInt("Five_Wicket_Hauls"));
			player.setRunOuts(rs1.getInt("Run_Outs"));
			player.setCatches(rs1.getInt("Catches"));
			player.setStumpings(rs1.getInt("Stumpings"));
		}

		DecimalFormat f = new DecimalFormat("##.0");

		if (player.getBallsFaced() != 0) {
			player.setBattingStrikeRate(
					f.format((double) player.getRunsScored() / player.getBallsFaced() * 100) + "");
		} else {
			player.setBattingStrikeRate("NA");
		}

		if ((player.getBattingInnings() - player.getNotOuts()) != 0) {
			player.setBattingAverage(f.format(
					(double) player.getRunsScored() / (player.getBattingInnings() - player.getNotOuts()))
					+ "");
		} else {
			player.setBattingAverage("NA");
		}

		if (player.getWicketsTaken() != 0) {
			player.setBowlingAverage(
					f.format((double) player.getRunsConceded() / player.getWicketsTaken()) + "");
		} else {
			player.setBowlingAverage("NA");
		}

		if ((player.getBallsBowled() / 6) != 0) {
			player.setEconomy(f.format((double) player.getRunsConceded() / (player.getBallsBowled() / 6)) + "");
		} else {
			player.setEconomy("NA");
		}

		if (player.getWicketsTaken() != 0) {
			player.setBowlingStrikeRate(
					f.format((double) player.getBallsBowled() / player.getWicketsTaken()) + "");
		} else {
			player.setBowlingStrikeRate("NA");
		}

		players.add(player);

		return players;
	}

	public ArrayList<PlayerSeasonsDTO> getSeasonsPlayed(String player_id) throws SQLException {
		ArrayList<PlayerSeasonsDTO> seasons = new ArrayList<PlayerSeasonsDTO>();

		DBConnect dbconnect = new DBConnect();
		ResultSet rs = dbconnect.executeSelect("SELECT Player_ID, Season FROM tblPlayerStatistics WHERE Player_ID = \"" + player_id + "\" ORDER BY Season DESC;");

		while (rs.next()) {
			PlayerSeasonsDTO season = new PlayerSeasonsDTO();
			season.setPlayerID(rs.getString("Player_ID"));
			season.setSeason(rs.getInt("Season") + "");

			seasons.add(season);
		}
		return seasons;
	}

	public ArrayList<MatchesDTO> getMatchInforation(String player_id) throws SQLException {

		ArrayList<MatchesDTO> matches = new ArrayList<MatchesDTO>();

		DBConnect dbconnect = new DBConnect();
		ResultSet rs = dbconnect.executeSelect(
				"SELECT tblMatches.Match_ID, Match_Date, Format, Team_1_ID, Team_2_ID, Toss_Winner_ID, Toss_Decision, Is_Result, Win_Type, Won_By, Match_Winner_ID, Innings_1_Total, Innings_1_Overs, Innings_1_Wickets, Innings_2_Total, Innings_2_Overs, Innings_2_Wickets "
						+ "FROM tblMatches, tblPlayerMatches "
						+ "WHERE Val(tblMatches.Match_ID) = Val(tblPlayerMatches.Match_ID) AND tblPlayerMatches.Player_ID = \""+ player_id +"\";");

		while (rs.next()) {
			MatchesDTO match = new MatchesDTO();

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

			matches.add(match);
		}
		return matches;
	}
}
