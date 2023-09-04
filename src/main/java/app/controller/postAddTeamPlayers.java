package app.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.connection.DBConnect;

/**
 * Servlet implementation class postAddTeamPlayers
 */
@WebServlet("/postAddTeamPlayers")
public class postAddTeamPlayers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public postAddTeamPlayers() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Get the playerID, and teamID from the HTTP POST request parameters.
		String playerID =  request.getParameter("playerID");
		String teamID =  request.getParameter("teamID");
		
		 // Create a new DBConnect instance to interact with the database.
		DBConnect dbconnect = new DBConnect();
		
		// Constructs an SQL query to insert the player into the team.
		String query = String.format("INSERT INTO tblTeamPlayers(Team_ID, Player_ID) VALUES(\"%s\",\"%s\");", teamID, playerID);
		
		// Execute the SQL query to add the player to the team.
		dbconnect.executeQuery(query);
	}

}
