package app.model.dto;

import java.io.Serializable;
import java.sql.Date;

public class MatchesDTO implements Serializable{
	
	private String matchID;
	private Date matchDate;
	private String format;
	private String teamID1;
	private String teamName1;
	private String teamAgeGroup1;
	private String teamID2;
	private String teamName2;
	private String teamAgeGroup2;
	private String tossWinnerID;
	private String tossDecision;
	private Boolean isResult;
	private String winType;
	private int wonBy;
	private String matchWinnerID;
	private String winMessage;
	private int inningsTotal1;
	private String inningsOvers1;
	private int inningsWickets1;
	private int inningsTotal2;
	private String inningsOvers2;
	private int inningsWickets2;
	
	public String getMatchID() {
		return matchID;
	}
	public void setMatchID(String matchID) {
		this.matchID = matchID;
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
	public String getTossWinnerID() {
		return tossWinnerID;
	}
	public void setTossWinnerID(String tossWinnerID) {
		this.tossWinnerID = tossWinnerID;
	}
	public String getTossDecision() {
		return tossDecision;
	}
	public void setTossDecision(String tossDecision) {
		this.tossDecision = tossDecision;
	}
	public Boolean isResult() {
		return isResult;
	}
	public void setResult(Boolean isResult) {
		this.isResult = isResult;
	}
	public String getWinType() {
		return winType;
	}
	public void setWinType(String winType) {
		this.winType = winType;
	}
	public int getWonBy() {
		return wonBy;
	}
	public void setWonBy(int wonBy) {
		this.wonBy = wonBy;
	}
	public String getMatchWinnerID() {
		return matchWinnerID;
	}
	public void setMatchWinnerID(String matchWinnerID) {
		this.matchWinnerID = matchWinnerID;
	}
	public String getWinMessage() {
		return winMessage;
	}
	public void setWinMessage(String winMessage) {
		this.winMessage = winMessage;
	}
	public int getInningsTotal1() {
		return inningsTotal1;
	}
	public void setInningsTotal1(int inningsTotal1) {
		this.inningsTotal1 = inningsTotal1;
	}
	public String getInningsOvers1() {
		return inningsOvers1;
	}
	public void setInningsOvers1(String inningsOvers1) {
		this.inningsOvers1 = inningsOvers1;
	}
	public int getInningsWickets1() {
		return inningsWickets1;
	}
	public void setInningsWickets1(int inningsWickets1) {
		this.inningsWickets1 = inningsWickets1;
	}
	public int getInningsTotal2() {
		return inningsTotal2;
	}
	public void setInningsTotal2(int inningsTotal2) {
		this.inningsTotal2 = inningsTotal2;
	}
	public String getInningsOvers2() {
		return inningsOvers2;
	}
	public void setInningsOvers2(String inningsOvers2) {
		this.inningsOvers2 = inningsOvers2;
	}
	public int getInningsWickets2() {
		return inningsWickets2;
	}
	public void setInningsWickets2(int inningsWickets2) {
		this.inningsWickets2 = inningsWickets2;
	}
	@Override
	public String toString() {
		return "MatchesDTO [matchID=" + matchID + ", matchDate=" + matchDate + ", format=" + format + ", teamID1="
				+ teamID1 + ", teamName1=" + teamName1 + ", teamAgeGroup1=" + teamAgeGroup1 + ", teamID2=" + teamID2
				+ ", teamName2=" + teamName2 + ", teamAgeGroup2=" + teamAgeGroup2 + ", tossWinnerID=" + tossWinnerID
				+ ", tossDecision=" + tossDecision + ", isResult=" + isResult + ", winType=" + winType + ", wonBy="
				+ wonBy + ", matchWinnerID=" + matchWinnerID + ", winMessage=" + winMessage + ", inningsTotal1="
				+ inningsTotal1 + ", inningsOvers1=" + inningsOvers1 + ", inningsWickets1=" + inningsWickets1
				+ ", inningsTotal2=" + inningsTotal2 + ", inningsOvers2=" + inningsOvers2 + ", inningsWickets2="
				+ inningsWickets2 + "]";
	}
}
