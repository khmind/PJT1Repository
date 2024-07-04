package controller.frMng;


import java.util.List;
import java.util.Map;

import controller.Controller;
import dao.bkMng.CategoryDAO;
import dao.bkMng.RecipeDAO;
import dao.frMng.RecipeFrDAO;
import vo.bkMng.CategoryVO;
import vo.bkMng.RecipeVO;
import vo.bkMng.UserVO;

public class RecipeSearchController implements Controller{
	
	CategoryDAO cateDAO;
	RecipeFrDAO recipeFrDAO;
	RecipeDAO recipeDAO;
	
	public RecipeSearchController setDAO(CategoryDAO cateDAO, RecipeFrDAO recipeFrDAO, RecipeDAO recipeDAO) {		
		this.cateDAO = cateDAO;
		this.recipeFrDAO = recipeFrDAO;
		this.recipeDAO=recipeDAO;
		return this;
	}

	@Override
	public String execute(String flag, Map<String, Object> model) throws Exception {

		String returnValue="";
		
		if(flag.equals("search")) {
			returnValue = searchAll(flag, model);
		}
		else if(flag.equals("detail")) {
			returnValue=recipeDetail(flag,model);
		}
		else if(flag.equals("update")) {
			returnValue=recipeUpdate(flag,model);
		}
		else if(flag.equals("recipe_add")) {
			returnValue = recipe_add(flag,model);
		}
		return returnValue;
		
	}
	
	private String recipe_add(String flag, Map<String, Object> model) throws Exception {
		model.put("navbar", cateDAO.frCateList());
		if(model.get("recipe_new") == null) {
			model.put("class_name", recipeDAO.classList());
			//model.put("navbar", cateDAO.frCateList());
			return "/view/frMng/fr_recipe_register.jsp";
			
		}
		else {
			System.out.println("add=============4");
			RecipeVO vo=(RecipeVO)model.get("recipe_new");
			recipeDAO.insert(vo);
			//model.put("navbar", cateDAO.frCateList());
			return "redirect:recipeDetail.to";
		}
	}

	private String recipeUpdate(String flag, Map<String, Object> model) throws Exception {
		model.put("navbar", cateDAO.frCateList());
		System.out.println("fr================1");
		RecipeVO vo=(RecipeVO)model.get("recipeUpdate");
		System.out.println("fr================2"+vo.getRecipe_title());
		if(vo.getRecipe_title()==null) {
			
			
			String id = vo.getRecipe_id();
			RecipeVO recipeVO = recipeDAO.detail(id);
			
			model.put("recipe", recipeVO);
			model.put("class_name", recipeDAO.classList());
			return "/view/frMng/fr_recipe_edit.jsp";
		}
		else {
			
			recipeDAO.update(vo);
			return "redirect:recipeDetail.to";
		}
	}

	private String recipeDetail(String flag, Map<String, Object> model) throws Exception {
		model.put("navbar", cateDAO.frCateList());
		RecipeVO vo = (RecipeVO)model.get("recipe_detail");
		if(vo.getRecipe_title()==null) {
			String id=vo.getRecipe_id();
			RecipeVO reVO=(RecipeVO)recipeDAO.detail(id);
			model.put("recipeD", reVO);
			model.put("classN", recipeDAO.classList());
		}
		return "/view/frMng/fr_recipe_detail.jsp";
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
		model.put("class_name", recipeDAO.classList());
		model.put("recipeSearch1", recipeFrDAO.searchAll(1, recipeVo1));	
		model.put("recipeSearch2", recipeFrDAO.searchAll(2, recipeVo1));
		
	    return "frMng/fr_recipelist.jsp";
		
	}	

}
