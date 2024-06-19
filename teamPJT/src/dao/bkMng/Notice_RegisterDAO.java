package dao.bkMng;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;



import vo.bkMng.NoticeVO;


public class Notice_RegisterDAO {
	
	DataSource ds;
	
	public void setDataSource(DataSource ds) {
		this.ds=ds;
	}
	
	public int insert(NoticeVO notice) throws Exception{
		System.out.println("```````````````````````4");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		Statement stmt= null;
		ResultSet rs1= null ;
		int res = 0;
		
		String setMaxId = "";
		
		//String sql = "select notice_title, notice_content, notice_id from notice_info where notice_id='"+notice_id+"'";


		String maxId ="select max(notice_id)as maxId from notice_info";
			
		System.out.println("-----1");
		
		try {
			conn = ds.getConnection();
			stmt = conn.createStatement(); 
			rs1 = stmt.executeQuery(maxId);
			
			
			if(rs1.next()) {
				
				System.out.println("update max1 : " + rs1.getString("maxId"));
				
				
				setMaxId = rs1.getString("maxId") ;
				
				System.out.println("s : " + setMaxId.substring(0, 1) );
				
				int a = Integer.parseInt(setMaxId.substring(1));
				
				a=a+001;
				
				System.out.println("s2 : " + setMaxId.substring(1) );
				System.out.println("s3 : " + a );
				System.out.println("s4 : " + setMaxId.substring(0, 1) + a );
				
				
				
				
			
			}			
			
			
			
		}catch (Exception e) {
			throw e;
		}finally {
			try {if (rs1 != null) rs1.close();} catch(Exception e) {}
		    try {if (stmt != null) stmt.close();} catch(Exception e) {}
		    try {if (conn != null) conn.close();} catch(Exception e) {}
		} 

		
		/*
		try {
			System.out.println("```````````````````````43");
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, notice.getNotice_id());
			pstmt.setString(2,notice.getNotice_title());
			pstmt.setString(3,notice.getNotice_content());
			pstmt.setString(4, notice.getUser_id());
			res = pstmt.executeUpdate();
			System.out.println("```````````````````````4"+notice.getNotice_title());
			System.out.println("```````````````````````4");
		}catch (Exception e) {
			throw e;
			
		}finally {			
			try {if (pstmt != null) pstmt.close();} catch(Exception e) {}
			try {if (conn != null) conn.close();} catch(Exception e) {}
		}
		 */
		
		return res;
	}
}
