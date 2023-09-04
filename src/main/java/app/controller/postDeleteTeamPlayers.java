package app.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.connection.DBConnect;

/**
 * Servlet implementation class postDeleteTeamPlayers
 */
@WebServlet("/postDeleteTeamPlayers")
public class postDeleteTeamPlayers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public postDeleteTeamPlayers() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Retrieve player's ID and team's ID from HTTP POST request parameters.
		String playerID =  request.getParameter("playerID");
		String teamID =  request.getParameter("teamID");
		
		// Create a DBConnect instance for database interaction.
		DBConnect dbconnect = new DBConnect();
		
		// Constructs a SQL query to delete the player from the team in the database
		String query = String.format("DELETE FROM tblTeamPlayers WHERE Player_ID = \"%s\" AND Team_ID = \"%s\";", playerID, teamID);
		
		// Executes the SQL query to delete the player from the team in the database
		dbconnect.executeQuery(query);
	}

}
