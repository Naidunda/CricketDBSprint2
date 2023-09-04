package app.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.model.dao.TeamProfileDAO;
import app.model.dto.MatchesDTO;
import app.model.dto.PlayerStatisticsDTO;
import app.model.dto.PlayersDTO;
import app.model.dto.TeamsDTO;

/**
 * Servlet implementation class getTeamProfile
 */
@WebServlet("/getTeamProfile")
public class getTeamProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getTeamProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String teamID =  request.getParameter("teamID"); // Gets the team's ID from the request.
		
		try {
			// Retrieve team information based on the team's id and sets it as an attribute for the request.
			TeamsDTO team = new TeamProfileDAO().getTeamsInformation(teamID);
			request.setAttribute("teamsinformation", team);
			
			 // Retrieve player statistics for the team and sets the array as an attribute for the request.
			ArrayList<PlayerStatisticsDTO> playerStatistics = new TeamProfileDAO().getPlayerStatistics(teamID);
			request.setAttribute("playerstatistics", playerStatistics);
			
			// Retrieve player information for the team and sets the array as an attribute for the request.
			ArrayList<PlayersDTO> playerInformation = new TeamProfileDAO().getPlayerInformation(teamID);
			request.setAttribute("playerinformation", playerInformation);
			
			// Retrieves match information related to the team and sets the array as an attribute for the request.
			ArrayList<MatchesDTO> matches = new TeamProfileDAO().getMatchInforation(teamID);
			request.setAttribute("matchinformation", matches);
			
			// Forward the request to the "team-profile.jsp" page for rendering.
			request.getRequestDispatcher("WEB-INF/pages/team-profile.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
