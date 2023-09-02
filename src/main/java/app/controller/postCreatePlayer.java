package app.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Year;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.connection.DBConnect;

/**
 * Servlet implementation class postCreatePlayer
 */

public class postCreatePlayer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public postCreatePlayer() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("player-name");
		String dob = request.getParameter("dob");
		String battingHand = request.getParameter("batting-hand");
		String bowlingArm = request.getParameter("bowling-arm");
		String bowlingSkill = request.getParameter("bowling-skill");
		String keeper = request.getParameter("is-keeper");
		
		
		DBConnect dbconnect = new DBConnect();
		
		String bowlingMess;
		if(bowlingArm.equals("NA") || bowlingSkill.equals("NA")) {
			bowlingMess = "NA";
		} else {
			bowlingMess = bowlingArm + " " + bowlingSkill;
		}
		
		boolean isKeeper;
		
		if(keeper.equals("Yes")) {
			isKeeper = true;
		} else {
			isKeeper = false;
		}
		
		dbconnect.executeQuery("INSERT INTO tblPlayers (Player_Name, DOB, Batting_Hand, Bowling_Skill, Is_Keeper) "
				+ "VALUES (\"" + name + "\", DateValue(\"" + dob + "\"), \"" + battingHand + "\", \"" + bowlingMess + "\", " + keeper + ");");
		
		ResultSet rs = dbconnect.executeSelect("SELECT TOP 1 Player_ID "
				+ "FROM tblPlayers "
				+ "ORDER BY Player_ID DESC");
		
		String playerID;

		int year = Year.now().getValue(); 
		
		try {
			if (rs.next()) {
				playerID = rs.getString("Player_ID");
				
				dbconnect.executeQuery("INSERT INTO tblPlayerStatistics(Player_ID, Season) "
						+ "VALUES (" + playerID + "," + year + ");");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
