package app.model.dto;

import java.io.Serializable;

public class PlayerStatisticsDTO implements Serializable {
	private String p_id;
	private String p_player_name;
	private int p_matches;
	private int p_batting_innings;
	private int p_not_outs;
	private int p_runs_scored;
	private int p_balls_faced;
	private String p_batting_strike_rate;
	private int p_high_score;
	private String p_batting_average;
	private int p_fifties;
	private int p_hundreds;
	private int p_fours;
	private int p_sixes;
	private int p_bowling_innings;
	private int p_balls_bowled;
	private int p_runs_conceded;
	private int p_wickets_taken;
	private String p_best_figures;
	private String p_bowling_average;
	private String p_economy;
	private String p_bowling_strike_rate;
	private int p_five_wickets;
	private int p_run_outs;
	private int p_catches;
	private int p_stumpings;
	
	public String getP_id() {
		return p_id;
	}
	public void setP_id(String p_id) {
		this.p_id = p_id;
	}
	public String getP_player_name() {
		return p_player_name;
	}
	public void setP_player_name(String p_player_name) {
		this.p_player_name = p_player_name;
	}
	public int getP_matches() {
		return p_matches;
	}
	public void setP_matches(int p_matches) {
		this.p_matches = p_matches;
	}
	public int getP_batting_innings() {
		return p_batting_innings;
	}
	public void setP_batting_innings(int p_batting_innings) {
		this.p_batting_innings = p_batting_innings;
	}
	public int getP_not_outs() {
		return p_not_outs;
	}
	public void setP_not_outs(int p_not_outs) {
		this.p_not_outs = p_not_outs;
	}
	public int getP_runs_scored() {
		return p_runs_scored;
	}
	public void setP_runs_scored(int p_runs_scored) {
		this.p_runs_scored = p_runs_scored;
	}
	public int getP_balls_faced() {
		return p_balls_faced;
	}
	public void setP_balls_faced(int p_balls_faced) {
		this.p_balls_faced = p_balls_faced;
	}
	public String getP_batting_strike_rate() {
		return p_batting_strike_rate;
	}
	public void setP_batting_strike_rate(String p_batting_strike_rate) {
		this.p_batting_strike_rate = p_batting_strike_rate;
	}
	public int getP_high_score() {
		return p_high_score;
	}
	public void setP_high_score(int p_high_score) {
		this.p_high_score = p_high_score;
	}
	public String getP_batting_average() {
		return p_batting_average;
	}
	public void setP_batting_average(String p_batting_average) {
		this.p_batting_average = p_batting_average;
	}
	public int getP_fifties() {
		return p_fifties;
	}
	public void setP_fifties(int p_fifties) {
		this.p_fifties = p_fifties;
	}
	public int getP_hundreds() {
		return p_hundreds;
	}
	public void setP_hundreds(int p_hundreds) {
		this.p_hundreds = p_hundreds;
	}
	public int getP_fours() {
		return p_fours;
	}
	public void setP_fours(int p_fours) {
		this.p_fours = p_fours;
	}
	public int getP_sixes() {
		return p_sixes;
	}
	public void setP_sixes(int p_sixes) {
		this.p_sixes = p_sixes;
	}
	public int getP_bowling_innings() {
		return p_bowling_innings;
	}
	public void setP_bowling_innings(int p_bowling_innings) {
		this.p_bowling_innings = p_bowling_innings;
	}
	public int getP_balls_bowled() {
		return p_balls_bowled;
	}
	public void setP_balls_bowled(int p_balls_bowled) {
		this.p_balls_bowled = p_balls_bowled;
	}
	public int getP_runs_conceded() {
		return p_runs_conceded;
	}
	public void setP_runs_conceded(int p_runs_conceded) {
		this.p_runs_conceded = p_runs_conceded;
	}
	public int getP_wickets_taken() {
		return p_wickets_taken;
	}
	public void setP_wickets_taken(int p_wickets_taken) {
		this.p_wickets_taken = p_wickets_taken;
	}
	public String getP_best_figures() {
		return p_best_figures;
	}
	public void setP_best_figures(String p_best_figures) {
		this.p_best_figures = p_best_figures;
	}
	public String getP_bowling_average() {
		return p_bowling_average;
	}
	public void setP_bowling_average(String p_bowling_average) {
		this.p_bowling_average = p_bowling_average;
	}
	public String getP_economy() {
		return p_economy;
	}
	public void setP_economy(String p_economy) {
		this.p_economy = p_economy;
	}
	public String getP_bowling_strike_rate() {
		return p_bowling_strike_rate;
	}
	public void setP_bowling_strike_rate(String p_bowling_strike_rate) {
		this.p_bowling_strike_rate = p_bowling_strike_rate;
	}
	public int getP_five_wickets() {
		return p_five_wickets;
	}
	public void setP_five_wickets(int p_five_wickets) {
		this.p_five_wickets = p_five_wickets;
	}
	public int getP_run_outs() {
		return p_run_outs;
	}
	public void setP_run_outs(int p_run_outs) {
		this.p_run_outs = p_run_outs;
	}
	public int getP_catches() {
		return p_catches;
	}
	public void setP_catches(int p_catches) {
		this.p_catches = p_catches;
	}
	public int getP_stumpings() {
		return p_stumpings;
	}
	public void setP_stumpings(int p_stumpings) {
		this.p_stumpings = p_stumpings;
	}
	
	@Override
	public String toString() {
		return "PlayerStatisticsDTO [p_id=" + p_id + ", p_player_name=" + p_player_name + ", p_matches=" + p_matches
				+ ", p_batting_innings=" + p_batting_innings + ", p_not_outs=" + p_not_outs + ", p_runs_scored="
				+ p_runs_scored + ", p_balls_faced=" + p_balls_faced + ", p_batting_strike_rate="
				+ p_batting_strike_rate + ", p_high_score=" + p_high_score + ", p_batting_average=" + p_batting_average
				+ ", p_fifties=" + p_fifties + ", p_hundreds=" + p_hundreds + ", p_fours=" + p_fours + ", p_sixes="
				+ p_sixes + ", p_bowling_innings=" + p_bowling_innings + ", p_balls_bowled=" + p_balls_bowled
				+ ", p_runs_conceded=" + p_runs_conceded + ", p_wickets_taken=" + p_wickets_taken + ", p_best_figures="
				+ p_best_figures + ", p_bowling_average=" + p_bowling_average + ", p_economy=" + p_economy
				+ ", p_bowling_strike_rate=" + p_bowling_strike_rate + ", p_five_wickets=" + p_five_wickets
				+ ", p_run_outs=" + p_run_outs + ", p_catches=" + p_catches + ", p_stumpings=" + p_stumpings + "]";
	}
	
}
