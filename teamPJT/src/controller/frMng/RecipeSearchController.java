package controller.frMng;


import java.util.List;
import java.util.Map;

import controller.Controller;
import dao.bkMng.CategoryDAO;
import dao.frMng.RecipeFrDAO;
import vo.bkMng.CategoryVO;
import vo.bkMng.RecipeVO;
import vo.bkMng.UserVO;

public class RecipeSearchController implements Controller{
	
	CategoryDAO cateDAO;
	RecipeFrDAO recipeFrDAO;
	
	public RecipeSearchController setDAO(CategoryDAO cateDAO, RecipeFrDAO recipeFrDAO) {		
		this.cateDAO = cateDAO;
		this.recipeFrDAO = recipeFrDAO;
		return this;
	}

	@Override
	public String execute(String flag, Map<String, Object> model) throws Exception {

		String returnValue="";
		
		if(flag.equals("search")) {
			returnValue = searchAll(flag, model);
		}
		
		return returnValue;
		
	}
	
	public String searchAll(String flag, Map<String, Object> model) throws Exception{
		
		RecipeVO recipeVo = (RecipeVO)model.get("PageInfo");
		RecipeVO recipeVo1 = recipeFrDAO.searchAllCnt(recipeVo);
		/*
		System.out.println("@@ getSel1   : " + recipeVo1.getSel1());
		System.out.println("@@ getSearchText   : " + recipeVo1.getSearchText());
		System.out.println("@@ getPage   : " + recipeVo1.getPage());
		System.out.println("@@ getStartPage   : " + recipeVo1.getStartPage());
		System.out.println("@@ getEndPage   : " + recipeVo1.getEndPage());
		System.out.println("@@ getLimit   : " + recipeVo1.getLimit());
		System.out.println("@@ getOrderby   : " + recipeVo1.getOrderby());
		System.out.println("@@ getClass_id   : " + recipeVo1.getClass_id());
		*/		
		model.put("PageInfo", recipeVo1);
		model.put("navbar", cateDAO.frCateList());
		model.put("recipeSearch1", recipeFrDAO.searchAll(1, recipeVo1));	
		model.put("recipeSearch2", recipeFrDAO.searchAll(2, recipeVo1));
		
	    return "frMng/fr_recipelist.jsp";
		
	}	

}
