package app.model.dto;

import java.io.Serializable;
import java.sql.Date;

public class MatchesDTO implements Serializable{
	
	private String m_match_id;
	private Date m_match_date;
	private String m_format;
	
	private String m_team_1_id;
	private String m_team_1_team_name;
	private String m_team_1_age_group;
	
	private String m_team_2_id;
	private String m_team_2_team_name;
	private String m_team_2_age_group;
	
	private String m_toss_winner_id;
	private String m_toss_decision;
	
	private Boolean m_is_result;
	private String m_win_type;
	private int m_won_by;
	private String m_match_winner_id;
	private String m_win_message;
	
	private int m_innings_1_total;
	private String m_innings_1_overs;
	private int m_innings_1_wickets;
	
	private int m_innings_2_total;
	private String m_innings_2_overs;
	private int m_innings_2_wickets;
	
	public String getM_match_id() {
		return m_match_id;
	}
	public void setM_match_id(String m_match_id) {
		this.m_match_id = m_match_id;
	}
	public Date getM_match_date() {
		return m_match_date;
	}
	public void setM_match_date(Date m_match_date) {
		this.m_match_date = m_match_date;
	}
	public String getM_format() {
		return m_format;
	}
	public void setM_format(String m_format) {
		this.m_format = m_format;
	}
	public String getM_team_1_id() {
		return m_team_1_id;
	}
	public void setM_team_1_id(String m_team_1_id) {
		this.m_team_1_id = m_team_1_id;
	}
	public String getM_team_1_team_name() {
		return m_team_1_team_name;
	}
	public void setM_team_1_team_name(String m_team_1_team_name) {
		this.m_team_1_team_name = m_team_1_team_name;
	}
	public String getM_team_1_age_group() {
		return m_team_1_age_group;
	}
	public void setM_team_1_age_group(String m_team_1_age_group) {
		this.m_team_1_age_group = m_team_1_age_group;
	}
	public String getM_team_2_id() {
		return m_team_2_id;
	}
	public void setM_team_2_id(String m_team_2_id) {
		this.m_team_2_id = m_team_2_id;
	}
	public String getM_team_2_team_name() {
		return m_team_2_team_name;
	}
	public void setM_team_2_team_name(String m_team_2_team_name) {
		this.m_team_2_team_name = m_team_2_team_name;
	}
	public String getM_team_2_age_group() {
		return m_team_2_age_group;
	}
	public void setM_team_2_age_group(String m_team_2_age_group) {
		this.m_team_2_age_group = m_team_2_age_group;
	}
	public String getM_toss_winner_id() {
		return m_toss_winner_id;
	}
	public void setM_toss_winner_id(String m_toss_winner_id) {
		this.m_toss_winner_id = m_toss_winner_id;
	}
	public String getM_toss_decision() {
		return m_toss_decision;
	}
	public void setM_toss_decision(String m_toss_decision) {
		this.m_toss_decision = m_toss_decision;
	}
	public Boolean getM_is_result() {
		return m_is_result;
	}
	public void setM_is_result(Boolean m_is_result) {
		this.m_is_result = m_is_result;
	}
	public String getM_win_type() {
		return m_win_type;
	}
	public void setM_win_type(String m_win_type) {
		this.m_win_type = m_win_type;
	}
	public int getM_won_by() {
		return m_won_by;
	}
	public void setM_won_by(int m_won_by) {
		this.m_won_by = m_won_by;
	}
	public String getM_match_winner_id() {
		return m_match_winner_id;
	}
	public void setM_match_winner_id(String m_match_winner) {
		this.m_match_winner_id = m_match_winner;
	}
	public String getM_win_message() {
		return m_win_message;
	}
	public void setM_win_message(String m_win_message) {
		this.m_win_message = m_win_message;
	}
	public int getM_innings_1_total() {
		return m_innings_1_total;
	}
	public void setM_innings_1_total(int m_innings_1_total) {
		this.m_innings_1_total = m_innings_1_total;
	}
	public String getM_innings_1_overs() {
		return m_innings_1_overs;
	}
	public void setM_innings_1_overs(String m_innings_1_overs) {
		this.m_innings_1_overs = m_innings_1_overs;
	}
	public int getM_innings_1_wickets() {
		return m_innings_1_wickets;
	}
	public void setM_innings_1_wickets(int m_innings_1_wickets) {
		this.m_innings_1_wickets = m_innings_1_wickets;
	}
	public int getM_innings_2_total() {
		return m_innings_2_total;
	}
	public void setM_innings_2_total(int m_innings_2_total) {
		this.m_innings_2_total = m_innings_2_total;
	}
	public String getM_innings_2_overs() {
		return m_innings_2_overs;
	}
	public void setM_innings_2_overs(String m_innings_2_overs) {
		this.m_innings_2_overs = m_innings_2_overs;
	}
	public int getM_innings_2_wickets() {
		return m_innings_2_wickets;
	}
	public void setM_innings_2_wickets(int m_innings_2_wickets) {
		this.m_innings_2_wickets = m_innings_2_wickets;
	}
	@Override
	public String toString() {
		return "MatchesDTO [m_match_id=" + m_match_id + ", m_match_date=" + m_match_date + ", m_format=" + m_format
				+ ", m_team_1_id=" + m_team_1_id + ", m_team_1_team_name=" + m_team_1_team_name
				+ ", m_team_1_age_group=" + m_team_1_age_group + ", m_team_2_id=" + m_team_2_id
				+ ", m_team_2_team_name=" + m_team_2_team_name + ", m_team_2_age_group=" + m_team_2_age_group
				+ ", m_toss_winner_id=" + m_toss_winner_id + ", m_toss_decision=" + m_toss_decision + ", m_is_result="
				+ m_is_result + ", m_win_type=" + m_win_type + ", m_won_by=" + m_won_by + ", m_match_winner_id="
				+ m_match_winner_id + ", m_win_message=" + m_win_message + ", m_innings_1_total=" + m_innings_1_total
				+ ", m_innings_1_overs=" + m_innings_1_overs + ", m_innings_1_wickets=" + m_innings_1_wickets
				+ ", m_innings_2_total=" + m_innings_2_total + ", m_innings_2_overs=" + m_innings_2_overs
				+ ", m_innings_2_wickets=" + m_innings_2_wickets + "]";
	}

}
