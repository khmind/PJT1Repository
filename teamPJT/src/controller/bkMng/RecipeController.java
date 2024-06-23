package controller.bkMng;

import java.util.Map;

import controller.Controller;
import dao.bkMng.RecipeDAO;
import vo.bkMng.RecipeVO;

public class RecipeController implements Controller{

	RecipeDAO listDAO;
	public RecipeController setRecipeListDAO(RecipeDAO listDAO) {
		this.listDAO=listDAO;
		return this;
	}
	@Override 
	public String execute(String flag, Map<String, Object> model) throws Exception {
		
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
	private String recipe_delete(String flag, Map<String, Object> model) {
		// TODO Auto-generated method stub
		return null;
	}
	private String recipe_add(String flag, Map<String, Object> model) {
		// TODO Auto-generated method stub
		return null;
	}
	private String recipe_update(String flag, Map<String, Object> model) throws Exception {
		
		RecipeVO vo=(RecipeVO)model.get("recipe_edit");
		if(vo.getRecipe_title()==null) {
			String id = vo.getRecipe_id();
			model.put("recipe", listDAO.detail(id));
			return "fr_recipe_edit.jsp";
		}
		
		return "redirect:recipe.do";
	}
	private String recipe_list(String flag, Map<String, Object> model) throws Exception {
		model.put("recipe_list", listDAO.recipeList());
		return "bk_recipe.jsp";
	}

}
