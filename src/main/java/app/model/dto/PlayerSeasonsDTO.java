package app.model.dto;

public class PlayerSeasonsDTO {
	private String playerID;
	private String season;
	
	// Getters and setters for all the fields
	public String getPlayerID() {
		return playerID;
	}
	public void setPlayerID(String playerID) {
		this.playerID = playerID;
	}
	public String getSeason() {
		return season;
	}
	public void setSeason(String season) {
		this.season = season;
	}
	@Override
	public String toString() {
		return "PlayerSeasonsDTO [playerID=" + playerID + ", season=" + season + "]";
	}
}
