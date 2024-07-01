package dao.frMng;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import vo.bkMng.RecipeVO;

public class RecipeFrDAO {

	DataSource ds; 
	Connection conn = null;
	PreparedStatement pstmt = null;	
	ResultSet rs =null;
	
	public void setDs(DataSource ds) {
		this.ds = ds;
	}	
	
	//랜덤 조회  
	public List<RecipeVO> recipeRandom() throws Exception{
		
		String imgPath = "../view/assets/images/";		
		List<RecipeVO> recipeRand = new ArrayList<RecipeVO>();
		
		String sql = 	" select a.RECIPE_ID, \n" + 
						" case b.IMG_MAIN  \n" + 
						" when 'PATH01' then IMG_PATH_01  \n" + 
						" when 'PATH02' then IMG_PATH_02  \n" + 
						" when 'PATH03' then IMG_PATH_03  \n" + 
						" end as IMG_MAIN  \n" + 
						" from recipe_info a  \n" + 
						" inner join recipe_image_info b on a.RECIPE_ID = b.RECIPE_ID  \n" + 
						" order by rand() limit 5  \n" 
						;
		
		try {
			
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				RecipeVO listVO= new RecipeVO()
						.setRecipe_id(rs.getString("recipe_id"))
						.setImg_main(imgPath + rs.getString("img_main"));
				
				recipeRand.add(listVO);
				
			}
			
		}catch (Exception e) {
			throw e;
		}finally {
			try {if (rs != null) rs.close();} catch(Exception e) {}
		    try {if (pstmt != null) pstmt.close();} catch(Exception e) {}
		    try {if (conn != null) conn.close();} catch(Exception e) {}
		}
		
		return recipeRand;
	}	
	
	
	//랜덤 조회  
	public List<RecipeVO> searchAll(int startrow) throws Exception{
		
		List<RecipeVO> recipeRand = new ArrayList<RecipeVO>();
		int limit=4;		
		String imgPath = "../view/assets/images/";
		
		String sql = 	" select a.RECIPE_ID, a.RECIPE_TITLE, \n" + 
						" case b.IMG_MAIN \n" + 
						" when 'PATH01' then IMG_PATH_01 \n" + 
						" when 'PATH02' then IMG_PATH_02 \n" + 
						" when 'PATH03' then IMG_PATH_03 \n" + 
						" end as main \n" + 
						" from recipe_info a \n" + 
						" inner join recipe_image_info b on a.RECIPE_ID = b.RECIPE_ID \n" + 
						" where 1=1 \n" + 
						//" and a.RECIPE_TITLE like '%?%' \n" + 
						//" and CLASS_ID = 'C002' \n" + 
						" ORDER BY a.RECIPE_DATE \n" +
						" limit ?, ?" 
						;
		
		try {
			
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,startrow);
			pstmt.setInt(2, limit);			
			rs = pstmt.executeQuery();
			
			System.out.println(" sql : " + sql);
			
			while(rs.next()) {
				
				System.out.println(" -----------01 " + rs.getString("recipe_id"));
				System.out.println(" -----------02 " + rs.getString("recipe_title"));
				System.out.println(" -----------03 " + imgPath + rs.getString("main"));
				
				RecipeVO listVO= new RecipeVO()
						.setRecipe_id(rs.getString("recipe_id"))
						.setRecipe_title(rs.getString("recipe_title"))
						.setImg_main(imgPath + rs.getString("main"));
				
				recipeRand.add(listVO);
				
			}
			
		}catch (Exception e) {
			throw e;
		}finally {
			try {if (rs != null) rs.close();} catch(Exception e) {}
		    try {if (pstmt != null) pstmt.close();} catch(Exception e) {}
		    try {if (conn != null) conn.close();} catch(Exception e) {}
		}
		
		return recipeRand;
	}	
	
}
