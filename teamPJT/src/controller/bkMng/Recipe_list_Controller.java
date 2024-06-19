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
		
		model.put("recipe_list", listDAO.recipeList());
		return "bk_recipe.jsp";
	}

}
