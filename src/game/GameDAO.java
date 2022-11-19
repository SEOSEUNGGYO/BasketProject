package game;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.DatabaseUtil;

public class GameDAO {
	
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
	public int regist(String game_region,String game_date, String game_time, String game_rule, String game_address, String game_court, String game_information) {
		String SQL = "INSERT INTO game VALUES(?,?,?,?,?,?,?,?)";
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
	
}
