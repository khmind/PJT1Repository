package dao.bkMng;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import vo.bkMng.NoticeVO;

public class NoticeDAO {
	
	DataSource ds;
	
	public void setDataSource(DataSource ds) {
		this.ds=ds;
	}
	
	//공지사항리스트 출력
	public List<NoticeVO> NoticeList() throws Exception{
		System.out.println("-------------------------3");
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		
		List<NoticeVO> noticelist = new ArrayList<NoticeVO>();
		
		String sql = "select notice_id, notice_title, user_id, notice_date,"
					+ "notice_update from notice_info order by notice_date asc";
		try {
			
			conn=ds.getConnection();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				NoticeVO notice = new NoticeVO()
						.setNotice_id(rs.getString("notice_id"))
						.setNotice_title(rs.getString("notice_title"))
						.setUser_id(rs.getString("user_id"))
						.setNotice_date(rs.getDate("notice_date"))
						.setNotice_update(rs.getDate("notice_update"));
				noticelist.add(notice);
				System.out.println("-------------------------3"+rs.getString("notice_id"));
				
			}
			
		}catch (Exception e) {
			throw e;
		}finally {
			try {if (rs != null) rs.close();} catch(Exception e) {}
		    try {if (pstmt != null) pstmt.close();} catch(Exception e) {}
		    try {if (conn != null) conn.close();} catch(Exception e) {}
		}
		return noticelist;		
	}
	//특정 공지사항 조회
	public NoticeVO selectOne(String notice_id) throws Exception {
		
		Connection conn = null;
		Statement stmt= null;
		ResultSet rs1= null ;
		
		String sql = "select notice_title, notice_content, notice_id from notice_info where notice_id='"+notice_id+"'";
		
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
		}
		catch (Exception e) {
			throw e;
		}
		finally {
			try {if (rs1 != null) rs1.close();} catch(Exception e) {}
		    try {if (stmt != null) stmt.close();} catch(Exception e) {}
		    try {if (conn != null) conn.close();} catch(Exception e) {}
		} 
	}
	
	//공지사항 업데이트
	public int update(NoticeVO notice) throws Exception{
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update notice_info set notice_title=?, notice_content=?, notice_update=now() where notice_id=?";

		try {
			
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,notice.getNotice_title());
			pstmt.setString(2,notice.getNotice_content());
			pstmt.setString(3,notice.getNotice_id());
			
			return pstmt.executeUpdate(); 
			
		}catch (Exception e) {
			throw e;
		}finally {
			try {if (pstmt != null) pstmt.close();} catch(Exception e) {}
			try {if (conn != null) conn.close();} catch(Exception e) {}
		}
	}
	// 공지사항 등록
	public int insert(NoticeVO notice) throws Exception{
		System.out.println("```````````````````````4");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		Statement stmt= null;
		ResultSet rs1= null ;
		int res = 0;
		
		String setMaxId = "";
		
		String sql = "select notice_title, notice_content, notice_id from notice_info where notice_id=?";


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

		
		try {
			System.out.println("```````````````````````43");
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
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
		
		return res;
	}
	
}
