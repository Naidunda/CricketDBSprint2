package app.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import app.connection.DBConnect;
import app.model.dto.PlayerStatisticsDTO;
import app.model.dto.PlayersDTO;
import app.model.dto.TeamsDTO;

public class TeamsDAO {
	public ArrayList<TeamsDTO> getTeamsInformation() throws SQLException {

		ArrayList<TeamsDTO> teams = new ArrayList<TeamsDTO>();

		DBConnect dbconnect = new DBConnect();

		ResultSet rs = dbconnect.executeSelect("SELECT * FROM tblTeams ORDER BY Team_Name, Age_Group");

		while (rs.next()) {
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
}
