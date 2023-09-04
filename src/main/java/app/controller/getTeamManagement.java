package app.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.connection.DBConnect;
import app.model.dao.TeamManagementDAO;
import app.model.dto.TeamPlayersDTO;
import app.model.dto.TeamsDTO;

/**
 * Servlet implementation class getTeamManagement
 */
@WebServlet("/getTeamManagement")
public class getTeamManagement extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public getTeamManagement() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String teamID = request.getParameter("teamID");  // Gets the team's  ID from the request.

		//If there is no teamID in the request, retrieves the team whose ID has the lowest value.
		if (teamID.equals("")) {
			DBConnect dbconnect = new DBConnect();

			ResultSet rs = dbconnect.executeSelect("SELECT TOP 1 Team_ID FROM tblTeams");

			try {
				if (rs.next()) {
					teamID = rs.getString("Team_ID");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		// Set the team's ID as an attribute for request.
		request.setAttribute("teamid", teamID);

		try {
			TeamsDTO team = new TeamManagementDAO().getTeamInformation(teamID);

			if (team.isClub() == true) { // Check if the team is a club and set the "isclub" attribute accordingly.
				request.setAttribute("isclub", "Yes");
			} else {
				request.setAttribute("isclub", "No");
			}

			ArrayList<TeamsDTO> teams = new TeamManagementDAO().getAllTeamInformation(teamID);
			
			// Set the team's information and the full list of teams as attributes for the request.
			request.setAttribute("teams", teams);

			ArrayList<TeamPlayersDTO> teamPlayers = new TeamManagementDAO().getTeamPlayers(teamID);
			ArrayList<TeamPlayersDTO> nonTeamPlayers = new TeamManagementDAO().getNonTeamPlayers(teamID);
			
			 // Set the player's who play for the team and players who do not as attributes for the request.
			request.setAttribute("teamplayers", teamPlayers);
			request.setAttribute("nonteamplayers", nonTeamPlayers);
			
			 // Forward the request to the "team-management.jsp" page for rendering.
			request.getRequestDispatcher("WEB-INF/pages/team-management.jsp").forward(request, response);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
