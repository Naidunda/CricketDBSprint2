package app.model.dto;

public class BowlingScorecardDTO {
	private String matchID;
	private int innings;
	private String bowlerID;
	private String bowlerName;
	private String overs;
	private int maidens;
	private int runsConceded;
	private int wicketsTaken;
	private String economy;
	private String average;
	private int wide;
	private int noBalls;
	
	// Getters and setters for all the fields
	public String getMatchID() {
		return matchID;
	}
	public void setMatchID(String matchID) {
		this.matchID = matchID;
	}
	public int getInnings() {
		return innings;
	}
	public void setInnings(int innings) {
		this.innings = innings;
	}
	public String getBowlerID() {
		return bowlerID;
	}
	public void setBowlerID(String bowlerID) {
		this.bowlerID = bowlerID;
	}
	public String getBowlerName() {
		return bowlerName;
	}
	public void setBowlerName(String bowlerName) {
		this.bowlerName = bowlerName;
	}
	public String getOvers() {
		return overs;
	}
	public void setOvers(String overs) {
		this.overs = overs;
	}
	public int getMaidens() {
		return maidens;
	}
	public void setMaidens(int maidens) {
		this.maidens = maidens;
	}
	public int getRunsConceded() {
		return runsConceded;
	}
	public void setRunsConceded(int runsConceded) {
		this.runsConceded = runsConceded;
	}
	public int getWicketsTaken() {
		return wicketsTaken;
	}
	public void setWicketsTaken(int wicketsTaken) {
		this.wicketsTaken = wicketsTaken;
	}
	public String getEconomy() {
		return economy;
	}
	public void setEconomy(String economy) {
		this.economy = economy;
	}
	public String getAverage() {
		return average;
	}
	public void setAverage(String average) {
		this.average = average;
	}
	public int getWide() {
		return wide;
	}
	public void setWide(int wide) {
		this.wide = wide;
	}
	public int getNoBalls() {
		return noBalls;
	}
	public void setNoBalls(int noBalls) {
		this.noBalls = noBalls;
	}
	@Override
	public String toString() {
		return "BowlingScorecardDTO [matchID=" + matchID + ", innings=" + innings + ", bowlerID=" + bowlerID
				+ ", bowlerName=" + bowlerName + ", overs=" + overs + ", maidens=" + maidens + ", runsConceded="
				+ runsConceded + ", wicketsTaken=" + wicketsTaken + ", economy=" + economy + ", average=" + average
				+ ", wide=" + wide + ", noBalls=" + noBalls + "]";
	}
}