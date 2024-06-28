package dao.bkMng;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import vo.bkMng.InfoVO;

public class InfoDAO {

	DataSource ds;
	
	public void setDataSource(DataSource ds) {
		this.ds=ds;
	}
	
	public InfoVO exist(String email, String password) throws Exception{
		 
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select user_id, user_name, user_role from user_info where user_email=? and user_pw=?";
		
		try {
			conn=ds.getConnection();
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			
			rs=pstmt.executeQuery();
			if(rs.next()) {
				return new InfoVO()
						.setUser_name(rs.getString("user_name"))
						.setUser_id(rs.getString("user_id"))
						.setUser_role(rs.getString("user_role")); 
			}
			else {
				return null;
			}
		}catch (Exception e) {
			throw e;
		}finally {
			 try {if (rs != null) rs.close();} catch (Exception e) {}
		     try {if (pstmt != null) pstmt.close();} catch (Exception e) {}
		     try {if (conn != null) conn.close();} catch(Exception e) {}
		}
	}
}
