package user;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.DatabaseUtil;

public class UserDAO {
	public int join(UserDTO userDTO) {
		String SQL = "INSERT INTO user VALUES(?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement(SQL);
			
			pstmt.setString(1, userDTO.getUser_id());
			pstmt.setString(2, userDTO.getUser_password());
			pstmt.setString(3, userDTO.getUser_email());
			pstmt.setString(4, userDTO.getUser_phone());
			pstmt.setString(5, userDTO.getUser_name());
			pstmt.setString(6, userDTO.getUser_birth());
			
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
	public int login(String user_id, String user_password) {
		String SQL = "SELECT user_password FROM user WHERE user_id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement(SQL);
			
			pstmt.setString(1, user_id);
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				if(rs.getString("user_password").equals(user_password)) {
					return 1;
				}else {
					return -1;
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {if(conn!=null) conn.close();}catch(Exception e) {e.printStackTrace();}
			try {if(pstmt!=null) pstmt.close();}catch(Exception e) {e.printStackTrace();}
			try {if(rs!=null) rs.close();}catch(Exception e) {e.printStackTrace();}
		}
		return 0;
	}
}
