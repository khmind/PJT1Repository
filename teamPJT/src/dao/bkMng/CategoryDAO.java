package dao.bkMng;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import vo.bkMng.CategoryVO;

public class CategoryDAO {

	DataSource ds;
	
	public void setDs(DataSource ds) {
		this.ds=ds;
	}
	
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	//전체 조회
	public List<CategoryVO> cateList() throws Exception{
		
		
		List<CategoryVO> cateList = new ArrayList<CategoryVO>();
		String sql = "select * from category_info order by cate_id asc";
		
		try {
			conn=ds.getConnection();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				CategoryVO cateVO=new CategoryVO()
						.setCate_id(rs.getString("cate_id"))
						.setCate_name(rs.getString("cate_name"))						
						.setCate_order(rs.getString("cate_order"))
						.setCate_place(rs.getString("cate_place"))
						.setCate_date(rs.getDate("cate_date"))
						.setAction(rs.getString("action"));
				cateList.add(cateVO);
			}
		}catch (Exception e) {
			throw e;
		}finally {
			try {if (rs != null) rs.close();} catch(Exception e) {}
		    try {if (pstmt != null) pstmt.close();} catch(Exception e) {}
		    try {if (conn != null) conn.close();} catch(Exception e) {}
		}
		return cateList;
	}
	//등록
	public int insert(CategoryVO vo) throws Exception{
		System.out.println("add===========3");
		String sql = "insert into category_info values(?,?,?,?,?,now())";
		int res=0;
		
		try {
			System.out.println("add===========4");
			conn=ds.getConnection();
			pstmt=conn.prepareStatement(sql);
			 
			pstmt.setString(1, vo.getCate_id());
			pstmt.setString(2, vo.getCate_name());
			pstmt.setString(3, vo.getCate_order());
			pstmt.setString(4, vo.getCate_place());
			pstmt.setString(5, vo.getAction());
			
			System.out.println("add===========5");
			System.out.println(vo.getCate_id());
			System.out.println(vo.getCate_name());
			System.out.println(vo.getCate_order());
			System.out.println(vo.getCate_place());
			System.out.println(vo.getAction());
			res=pstmt.executeUpdate();
			System.out.println("add===========6"+res);
		}catch (Exception e) {
			throw e;
		}finally {
			try {if (pstmt != null) pstmt.close();} catch(Exception e) {}
			try {if (conn != null) conn.close();} catch(Exception e) {}
		}
		return res;
	}
	//삭제
	public int delete(String[] ids) throws Exception{
		
		int res=0;
		int[] cnt=null;
		String sql="delete from category_info where CATE_id = ? ";
		
		try {
			conn=ds.getConnection();
			pstmt=conn.prepareStatement(sql);
			
			for(int i=0; i<ids.length; i++) {
				pstmt.setString(1, ids[i]);
				
				pstmt.addBatch();
			}
			cnt=pstmt.executeBatch();
			System.out.println(cnt.length+"================cnt111111");
			
			if ( cnt.length > 0)
				res = 11;
			
			
			/*
			for(int i=0; i<cnt.length; i++) {
				System.out.println(cnt[i]+"bbbbbbbbb");
				if(cnt[i]==2) {
					res++;
					System.out.println(cnt[i]+"aaaaaaaa");
				} 
			}
			 */
		}catch (Exception e) {
			res = 0;
			e.printStackTrace();
		}
		
		return res;
	}
	//조회
	public CategoryVO detail(String cate_id) throws Exception{
		 
		String sql = "select cate_id, cate_name, cate_order, cate_place, action from category_info where cate_id='"+cate_id+"'";
		
		try {
			conn=ds.getConnection();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				return new CategoryVO()
						.setCate_id(rs.getString("cate_id"))
						.setCate_name(rs.getString("cate_name"))
						.setCate_order(rs.getString("cate_order"))
						.setCate_place(rs.getString("cate_place"))
						.setAction(rs.getString("action"));
				
			}else {
				throw new Exception("해당 번호의 회원을 찾을수 없습니다.");
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
	public int update(CategoryVO cateVO) throws Exception{
		System.out.println("edit==========4");
		String sql = "update category_info set cate_name=?, cate_order=?, cate_place=?, action=? where cate_id=?";
		
		try {
			conn=ds.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, cateVO.getCate_name());
			pstmt.setString(2, cateVO.getCate_order());
			pstmt.setString(3, cateVO.getCate_place());
			pstmt.setString(4, cateVO.getAction());
			pstmt.setString(5, cateVO.getCate_id());
			System.out.println("edit==========3"+cateVO.getCate_name());
			System.out.println("edit==========3"+cateVO.getCate_order());
			System.out.println("edit==========3"+cateVO.getCate_place());
			System.out.println("edit==========3"+cateVO.getAction());
			System.out.println("edit==========3"+cateVO.getCate_id());
			return pstmt.executeUpdate();
			
		}catch (Exception e) {
			throw e;
		}finally {
			try {if (pstmt != null) pstmt.close();} catch(Exception e) {}
			try {if (conn != null) conn.close();} catch(Exception e) {}
		}
	}
	
	//관리자 사이트 카테고리 
	public List<CategoryVO> bkCateList() throws Exception{
		
		List<CategoryVO> cateList = new ArrayList<CategoryVO>();
		String sql = "select * from category_info where cate_place = 'B' order by cate_order asc";		
		
		try {
			 
			conn=ds.getConnection();		
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {

				CategoryVO cateVO=new CategoryVO()
						.setCate_id(rs.getString("cate_id"))
						.setCate_name(rs.getString("cate_name"))
						.setCate_order(rs.getString("cate_order"))
						.setCate_place(rs.getString("cate_place"))
						.setCate_date(rs.getDate("cate_date"))
						.setAction(rs.getString("action"));
				
				cateList.add(cateVO);
				
			}
		}catch (Exception e) {
			throw e;
		}finally {
			try {if (rs != null) rs.close();} catch(Exception e) {}
		    try {if (pstmt != null) pstmt.close();} catch(Exception e) {}
		    try {if (conn != null) conn.close();} catch(Exception e) {}
		}
		return cateList;
	}	
	
}
