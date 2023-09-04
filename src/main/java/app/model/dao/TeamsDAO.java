package app.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import app.connection.DBConnect;
import app.model.dto.TeamsDTO;

public class TeamsDAO {
	// Method to retrieve team information for every team in the database.
	public ArrayList<TeamsDTO> getTeamsInformation(String search) throws SQLException {

		ArrayList<TeamsDTO> teams = new ArrayList<TeamsDTO>();
		
		// Create a new database connection
		DBConnect dbconnect = new DBConnect();
		
		 // Execute a SQL query to fetch teams based on the provided search query.
		ResultSet rs = dbconnect.executeSelect("SELECT * FROM tblTeams WHERE Team_Name LIKE \"*" + search + "*\" ORDER BY Team_Name, Age_Group");

		while (rs.next()) {
			TeamsDTO team = new TeamsDTO();
			
			// Set team's properties from the query results
			team.setTeamID(rs.getString("Team_ID"));
			team.setTeamName(rs.getString("Team_Name"));
			team.setAgeGroup(rs.getString("Age_Group"));
			team.setLocation(rs.getString("Location"));
			team.setClub(rs.getBoolean("isClub"));
			
			teams.add(team);
		}
		return teams;
	}
}
