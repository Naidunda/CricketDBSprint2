package app.model.dto;
import java.io.Serializable;
import java.sql.Date;

public class FixturesDTO implements Serializable{
	private String fixtureID;
	private Date matchDate;
	private String format;
	private String teamID1;
	private String teamName1;
	private String teamAgeGroup1;
	private String teamID2;
	private String teamName2;
	private String teamAgeGroup2;
	
	// Getters and setters for all the fields
	public String getFixtureID() {
		return fixtureID;
	}
	public void setFixtureID(String fixtureID) {
		this.fixtureID = fixtureID;
	}
	public Date getMatchDate() {
		return matchDate;
	}
	public void setMatchDate(Date matchDate) {
		this.matchDate = matchDate;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public String getTeamID1() {
		return teamID1;
	}
	public void setTeamID1(String teamID1) {
		this.teamID1 = teamID1;
	}
	public String getTeamName1() {
		return teamName1;
	}
	public void setTeamName1(String teamName1) {
		this.teamName1 = teamName1;
	}
	public String getTeamAgeGroup1() {
		return teamAgeGroup1;
	}
	public void setTeamAgeGroup1(String teamAgeGroup1) {
		this.teamAgeGroup1 = teamAgeGroup1;
	}
	public String getTeamID2() {
		return teamID2;
	}
	public void setTeamID2(String teamID2) {
		this.teamID2 = teamID2;
	}
	public String getTeamName2() {
		return teamName2;
	}
	public void setTeamName2(String teamName2) {
		this.teamName2 = teamName2;
	}
	public String getTeamAgeGroup2() {
		return teamAgeGroup2;
	}
	public void setTeamAgeGroup2(String teamAgeGroup2) {
		this.teamAgeGroup2 = teamAgeGroup2;
	}
	@Override
	public String toString() {
		return "FixturesDTO [fixtureID=" + fixtureID + ", matchDate=" + matchDate + ", format=" + format + ", teamID1="
				+ teamID1 + ", teamName1=" + teamName1 + ", teamAgeGroup1=" + teamAgeGroup1 + ", teamID2=" + teamID2
				+ ", teamName2=" + teamName2 + ", teamAgeGroup2=" + teamAgeGroup2 + "]";
	}
	
	
}
