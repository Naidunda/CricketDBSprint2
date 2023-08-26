package app.model.dto;

public class PlayerSeasonsDTO {
	private String p_player_id;
	private String p_season;
	
	public String getP_player_id() {
		return p_player_id;
	}
	public void setP_player_id(String p_player_id) {
		this.p_player_id = p_player_id;
	}
	public String getP_season() {
		return p_season;
	}
	public void setP_season(String p_season) {
		this.p_season = p_season;
	}
	@Override
	public String toString() {
		return "PlayerSeasonsDTO [p_player_id=" + p_player_id + ", p_season=" + p_season + "]";
	}
}
