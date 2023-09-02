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
import app.model.dao.PlayersDAO;
import app.model.dto.PlayersDTO;
import app.model.dto.TeamPlayersDTO;

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
		
		String playerID =  request.getParameter("playerID");
		
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
		
		
		request.setAttribute("playerid", playerID);
		
		try {
			PlayersDTO player = new PlayerManagementDAO().getPlayerInformation(playerID);
		
			Scanner scBowlingSkill =  new Scanner(player.getBowlingSkill());

			String bowlingArm = scBowlingSkill.next();
			
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
			
			if(player.isKeeper() == true) {
				request.setAttribute("iskeeper", "Yes");
			} else {
				request.setAttribute("iskeeper", "No");
			}
			
			ArrayList<PlayersDTO> players = new PlayerManagementDAO().getAllPlayerInformation(playerID);
			
			players.sort((o1, o2) -> o1.getPlayerName().compareTo(o2.getPlayerName()));
			
			request.setAttribute("player", player);
			request.setAttribute("players", players);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("WEB-INF/pages/player-management.jsp").forward(request, response);
	}
}
