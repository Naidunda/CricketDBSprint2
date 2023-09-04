package app.model.dto;

import java.io.Serializable;

public class TeamPlayersDTO implements Serializable{
	private String teamID;
	private String teamName;
	private String ageGroup;
	private String location;
	private String playerID;
	private String playerName;
	
	// Getters and setters for all the fields
	public String getTeamID() {
		return teamID;
	}
	public void setTeamID(String teamID) {
		this.teamID = teamID;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getAgeGroup() {
		return ageGroup;
	}
	public void setAgeGroup(String ageGroup) {
		this.ageGroup = ageGroup;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
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
	@Override
	public String toString() {
		return "TeamPlayersDTO [teamID=" + teamID + ", teamName=" + teamName + ", ageGroup=" + ageGroup + ", location="
				+ location + ", playerID=" + playerID + ", playerName=" + playerName + "]";
	}
}