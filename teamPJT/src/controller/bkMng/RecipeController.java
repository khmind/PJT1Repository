package controller.bkMng;

import java.util.Map;

import controller.Controller;
import dao.bkMng.RecipeDAO;
import vo.bkMng.RecipeVO;

public class RecipeController implements Controller{

	RecipeDAO recipeDAO;
	
	public RecipeController setRecipeDAO(RecipeDAO recipeDAO) {
		this.recipeDAO=recipeDAO;
		return this;
	}
	
	@Override  
	public String execute(String flag, Map<String, Object> model) throws Exception {
		System.out.println("add=================1=====1");
		String returnValue="";
		if(flag.equals("recipe_list")) {
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
			System.out.println("add=============4");
			RecipeVO vo=(RecipeVO)model.get("recipe_new");
			recipeDAO.insert(vo);
			return "redirect:recipe.do";
		}
	}
	
	private String recipe_update(String flag, Map<String, Object> model) throws Exception {
		
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
		model.put("recipe_list", recipeDAO.recipeList());
		return "bk_recipe.jsp";
	}

}
