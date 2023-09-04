package app.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.connection.DBConnect;

/**
 * Servlet implementation class postCreateTeam
 */
@WebServlet("/postCreateTeam")
public class postCreateTeam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public postCreateTeam() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Retrieves team information from HTTP POST request parameters
		String name = request.getParameter("team-name");
		String location= request.getParameter("location");
		String ageGroup = request.getParameter("age-group");
		String club = request.getParameter("is-club");
		
		 // Converts the club parameter to a boolean
		boolean isClub;
		if(club.equals("Yes")) {
			isClub = true;
		} else {
			isClub = false;
		}

		// Creates a DBConnect instance for database interaction.
		DBConnect dbconnect = new DBConnect();
		
		// Constructs a SQL query to insert the team into the databases.
		String query = String.format("INSERT INTO tblTeams(Team_Name, Age_Group, Location, isClub) VALUES(\"%s\",\"%s\",\"%s\",%s)", name, ageGroup, location, isClub);
		
		// Execute the SQL query to add the team into the database.
		dbconnect.executeQuery(query);
				
	}
}
