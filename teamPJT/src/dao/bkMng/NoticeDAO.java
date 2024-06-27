package dao.bkMng;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import vo.bkMng.NoticeVO;
import vo.bkMng.UserVO;

public class NoticeDAO {
	
	NoticeVO vo;
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
	public int insert(NoticeVO noticeVO) throws Exception{
		System.out.println("-------------------a");
		Connection conn = null; System.out.println("-------------------b");
		PreparedStatement pstmt = null; System.out.println("-------------------c");
		Statement stmt= null; System.out.println("-------------------d");
		ResultSet rs1= null ; System.out.println("-------------------e");
		int res1; System.out.println("-------------------f");
		
		String maxId ="select max(notice_id)as maxId from notice_info";
		String sql1 = "insert into notice_info(notice_id, notice_title, NOTICE_CONTENT, user_id, notice_date) values(?,?, ?, ?,now());";
		System.out.println("-------------------g");
		try {
			conn = ds.getConnection(); System.out.println("-------------------h");
			stmt = conn.createStatement();  System.out.println("-------------------i");
			rs1 = stmt.executeQuery(maxId); System.out.println("-------------------j");
			
			if(rs1.next()) {
				System.out.println("-------------------k");
				maxId = rs1.getString("maxId") ;
				
				int a = Integer.parseInt(maxId.substring(1));
				System.out.println("-------------------k"+a);
				a++;
				String sql2 = maxId.substring(0, 1) + a; 
				System.out.println("-------------------l");
			}			

		}catch (Exception e) {
			throw e;
		}finally {
			try {if (rs1 != null) rs1.close();} catch(Exception e) {}
		    try {if (stmt != null) stmt.close();} catch(Exception e) {}
		    try {if (conn != null) conn.close();} catch(Exception e) {}
		} 

		try {
			System.out.println("-------------------m");
			int a = Integer.parseInt(maxId.substring(1));
			a++;
			String sql2 = maxId.substring(0, 1) + a; 
			System.out.println("-------------------n");
			conn = ds.getConnection();
			
			pstmt = conn.prepareStatement(sql1);System.out.println("-------------------0");
			pstmt.setString(1, sql2 );System.out.println("-------------------01"+sql2);
			pstmt.setString(2,noticeVO.getNotice_title()); System.out.println("-------------------02"+noticeVO.getNotice_title());
			pstmt.setString(3,noticeVO.getNotice_content());System.out.println("-------------------03"+noticeVO.getNotice_content());
			pstmt.setString(4, noticeVO.getUser_id()); System.out.println("-------------------04"+noticeVO.getUser_id());
			res1 = pstmt.executeUpdate(); System.out.println("-------------------05");
		}catch (Exception e) {
			throw e;
			
		}finally {			
			try {if (pstmt != null) pstmt.close();} catch(Exception e) {}
			try {if (conn != null) conn.close();} catch(Exception e) {}
		}
		System.out.println("-------------------06");
		return res1;
	}
	
