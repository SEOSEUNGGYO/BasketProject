package schedule;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import game.GameDAO;
import game.GameDTO;
import util.DatabaseUtil;

public class ScheduleDAO {
	
	public int match(int schedule_game, String schedule_writer, String schedule_opponent) {
		String SQL = "INSERT INTO schedule VALUES(?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement(SQL);
			
			pstmt.setInt(1, schedule_game);
			pstmt.setString(2, schedule_writer);
			pstmt.setString(3, schedule_opponent);
			
			
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

	public ArrayList<String> scheduleCheck(String schedule_opponent){
		ArrayList<String> list = new ArrayList<String>();
		String SQL = "select game_date from game inner join schedule on game_id=schedule_game where schedule.schedule_opponent=?";
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
				list.add(game_date);
				
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
	
	
	public ArrayList<GameDTO> getMyJoinGameList(String schedule_opponent, int start, int end){
		ArrayList<GameDTO> list = new ArrayList<GameDTO>();
		String SQL = "SELECT * FROM game inner join schedule on game_id=schedule_game where schedule.schedule_opponent=? limit ?,?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DatabaseUtil.getConnection();
			pstmt=conn.prepareStatement(SQL);
			pstmt.setString(1,schedule_opponent);
			pstmt.setInt(2, start-1);
			pstmt.setInt(3, end);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				GameDTO gameDTO = new GameDTO();	
				gameDTO.setGame_id(rs.getInt("game_id"));
				gameDTO.setGame_region(rs.getString("game_region"));
				gameDTO.setGame_date(rs.getString("game_date"));
				gameDTO.setGame_time(rs.getString("game_time"));
				gameDTO.setGame_rule(rs.getString("game_rule"));
				gameDTO.setGame_address(rs.getString("game_address"));
				gameDTO.setGame_court(rs.getString("game_court"));
				gameDTO.setGame_information(rs.getString("game_information"));
				gameDTO.setGame_reservation(rs.getInt("game_reservation"));
				gameDTO.setGame_writer(rs.getString("game_writer"));
				list.add(gameDTO);
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
	
	public int getMyJoinGameCount(String schedule_opponent) {
		String SQL = "select count(*) from game inner join schedule on game_id=schedule_game where schedule.schedule_opponent=?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DatabaseUtil.getConnection();
			pstmt=conn.prepareStatement(SQL);
			pstmt.setString(1, schedule_opponent);
			

			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				return rs.getInt(1);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {if(conn!=null) conn.close();}catch(Exception e) {e.printStackTrace();}
			try {if(pstmt!=null) pstmt.close();}catch(Exception e) {e.printStackTrace();}
			try {if(rs!=null) rs.close();}catch(Exception e) {e.printStackTrace();}
		}
		return -1;
		
	}
	
	public void scheduleDelete(String schedule_game) {
		String SQL = "DELETE FROM schedule WHERE schedule_game=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn=DatabaseUtil.getConnection();
			pstmt=conn.prepareStatement(SQL);	
			pstmt.setString(1, schedule_game);
			pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {if(conn!=null) conn.close();}catch(Exception e) {e.printStackTrace();}
			try {if(pstmt!=null) pstmt.close();}catch(Exception e) {e.printStackTrace();}
			try {if(rs!=null) rs.close();}catch(Exception e) {e.printStackTrace();}
		}
	}

}
