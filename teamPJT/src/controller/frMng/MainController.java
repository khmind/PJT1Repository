package controller.frMng;

import java.util.List;
import java.util.Map;


import controller.Controller;
import dao.bkMng.CategoryDAO;
import dao.frMng.RecipeFrDAO;
import vo.bkMng.CategoryVO;
import vo.bkMng.RecipeVO;

public class MainController implements Controller{
	
	//HeaderController hc = new HeaderController();

	CategoryDAO cateDAO;
	RecipeFrDAO recipeFrDAO;
	
	public MainController setInfoDAO(CategoryDAO cateDAO, RecipeFrDAO recipeFrDAO) {		
		this.cateDAO = cateDAO;
		this.recipeFrDAO = recipeFrDAO;
		return this;
	}

	@Override
	public String execute(String flag, Map<String, Object> model) throws Exception {
		
		String returnValue="";
				
		if(flag.equals("main")) {		
			System.out.println("-------------2");
			returnValue = navbar(flag, model);
		}
		
		return returnValue;
		
	}
	
	
	public String navbar(String flag, Map<String, Object> model) throws Exception{
		
		List<CategoryVO> cvo  = cateDAO.frCateList();		
		List<RecipeVO> randomVo = recipeFrDAO.recipeRandom();
				
		model.put("navbar", cvo);
		model.put("random", randomVo);	
		System.out.println("-------------5");
		
	    return "frMng/main.jsp";
	    //return "/view/frMng/main2.jsp";
		
	}

}
