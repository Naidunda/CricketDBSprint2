package app.model.dto;

import java.io.Serializable;

public class PlayerStatisticsDTO implements Serializable {
	private String playerID;
	private String playerName;
	private int matches;
	private int battingInnings;
	private int notOuts;
	private int runsScored;
	private int ballsFaced;
	private String battingStrikeRate;
	private String highScore;
	private String battingAverage;
	private int fifties;
	private int hundreds;
	private int fours;
	private int sixes;
	private int bowlingInnings;
	private int ballsBowled;
	private int runsConceded;
	private int wicketsTaken;
	private String bestFigures;
	private String bowlingAverage;
	private String economy;
	private String bowlingStrikeRate;
	private int fiveWickets;
	private int runOuts;
	private int catches;
	private int stumpings;
	
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
	public int getMatches() {
		return matches;
	}
	public void setMatches(int matches) {
		this.matches = matches;
	}
	public int getBattingInnings() {
		return battingInnings;
	}
	public void setBattingInnings(int battingInnings) {
		this.battingInnings = battingInnings;
	}
	public int getNotOuts() {
		return notOuts;
	}
	public void setNotOuts(int notOuts) {
		this.notOuts = notOuts;
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
	public String getBattingStrikeRate() {
		return battingStrikeRate;
	}
	public void setBattingStrikeRate(String battingStrikeRate) {
		this.battingStrikeRate = battingStrikeRate;
	}
	public String getHighScore() {
		return highScore;
	}
	public void setHighScore(String highScore) {
		this.highScore = highScore;
	}
	public String getBattingAverage() {
		return battingAverage;
	}
	public void setBattingAverage(String battingAverage) {
		this.battingAverage = battingAverage;
	}
	public int getFifties() {
		return fifties;
	}
	public void setFifties(int fifties) {
		this.fifties = fifties;
	}
	public int getHundreds() {
		return hundreds;
	}
	public void setHundreds(int hundreds) {
		this.hundreds = hundreds;
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
	public int getBowlingInnings() {
		return bowlingInnings;
	}
	public void setBowlingInnings(int bowlingInnings) {
		this.bowlingInnings = bowlingInnings;
	}
	public int getBallsBowled() {
		return ballsBowled;
	}
	public void setBallsBowled(int ballsBowled) {
		this.ballsBowled = ballsBowled;
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
	public String getBestFigures() {
		return bestFigures;
	}
	public void setBestFigures(String bestFigures) {
		this.bestFigures = bestFigures;
	}
	public String getBowlingAverage() {
		return bowlingAverage;
	}
	public void setBowlingAverage(String bowlingAverage) {
		this.bowlingAverage = bowlingAverage;
	}
	public String getEconomy() {
		return economy;
	}
	public void setEconomy(String economy) {
		this.economy = economy;
	}
	public String getBowlingStrikeRate() {
		return bowlingStrikeRate;
	}
	public void setBowlingStrikeRate(String bowlingStrikeRate) {
		this.bowlingStrikeRate = bowlingStrikeRate;
	}
	public int getFiveWickets() {
		return fiveWickets;
	}
	public void setFiveWickets(int fiveWickets) {
		this.fiveWickets = fiveWickets;
	}
	public int getRunOuts() {
		return runOuts;
	}
	public void setRunOuts(int runOuts) {
		this.runOuts = runOuts;
	}
	public int getCatches() {
		return catches;
	}
	public void setCatches(int catches) {
		this.catches = catches;
	}
	public int getStumpings() {
		return stumpings;
	}
	public void setStumpings(int stumpings) {
		this.stumpings = stumpings;
	}
	@Override
	public String toString() {
		return "PlayerStatisticsDTO [playerID=" + playerID + ", playerName=" + playerName + ", matches=" + matches
				+ ", battingInnings=" + battingInnings + ", notOuts=" + notOuts + ", runsScored=" + runsScored
				+ ", ballsFaced=" + ballsFaced + ", battingStrikeRate=" + battingStrikeRate + ", highScore=" + highScore
				+ ", battingAverage=" + battingAverage + ", fifties=" + fifties + ", hundreds=" + hundreds + ", fours="
				+ fours + ", sixes=" + sixes + ", bowlingInnings=" + bowlingInnings + ", ballsBowled=" + ballsBowled
				+ ", runsConceded=" + runsConceded + ", wicketsTaken=" + wicketsTaken + ", bestFigures=" + bestFigures
				+ ", bowlingAverage=" + bowlingAverage + ", economy=" + economy + ", bowlingStrikeRate="
				+ bowlingStrikeRate + ", fiveWickets=" + fiveWickets + ", runOuts=" + runOuts + ", catches=" + catches
				+ ", stumpings=" + stumpings + "]";
	}
}
