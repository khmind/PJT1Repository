package dao.bkMng;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import vo.bkMng.Recipe_listVO;

public class Recipe_listDAO {

	DataSource ds; 

	public void setDs(DataSource ds) {
		this.ds = ds;
	}
	
	//등록 ->dao.bkMng
	//수정 ->dao.bkMng
	//삭제  ->dao.bkMng
	//조회  ->dao.bkMng
	//전체조회  
	public List<Recipe_listVO> recipeList() throws Exception{
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		List<Recipe_listVO> recipelist = new ArrayList<Recipe_listVO>();
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
				Recipe_listVO listVO= new Recipe_listVO()
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
}
