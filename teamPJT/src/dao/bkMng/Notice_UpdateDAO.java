package dao.bkMng;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;
import vo.bkMng.NoticeVO;


public class Notice_UpdateDAO {
	
	DataSource ds;
	
	public void setDataSource(DataSource ds) {
		this.ds=ds;
	}
	//공지사항상세
	public NoticeVO selectOne(String notice_id) throws Exception {
		
		Connection conn = null;
		Statement stmt= null;
		ResultSet rs1= null ;
		
		String sql = "select notice_title, notice_content, notice_id from notice_info where notice_id='"+notice_id+"'";
		//String sql = "select notice_title, notice_content, notice_id from notice_info where notice_id='N003'";
		//String sql = "select notice_title, notice_content, notice_id from notice_info where notice_id='N001' ";
		
		//String sql2 = "select notice_id from notice_info where notice_id='N003'";
		//String maxId ="select max(notice_id)as maxId from notice_info";

		
		
		try {
			conn = ds.getConnection();
			stmt = conn.createStatement(); 
			rs1 = stmt.executeQuery(sql);
			
			if(rs1.next()) {
			
				System.out.println("update max1 : " + rs1.getString("notice_id"));
			
			}
			
			return null;
			
			/*
			if(rs1.next()) {
				return new NoticeVO()						
						.setNotice_id(rs1.getString("notice_id"));
			}else {
				throw new Exception("해당 번호의 회원을 찾을수 없습니다.");
			}
			*/
		}catch (Exception e) {
			throw e;
		}finally {
			try {if (rs1 != null) rs1.close();} catch(Exception e) {}
		    try {if (stmt != null) stmt.close();} catch(Exception e) {}
		    try {if (conn != null) conn.close();} catch(Exception e) {}
		} 
	}		
		
		
		/*
		try {
			conn = ds.getConnection();
			stmt = conn.createStatement(); 
			rs1 = stmt.executeQuery(sql);
			
			
			if(rs1.next()) {
				return new NoticeVO()
						.setNotice_title(rs1.getString("notice_title"))
						.setNotice_content(rs1.getString("notice_content"))
						.setNotice_id(rs1.getString("notice_id"));
			}else {
				throw new Exception("해당 번호의 회원을 찾을수 없습니다.");
			}
		}catch (Exception e) {
			throw e;
		}finally {
			try {if (rs1 != null) rs1.close();} catch(Exception e) {}
		    try {if (stmt != null) stmt.close();} catch(Exception e) {}
		    try {if (conn != null) conn.close();} catch(Exception e) {}
		} 
	}*/
	
	//공지사항 업데이트
	public int update(NoticeVO notice) throws Exception{
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update notice_info set notice_title=?, notice_content=?, notice_update=now() where notice_id=?";

		try {
			
			conn = ds.getConnection();System.out.println("---------s1");
			pstmt = conn.prepareStatement(sql);System.out.println("---------s2");
			pstmt.setString(1,notice.getNotice_title());
			pstmt.setString(2,notice.getNotice_content());
			pstmt.setString(3,notice.getNotice_id());
			System.out.println("---------s3 : " + notice.getNotice_title() + ", " +notice.getNotice_content() + ", "+ notice.getNotice_id());
			return pstmt.executeUpdate(); 
			
		}catch (Exception e) {
			throw e;
		}finally {
			try {if (pstmt != null) pstmt.close();} catch(Exception e) {}
			try {if (conn != null) conn.close();} catch(Exception e) {}
		}
	}
}
