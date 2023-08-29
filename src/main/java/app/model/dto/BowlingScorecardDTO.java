package app.model.dto;

public class BowlingScorecardDTO {
	private String s_match_id;
	private int s_innings;
	private String s_bowler_id;
	private String s_bowler_name;
	private String s_overs;
	private int s_maidens;
	private int s_runs_conceded;
	private int s_wickets_taken;
	private String s_economy;
	private String s_average;
	private int s_wide;
	private int s_no_ball;
	
	
	public String getS_match_id() {
		return s_match_id;
	}
	public void setS_match_id(String s_match_id) {
		this.s_match_id = s_match_id;
	}
	public int getS_innings() {
		return s_innings;
	}
	public void setS_innings(int s_innings) {
		this.s_innings = s_innings;
	}
	public String getS_bowler_id() {
		return s_bowler_id;
	}
	public void setS_bowler_id(String s_bowler_id) {
		this.s_bowler_id = s_bowler_id;
	}
	public String getS_bowler_name() {
		return s_bowler_name;
	}
	public void setS_bowler_name(String s_bowler_name) {
		this.s_bowler_name = s_bowler_name;
	}
	public String getS_overs() {
		return s_overs;
	}
	public void setS_overs(String s_overs) {
		this.s_overs = s_overs;
	}
	public int getS_maidens() {
		return s_maidens;
	}
	public void setS_maidens(int s_maidens) {
		this.s_maidens = s_maidens;
	}
	public int getS_runs_conceded() {
		return s_runs_conceded;
	}
	public void setS_runs_conceded(int s_runs_conceded) {
		this.s_runs_conceded = s_runs_conceded;
	}
	public int getS_wickets_taken() {
		return s_wickets_taken;
	}
	public void setS_wickets_taken(int s_wickets_taken) {
		this.s_wickets_taken = s_wickets_taken;
	}
	public String getS_economy() {
		return s_economy;
	}
	public void setS_economy(String s_economy) {
		this.s_economy = s_economy;
	}
	public String getS_average() {
		return s_average;
	}
	public void setS_average(String s_average) {
		this.s_average = s_average;
	}
	public int getS_wide() {
		return s_wide;
	}
	public void setS_wide(int s_wide) {
		this.s_wide = s_wide;
	}
	public int getS_no_ball() {
		return s_no_ball;
	}
	public void setS_no_ball(int s_no_ball) {
		this.s_no_ball = s_no_ball;
	}
	@Override
	public String toString() {
		return "BowlingScorecardDTO [s_match_id=" + s_match_id + ", s_innings=" + s_innings + ", s_bowler_id="
				+ s_bowler_id + ", s_bowler_name=" + s_bowler_name + ", s_overs=" + s_overs + ", s_maidens=" + s_maidens
				+ ", s_runs_conceded=" + s_runs_conceded + ", s_wickets_taken=" + s_wickets_taken + ", s_economy="
				+ s_economy + ", s_average=" + s_average + ", s_wide=" + s_wide + ", s_no_ball=" + s_no_ball + "]";
	}

}
