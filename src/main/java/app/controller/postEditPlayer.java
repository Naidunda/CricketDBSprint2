package app.controller;

import java.io.IOException;
import java.time.Year;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.connection.DBConnect;

/**
 * Servlet implementation class postEditPlayer
 */
@WebServlet("/postEditPlayer")
public class postEditPlayer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public postEditPlayer() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String playerID = request.getParameter("playerID");
		String name = request.getParameter("player-name");
		String dob = request.getParameter("dob");
		String battingHand = request.getParameter("batting-hand-edit");
		String bowlingArm = request.getParameter("bowling-arm-edit");
		String bowlingSkill = request.getParameter("bowling-skill-edit");
		String keeper = request.getParameter("is-keeper-edit");
		
		System.out.println(playerID);
		System.out.println(name);
		System.out.println(dob);
		System.out.println(battingHand);
		System.out.println(bowlingArm);
		System.out.println(bowlingSkill);
		System.out.println(keeper);
		 

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
		
		DBConnect dbconnect = new DBConnect();
		
		
		String query = String.format("UPDATE tblPlayers "
				+ "SET Player_Name = \"%s\", dob = DateValue(\"%s\"), Batting_Hand = \"%s\", Bowling_Skill = \"%s\", Is_Keeper = %s "
				+ "WHERE Player_ID = %s;", name, dob, battingHand, bowlingMess, isKeeper, Integer.parseInt(playerID));
		
		dbconnect.executeQuery(query);
		
		
	}
}
