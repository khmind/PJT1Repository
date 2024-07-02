package controller.frMng;

import java.util.Map;

import controller.Controller;
import dao.bkMng.CategoryDAO;
import dao.frMng.RecipeFrDAO;
import vo.bkMng.RecipeVO;

public class MyPageController implements Controller{
	
	
	CategoryDAO cateDAO;
	RecipeFrDAO recipeFrDAO;
	
	public MyPageController setDAO(CategoryDAO cateDAO) {		
		this.cateDAO = cateDAO;
		this.recipeFrDAO = recipeFrDAO;
		return this;
	}	

	@Override
	public String execute(String flag, Map<String, Object> model) throws Exception {
		// TODO Auto-generated method stub
		//return null;
		
		
		model.put("navbar", cateDAO.frCateList());
		return "frMng/fr_user_info.jsp";
		
	}

}
