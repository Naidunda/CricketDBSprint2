package app.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.model.dao.PlayersDAO;
import app.model.dto.MatchesDTO;
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
		String playerID =  request.getParameter("playerID"); // Gets the player's ID from the request.
		String season = request.getParameter("season"); // Gets the selected season from the request.
		
		request.setAttribute("player_id", playerID);  // Set the player's ID as an attribute for use in the JSP.
		request.setAttribute("season", season); // Set the selected season as an attribute for use in the JSP.
		
		try {
			PlayersDTO player = new PlayersDAO().getPlayerProfile(playerID);
			request.setAttribute("playerprofile", player);
			
			ArrayList<TeamPlayersDTO> teams = new PlayersDAO().getPlayerTeams(playerID);
			request.setAttribute("playerteams", teams);
			
			if (season.equals("All-Time")) {
				// If the selected season is "All-Time," retrieves all the player's statistics.
				ArrayList<PlayerStatisticsDTO> playerStats = new PlayersDAO().getAllPlayerStatistics(playerID);
				request.setAttribute("playerstats", playerStats);
			} else {
				// If a specific season is selected, retrieves player's statistics for that season.
				ArrayList<PlayerStatisticsDTO> playerStats = new PlayersDAO().getSeasonPlayerStatistics(playerID, season);
				request.setAttribute("playerstats", playerStats);
			}
			
			ArrayList<PlayerSeasonsDTO> seasonsPlayed = new PlayersDAO().getSeasonsPlayed(playerID);
			
			// Set the seasonsPlayed array as attributes in the request.
			request.setAttribute("seasonsPlayed", seasonsPlayed);
			
			ArrayList<MatchesDTO> matches = new PlayersDAO().getMatchInforation(playerID);
			
			// Set the matches array as attributes in the request.
			request.setAttribute("matchinformation", matches);
			
			
			// Forwards the request to the "player-profile.jsp" page for rendering.
			request.getRequestDispatcher("WEB-INF/pages/player-profile.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
