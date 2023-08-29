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
 * Servlet implementation class getMatches
 */
@WebServlet("/getMatches")
public class getMatches extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getMatches() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sortBy = request.getParameter("sortBy");
		String direction = request.getParameter("direction");
		String search = request.getParameter("search");
		
		
		try {
			ArrayList<MatchesDTO> matches = new MatchesDAO().getMatchInformation(search);
			ArrayList<FixturesDTO> fixtures = new MatchesDAO().getFixtureInformation(search);
			
			
			if (sortBy.equals("Date")) {
				if (direction.equals("fa-arrow-down-a-z")) {
					matches.sort((o1, o2) -> o1.getM_match_date().compareTo(o2.getM_match_date()));
					fixtures.sort((o1, o2) -> o1.getF_match_date().compareTo(o2.getF_match_date()));
				} else {
					matches.sort((o1, o2) -> o2.getM_match_date().compareTo(o1.getM_match_date()));
					fixtures.sort((o1, o2) -> o2.getF_match_date().compareTo(o1.getF_match_date()));
				}
			} else {
				if (direction.equals("fa-arrow-down-a-z")) {
					matches.sort((o1, o2) -> o1.getM_format().compareTo(o2.getM_format()));
					fixtures.sort((o1, o2) -> o1.getF_format().compareTo(o2.getF_format()));
				} else {
					matches.sort((o1, o2) -> o2.getM_format().compareTo(o1.getM_format()));
					fixtures.sort((o1, o2) -> o2.getF_format().compareTo(o1.getF_format()));
				}
			}
			
			
			request.setAttribute("matchinformation", matches);
			request.setAttribute("fixtureinformation", fixtures);
			
			request.setAttribute("sortby", sortBy);
			request.setAttribute("direction", direction);
			request.setAttribute("search", search);
			
			request.getRequestDispatcher("WEB-INF/pages/matches.jsp").forward(request, response);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
