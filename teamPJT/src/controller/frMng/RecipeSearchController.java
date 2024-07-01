package controller.frMng;

import java.util.List;
import java.util.Map;

import controller.Controller;
import dao.bkMng.CategoryDAO;
import dao.frMng.RecipeFrDAO;
import vo.bkMng.CategoryVO;
import vo.bkMng.RecipeVO;

public class RecipeSearchController implements Controller{
	
	CategoryDAO cateDAO;
	RecipeFrDAO recipeFrDAO;
	
	public RecipeSearchController setInfoDAO(CategoryDAO cateDAO, RecipeFrDAO recipeFrDAO) {		
		this.cateDAO = cateDAO;
		this.recipeFrDAO = recipeFrDAO;
		return this;
	}

	@Override
	public String execute(String flag, Map<String, Object> model) throws Exception {

		String returnValue="";
		
		if(flag.equals("searchAll")) {		
			System.out.println("-------------2");
			returnValue = searchAll(flag, model);
		}
		
		return returnValue;
		
	}
	
	public String searchAll(String flag, Map<String, Object> model) throws Exception{
		
		List<CategoryVO> cvo  = cateDAO.frCateList();		
		//List<RecipeVO> searchVo = recipeFrDAO.searchAll(1);
				
		model.put("navbar", cvo);
		model.put("recipeSearch1", recipeFrDAO.searchAll(1));	
		model.put("recipeSearch2", recipeFrDAO.searchAll(5));
		System.out.println("-------------5");
		
	    return "frMng/fr_recipelist_all.jsp";
		
	}	

}
