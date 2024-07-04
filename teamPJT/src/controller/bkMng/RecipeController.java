package controller.bkMng;

import java.util.Map;

import javax.servlet.http.HttpSession;

import controller.Controller;
import dao.bkMng.CategoryDAO;
import dao.bkMng.InfoDAO;
import dao.bkMng.RecipeDAO;
import vo.bkMng.InfoVO;
import vo.bkMng.RecipeVO;

public class RecipeController implements Controller{

	RecipeDAO recipeDAO;
	CategoryDAO cateDAO;
	
	public RecipeController setRecipeDAO(RecipeDAO recipeDAO,CategoryDAO cateDAO) {
		this.recipeDAO=recipeDAO;
		this.cateDAO=cateDAO;
		return this;
	}
	
	@Override  
	public String execute(String flag, Map<String, Object> model) throws Exception {
		System.out.println("add=================1=====1");
		String returnValue="";
		if(flag.equals("recipe_listFr")|| flag.equals("recipe_listBk")
				|| flag.equals("recipe_listFr1") || flag.equals("recipe_listFr2")) {
			returnValue = recipe_list(flag, model);
		}
		else if(flag.equals("recipe_edit")) {
			returnValue = recipe_update(flag, model);
		} 
		else if(flag.equals("recipe_add")) {
			returnValue = recipe_add(flag,model);
		}
		else if(flag.equals("recipe_delete")){
			returnValue = recipe_delete(flag,model);
		}
		else if(flag.equals("recipe_commnet")){
			returnValue = recipe_commnet(flag,model);
		}
	 	return returnValue;
		
	} 
	private String recipe_commnet(String flag, Map<String, Object> model) {
		model.put("recipe_comment", model);
		return null;
	}
	//삭제
	private String recipe_delete(String flag, Map<String, Object> model) throws Exception {
		String [] no = (String[])model.get("reci");
		recipeDAO.delete(no);
		return "redirect:recipe.do";
	}
	//등록
	private String recipe_add(String flag, Map<String, Object> model) throws Exception {
		System.out.println("add=============3");
		if(model.get("recipe_new") == null) {
			model.put("class_name", recipeDAO.classList());
			return "/view/frMng/fr_recipe_register.jsp";
			
		}
		else {
			
			RecipeVO vo=(RecipeVO)model.get("recipe_new");
			recipeDAO.insert(vo);
			
			
				System.out.println("add=============4");
				return "redirect:recipe.do";
			
			
		}
	}
	
	private String recipe_update(String flag, Map<String, Object> model) throws Exception {
		model.put("navbar", cateDAO.frCateList());
		System.out.println("recipe=============1");
		
		RecipeVO vo=(RecipeVO)model.get("recipe_edit");
		if(vo.getRecipe_title()==null) {
			
			System.out.println("recipe=============1"+vo.getRecipe_title());
			
			String id = vo.getRecipe_id();
			//System.out.println("recipe=============1"+vo.getRecipe_id());
			RecipeVO recipeVO = recipeDAO.detail(id);
			
			//System.out.println("----------------------------");
			model.put("recipe", recipeVO);
			model.put("class_name", recipeDAO.classList());
			return "/view/frMng/fr_recipe_edit.jsp";
		}
		else {
			System.out.println("eeeeeeeeeeeeeeeee");
			System.out.println("eeeeeeeeeeeeeeeee"+vo.getRecipe_title());
			recipeDAO.update(vo);
			return "redirect:recipe.do";
		}
		
	}
	private String recipe_list(String flag, Map<String, Object> model) throws Exception {
		
		System.out.println("888888888888888");
		model.put("navbar", cateDAO.frCateList());
		if(flag.equals("recipe_listFr")) {
			System.out.println("add=============4");
			model.put("recipe_list", recipeDAO.recipeList());
			return "/view/frMng/fr_myRecipe.jsp";
		}
		else if(flag.equals("recipe_listFr1")) {
			model.put("recipe_list1", recipeDAO.recipeList());
			return "/view/frMng/fr_interest_recipe.jsp";
		}
		else if (flag.equals("recipe_listFr2")) {
			model.put("recipe_list2", recipeDAO.recipeList());
			return "/view/frMng/fr_recommend_recipe.jsp";
		}
		else {
			model.put("recipe_list", recipeDAO.recipeList());
			return "bk_recipe.jsp";
		}
		
		
	}

}
