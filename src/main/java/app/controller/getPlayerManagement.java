package app.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.connection.DBConnect;
import app.model.dao.PlayerManagementDAO;
import app.model.dto.PlayersDTO;

/**
 * Servlet implementation class getManagement
 */
@WebServlet("/getPlayerManagement")
public class getPlayerManagement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getPlayerManagement() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String playerID =  request.getParameter("playerID"); // Gets the player's ID from the request.
		
		
		//If there is no playerID in the request, retrieves the player whose ID has the lowest value.
		if (playerID.equals("")){
			DBConnect dbconnect = new DBConnect();
			ResultSet rs = dbconnect.executeSelect("SELECT TOP 1 Player_ID FROM tblPlayers");
			
			try {
				if(rs.next()) {
					playerID = rs.getString("Player_ID");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		 // Set the player's ID as an attribute for request.
		request.setAttribute("playerid", playerID);
		
		try {
			PlayersDTO player = new PlayerManagementDAO().getPlayerInformation(playerID);
			
			// Extract bowling skill details
			Scanner scBowlingSkill =  new Scanner(player.getBowlingSkill());
			String bowlingArm = scBowlingSkill.next();
			
			//Makes a singular string containing all the player's bowling details and sets it as an attribute for the request.
			if (bowlingArm.equals("NA")) { 
				request.setAttribute("bowlingarm", "NA");
				request.setAttribute("bowlingskill", "NA");
			} else {
			
				bowlingArm += " " + scBowlingSkill.next();
				
				request.setAttribute("bowlingarm", bowlingArm);
				
				String bowlingSkill = scBowlingSkill.next();
				
				while (scBowlingSkill.hasNext()) {
					bowlingSkill += " " + scBowlingSkill.next();
				}
				
				request.setAttribute("bowlingskill", bowlingSkill);
			}
			
			if(player.isKeeper() == true) { //Sets "Yes or "No" as an attribute based of if the player is a keeper.
				request.setAttribute("iskeeper", "Yes");
			} else {
				request.setAttribute("iskeeper", "No");
			}
			
			ArrayList<PlayersDTO> players = new PlayerManagementDAO().getAllPlayerInformation(playerID);
			
			// Sort the player list by player name.
			players.sort((o1, o2) -> o1.getPlayerName().compareTo(o2.getPlayerName()));
			
			// Set the player's information and the full list of players as an attribute for request.
			request.setAttribute("player", player);
			request.setAttribute("players", players);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// Forward the request to the "player-management.jsp" page for rendering.
		request.getRequestDispatcher("WEB-INF/pages/player-management.jsp").forward(request, response);
	}
}
