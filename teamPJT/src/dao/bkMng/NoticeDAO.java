package dao.bkMng;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import vo.bkMng.NoticeVO;

public class NoticeDAO {
	
	DataSource ds;
	
	public void setDataSource(DataSource ds) {
		this.ds=ds;
	}
	
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
}
