package game;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import util.DatabaseUtil;

public class GameDAO {
	
	//game_id 1부터 순차적으로 
	public int registNum() {
		String SQL = "select game_id from game order by game_id desc";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement(SQL);
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				return rs.getInt(1)+1;
			}
			return 1;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {if(conn!=null) conn.close();}catch(Exception e) {e.printStackTrace();}
			try {if(pstmt!=null) pstmt.close();}catch(Exception e) {e.printStackTrace();}
			try {if(rs!=null) rs.close();}catch(Exception e) {e.printStackTrace();}
		}
		return 0;
	}
	//전체 게임 등록 수
	public int getGameCount(String game_region, String game_date) {
		String SQL = "select count(*) from game where game_region=? and game_date=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try {
			conn = DatabaseUtil.getConnection();
			pstmt=conn.prepareStatement(SQL);
			pstmt.setString(1, game_region);
			pstmt.setString(2, game_date);

			
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
	//game 글 등록
	public int regist(String game_region,String game_date, String game_time, String game_rule, String game_address, String game_court, String game_information, String game_writer) {
		String SQL = "INSERT INTO game VALUES(?,?,?,?,?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement(SQL);
			
			pstmt.setInt(1, registNum());
			pstmt.setString(2, game_region);
			pstmt.setString(3, game_date);
			pstmt.setString(4, game_time);
			pstmt.setString(5, game_rule);
			pstmt.setString(6, game_address);
			pstmt.setString(7, game_court);
			pstmt.setString(8, game_information);
			pstmt.setInt(9, 0);
			pstmt.setString(10, game_writer);
			
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
	
	
	public ArrayList<GameDTO> getgGmeList(String game_region, String game_date, int start, int end){
		ArrayList<GameDTO> list = new ArrayList<GameDTO>();
		String SQL = "SELECT * FROM game where game_region=? and game_date=? limit ?,?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DatabaseUtil.getConnection();
			pstmt=conn.prepareStatement(SQL);
			pstmt.setString(1,game_region);
			pstmt.setString(2,game_date);
			pstmt.setInt(3, start-1);
			pstmt.setInt(4, end);
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
}
