package schedule;

public class ScheduleDTO {
	private int schedule_game;
	private String schedule_writer;
	private String schedule_opponent;
	public int getSchedule_game() {
		return schedule_game;
	}
	public void setSchedule_game(int schedule_game) {
		this.schedule_game = schedule_game;
	}
	public String getSchedule_writer() {
		return schedule_writer;
	}
	public void setSchedule_writer(String schedule_writer) {
		this.schedule_writer = schedule_writer;
	}
	public String getSchedule_opponent() {
		return schedule_opponent;
	}
	public void setSchedule_opponent(String schedule_opponent) {
		this.schedule_opponent = schedule_opponent;
	}
	public ScheduleDTO(int schedule_game, String schedule_writer, String schedule_opponent) {
		
		this.schedule_game = schedule_game;
		this.schedule_writer = schedule_writer;
		this.schedule_opponent = schedule_opponent;
	}
	
	public ScheduleDTO() {
		
	}
	
	

}
