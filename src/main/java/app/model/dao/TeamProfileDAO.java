package app.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import app.connection.DBConnect;
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
}
