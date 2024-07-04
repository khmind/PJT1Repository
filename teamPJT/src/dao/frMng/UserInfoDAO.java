package dao.frMng;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.sql.DataSource;

import vo.bkMng.UserVO;


public class UserInfoDAO {

	DataSource ds;
	
	public void setDataSource(DataSource ds) {
		this.ds=ds;
	}
	
	//상세검색
	public UserVO getUser(String user_id) throws Exception {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from user_info where user_id = ? ";
		
		try {
		
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,user_id);
			rs = pstmt.executeQuery();	
		
			if(rs.next()) {
		
				return new UserVO()
						.setUser_id(rs.getString("USER_ID"))
						.setUser_name(rs.getString("USER_NAME"))						
						.setUser_email(rs.getString("USER_EMAIL"))						
						.setUser_pw(rs.getString("USER_PW"))
						.setUser_role(rs.getString("USER_ROLE"))						
						.setUser_date(rs.getDate("USER_DATE"));						
			}else {
				throw new Exception("데이터가 존재하지 않습니다.");
			}
			
		}catch (Exception e) {
			throw e;
		}finally {
			try {if (rs != null) rs.close();} catch(Exception e) {}
		    try {if (pstmt != null) pstmt.close();} catch(Exception e) {}
		    try {if (conn != null) conn.close();} catch(Exception e) {}
		} 
	}	
	
	
	//수정
	public void modify(UserVO userVO) throws Exception{
				
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "update user_info set user_email=?, user_pw=? where user_id=?";
		
		try {
			
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userVO.getUser_email()); 
			pstmt.setString(2, userVO.getUser_pw());			
			pstmt.setString(3, userVO.getUser_id());
			
			pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {if (pstmt != null) pstmt.close();} catch(Exception e) {}
			try {if (conn != null) conn.close();} catch(Exception e) {}
		}
	}	
	
}