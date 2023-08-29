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
			
			batsmen.sort((o1, o2) -> Integer.compare(o2.getP_runs_scored(),o1.getP_runs_scored()));
			request.setAttribute("topscorers", batsmen);
			
			bowlers.sort((o1, o2) -> Integer.compare(o2.getP_wickets_taken(),o1.getP_wickets_taken()));
			request.setAttribute("topwickettakers", bowlers);
			
			
			ArrayList<MatchesDTO> matches = new MatchesDAO().getMatchInformation("");
			ArrayList<FixturesDTO> fixtures = new MatchesDAO().getFixtureInformation("");
			
			matches.sort((o1, o2) -> o2.getM_match_date().compareTo(o1.getM_match_date()));
			fixtures.sort((o1, o2) -> o1.getF_match_date().compareTo(o2.getF_match_date()));
			
			
			request.setAttribute("matchinformation", matches);
			request.setAttribute("fixtureinformation", fixtures);
			
			request.getRequestDispatcher("index.jsp").forward(request, response);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
