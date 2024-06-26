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
	 	return returnValue;
		
	} 
	//삭제
	private String recipe_delete(String flag, Map<String, Object> model) {
		// TODO Auto-generated method stub
		return null;
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
			System.out.println("recipe=============1"+vo.getRecipe_id());
			model.put("recipe", recipeDAO.detail(id));
			return "/view/frMng/fr_recipe_edit.jsp";
		}
		
		return "redirect:recipe.do";
	}
	private String recipe_list(String flag, Map<String, Object> model) throws Exception {
		model.put("recipe_list", recipeDAO.recipeList());
		return "bk_recipe.jsp";
	}

}
