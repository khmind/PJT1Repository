package dao.bkMng;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

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
	//회원가입
		public int insert(InfoVO vo) throws Exception{
			
			System.out.println("addDAO===========1");
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			Statement stmt=null;
			ResultSet rs=null;
			int res;
			
			
			String maxId ="select max(user_id)as maxId from user_info";
			String query ="insert into user_info \r\n" + 
					"	values(?,?,?,?,user_role,now());";
			try {
				System.out.println("addDAO===========2");
				conn = ds.getConnection();
				stmt = conn.createStatement(); 
				rs = stmt.executeQuery(maxId);
				
				if(rs.next()) {
					
					maxId = rs.getString("maxId") ;
					
					int a = Integer.parseInt(maxId.substring(2));
					
					a++;
					String sql2 = maxId.substring(0, 2) + a; 
					
				}		
				int a = Integer.parseInt(maxId.substring(2));
				a++;
				String sql2 = maxId.substring(0, 2) + a;
				System.out.println("addDAO===========3===="+sql2);
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1,sql2);
				pstmt.setString(2, vo.getUser_name());
				pstmt.setString(3, vo.getUser_email());
				pstmt.setString(4, vo.getUser_pw());
				
				System.out.println("addDAO===========1"+vo.getUser_name());
				System.out.println("addDAO===========1"+vo.getUser_email());
				System.out.println("addDAO===========1"+vo.getUser_pw());
				
				res = pstmt.executeUpdate();
				
				System.out.println("==================================");
				
			}catch (Exception e) {
				throw e;
				
			}finally {
				 try {if (pstmt != null) pstmt.close();} catch(Exception e) {}
				 try {if (conn != null) conn.close();} catch(Exception e) {}
			}
			
			return res;
		}
}
