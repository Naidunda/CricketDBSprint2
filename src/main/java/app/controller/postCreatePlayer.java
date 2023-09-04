package app.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Year;

import javax.servlet.ServletException;
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
		
		// Retrieves player information from HTTP POST request parameters
		String name = request.getParameter("player-name");
		String dob = request.getParameter("dob");
		String battingHand = request.getParameter("batting-hand");
		String bowlingArm = request.getParameter("bowling-arm");
		String bowlingSkill = request.getParameter("bowling-skill");
		String keeper = request.getParameter("is-keeper");
		
		// Creates a DBConnect instance for database interaction
		DBConnect dbconnect = new DBConnect();
		
		 // Contructs the bowling information into a singular string.
		String bowlingMess;
		if(bowlingArm.equals("NA") || bowlingSkill.equals("NA")) {
			bowlingMess = "NA";
		} else {
			bowlingMess = bowlingArm + " " + bowlingSkill;
		}
		
		 // Converts the keeper value to a boolean
		boolean isKeeper;
		if(keeper.equals("Yes")) {
			isKeeper = true;
		} else {
			isKeeper = false;
		}
		
		// Constructs and execute an SQL query to insert the player into the database
		dbconnect.executeQuery("INSERT INTO tblPlayers (Player_Name, DOB, Batting_Hand, Bowling_Skill, Is_Keeper) "
				+ "VALUES (\"" + name + "\", DateValue(\"" + dob + "\"), \"" + battingHand + "\", \"" + bowlingMess + "\", " + isKeeper + ");");
		
		// Retrieves the newly created player's ID
		ResultSet rs = dbconnect.executeSelect("SELECT TOP 1 Player_ID "
				+ "FROM tblPlayers "
				+ "ORDER BY Player_ID DESC");
		
		String playerID;

		int year = Year.now().getValue(); 
		
		try {
			if (rs.next()) {
				playerID = rs.getString("Player_ID");
				
				// Creates player statistics entry for the current year
				dbconnect.executeQuery("INSERT INTO tblPlayerStatistics(Player_ID, Season) "
						+ "VALUES (" + playerID + "," + year + ");");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
