package app.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import app.connection.DBConnect;
import app.model.dto.PlayersDTO;


public class PlayerManagementDAO {

	public PlayersDTO getPlayerInformation(String playerID) throws SQLException {
		PlayersDTO player = new PlayersDTO();

		DBConnect dbconnect = new DBConnect();
		ResultSet rs = dbconnect.executeSelect("SELECT * FROM tblPlayers WHERE Player_ID = \"" + playerID + "\";");

		if (rs.next()) {
			player.setPlayerID(rs.getString("Player_ID"));

			player.setPlayerName(rs.getString("Player_Name"));

			player.setDob(rs.getDate("DOB"));

			player.setBattingHand(rs.getString("Batting_Hand"));
			player.setBowlingSkill(rs.getString("Bowling_Skill"));
			player.setKeeper(rs.getBoolean("Is_Keeper"));
			String mess = player.getBattingHand() + " | " + player.getBowlingSkill();

			if (player.isKeeper()) {
				mess += " | Wicket-Keeper";
			}

			player.setRole(mess);
		}
		return player;
	}
	
	public ArrayList<PlayersDTO> getAllPlayerInformation(String playerID) throws SQLException {
		ArrayList<PlayersDTO> players = new ArrayList<PlayersDTO>();

		DBConnect dbconnect = new DBConnect();
		ResultSet rs = dbconnect.executeSelect("SELECT * FROM tblPlayers");

		while (rs.next()) {
			
			PlayersDTO player = new PlayersDTO();
			player.setPlayerID(rs.getString("Player_ID"));

			player.setPlayerName(rs.getString("Player_Name"));

			player.setDob(rs.getDate("DOB"));

			player.setBattingHand(rs.getString("Batting_Hand"));
			player.setBowlingSkill(rs.getString("Bowling_Skill"));
			player.setKeeper(rs.getBoolean("Is_Keeper"));
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
