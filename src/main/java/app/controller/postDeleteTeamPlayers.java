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
		
		
		String playerID =  request.getParameter("playerID");
		String teamID =  request.getParameter("teamID");
		String playerName =  request.getParameter("playerName");
		
		DBConnect dbconnect = new DBConnect();
		
		String query = String.format("DELETE FROM tblTeamPlayers WHERE Player_ID = \"%s\" AND Team_ID = \"%s\";", playerID, teamID);
		
		dbconnect.executeQuery(query);
	}

}
