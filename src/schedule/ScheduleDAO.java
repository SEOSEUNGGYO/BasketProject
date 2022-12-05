package schedule;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import game.GameDAO;
import game.GameDTO;
import util.DatabaseUtil;

public class ScheduleDAO {
	
	public int match(int schedule_game, String schedule_writer, String schedule_opponent, String schedule_date, String schedule_time) {
		String SQL = "INSERT INTO schedule VALUES(?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement(SQL);
			
			pstmt.setInt(1, schedule_game);
			pstmt.setString(2, schedule_writer);
			pstmt.setString(3, schedule_opponent);
			pstmt.setString(4, schedule_date);
			pstmt.setString(5, schedule_time);
			
			return pstmt.executeUpdate(); //return 1;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {if(conn!=null) conn.close();}catch(Exception e) {e.printStackTrace();}
			try {if(pstmt!=null) pstmt.close();}catch(Exception e) {e.printStackTrace();}
			try {if(rs!=null) rs.close();}catch(Exception e) {e.printStackTrace();}
		}
		return -1;
	}

	public ArrayList<String> dupCheck(String schedule_opponent){
		ArrayList<String> list = new ArrayList<String>();
		String SQL = "select game_date, game_time from game inner join schedule on game_id=schedule_game where schedule.schedule_opponent=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DatabaseUtil.getConnection();
			pstmt=conn.prepareStatement(SQL);
			pstmt.setString(1,schedule_opponent);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				String game_date = rs.getString("game_date");
				String game_time = rs.getString("game_time");
				list.add(game_date+game_time);
				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {if(conn!=null) conn.close();}catch(Exception e) {e.printStackTrace();}
			try {if(pstmt!=null) pstmt.close();}catch(Exception e) {e.printStackTrace();}
			try {if(rs!=null) rs.close();}catch(Exception e) {e.printStackTrace();}
		}
		
		return list;
	}
}
