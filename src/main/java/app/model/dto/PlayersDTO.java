package app.model.dto;

import java.io.Serializable;
import java.sql.Date;

public class PlayersDTO implements Serializable{
	private String playerID;
	private String playerName;
	private Date dob;
	private String battingHand;
	private String bowlingSkill;
	private boolean keeper;
	private String role;
	
	// Getters and setters for all the fields
	public String getPlayerID() {
		return playerID;
	}
	public void setPlayerID(String playerID) {
		this.playerID = playerID;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getBattingHand() {
		return battingHand;
	}
	public void setBattingHand(String battingHand) {
		this.battingHand = battingHand;
	}
	public String getBowlingSkill() {
		return bowlingSkill;
	}
	public void setBowlingSkill(String bowlingSkill) {
		this.bowlingSkill = bowlingSkill;
	}
	public boolean isKeeper() {
		return keeper;
	}
	public void setKeeper(boolean keeper) {
		this.keeper = keeper;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "PlayersDTO [playerID=" + playerID + ", playerName=" + playerName + ", dob=" + dob + ", battingHand="
				+ battingHand + ", bowlingSkill=" + bowlingSkill + ", keeper=" + keeper + ", role=" + role + "]";
	}
}
