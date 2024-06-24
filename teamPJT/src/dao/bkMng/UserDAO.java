package dao.bkMng;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import vo.bkMng.UserVO;


public class UserDAO {

	DataSource ds;
	
	public void setDataSource(DataSource ds) {
		this.ds=ds;
	}
	
	
	public UserVO selectListCnt(UserVO userV) throws Exception {
		
		//System.out.println("selectList a: " + userV.getSel1() + ", b : " + userV.getSel2() + ", c : " + userV.getSearchText()  + " startP : " + userV.getStartPage()+ ", endP :" + userV.getEndPage());
		
		Connection conn = null;				
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String where = "" ;	
		String methodFlag = userV.getMethodFlag();
		
		int page= userV.getPage();
		int total = 0;	  
		int limit=3;
  
		int startPage = (((int) ((double)page / limit + 0.9)) - 1) * limit + 1;
		int endPage = startPage+limit; 
		
		//System.out.println("********** startPage : " + startPage + ", (page/limit) : " + (page/limit) +",  (page/limit) * limit :" + (page/limit) * limit   + ", endPage : " + endPage );
		
		
		if ( userV.getSel2() != null &&  userV.getSel2() != "") {		
			where = " and " +  userV.getSel2() + " like '%" + userV.getSearchText() +"%' \n";
		}
		
		String sqlCnt =
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
		
		System.out.println("sqlCnt : " + sqlCnt);
					
		try {		
			
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sqlCnt);
			pstmt.setString(1,methodFlag);
			rs = pstmt.executeQuery();			
			
			if (rs.next())
				total = rs.getInt(1);
			
			int maxPage=(int)((double)total/limit+0.95);
			
			if (endPage> maxPage) endPage= maxPage;
			if (startPage == endPage )startPage = 1;
			
			//System.out.println(" +++++++++++  total : " + total +",  maxPage : " + maxPage +", startPage : " + startPage  + ", endPage : " + endPage );
			
			return new UserVO()
					.setSel1(userV.getSel1())
					.setSel2(userV.getSel2())
					.setSearchText(userV.getSearchText())
					.setPage(page)					
					.setStartPage(startPage)
					.setEndPage(endPage)
					.setLimit(limit)
					.setMethodFlag(methodFlag);
						
		} catch (Exception e) {
			throw e;
		}finally {
			try {if (rs != null) rs.close();} catch(Exception e) {}
		    try {if (pstmt != null) pstmt.close();} catch(Exception e) {}
		    try {if (conn != null) conn.close();} catch(Exception e) {}		    
		}
		
	}	
	
	public List<UserVO> selectList(UserVO userV) throws Exception {
		
		//System.out.println("selectList a: " + userV.getSel1() + ", b : " + userV.getSel2() + ", c : " + userV.getSearchText()  + " startP : " + userV.getStartPage()+ ", endP :" + userV.getEndPage());
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<UserVO> list = new ArrayList<UserVO>();
		
		String where = "" ;		
		String order = "";
		String methodFlag = userV.getMethodFlag();

	  	int page= userV.getPage();
		int limit=3;		
		int startrow=(page-1)*limit;
		
		if ( userV.getSel2() != null &&  userV.getSel2() != "") {				
			where = " and " +  userV.getSel2() + " like '%" + userV.getSearchText() +"%' \n";
		}
		
		if ( userV.getSel1() != null &&  userV.getSel1() != "") {
			order = " order by " + userV.getSel1() + " desc  \n" ;
		}
		
		String sql =
				" select a.user_id, a.user_name, a.user_email, a.user_pw, a.user_role, a.user_date, b.cnt, b.goodCnt, b.rcmCnt \n" + 
				" from user_info as a \n" + 
				" inner join ( \n" + 
				" 	select user_id, count(*) as cnt,  sum(recipe_good) as goodCnt, sum(recipe_rcm) as rcmCnt \n" + 
				" 	from recipe_info \n" + 
				"   group by user_id \n" + 
				" ) as b \n" + 
				" on a.user_id = b.user_id \n" +
				" where 1=1 \n" +
				" and user_role = ? \n" +
				where +
				order + 
				" limit ?, ?"
				;

		System.out.println("sql : " + sql);
					
		try {		
			
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,methodFlag);
			pstmt.setInt(2,startrow);
			pstmt.setInt(3, limit);
			rs = pstmt.executeQuery();
			
			System.out.println(" startrow : "  + startrow + ", limit : " + limit);
			
			while(rs.next()) {
				
				UserVO user = new UserVO()
						.setUser_id(rs.getString("user_id"))
						.setUser_name(rs.getString("user_name"))
						.setUser_email(rs.getString("user_email"))
						.setUser_pw(rs.getString("user_pw"))
						.setUser_role(rs.getString("user_role"))
						.setUser_date(rs.getDate("user_date"))			
						.setCnt(rs.getInt("cnt"))
						.setGoodCnt(rs.getInt("goodCnt"))
						.setRcmCnt(rs.getInt("rcmCnt"));
				
				list.add(user);		
				
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
						//.setUser_role(rs.getString("USER_ROLE")=="A" ? "관리자" : "일반사용자")
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
	public void update(UserVO UserVO) throws Exception{
				
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update user_info set user_email=? ,  user_pw=? , user_role=?  where user_id=?";
		
		try {
			
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, UserVO.getUser_email()); 
			pstmt.setString(2, UserVO.getUser_pw());
			pstmt.setString(3, UserVO.getUser_role());
			pstmt.setString(4, UserVO.getUser_id());
			
			pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {if (pstmt != null) pstmt.close();} catch(Exception e) {}
			try {if (conn != null) conn.close();} catch(Exception e) {}
		}
	}	
	
}