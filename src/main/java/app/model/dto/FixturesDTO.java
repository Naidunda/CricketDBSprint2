package app.model.dto;
import java.io.Serializable;
import java.sql.Date;

public class FixturesDTO implements Serializable{
	private String f_fixture_id;
	private Date f_match_date;
	private String f_format;
	private String f_team_1_id;
	private String f_team_1_team_name;
	private String f_team_1_age_group;
	private String f_team_2_id;
	private String f_team_2_team_name;
	private String f_team_2_age_group;
	
	public String getF_fixture_id() {
		return f_fixture_id;
	}
	public void setF_fixture_id(String f_fixture_id) {
		this.f_fixture_id = f_fixture_id;
	}
	public Date getF_match_date() {
		return f_match_date;
	}
	public void setF_match_date(Date f_match_date) {
		this.f_match_date = f_match_date;
	}
	public String getF_format() {
		return f_format;
	}
	public void setF_format(String f_format) {
		this.f_format = f_format;
	}
	public String getF_team_1_id() {
		return f_team_1_id;
	}
	public void setF_team_1_id(String f_team_1_id) {
		this.f_team_1_id = f_team_1_id;
	}
	public String getF_team_1_team_name() {
		return f_team_1_team_name;
	}
	public void setF_team_1_team_name(String f_team_1_team_name) {
		this.f_team_1_team_name = f_team_1_team_name;
	}
	public String getF_team_1_age_group() {
		return f_team_1_age_group;
	}
	public void setF_team_1_age_group(String f_team_1_age_group) {
		this.f_team_1_age_group = f_team_1_age_group;
	}
	public String getF_team_2_id() {
		return f_team_2_id;
	}
	public void setF_team_2_id(String f_team_2_id) {
		this.f_team_2_id = f_team_2_id;
	}
	public String getF_team_2_team_name() {
		return f_team_2_team_name;
	}
	public void setF_team_2_team_name(String f_team_2_team_name) {
		this.f_team_2_team_name = f_team_2_team_name;
	}
	public String getF_team_2_age_group() {
		return f_team_2_age_group;
	}
	public void setF_team_2_age_group(String f_team_2_age_group) {
		this.f_team_2_age_group = f_team_2_age_group;
	}
	@Override
	public String toString() {
		return "FixturesDTO [f_fixture_id=" + f_fixture_id + ", f_match_date=" + f_match_date + ", f_format=" + f_format
				+ ", f_team_1_id=" + f_team_1_id + ", f_team_1_team_name=" + f_team_1_team_name
				+ ", f_team_1_age_group=" + f_team_1_age_group + ", f_team_2_id=" + f_team_2_id
				+ ", f_team_2_team_name=" + f_team_2_team_name + ", f_team_2_age_group=" + f_team_2_age_group + "]";
	}
}
