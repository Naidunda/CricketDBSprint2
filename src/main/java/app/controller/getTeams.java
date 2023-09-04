package app.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.model.dao.TeamsDAO;
import app.model.dto.TeamsDTO;

/**
 * Servlet implementation class getTeams
 */
@WebServlet("/getTeams")
public class getTeams extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getTeams() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sortBy = request.getParameter("sortBy"); // Get the sorting by criteria.
		String direction = request.getParameter("direction"); // Get the sorting direction.
		String search = request.getParameter("search"); // Get the search keyword.

		
		
		try {
			ArrayList<TeamsDTO> teams = new TeamsDAO().getTeamsInformation(search);
			
			//Sets the sort criteria as attributes in the requests
			request.setAttribute("sortby", sortBy);
			request.setAttribute("direction", direction);
			request.setAttribute("search", search);
			
			// Sorts the teams based on the specified sorting criteria and direction.
			if (sortBy.equals("Team Name")) {
	
				if(direction.equals("fa-arrow-down-a-z")) {
					teams.sort((o1, o2) -> o1.getTeamName().compareTo(o2.getTeamName()));
				} else {
					teams.sort((o1, o2) -> o2.getTeamName().compareTo(o1.getTeamName()));
				}
			}else if(sortBy.equals("Age Group")){
				if(direction.equals("fa-arrow-down-a-z")) {
					teams.sort((o1, o2) -> o1.getAgeGroup().compareTo(o2.getAgeGroup()));
				} else {
					teams.sort((o1, o2) -> o2.getAgeGroup().compareTo(o1.getAgeGroup()));
				}
			} else if (sortBy.equals("Location")) {
				if(direction.equals("fa-arrow-down-a-z")) {
					teams.sort((o1, o2) -> o1.getLocation().compareTo(o2.getLocation()));
				} else {
					teams.sort((o1, o2) -> o2.getLocation().compareTo(o1.getLocation()));
				}
			}
			
			// Set the sorted list as attributes in the request.
			request.setAttribute("teamsinformation", teams);
				
			// Forward the request to the "teams.jsp" page for rendering.
			request.getRequestDispatcher("WEB-INF/pages/teams.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
