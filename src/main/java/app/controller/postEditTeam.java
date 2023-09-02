package app.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.connection.DBConnect;

/**
 * Servlet implementation class postEditTeam
 */
@WebServlet("/postEditTeam")
public class postEditTeam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public postEditTeam() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String teamID = request.getParameter("teamID");
		String name = request.getParameter("team-name");
		String ageGroup = request.getParameter("age-group-edit");
		String location = request.getParameter("location");
		String club = request.getParameter("is-club-edit");

		boolean isClub;
		
		if(club.equals("Yes")) {
			isClub = true;
		} else {
			isClub = false;
		}
		
		DBConnect dbconnect = new DBConnect();
		
		String query = String.format("UPDATE tblTeams "
				+ "SET Team_Name = \"%s\", Age_Group = \"%s\", Location = \"%s\", isClub = %s "
				+ "WHERE Team_ID = %s;", name, ageGroup, location, isClub, Integer.parseInt(teamID));
		
		dbconnect.executeQuery(query);
	
	}

}
