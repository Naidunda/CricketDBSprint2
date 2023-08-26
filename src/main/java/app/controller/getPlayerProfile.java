package app.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.model.dao.PlayerStatisticsDAO;
import app.model.dao.PlayersDAO;
import app.model.dto.PlayerSeasonsDTO;
import app.model.dto.PlayerStatisticsDTO;
import app.model.dto.PlayersDTO;
import app.model.dto.TeamPlayersDTO;

/**
 * Servlet implementation class getPlayerProfile
 */
@WebServlet("/getPlayerProfile")
public class getPlayerProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getPlayerProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String playerID =  request.getParameter("playerID");
		String season = request.getParameter("season");
		
		request.setAttribute("player_id", playerID);
		
		request.setAttribute("season", season);
		
		try {
			ArrayList<PlayersDTO> players = new PlayersDAO().getPlayerProfile(playerID);
			request.setAttribute("playerprofile", players);
			
			ArrayList<TeamPlayersDTO> teams = new PlayersDAO().getPlayerTeams(playerID);
			request.setAttribute("playerteams", teams);
			
			if (season.equals("All-Time")) {
				ArrayList<PlayerStatisticsDTO> playerStats = new PlayersDAO().getAllPlayerStatistics(playerID);
				request.setAttribute("playerStats", playerStats);
			} else {
				ArrayList<PlayerStatisticsDTO> playerStats = new PlayersDAO().getSeasonPlayerStatistics(playerID, season);
				request.setAttribute("playerStats", playerStats);
			}
			
			ArrayList<PlayerSeasonsDTO> seasonsPlayed = new PlayersDAO().getSeasonsPlayed(playerID);
			request.setAttribute("seasonsPlayed", seasonsPlayed);
			
			
			request.getRequestDispatcher("WEB-INF/pages/player-profile.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
