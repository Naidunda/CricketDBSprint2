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
		String playerID =  request.getParameter("playerID");
		String teamID =  request.getParameter("teamID");
		String playerName =  request.getParameter("playerName");
		
		DBConnect dbconnect = new DBConnect();
		
		String query = String.format("INSERT INTO tblTeamPlayers(Team_ID, Player_ID) VALUES(\"%s\",\"%s\");", teamID, playerID);
		
		dbconnect.executeQuery(query);
	}

}
