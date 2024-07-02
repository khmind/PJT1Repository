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
	
	String imgPath = "../view/assets/images/";
	//String imgPath = "../view/frMng/images/";
	
	public void setDs(DataSource ds) {
		this.ds = ds;
	}	
	
	//랜덤 조회  
	public List<RecipeVO> recipeRandom() throws Exception{
			
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
	

	//레시피 검색 cnt
	public RecipeVO searchAllCnt(RecipeVO recipeVo) throws Exception{
		
		String where = "" ;
		
		int page= recipeVo.getPage();
		int total = 0;
		int limit = 8;		
		
		int startPage = (((int) ((double)page / limit + 0.9)) - 1) * limit + 1;
		int endPage = startPage+limit;
		
		if ( recipeVo.getClass_id() != null &&  recipeVo.getClass_id()!= "") {
			where = " and CLASS_ID = '" + recipeVo.getClass_id() + "' \n";
		}		
		
		if ( recipeVo.getSearchText() != null &&  recipeVo.getSearchText()!= "") {				
			where = " and a.RECIPE_TITLE like '%" + recipeVo.getSearchText() +"%' \n";
		}		
		
		String sqlCnt = 	" select count(a.RECIPE_ID) \n" +
						" from recipe_info a \n" + 
						" inner join recipe_image_info b on a.RECIPE_ID = b.RECIPE_ID \n" + 
						" where 1=1 \n" + 
						where 
						;
		
		try {
			
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sqlCnt);			
			rs = pstmt.executeQuery();			
			
			if (rs.next())
				total = rs.getInt(1);
			
			int maxPage=(int)((double)total/limit+0.95);
			
			if (endPage> maxPage) endPage= maxPage;
			if (startPage == endPage )startPage = 1;
			
			return new RecipeVO()
					.setSel1(recipeVo.getSel1())
					.setSearchText(recipeVo.getSearchText() )
					.setPage(page)
					.setStartPage(startPage)
					.setEndPage(endPage)
					.setLimit(limit) 
					.setOrderby(recipeVo.getOrderby() )
					.setClass_id(recipeVo.getClass_id())
					;					
			
		}catch (Exception e) {
			throw e;
		}finally {
			try {if (rs != null) rs.close();} catch(Exception e) {}
		    try {if (pstmt != null) pstmt.close();} catch(Exception e) {}
		    try {if (conn != null) conn.close();} catch(Exception e) {}
		}	
		
	}		
	
	
	//레시피 검색 
	public List<RecipeVO> searchAll(int strow, RecipeVO recipeVo) throws Exception{
		
		List<RecipeVO> recipeSearch = new ArrayList<RecipeVO>();
		
		String where = "" ;		
		String order = "";
		
		int page= recipeVo.getPage();
		int pageTemp = 0;
		int contentCnt = 8;
		int limit = 4;
		
		int startrow=(page-1)*contentCnt;
		
		System.out.println( " @@@@ page 1 : " + page + ", startrow : " + startrow);
		
		if ( strow == 1 ) { 
			pageTemp = (startrow);			
		}else {			
			pageTemp = startrow + limit ;
		}
		
		startrow = pageTemp;
		
		System.out.println(" ##--------- pageTemp : " + pageTemp + ", startrow : " + startrow);
		
		if ( recipeVo.getClass_id() != null &&  recipeVo.getClass_id()!= "") {
			where = " and CLASS_ID = '" + recipeVo.getClass_id() + "' \n";
		}
		
		
		if ( recipeVo.getSearchText() != null &&  recipeVo.getSearchText()!= "") {				
			where += " and a.RECIPE_TITLE like '%" + recipeVo.getSearchText() +"%' \n";
		}
		
		
		if ( recipeVo.getOrderby() != null &&  recipeVo.getOrderby()!= "") {		
			
			if ( recipeVo.getOrderby().contentEquals("recipe_date") ) {
				
				order = "ORDER BY a.RECIPE_DATE DESC  \n"; //최신순
				
			}else if ( recipeVo.getOrderby().contentEquals("recipe_rcm") ) {
				
				order = "ORDER BY A.RECIPE_RCM DESC \n"; //추천순
			
			}else if ( recipeVo.getOrderby().contentEquals("recipe_good") ) {
				
				order = "ORDER BY A.RECIPE_GOOD DESC \n"; //관심순
				
			}else if ( recipeVo.getOrderby().contentEquals("recipe_level") ) {
				
				order = "ORDER BY A.RECIPE_LEVEL ASC \n"; //난이도순
				
			}else { 
				
				order = "ORDER BY a.RECIPE_DATE DESC \n";
				
			}
			
		}
		
		


		String sql = 	" select a.RECIPE_ID, a.RECIPE_TITLE, \n" + 
						" case b.IMG_MAIN \n" + 
						" when 'PATH01' then IMG_PATH_01 \n" + 
						" when 'PATH02' then IMG_PATH_02 \n" + 
						" when 'PATH03' then IMG_PATH_03 \n" + 
						" end as main \n" + 
						" from recipe_info a \n" + 
						" inner join recipe_image_info b on a.RECIPE_ID = b.RECIPE_ID \n" + 
						" where 1=1 \n" + 
						where +
						order +
						" limit ?, ?" 
						;
		
		try {
			
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startrow);
			pstmt.setInt(2, limit);			
			rs = pstmt.executeQuery();
			
			System.out.println(" sql : " + sql);
			
			while(rs.next()) {
				
				RecipeVO listVO= new RecipeVO()
						.setRecipe_id(rs.getString("recipe_id"))
						.setRecipe_title(rs.getString("recipe_title"))
						.setImg_main(imgPath + rs.getString("main"));
				
				recipeSearch.add(listVO);
				
			}
			
		}catch (Exception e) {
			throw e;
		}finally {
			try {if (rs != null) rs.close();} catch(Exception e) {}
		    try {if (pstmt != null) pstmt.close();} catch(Exception e) {}
		    try {if (conn != null) conn.close();} catch(Exception e) {}
		}
		
		return recipeSearch;
	}	
	
}
