package app.model.dto;

import java.io.Serializable;

public class TeamsDTO implements Serializable{
	private String teamID;
	private String teamName;
	private String ageGroup;
	private String location;
	private boolean club;
	
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
	public boolean isClub() {
		return club;
	}
	public void setClub(boolean club) {
		this.club = club;
	}
	
	@Override
	public String toString() {
		return "TeamsDTO [teamID=" + teamID + ", teamName=" + teamName + ", ageGroup=" + ageGroup + ", location="
				+ location + ", club=" + club + "]";
	}
}