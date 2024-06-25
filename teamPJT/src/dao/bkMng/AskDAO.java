package dao.bkMng;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import vo.bkMng.AskVO;
import vo.bkMng.UserVO;

public class AskDAO {

	UserVO vo;
	DataSource ds;
	
	public void setDataSource(DataSource ds) {
		this.ds=ds;
	}	
	
	public List<AskVO> AskList() throws Exception{
		System.out.println("-------------------------3");
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
	//문의사항 조회
	public AskVO selectOne(String ask_id) throws Exception {
		System.out.println("----------------------------5-2");
		Connection conn = null;
		Statement stmt= null;
		ResultSet rs= null ;
		
		String sql = "select ask_id, ask_title, ask_content, user_id, ask_date, recomm_content "
				+ "from ask_info where ask_id='"+ask_id+"'";
		System.out.println("----------------------------5-3");
		try {
			conn = ds.getConnection();
			stmt = conn.createStatement(); 
			rs = stmt.executeQuery(sql);
			System.out.println("----------------------------5-4");
			
			if(rs.next()) {
				System.out.println("----------------------------5-5");
				System.out.println("----------------------------5-5-1"+ask_id);
				return new AskVO()
						.setAsk_title(rs.getString("ask_title"))
						.setAsk_content(rs.getString("ask_content"))
						.setUser_id(rs.getString("user_id"))
						.setAsk_date(rs.getDate("ask_date"))
						.setRecomm_content(rs.getString("recomm_content"))
						.setAsk_id(rs.getString("ask_id"));
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
		System.out.println("----------------------------10");
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update ask_info set recomm_content=?, recomm_date=now() where ask_id=?";
		System.out.println("----------------------------11"+ask.getAsk_id());
		try {
			System.out.println("----------------------------12");
			conn = ds.getConnection();System.out.println("----------------------------13");
			pstmt = conn.prepareStatement(sql);System.out.println("----------------------------14"+sql);
			pstmt.setString(1,ask.getRecomm_content());System.out.println("----------------------------15-1"+ask.getRecomm_content());
			pstmt.setString(2, ask.getAsk_id());System.out.println("----------------------------15-2"+ask.getAsk_id());
			System.out.println("----------------------------16");
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
		Statement stmt= null;
		ResultSet rs1= null ;
		int res;
		
		String maxId ="select max(ask_id)as maxId from ask_info";
		String sql1 = "update ask_info set recomm_content=?, recomm_date=now() where ask_id=?";
		
		try {
			conn = ds.getConnection();
			stmt = conn.createStatement(); 
			rs1 = stmt.executeQuery(maxId);
			
			if(rs1.next()) {
			
				maxId = rs1.getString("maxId") ;
				
				int a = Integer.parseInt(maxId.substring(1));
				a++;
				String ask_id = maxId.substring(0, 1) + a; 
			}			

		}catch (Exception e) {
			throw e;
		}finally {
			try {if (rs1 != null) rs1.close();} catch(Exception e) {}
		    try {if (stmt != null) stmt.close();} catch(Exception e) {}
		    try {if (conn != null) conn.close();} catch(Exception e) {}
		} 

		try {
			int a = Integer.parseInt(maxId.substring(1));
			a++;
			String ask_id = maxId.substring(0, 1) + a; 
			conn = ds.getConnection();
			
			pstmt = conn.prepareStatement(sql1);
			pstmt.setString(1, ask_id );
			pstmt.setString(2,askVO.getUser_id());
			pstmt.setString(3,askVO.getRecomm_content());
			pstmt.setString(4, askVO.getRecomm_user_id());
			res = pstmt.executeUpdate();
		}catch (Exception e) {
			throw e;
			
		}finally {			
			try {if (pstmt != null) pstmt.close();} catch(Exception e) {}
			try {if (conn != null) conn.close();} catch(Exception e) {}
		}
		
		return res;
	}
}
