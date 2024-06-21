package dao.bkMng;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import vo.bkMng.AskVO;
import vo.bkMng.NoticeVO;
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
				System.out.println("-------------------------3"+rs.getString("ask_id"));
				System.out.println("-------------------------3"+rs.getString("user_id"));
				System.out.println("-------------------------3"+rs.getString("ask_title"));
				System.out.println("-------------------------3"+rs.getString("ask_date"));
				System.out.println("-------------------------3"+rs.getString("recomm_date"));
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
		
		Connection conn = null;
		Statement stmt= null;
		ResultSet rs= null ;
		
		String sql = "select ask_id, ask_title ,ask_content, user_id, ask_date, recomm_content "
				+ "from ask_info where notice_id='"+ask_id+"'";
		
		try {
			conn = ds.getConnection();
			stmt = conn.createStatement(); 
			rs = stmt.executeQuery(sql);
			
			
			if(rs.next()) {
				return new AskVO()
						.setAsk_title(rs.getString("ask_title"))
						.setAsk_content(rs.getString("ask_content"))
						.setUser_id(rs.getString("user_id"))
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
	//문의사항 답변추가
	
}
