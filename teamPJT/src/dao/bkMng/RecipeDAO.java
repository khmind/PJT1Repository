package dao.bkMng;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import vo.bkMng.RecipeVO;

public class RecipeDAO {

	DataSource ds; 
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs =null;
	Statement stmt = null;
	
	public void setDs(DataSource ds) {
		this.ds = ds;
	}
	//분류조회
	public List<RecipeVO> classList() throws Exception{

		List<RecipeVO> classList = new ArrayList<RecipeVO>();
		String sql = "select * from recipe_class_info";
		
		try {
			conn=ds.getConnection();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				RecipeVO vo = new RecipeVO()
						.setClass_id(rs.getString("class_id"))
						.setClass_name(rs.getString("class_name"));
				
				classList.add(vo);
			}
			
		}catch (Exception e) {
			throw e;
		}finally {
			try {if (rs != null) rs.close();} catch(Exception e) {}
		    try {if (stmt != null) stmt.close();} catch(Exception e) {}
		    try {if (conn != null) conn.close();} catch(Exception e) {}
		}
		return classList;
	}
	//등록 ->dao.bkMng
	public int insert(RecipeVO vo) throws Exception{
		
		System.out.println("addDAO=============1");
		int res;
		int res1;
		String imgPath = "../img/frMng/";
		String maxId ="select max(recipe_id)as maxId from recipe_info";
		String sql1 = "insert into recipe_info \r\n" + 
				"	(recipe_id, recipe_title, class_id, recipe_level,\r\n" + 
				"    recipe_stuff, recipe_content, user_id, recipe_date) \r\n" + 
				"	values(?,?,?,?,?,?,?,now())";
		String sql3="insert into recipe_image_info \r\n" + 
				"	(recipe_id,img_path_01,img_path_02,img_path_03,img_main)\r\n" + 
				"	values(?,?,?,?,img_path_03)";
		
		try {
			conn = ds.getConnection();
			stmt = conn.createStatement(); 
			rs = stmt.executeQuery(maxId);
			//String sql2=null;
			PreparedStatement pstmt2=null;
			
			System.out.println("addDAO=============2");
			
			if(rs.next()) {
			
				System.out.println("////////////////////");
				maxId = rs.getString("maxId") ;
				System.out.println("////////////////////"+maxId);
				int a = Integer.parseInt(maxId.substring(2));
				System.out.println("////////////////////"+a);
				a++;
				String sql2 = maxId.substring(0, 2) + a; 
				System.out.println("addDAO=============3"+sql2);
			}		
			int a = Integer.parseInt(maxId.substring(2));
			a++;
			String sql2 = maxId.substring(0, 2) + a;
			System.out.println("addDAO=============3"+sql2);
			
			pstmt=conn.prepareStatement(sql1);
			pstmt.setString(1, sql2);
			pstmt.setString(2, vo.getRecipe_title());
			pstmt.setString(3, vo.getClass_id());
			pstmt.setString(4, vo.getRecipe_level());
			pstmt.setString(5, vo.getRecipe_stuff());
			pstmt.setString(6, vo.getRecipe_content());
			pstmt.setString(7, vo.getUser_id());


			res=pstmt.executeUpdate();
			
			pstmt2=conn.prepareStatement(sql3);
			pstmt2.setString(1, sql2);
			pstmt2.setString(2, imgPath+vo.getImg_path_01());
			pstmt2.setString(3, imgPath+vo.getImg_path_02());
			pstmt2.setString(4, imgPath+vo.getImg_path_03());
			

			
			res1=pstmt2.executeUpdate();
			

		}catch (Exception e) {
			throw e;
		}finally {
			try {if (rs != null) rs.close();} catch(Exception e) {}
		    try {if (stmt != null) stmt.close();} catch(Exception e) {}
		    try {if (conn != null) conn.close();} catch(Exception e) {}
		} 
		
		return res1;
	}

	//수정 ->dao.bkMng
	public int update(RecipeVO vo) throws Exception{
		
		System.out.println("update===================1");
		String imgPath = "../img/frMng/";
		int res;
		String sql01="update recipe_info \r\n" + 
				"	set recipe_title=?,recipe_level=?,recipe_stuff=?,\r\n" + 
				"		recipe_content=? where recipe_id=?";
		String sql02="update recipe_image_info\r\n" + 
				"	set img_path_01=?,img_path_02=?,img_path_03=? where recipe_id=?";
		String sql03="update recipe_class_info\r\n" + 
				"	set class_name=? where class_id=?";
		
		try {
			conn=ds.getConnection();
			pstmt=conn.prepareStatement(sql01);
			pstmt.setString(1, vo.getRecipe_title());
			pstmt.setString(2, vo.getRecipe_level());
			pstmt.setString(3, vo.getRecipe_stuff());
			pstmt.setString(4, vo.getRecipe_content());
			pstmt.setString(5, vo.getRecipe_id());
			res=pstmt.executeUpdate();
			
			pstmt=conn.prepareStatement(sql02);
			pstmt.setString(1, imgPath+vo.getImg_path_01());
			pstmt.setString(2, imgPath+vo.getImg_path_02());
			pstmt.setString(3, imgPath+vo.getImg_path_03());
			pstmt.setString(4, vo.getRecipe_id());
			res=pstmt.executeUpdate();
			
			pstmt=conn.prepareStatement(sql03);
			pstmt.setString(1, vo.getClass_name());
			pstmt.setString(2, vo.getClass_id());
			res=pstmt.executeUpdate();
			
			return res;
			
		}catch (Exception e) {
			throw e;
		}finally {
			
		}
		
	}
	//삭제  ->dao.bkMng
	public int delete(String[] ids) throws Exception {
		int res=0;
		int[] cnt=null;
		String sql01 = "delete from recipe_image_info where recipe_id=?";
		String sql02 = "delete from recipe_info where recipe_id=?";
		try {
			conn=ds.getConnection();
			//pstmt=conn.prepareStatement(sql01);
			
			for(int i=0; i<ids.length; i++) {
				
				pstmt=conn.prepareStatement(sql01);
				pstmt.setString(1, ids[i]);				
				pstmt.addBatch();
				cnt=pstmt.executeBatch();
				
				pstmt=conn.prepareStatement(sql02);
				pstmt.setString(1, ids[i]);				
				pstmt.addBatch();				
				cnt=pstmt.executeBatch();
				
			}
			//cnt=pstmt.executeBatch();			
			
			
			
/*			
			for(int i=0; i<ids.length; i++) {
				pstmt.setString(1, ids[i]);
				
				pstmt.addBatch();
			}
			cnt=pstmt.executeBatch();
			
			pstmt=conn.prepareStatement(sql02);
			
			for(int i=0; i<ids.length; i++) {
				pstmt.setString(1, ids[i]);
				
				pstmt.addBatch();
			}
			cnt=pstmt.executeBatch();
			
			*/
			
		}catch (Exception e) {
			res = 0;
			e.printStackTrace();
		}
		
		return res;	
	}
	//상세조회 
	public RecipeVO detail(String recipe_id) throws Exception{
		
		System.out.println("detailDAO==============1");
		String sql = "select a.recipe_id, a.recipe_title, b.class_name, c.img_path_01, c.img_path_02, c.img_path_03,\r\n" + 
				"	a.recipe_level, a.recipe_stuff, a.recipe_content, d.user_name, e.comment_content, e.comment_date\r\n" + 
				"    from recipe_info a\r\n" + 
				"    inner join recipe_class_info b on a.class_id=b.class_id\r\n" + 
				"    inner join recipe_image_info c on a.recipe_id=c.recipe_id\r\n" + 
				"    inner join user_info d on a.user_id=d.user_id\r\n" + 
				"    inner join recipe_reply e on a.recipe_id= e.recipe_id\r\n" + 
				"	where a.recipe_id='"+recipe_id+"'";
		
		try {
			conn=ds.getConnection();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {			
				return new RecipeVO()
						.setRecipe_id(rs.getString("recipe_id"))
						.setRecipe_title(rs.getString("recipe_title"))
						.setClass_name(rs.getString("class_name"))
						.setImg_path_01(rs.getString("img_path_01"))
						.setImg_path_02(rs.getString("img_path_02"))
						.setImg_path_03(rs.getString("img_path_03"))
						.setRecipe_level(rs.getString("recipe_level"))
						.setRecipe_stuff(rs.getString("recipe_stuff"))
						.setRecipe_content(rs.getString("recipe_content"))
						.setUser_name(rs.getString("user_name"))
						//.setComment_id(rs.getString("comment_id"))
						.setComment_content(rs.getString("comment_content"))
						.setComment_date(rs.getDate("comment_date"));
					
			}
			else {
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
	
	//전체조회  
	public List<RecipeVO> recipeList() throws Exception{
		
		
		List<RecipeVO> recipelist = new ArrayList<RecipeVO>();
		String sql = "select a.RECIPE_ID, d.CLASS_NAME, c.IMG_MAIN,\r\n" + 
				"	a.RECIPE_TITLE, b.USER_NAME, a.RECIPE_RCM,\r\n" + 
				"    a.RECIPE_GOOD, a.RECIPE_SHOW, a.RECIPE_DATE\r\n" + 
				"    from recipe_info a\r\n" + 
				"    inner join user_info b on a.USER_ID = b.USER_ID\r\n" + 
				"    inner join recipe_image_info c on a.RECIPE_ID = c.RECIPE_ID\r\n" + 
				"    inner join recipe_class_info d on a.CLASS_ID = d.CLASS_ID;";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				RecipeVO listVO= new RecipeVO()
						.setRecipe_id(rs.getString("recipe_id"))
						.setClass_name(rs.getString("class_name"))
						.setImg_main(rs.getString("img_main"))
						.setRecipe_title(rs.getString("recipe_title"))
						.setUser_name(rs.getString("user_name"))
						.setRecipe_rcm(rs.getInt("recipe_rcm"))
						.setRecipe_good(rs.getInt("recipe_good"))
						.setRecipe_show(rs.getString("recipe_show"))
						.setRecipe_date(rs.getDate("recipe_date"));
				recipelist.add(listVO);
			}
		}catch (Exception e) {
			throw e;
		}finally {
			try {if (rs != null) rs.close();} catch(Exception e) {}
		    try {if (pstmt != null) pstmt.close();} catch(Exception e) {}
		    try {if (conn != null) conn.close();} catch(Exception e) {}
		}
		return recipelist;
	}
	//레시피 댓글조회
	public List<RecipeVO> commentList() throws Exception{
		
		List<RecipeVO> reci_comment = new ArrayList<RecipeVO>();
		String sql = "select b.user_name, a.comment_content, a.COMMENT_DATE \r\n" + 
				"	from recipe_reply a\r\n" + 
				"    inner join user_info b on a.USER_ID=b.USER_ID;";
		
		try {
			conn=ds.getConnection();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				RecipeVO vo = new RecipeVO()
						.setUser_name(rs.getString("user_name"))
						.setComment_content(rs.getString("comment_content"))
						.setComment_date(rs.getDate("comment_date"));
				reci_comment.add(vo);
			}
		}catch (Exception e) {
			throw e;
		}finally {
			try {if (rs != null) rs.close();} catch(Exception e) {}
		    try {if (pstmt != null) pstmt.close();} catch(Exception e) {}
		    try {if (conn != null) conn.close();} catch(Exception e) {}
		}
		return reci_comment;
	}
	//레시피 댓글 등록
//	public int commentInsert(RecipeVO vo) throws Exception{
//		int res;
//		String maxId ="select max(recipe_id)as maxId from recipe_info";
//		String sql = "insert into ";
//		try {
//			conn=ds.getConnection();
//			pstmt=conn.prepareStatement(sql);
//		}catch (Exception e) {
//			throw e;
//		}finally {
//			
//		}
//		return null;
//	}
}
