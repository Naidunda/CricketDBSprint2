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
import app.model.dto.FixturesDTO;
import app.model.dto.MatchesDTO;

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
		String sortBy = request.getParameter("sortBy");   // Get the sorting by criteria.
		String direction = request.getParameter("direction"); // Get the sorting direction.
		String search = request.getParameter("search"); // Get the search keyword.
		
		
		try {
			// Retrieve match and fixture information based on the search parameters.
			ArrayList<MatchesDTO> matches = new MatchesDAO().getMatchInformation(search);
			ArrayList<FixturesDTO> fixtures = new MatchesDAO().getFixtureInformation(search);
			
			// Sort the retrieved match and fixture information based on the sorting by criteria and sorting direction.
			if (sortBy.equals("Date")) {
				if (direction.equals("fa-arrow-down-a-z")) {
					matches.sort((o1, o2) -> o1.getMatchDate().compareTo(o2.getMatchDate()));
					fixtures.sort((o1, o2) -> o1.getMatchDate().compareTo(o2.getMatchDate()));
				} else {
					matches.sort((o1, o2) -> o2.getMatchDate().compareTo(o1.getMatchDate()));
					fixtures.sort((o1, o2) -> o2.getMatchDate().compareTo(o1.getMatchDate()));
				}
			} else {
				if (direction.equals("fa-arrow-down-a-z")) {
					matches.sort((o1, o2) -> o1.getFormat().compareTo(o2.getFormat()));
					fixtures.sort((o1, o2) -> o1.getFormat().compareTo(o2.getFormat()));
				} else {
					matches.sort((o1, o2) -> o2.getFormat().compareTo(o1.getFormat()));
					fixtures.sort((o1, o2) -> o2.getFormat().compareTo(o1.getFormat()));
				}
			}
			
			// Set the sorted match and fixture information as attributes in the request.
			request.setAttribute("matchinformation", matches);
			request.setAttribute("fixtureinformation", fixtures);
			
			//Sets the sort criteria as attributes in the requests
			request.setAttribute("sortby", sortBy);
			request.setAttribute("direction", direction);
			request.setAttribute("search", search);
			
			// Forward the request to the "matches.jsp" page for rendering.
			request.getRequestDispatcher("WEB-INF/pages/matches.jsp").forward(request, response);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