	//공지사항 전체삭제
	public int delete2(String[] ids) throws Exception {
		
		int res=0;
		int[] cnt=null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql="delete from notice_info where notice_id=?";
		System.out.println("delete11111");
		try {
			conn=ds.getConnection();
			pstmt=conn.prepareStatement(sql);
			
			for(int i=0; i<ids.length; i++) {
				pstmt.setString(1, ids[i]);
				
				pstmt.addBatch();
			}
			cnt=pstmt.executeBatch();
			
			
		}catch (Exception e) {
			res = 0;
			e.printStackTrace();
		}
		
		return res;
	}
	//공지사항 각자삭제
	public int delete1(String notice_id) throws Exception {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String query = "delete from notice_info where notice_id='"+notice_id+"'";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(query);
			return pstmt.executeUpdate();
			
		}catch (Exception e) {
			throw e;
		}finally {
			try {if (pstmt != null) pstmt.close();} catch(Exception e) {}
			try {if (conn != null) conn.close();} catch(Exception e) {}
		}		
	}
	
	

	public NoticeVO selectListCnt(NoticeVO noticeVO) throws Exception {
		System.out.println("-----------------------------10");
		
		Connection conn = null;				
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		System.out.println("-----------------------------11");
		String where = "" ;	
		int page = noticeVO.getPage();
		int total = 0; 
		int limit=3;
		System.out.println("-----------------------------12");
		int startPage = (((int) ((double)page / limit + 0.9)) - 1) * limit + 1;
		int endPage = startPage+limit; 
		
		System.out.println("********** startPage : " + startPage + ", (page/limit) : " + (page/limit) +",  (page/limit) * limit :" + (page/limit) * limit   + ", endPage : " + endPage );
		
		System.out.println("-----------------------------13");
		if ( noticeVO.getSel1() != null &&  noticeVO.getSel1() != "") {	
			System.out.println("-----------------------------14");
			where = " and " +  noticeVO.getSel1() + " like '%" + noticeVO.getSearchText() +"%' \n";
		}
		System.out.println("-----------------------------15");
		
		String sqlCnt = " select count(notice_id) from notice_info where 1=1" + where ;	
		
		System.out.println("-----------------------------16");
		
		/*
		String sqlCnt1 =
				" select count(a.user_id) \n" + 
				" from user_info as a \n" + 
				" inner join ( \n" + 
				" 	select user_id, count(*) as cnt,  sum(recipe_good) as goodCnt, sum(recipe_rcm) as rcmCnt \n" + 
				" 	from recipe_info \n" + 
				"   group by user_id \n" + 
				" ) as b \n" + 
				" on a.user_id = b.user_id \n" +
				" where 1=1 \n" +
				" and user_role = ? \n" +
				where ;	
		*/
		
		System.out.println("sqlCnt : " + sqlCnt);
		
		try {		
			System.out.println("-----------------------------17");
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sqlCnt);
			rs = pstmt.executeQuery();			
			
			if (rs.next())
				total = rs.getInt(1);
			
			int maxPage=(int)((double)total/limit+0.95);
			
			if (endPage> maxPage) endPage= maxPage;
			if (startPage == endPage )startPage = 1;
			
			System.out.println(" +++++++++++  total : " + total +",  maxPage : " + maxPage +", startPage : " + startPage  + ", endPage : " + endPage );
			
			return new NoticeVO()
					.setSel1(noticeVO.getSel1())
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
		System.out.println("-----------------------------18");
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		System.out.println("-----------------------------19");
		
		List<NoticeVO> list = new ArrayList<NoticeVO>();
		
		String where = "" ;		
		String order = "";
		System.out.println("-----------------------------20");
	  	int page = noticeVO.getPage(); 
		int limit=3;
		int startrow=(page-1)*limit; 
		System.out.println("-----------------------------21  page : " + page);
		if ( noticeVO.getSel1() != null &&  noticeVO.getSel1() != "") {				
			where = " and " +  noticeVO.getSel1() + " like '%" + noticeVO.getSearchText() +"%' \n";
			//order = " order by " + noticeVO.getSel1() + " desc  \n" ;
		}

		String sql =
				" select notice_id, notice_title, user_id, notice_date, notice_update from notice_info where 1=1 " + where + order + " limit ?, ?";
		/*
		String sql2 = 
		" select a.user_id, a.user_name, a.user_email, a.user_pw, a.user_role, a.user_date, b.cnt, b.goodCnt, b.rcmCnt \n" + " from user_info as a \n" +
		" inner join ( \n" + " 	select user_id, count(*) as cnt,  sum(recipe_good) as goodCnt, sum(recipe_rcm) as rcmCnt \n" + 
		" 	from recipe_info \n" +  "   group by user_id \n" + " ) as b \n" +  " on a.user_id = b.user_id \n" +
		" where 1=1 \n" + " and user_role = ? \n" + where + order + " limit ?, ?";
		*/
		System.out.println("sql : " + sql);
					
		try {		
			System.out.println("-----------------------------22");
			conn = ds.getConnection();	System.out.println("-----------------------------23");
			pstmt = conn.prepareStatement(sql); 	System.out.println("-----------------------------24");
			pstmt.setInt(1,startrow); 	System.out.println("-----------------------------25 : " + startrow);
			pstmt.setInt(2, limit); 	System.out.println("-----------------------------26 : " +  limit);
			rs = pstmt.executeQuery(); 	System.out.println("-----------------------------27");
			
			System.out.println(" startrow : "  + startrow + ", limit : " + limit);
			
			while(rs.next()) {
				
				NoticeVO notice = new NoticeVO()
						.setNotice_id(rs.getString("notice_id"))
						.setNotice_title(rs.getString("notice_title"))
						.setUser_id(rs.getString("user_id"))
						.setNotice_date(rs.getDate("notice_date"))
						.setNotice_update(rs.getDate("notice_update"));			
				
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
