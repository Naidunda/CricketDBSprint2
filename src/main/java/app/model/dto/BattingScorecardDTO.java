package app.model.dto;

public class BattingScorecardDTO {
	private String matchID;
	private int innings;
	private int battingPosition;
	private String batsmanID;
	private String batsmanName;
	private String dismissalType;
	private String bowlerID;
	private String bowlerName;
	private String fielderID;
	private String fielderName;
	private String dismissalMessage;
	private int runsScored;
	private int ballsFaced;
	private int fours;
	private int sixes;
	private String strikeRate;
	
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
	public int getBattingPosition() {
		return battingPosition;
	}
	public void setBattingPosition(int battingPosition) {
		this.battingPosition = battingPosition;
	}
	public String getBatsmanID() {
		return batsmanID;
	}
	public void setBatsmanID(String batsmanID) {
		this.batsmanID = batsmanID;
	}
	public String getBatsmanName() {
		return batsmanName;
	}
	public void setBatsmanName(String batsmanName) {
		this.batsmanName = batsmanName;
	}
	public String getDismissalType() {
		return dismissalType;
	}
	public void setDismissalType(String dismissalType) {
		this.dismissalType = dismissalType;
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
	public String getFielderID() {
		return fielderID;
	}
	public void setFielderID(String fielderID) {
		this.fielderID = fielderID;
	}
	public String getFielderName() {
		return fielderName;
	}
	public void setFielderName(String fielderName) {
		this.fielderName = fielderName;
	}
	public String getDismissalMessage() {
		return dismissalMessage;
	}
	public void setDismissalMessage(String dimissalMessage) {
		this.dismissalMessage = dimissalMessage;
	}
	public int getRunsScored() {
		return runsScored;
	}
	public void setRunsScored(int runsScored) {
		this.runsScored = runsScored;
	}
	public int getBallsFaced() {
		return ballsFaced;
	}
	public void setBallsFaced(int ballsFaced) {
		this.ballsFaced = ballsFaced;
	}
	public int getFours() {
		return fours;
	}
	public void setFours(int fours) {
		this.fours = fours;
	}
	public int getSixes() {
		return sixes;
	}
	public void setSixes(int sixes) {
		this.sixes = sixes;
	}
	public String getStrikeRate() {
		return strikeRate;
	}
	public void setStrikeRate(String strikeRate) {
		this.strikeRate = strikeRate;
	}
	@Override
	public String toString() {
		return "BattingScorecardDTO [matchID=" + matchID + ", innings=" + innings + ", battingPosition="
				+ battingPosition + ", batsmanID=" + batsmanID + ", batsmanName=" + batsmanName + ", dismissalType="
				+ dismissalType + ", bowlerID=" + bowlerID + ", bowlerName=" + bowlerName + ", fielderID=" + fielderID
				+ ", fielderName=" + fielderName + ", dismissalMessage=" + dismissalMessage + ", runsScored=" + runsScored
				+ ", ballsFaced=" + ballsFaced + ", fours=" + fours + ", sixes=" + sixes + ", strikeRate=" + strikeRate
				+ "]";
	}
}
