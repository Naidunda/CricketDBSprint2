package app.model.dto;

import java.io.Serializable;
import java.sql.Date;

public class PlayersDTO implements Serializable{
	private String p_player_id;
	private String p_player_name;
	private String p_dob;
	private String p_batting_hand;
	private String p_bowling_skill;
	private boolean p_is_keeper;
	private String p_role;
	
	public String getP_player_id() {
		return p_player_id;
	}
	public void setP_player_id(String p_player_id) {
		this.p_player_id = p_player_id;
	}
	public String getP_player_name() {
		return p_player_name;
	}
	public void setP_player_name(String p_player_name) {
		this.p_player_name = p_player_name;
	}
	public String getP_dob() {
		return p_dob;
	}
	public void setP_dob(String p_dob) {
		this.p_dob = p_dob;
	}
	public String getP_batting_hand() {
		return p_batting_hand;
	}
	public void setP_batting_hand(String p_batting_hand) {
		this.p_batting_hand = p_batting_hand;
	}
	public String getP_bowling_skill() {
		return p_bowling_skill;
	}
	public void setP_bowling_skill(String p_bowling_skill) {
		this.p_bowling_skill = p_bowling_skill;
	}
	public boolean isP_is_keeper() {
		return p_is_keeper;
	}
	public void setP_is_keeper(boolean p_is_keeper) {
		this.p_is_keeper = p_is_keeper;
	}
	public String getP_role() {
		return p_role;
	}
	public void setP_role(String p_role) {
		this.p_role = p_role;
	}
	@Override
	public String toString() {
		return "PlayersDTO [p_player_id=" + p_player_id + ", p_player_name=" + p_player_name + ", p_dob=" + p_dob
				+ ", p_batting_hand=" + p_batting_hand + ", p_bowling_skill=" + p_bowling_skill + ", p_is_keeper="
				+ p_is_keeper + ", p_role=" + p_role + "]";
	}
}
