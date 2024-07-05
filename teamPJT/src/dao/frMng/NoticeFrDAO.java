package dao.frMng;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

import vo.bkMng.NoticeVO;

public class NoticeFrDAO {
	
	NoticeVO vo;
	DataSource ds; 
	
	public void setDataSource(DataSource ds) {
		this.ds=ds;
	}	
	

	//특정 공지사항 조회
	public NoticeVO selectOne(String notice_id) throws Exception {
		
		Connection conn = null;
		Statement stmt= null;
		ResultSet rs= null ;
		String sql = "select notice_title, notice_content, notice_id from notice_info where notice_id='"+notice_id+"'";
		
		try {
			conn = ds.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		
			if(rs.next()) {
				return new NoticeVO()
						.setNotice_title(rs.getString("notice_title"))
						.setNotice_content(rs.getString("notice_content"))
						.setNotice_id(rs.getString("notice_id"));
			}else {
				throw new Exception("해당 번호의 회원을 찾을수 없습니다.");
			}
		}
		catch (Exception e) {
			throw e;
		}
		finally {
			try {if (rs != null) rs.close();} catch(Exception e) {}
		    try {if (stmt != null) stmt.close();} catch(Exception e) {}
		    try {if (conn != null) conn.close();} catch(Exception e) {}
		} 
	}
	
	public NoticeVO selectListCnt(NoticeVO noticeVO) throws Exception {
		
		Connection conn = null;				
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String where = "" ;	
		
		int page = noticeVO.getPage();
		int total = 0; 
		int limit=5;

		int startPage = (((int) ((double)page / limit + 0.9)) - 1) * limit + 1;
		int endPage = startPage+limit; 
		
		//System.out.println("********** startPage : " + startPage + ", (page/limit) : " + (page/limit) +",  (page/limit) * limit :" + (page/limit) * limit   + ", endPage : " + endPage );
		
		if ( noticeVO.getSel1() != null &&  noticeVO.getSel1() != "") {	
			where = " and " +  noticeVO.getSel1() + " like '%" + noticeVO.getSearchText() +"%' \n";
		}

		String sqlCnt = " select count(notice_id) from notice_info where 1=1" + where ;	
		
		//System.out.println("sqlCnt : " + sqlCnt);
		
		try {		
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sqlCnt);
			rs = pstmt.executeQuery();			
			
			if (rs.next())
				total = rs.getInt(1);
			
			int maxPage=(int)((double)total/limit+0.95);
			
			if (endPage> maxPage) endPage= maxPage;
			if (startPage == endPage )startPage = 1;
			
			//System.out.println(" +++++++++++  total : " + total +",  maxPage : " + maxPage +", startPage : " + startPage  + ", endPage : " + endPage );
			
			return new NoticeVO()
					.setEndPage(endPage)
					.setPage(page)
					.setStartPage(startPage)
					.setSearchText(noticeVO.getSearchText())
					.setLimit(limit);
			
						
		} catch (Exception e) {
			throw e;
		}finally {
			try {if (rs != null) rs.close();} catch(Exception e) {}
		    try {if (pstmt != null) pstmt.close();} catch(Exception e) {}
		    try {if (conn != null) conn.close();} catch(Exception e) {}		    
		}
		
	}
	
	public List<NoticeVO> selectList(NoticeVO noticeVO) throws Exception {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<NoticeVO> list = new ArrayList<NoticeVO>();
		
		String where = "" ;		
		String order = "";

	  	int page = noticeVO.getPage(); 
		int limit=5;
		int startrow=(page-1)*limit; 

		if ( noticeVO.getSel1() != null &&  noticeVO.getSel1() != "") {				
			where = " and " +  noticeVO.getSel1() + " like '%" + noticeVO.getSearchText() +"%' \n";
			//order = " order by " + noticeVO.getSel1() + " desc  \n" ;
		}

		String sql =
				" select notice_id, notice_title from notice_info where 1=1 " + where + order + " limit ?, ?";

		//System.out.println("sql : " + sql);
					
		try {		
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql); 
			pstmt.setInt(1,startrow); 	
			pstmt.setInt(2, limit); 	
			rs = pstmt.executeQuery(); 
			
			System.out.println(" startrow : "  + startrow + ", limit : " + limit);
			
			while(rs.next()) {
				
				NoticeVO notice = new NoticeVO()
						.setNotice_id(rs.getString("notice_id"))
						.setNotice_title(rs.getString("notice_title"));			
				
				list.add(notice);		
				
			}
			
		} catch (Exception e) {
			throw e;
		}finally {
			try {if (rs != null) rs.close();} catch(Exception e) {}
		    try {if (pstmt != null) pstmt.close();} catch(Exception e) {}
		    try {if (conn != null) conn.close();} catch(Exception e) {}		    
		}

		return list;
	}

}
