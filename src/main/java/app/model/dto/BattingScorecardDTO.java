package app.model.dto;

public class BattingScorecardDTO {
	private String s_match_id;
	private int s_innings;
	private int s_batting_position;
	private String s_batsman_id;
	private String s_batsman_name;
	private String s_dismissal_type;
	private String s_bowler_id;
	private String s_bowler_name;
	private String s_fielder_id;
	private String s_fielder_name;
	private String s_dismissal_message;
	private int s_runs_scored;
	private int s_balls_faced;
	private int s_fours;
	private int s_sixes;
	private String s_strike_rate;
	
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
	public int getS_batting_position() {
		return s_batting_position;
	}
	public void setS_batting_position(int s_batting_position) {
		this.s_batting_position = s_batting_position;
	}
	public String getS_batsman_id() {
		return s_batsman_id;
	}
	public void setS_batsman_id(String s_batsman_id) {
		this.s_batsman_id = s_batsman_id;
	}
	public String getS_batsman_name() {
		return s_batsman_name;
	}
	public void setS_batsman_name(String s_batsman_name) {
		this.s_batsman_name = s_batsman_name;
	}
	public String getS_dismissal_type() {
		return s_dismissal_type;
	}
	public void setS_dismissal_type(String s_dismissal_type) {
		this.s_dismissal_type = s_dismissal_type;
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
	public String getS_fielder_id() {
		return s_fielder_id;
	}
	public void setS_fielder_id(String s_fielder_id) {
		this.s_fielder_id = s_fielder_id;
	}
	public String getS_fielder_name() {
		return s_fielder_name;
	}
	public void setS_fielder_name(String s_fielder_name) {
		this.s_fielder_name = s_fielder_name;
	}
	public String getS_dismissal_message() {
		return s_dismissal_message;
	}
	public void setS_dismissal_message(String s_dismissal_message) {
		this.s_dismissal_message = s_dismissal_message;
	}
	public int getS_runs_scored() {
		return s_runs_scored;
	}
	public void setS_runs_scored(int s_runs_scored) {
		this.s_runs_scored = s_runs_scored;
	}
	public int getS_balls_faced() {
		return s_balls_faced;
	}
	public void setS_balls_faced(int s_balls_faced) {
		this.s_balls_faced = s_balls_faced;
	}
	public int getS_fours() {
		return s_fours;
	}
	public void setS_fours(int s_fours) {
		this.s_fours = s_fours;
	}
	public int getS_sixes() {
		return s_sixes;
	}
	public void setS_sixes(int s_sixes) {
		this.s_sixes = s_sixes;
	}
	public String getS_strike_rate() {
		return s_strike_rate;
	}
	public void setS_strike_rate(String s_strike_rate) {
		this.s_strike_rate = s_strike_rate;
	}
	@Override
	public String toString() {
		return "BattingScorecardDTO [s_match_id=" + s_match_id + ", s_innings=" + s_innings + ", s_batting_position="
				+ s_batting_position + ", s_batsman_id=" + s_batsman_id + ", s_batsman_name=" + s_batsman_name
				+ ", s_dismissal_type=" + s_dismissal_type + ", s_bowler_id=" + s_bowler_id + ", s_bowler_name="
				+ s_bowler_name + ", s_fielder_id=" + s_fielder_id + ", s_fielder_name=" + s_fielder_name
				+ ", s_dismissal_message=" + s_dismissal_message + ", s_runs_scored=" + s_runs_scored
				+ ", s_balls_faced=" + s_balls_faced + ", s_fours=" + s_fours + ", s_sixes=" + s_sixes
				+ ", s_strike_rate=" + s_strike_rate + "]";
	}
}
