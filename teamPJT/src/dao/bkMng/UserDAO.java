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
	
	
	public List<UserVO> selectList(UserVO userV) throws Exception {
		
		System.out.println("selectList a: " + userV.getSel1() + ", b : " + userV.getSel2() + ", c : " + userV.getSearchText());
		
		Connection conn = null;
		PreparedStatement pstmt = null;		
		Statement stmt = null;
		ResultSet rs = null;
		
		List<UserVO> list = new ArrayList<UserVO>();
		
		String where = "" ;
		String order = "";		
		int total = 0, start = 0, endP = 0;		
		int pageSize = 3;		// 페이징할 수
		int pageSeperate = 10;	// 페이징할 단위
		int pageTotal = 0;		// 전체페이지
		int cpage = 0;		
				
	  	int page=3;
		int limit=3;
		
		int startrow=(page-1)*limit;
				
		
		if ( userV.getSel2() != null &&  userV.getSel2() != "") {				
			where = " and " +  userV.getSel2() + " like '%" + userV.getSearchText() +"%'";
		}
		
		if ( userV.getSel1() != null &&  userV.getSel1() != "") {
			order = " order by " + userV.getSel1() + " desc " ;
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
				where ;	
		
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
				where +
				order +
				" limit ?, ?"
				;
		
		System.out.println("sqlCnt : " + sqlCnt);
		System.out.println("sql : " + sql);
					
		try {		
			
			conn = ds.getConnection();			
			stmt = conn.createStatement();			

			rs = stmt.executeQuery(sqlCnt);
			if (rs.next())
				total = rs.getInt(1);
			rs.close();
			
			cpage = 1;
			
			pageTotal = (total-1)/pageSize;
			if (cpage<0) cpage=0;
			if (cpage>pageTotal) cpage=pageTotal;		
			
			start = cpage * pageSize + 1;
			endP = start + pageSize - 1;
			
			System.out.println(" total : " + total + ", start : " + start +", endP : " + endP);
			System.out.println(" -------------0 ");
			System.out.println(" 0 startrow : "  + startrow + ", limit : " + limit);
			
			pstmt = conn.prepareStatement(sql); System.out.println(" -------------1 ");
			pstmt.setInt(1,startrow); System.out.println(" -------------2 ");
			pstmt.setInt(2, limit); System.out.println(" -------------3 ");
			rs = pstmt.executeQuery();
			
			System.out.println(" startrow : "  + startrow + ", limit : " + limit);
			
			while(rs.next()) {
				
				System.out.println(" -------------rs.next() ");
				
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
		    try {if (stmt != null) stmt.close();} catch(Exception e) {}
		    try {if (conn != null) conn.close();} catch(Exception e) {}		    
		}
		
		return list;
	}
	
/*	
	//등록
	public int insert(UserVO UserVO) throws Exception{
		
		Connection conn = null;		
		PreparedStatement pstmt = null;
		String query ="insert into UserVOs(email,pwd,mname,cre_date,mod_date)"
				+ "values(?,?,?,now(),now())";
		int res ;
		
		try {
			
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1,UserVO.getEmail());
			pstmt.setString(2, UserVO.getPassword());
			pstmt.setString(3,UserVO.getName());
			
			res = pstmt.executeUpdate();
			
		}catch (Exception e) {
			throw e;
			
		}finally {			
			try {if (pstmt != null) pstmt.close();} catch(Exception e) {}
			try {if (conn != null) conn.close();} catch(Exception e) {}
		}
		
		return res;
	}
	
	//삭제
	public int delete(int no) throws Exception {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String query = "delete from UserVOs where mno=?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1,no);
			
			return pstmt.executeUpdate();
			
		}catch (Exception e) {
			throw e;
		}finally {
			try {if (pstmt != null) pstmt.close();} catch(Exception e) {}
			try {if (conn != null) conn.close();} catch(Exception e) {}
		}		
	}
	
	//상세검색
	public UserVO selectOne(int no) throws Exception {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String query = "select mno,email,mname,cre_date from UserVOs where mno="+no;
		
		try {
			conn = ds.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			if(rs.next()) {
				return new UserVO()
						.setNo(rs.getInt("mno"))
						.setEmail(rs.getString("email"))
						.setName(rs.getString("mname"))
						.setCreatedDate(rs.getDate("cre_date"));
			}else {
				throw new Exception("해당 번호의 회원을 찾을수 없습니다.");
			}
		}catch (Exception e) {
			throw e;
		}finally {
			try {if (rs != null) rs.close();} catch(Exception e) {}
		    try {if (stmt != null) stmt.close();} catch(Exception e) {}
		    try {if (conn != null) conn.close();} catch(Exception e) {}
		} 
	}
	
	//수정
	public int update(UserVO UserVO) throws Exception{
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String query = "update UserVOs set email=?,mname=?,mod_date=now() where mno=?";
		
		try {
			
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1,UserVO.getEmail());
			pstmt.setString(2,UserVO.getName());
			pstmt.setInt(3,UserVO.getNo());
			
			return pstmt.executeUpdate();
			
		}catch (Exception e) {
			throw e;
		}finally {
			try {if (pstmt != null) pstmt.close();} catch(Exception e) {}
			try {if (conn != null) conn.close();} catch(Exception e) {}
		}
	}
	
	//회원확인
	public UserVO exist(String email, String password) throws Exception {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String query = "select mname,email from UserVOs where email=? and pwd=?";
		ResultSet rs = null;
		
		try {
		
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1,email);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return new UserVO()
						.setName(rs.getString("mname"))
						.setEmail(rs.getString("email"));
			}else {
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
	*/
	
}