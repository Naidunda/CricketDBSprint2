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
import app.model.dao.TeamsDAO;
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
		String teamID =  request.getParameter("teamID");
		
		try {
			ArrayList<TeamsDTO> teams = new TeamProfileDAO().getTeamsInformation(teamID);
			request.setAttribute("teamsinformation", teams);
			
			ArrayList<PlayerStatisticsDTO> playerStatistics = new TeamProfileDAO().getPlayerStatistics(teamID);
			request.setAttribute("playerstatistics", playerStatistics);
			
			ArrayList<PlayersDTO> playerInformation = new TeamProfileDAO().getPlayerInformation(teamID);
			request.setAttribute("playerinformation", playerInformation);
			
			request.getRequestDispatcher("WEB-INF/pages/team-profile.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
