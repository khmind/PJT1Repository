package controller.bkMng;

import java.util.Map;

import controller.Controller;
import dao.bkMng.Recipe_listDAO;

public class Recipe_list_Controller implements Controller{

	Recipe_listDAO listDAO;
	public Recipe_list_Controller setRecipeListDAO(Recipe_listDAO listDAO) {
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
	private String recipe_update(String flag, Map<String, Object> model) {
		
		return null;
	}
	private String recipe_list(String flag, Map<String, Object> model) throws Exception {
		model.put("recipe_list", listDAO.recipeList());
		return "bk_recipe.jsp";
	}

}
