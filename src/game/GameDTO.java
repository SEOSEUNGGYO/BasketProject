package game;

public class GameDTO {
	private int game_id;
	private String game_region;
	private String game_date;
	private String game_time;
	private String game_rule;
	private String game_address;
	private String game_court;
	private String game_information;
	public int getGame_id() {
		return game_id;
	}
	public void setGame_id(int game_id) {
		this.game_id = game_id;
	}
	public String getGame_region() {
		return game_region;
	}
	public void setGame_region(String game_region) {
		this.game_region = game_region;
	}
	public String getGame_date() {
		return game_date;
	}
	public void setGame_date(String game_date) {
		this.game_date = game_date;
	}
	public String getGame_time() {
		return game_time;
	}
	public void setGame_time(String game_time) {
		this.game_time = game_time;
	}
	public String getGame_rule() {
		return game_rule;
	}
	public void setGame_rule(String game_rule) {
		this.game_rule = game_rule;
	}
	public String getGame_address() {
		return game_address;
	}
	public void setGame_address(String game_address) {
		this.game_address = game_address;
	}
	public String getGame_court() {
		return game_court;
	}
	public void setGame_court(String game_court) {
		this.game_court = game_court;
	}
	public String getGame_information() {
		return game_information;
	}
	public void setGame_information(String game_information) {
		this.game_information = game_information;
	}
	public GameDTO(int game_id, String game_region, String game_date, String game_time, String game_rule,
			String game_address, String game_court, String game_information) {
		this.game_id = game_id;
		this.game_region = game_region;
		this.game_date = game_date;
		this.game_time = game_time;
		this.game_rule = game_rule;
		this.game_address = game_address;
		this.game_court = game_court;
		this.game_information = game_information;
	}
	public GameDTO() {}
	
}
