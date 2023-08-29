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
		String sortBy = request.getParameter("sortBy");
		String direction = request.getParameter("direction");
		String search = request.getParameter("search");
		
		
		try {
			ArrayList<TeamsDTO> teams = new TeamsDAO().getTeamsInformation(search);
			
			request.setAttribute("teamsinformation", teams);
			request.setAttribute("sortby", sortBy);
			request.setAttribute("direction", direction);
			request.setAttribute("search", search);
			
			if (sortBy.equals("Team Name")) {
	
				if(direction.equals("fa-arrow-down-a-z")) {
					teams.sort((o1, o2) -> o1.getT_team_name().compareTo(o2.getT_team_name()));
				} else {
					teams.sort((o1, o2) -> o2.getT_team_name().compareTo(o1.getT_team_name()));
				}
			}else if(sortBy.equals("Age Group")){
				if(direction.equals("fa-arrow-down-a-z")) {
					teams.sort((o1, o2) -> o1.getT_age_group().compareTo(o2.getT_age_group()));
				} else {
					teams.sort((o1, o2) -> o2.getT_age_group().compareTo(o1.getT_age_group()));
				}
			} else if (sortBy.equals("Location")) {
				if(direction.equals("fa-arrow-down-a-z")) {
					teams.sort((o1, o2) -> o1.getT_location().compareTo(o2.getT_location()));
				} else {
					teams.sort((o1, o2) -> o2.getT_location().compareTo(o1.getT_location()));
				}
			}
				
		
			request.getRequestDispatcher("WEB-INF/pages/teams.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
