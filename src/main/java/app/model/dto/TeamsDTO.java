package app.model.dto;

import java.io.Serializable;

public class TeamsDTO implements Serializable{
	private String t_team_id;
	private String t_team_name;
	private String t_age_group;
	private String t_location;
	private boolean t_is_club;
	
	public String getT_team_id() {
		return t_team_id;
	}
	public void setT_team_id(String t_team_id) {
		this.t_team_id = t_team_id;
	}
	public String getT_team_name() {
		return t_team_name;
	}
	public void setT_team_name(String t_team_name) {
		this.t_team_name = t_team_name;
	}
	public String getT_age_group() {
		return t_age_group;
	}
	public void setT_age_group(String t_age_group) {
		this.t_age_group = t_age_group;
	}
	public String getT_location() {
		return t_location;
	}
	public void setT_location(String t_location) {
		this.t_location = t_location;
	}
	public boolean isT_is_club() {
		return t_is_club;
	}
	public void setT_is_club(boolean t_is_club) {
		this.t_is_club = t_is_club;
	}
	@Override
	public String toString() {
		return "TeamsDTO [t_team_id=" + t_team_id + ", t_team_name=" + t_team_name + ", t_age_group=" + t_age_group
				+ ", t_location=" + t_location + ", t_is_club=" + t_is_club + "]";
	}
}