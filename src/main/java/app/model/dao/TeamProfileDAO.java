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
	
	public ArrayList<TeamsDTO> getTeamsInformation(String t_team_id) throws SQLException {

		ArrayList<TeamsDTO> teams = new ArrayList<TeamsDTO>();

		DBConnect dbconnect = new DBConnect();

		ResultSet rs = dbconnect.executeSelect("SELECT * FROM tblTeams WHERE Team_ID = \"" + t_team_id + "\"");

		if (rs.next()) {
			TeamsDTO team = new TeamsDTO();
			
			team.setT_team_id(rs.getString("Team_ID"));
			team.setT_team_name(rs.getString("Team_Name"));
			team.setT_age_group(rs.getString("Age_Group"));
			team.setT_location(rs.getString("Location"));
			team.setT_is_club(rs.getBoolean("isClub"));
			
			teams.add(team);
		}
		return teams;
	}
	
	public ArrayList<PlayerStatisticsDTO> getPlayerStatistics(String t_team_id) throws SQLException {
		
		ArrayList<PlayerStatisticsDTO> players = new ArrayList<PlayerStatisticsDTO>();
		DBConnect dbconnect = new DBConnect();
		
		ResultSet rs1= dbconnect.executeSelect("SELECT * FROM tblTeamPlayers WHERE Team_ID = \"" + t_team_id + "\";");
		
		while (rs1.next()) {
			ArrayList<PlayerStatisticsDTO> playerStats = new PlayersDAO().getAllPlayerStatistics(rs1.getString("Player_ID"));
			
			players.addAll(playerStats);
		}
		return players;
	}
	
	public ArrayList<PlayersDTO> getPlayerInformation(String t_team_id) throws SQLException {
		
		ArrayList<PlayersDTO> players = new ArrayList<PlayersDTO>();
		DBConnect dbconnect = new DBConnect();
		
		ResultSet rs1= dbconnect.executeSelect("SELECT * FROM tblTeamPlayers WHERE Team_ID = \"" + t_team_id + "\";");
		
		while (rs1.next()) {
			
			ArrayList<PlayersDTO> player = new PlayersDAO().getPlayerProfile(rs1.getString("Player_ID"));
			
			players.addAll(player);
		}
		return players;
	}
	
	public ArrayList<MatchesDTO> getMatchInforation(String t_team_id) throws SQLException {

		ArrayList<MatchesDTO> matches = new ArrayList<MatchesDTO>();

		DBConnect dbconnect = new DBConnect();
		ResultSet rs = dbconnect.executeSelect(
				"SELECT DISTINCT tblMatches.Match_ID, Match_Date, Format, Team_1_ID, Team_2_ID, Toss_Winner_ID, Toss_Decision, Is_Result, Win_Type, Won_By, Match_Winner_ID, Innings_1_Total, Innings_1_Overs, Innings_1_Wickets, Innings_2_Total, Innings_2_Overs, Innings_2_Wickets "
						+ "FROM tblMatches, tblPlayerMatches "
						+ "WHERE Val(tblMatches.Match_ID) = Val(tblPlayerMatches.Match_ID) AND tblPlayerMatches.Team_ID = \""+t_team_id+"\";");

		while (rs.next()) {
			MatchesDTO match = new MatchesDTO();

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

			ResultSet rs2 = dbconnect.executeSelect(
					"SELECT Team_Name FROM tblTeams WHERE Team_ID = " + match.getM_toss_winner_id() + ";");

			if (rs2.next() && match.getM_is_result() == true) {
				String tempStr = rs2.getString("Team_Name") + " won by " + match.getM_won_by() + " ";
				if (match.getM_win_type().equals("By runs")) {
					tempStr += "runs.";
				} else {
					tempStr += "wickets.";
				}
				match.setM_win_message(tempStr);
			} else {
				match.setM_win_message("Match Cancelled");
			}

			ResultSet rs3 = dbconnect.executeSelect(
					"SELECT Team_Name, Age_Group FROM tblTeams WHERE Team_ID = " + match.getM_team_1_id());

			if (rs3.next()) {
				match.setM_team_1_team_name(rs3.getString("Team_Name"));
				match.setM_team_1_age_group(rs3.getString("Age_Group"));
			}

			ResultSet rs4 = dbconnect.executeSelect(
					"SELECT Team_Name, Age_Group FROM tblTeams WHERE Team_ID = " + match.getM_team_2_id());

			if (rs4.next()) {
				match.setM_team_2_team_name(rs4.getString("Team_Name"));
				match.setM_team_2_age_group(rs4.getString("Age_Group"));
			}

			matches.add(match);
		}
		return matches;
	}
}

