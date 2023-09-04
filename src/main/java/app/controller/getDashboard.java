package app.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.model.dao.MatchesDAO;
import app.model.dao.PlayerStatisticsDAO;
import app.model.dto.FixturesDTO;
import app.model.dto.MatchesDTO;
import app.model.dto.PlayerStatisticsDTO;

/**
 * Servlet implementation class getDashboard
 */
@WebServlet("/getDashboard")
public class getDashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getDashboard() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		try {
			ArrayList<PlayerStatisticsDTO> batsmen = new PlayerStatisticsDAO().getPlayerStatistics("");
			ArrayList<PlayerStatisticsDTO> bowlers = new PlayerStatisticsDAO().getPlayerStatistics("");
			
			//Sorts the array in order of their total runs scored (From highest to lowest)
			batsmen.sort((o1, o2) -> Integer.compare(o2.getRunsScored(),o1.getRunsScored()));
			request.setAttribute("topscorers", batsmen);
			
			// Sort the bowlers array based on the wickets taken in descending order (highest to lowest).
			bowlers.sort((o1, o2) -> Integer.compare(o2.getWicketsTaken(),o1.getWicketsTaken())); 
			
			// Sets the sorted batsmen and bowlers arrays as attributes in the request.
			request.setAttribute("topscorers", batsmen);
			request.setAttribute("topwickettakers", bowlers);
			
			ArrayList<MatchesDTO> matches = new MatchesDAO().getMatchInformation(""); 
			ArrayList<FixturesDTO> fixtures = new MatchesDAO().getFixtureInformation(""); 
			
			// Sort the matches array based on the match date in descending order (most recent to oldest).
			matches.sort((o1, o2) -> o2.getMatchDate().compareTo(o1.getMatchDate()));
			
			// Sort the fixtures array based on the match date in ascending order (nearest in date to furthest).
			fixtures.sort((o1, o2) -> o1.getMatchDate().compareTo(o2.getMatchDate()));
			
			 // Sets the sorted match and fixture arrays as attributes in the request.
			request.setAttribute("matchinformation", matches);
			request.setAttribute("fixtureinformation", fixtures);
			
			// Forwards the request to the "index.jsp" page for rendering.
			request.getRequestDispatcher("index.jsp").forward(request, response);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
