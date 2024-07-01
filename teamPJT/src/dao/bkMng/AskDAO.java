package dao.bkMng;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import vo.bkMng.AskVO;

public class AskDAO {

	DataSource ds;
	
	public void setDataSource(DataSource ds) {
		this.ds=ds;
	}	
/*	
	public List<AskVO> AskList() throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		
		List<AskVO> asklist = new ArrayList<AskVO>();
		
		String sql = "select ask_id, user_id, ask_title, ask_date, recomm_date from ask_info order by ask_date asc";
		try {
			
			conn=ds.getConnection();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				AskVO ask = new AskVO().setAsk_id(rs.getString("ask_id"))
						.setUser_id(rs.getString("user_id"))
						.setAsk_title(rs.getString("ask_title"))
						.setAsk_date(rs.getDate("ask_date"))
						.setRecomm_date(rs.getDate("recomm_date"));
				asklist.add(ask);
			}
			
		}catch (Exception e) {
			throw e;
		}finally {
			try {if (rs != null) rs.close();} catch(Exception e) {}
		    try {if (pstmt != null) pstmt.close();} catch(Exception e) {}
		    try {if (conn != null) conn.close();} catch(Exception e) {}
		}
		return asklist;		
	}
	*/
	//문의사항 조회
	public AskVO selectOne(String ask_id) throws Exception {

		Connection conn = null;
		Statement stmt= null;
		ResultSet rs= null ;
		
		String sql = "select ask_id, ask_title, ask_content, user_id, ask_date, recomm_content "
				+ "from ask_info where ask_id='"+ask_id+"'";

		try {
			conn = ds.getConnection();
			stmt = conn.createStatement(); 
			rs = stmt.executeQuery(sql);

			
			if(rs.next()) {

				return new AskVO()
						.setAsk_title(rs.getString("ask_title"))
						.setAsk_content(rs.getString("ask_content"))
						.setUser_id(rs.getString("user_id"))
						.setAsk_date(rs.getDate("ask_date"))
						.setRecomm_content(rs.getString("recomm_content"))
						.setAsk_id(rs.getString("ask_id"))	;
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
	//문의사항 답변 업데이트
	public int update(AskVO ask) throws Exception{
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update ask_info set recomm_content=?, recomm_date=now() where ask_id=?";
		try {
			
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,ask.getRecomm_content());
			pstmt.setString(2, ask.getAsk_id());
			return pstmt.executeUpdate(); 
			
		}catch (Exception e) {
			throw e;
		}finally {
			try {if (pstmt != null) pstmt.close();} catch(Exception e) {}
			try {if (conn != null) conn.close();} catch(Exception e) {}
		}
	}
	
	public int insert(AskVO askVO) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "update ask_info set recomm_content=?,user_id=?, recomm_date=now(), recomm_user_id=? where ask_id=?";
		
		try {

			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
	
			pstmt.setString(1,askVO.getRecomm_content());
			pstmt.setString(2,askVO.getUser_id());
			pstmt.setString(3,askVO.getRecomm_user_id());
			pstmt.setString(4,askVO.getAsk_id());
			return pstmt.executeUpdate();
		}catch (Exception e) {
			throw e;
			
		}finally {			
			try {if (pstmt != null) pstmt.close();} catch(Exception e) {}
			try {if (conn != null) conn.close();} catch(Exception e) {}
		}
		
		
	}
	// 문의사항 답변 추가하는곳에서 삭제
	public int delete1(String ask_id) throws Exception {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String query = "delete from ask_info where ask_id=?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1,ask_id);
			
			return pstmt.executeUpdate();
			
		}catch (Exception e) {
			throw e;
		}finally {
			try {if (pstmt != null) pstmt.close();} catch(Exception e) {}
			try {if (conn != null) conn.close();} catch(Exception e) {}
		}		
	}
	// 문의사항 리스트에서 삭제
	public int delete2(String[] ids) throws Exception {

		int res=0;
		int[] cnt=null;
		String sql="delete from ask_info where ask_id = ? ";
		Connection conn = null; 
		PreparedStatement pstmt =null;
		try {
			conn=ds.getConnection();
			pstmt=conn.prepareStatement(sql);
			
			for(int i=0; i<ids.length; i++) {
				pstmt.setString(1, ids[i]);
				
				pstmt.addBatch();
			}
			cnt=pstmt.executeBatch();
			
			if ( cnt.length > 0) res = 11;
			
		}catch (Exception e) {
			res = 0;
			e.printStackTrace();
		}
		
		return res;
	}
	public AskVO selectListCnt(AskVO askVO) throws Exception {

		Connection conn = null;				
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String where = "" ;	
		int page = askVO.getPage();
		int total = 0; 
		int limit=3;
		int startPage = (((int) ((double)page / limit + 0.9)) - 1) * limit + 1;
		int endPage = startPage+limit; 
		
		//System.out.println("********** startPage : " + startPage + ", (page/limit) : " + (page/limit) +",  (page/limit) * limit :" + (page/limit) * limit   + ", endPage : " + endPage );
		
		if (askVO.getSel2() != null &&  askVO.getSel2() != "") {	
			
			where = " and " +  askVO.getSel2() + " like '%" + askVO.getSearchText() +"%' \n";
		}
		String sqlCnt = " select count(ask_id) from ask_info where 1=1" + where ;	
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
			
			return new AskVO()
					.setSel1(askVO.getSel1())
					.setSel2(askVO.getSel2())
					.setEndPage(endPage)
					.setPage(page)
					.setStartPage(startPage)
					.setSearchText(askVO.getSearchText())
					.setLimit(limit);
			
						
		} catch (Exception e) {
			throw e;
		}finally {
			try {if (rs != null) rs.close();} catch(Exception e) {}
		    try {if (pstmt != null) pstmt.close();} catch(Exception e) {}
		    try {if (conn != null) conn.close();} catch(Exception e) {}		    
		}
		
	}
	
	public List<AskVO> selectList(AskVO askVO) throws Exception {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<AskVO> list = new ArrayList<AskVO>();
		
		String where = "" ;		
		String order = "";
	  	int page = askVO.getPage(); 
		int limit=3;
		int startrow=(page-1)*limit; 
		if ( askVO.getSel2() != null &&  askVO.getSel2() != "") {				
			where = " and " +  askVO.getSel2() + " like '%" + askVO.getSearchText() +"%' \n";
			//order = " order by " + noticeVO.getSel1() + " desc  \n" ;
		}
		if ( askVO.getSel1() != null &&  askVO.getSel1() != "") {
			order = " order by " + askVO.getSel1() + " desc  \n" ;
		}
		
		String sql =
				" select ask_id, user_id, ask_title, ask_date, recomm_date from ask_info where 1=1 " + where + order + " limit ?, ?";

		//System.out.println("sql : " + sql);
					
		try {		
			
			conn = ds.getConnection();	
			pstmt = conn.prepareStatement(sql); 
			pstmt.setInt(1,startrow); 	
			pstmt.setInt(2, limit); 
			rs = pstmt.executeQuery();
			
			//System.out.println(" startrow : "  + startrow + ", limit : " + limit);
			
			while(rs.next()) {
				
				AskVO ask = new AskVO()
						.setAsk_id(rs.getString("ask_id"))
						.setAsk_title(rs.getString("ask_title"))
						.setUser_id(rs.getString("user_id"))
						.setAsk_date(rs.getDate("ask_date"))
						.setRecomm_date(rs.getDate("Recomm_date"));			
				
				list.add(ask);		
				
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
