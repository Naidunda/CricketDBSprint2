package app.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import app.connection.DBConnect;
import app.model.dto.PlayersDTO;


public class PlayerManagementDAO {
	
	// Method retrieves information about a specific player by their ID.
	public PlayersDTO getPlayerInformation(String playerID) throws SQLException {
		PlayersDTO player = new PlayersDTO();
		
		// Create a new database connection
		DBConnect dbconnect = new DBConnect();
		
		 // Execute a SQL query to fetch player information based on the provided playerID.
		ResultSet rs = dbconnect.executeSelect("SELECT * FROM tblPlayers WHERE Player_ID = \"" + playerID + "\";");

		if (rs.next()) {
			// Set player's properties from the query results
			player.setPlayerID(rs.getString("Player_ID"));
			player.setPlayerName(rs.getString("Player_Name"));
			player.setDob(rs.getDate("DOB"));
			player.setBattingHand(rs.getString("Batting_Hand"));
			player.setBowlingSkill(rs.getString("Bowling_Skill"));
			player.setKeeper(rs.getBoolean("Is_Keeper"));
			
			// Construct the player's role message based on batting hand, bowling skill, and keeper status.
			String mess = player.getBattingHand() + " | " + player.getBowlingSkill();
			if (player.isKeeper()) {
				mess += " | Wicket-Keeper";
			}

			player.setRole(mess);
		}
		return player;
	}
	
	  // Method retrieves information about all players in the database.
	public ArrayList<PlayersDTO> getAllPlayerInformation(String playerID) throws SQLException {
		ArrayList<PlayersDTO> players = new ArrayList<PlayersDTO>();
		
		// Create a new database connection
		DBConnect dbconnect = new DBConnect();
		
		// Execute a SQL query to fetch information about all players.
		ResultSet rs = dbconnect.executeSelect("SELECT * FROM tblPlayers");

		while (rs.next()) {
			PlayersDTO player = new PlayersDTO();
			
			// Set player's properties from the query results
			player.setPlayerID(rs.getString("Player_ID"));
			player.setPlayerName(rs.getString("Player_Name"));
			player.setDob(rs.getDate("DOB"));
			player.setBattingHand(rs.getString("Batting_Hand"));
			player.setBowlingSkill(rs.getString("Bowling_Skill"));
			player.setKeeper(rs.getBoolean("Is_Keeper"));
			
			// Construct the player's role message based on batting hand, bowling skill, and keeper status.
			String mess = player.getBattingHand() + " | " + player.getBowlingSkill();
			if (player.isKeeper()) {
				mess += " | Wicket-Keeper";
			}

			player.setRole(mess);
			
			players.add(player);
		}
		return players;
	}

}
