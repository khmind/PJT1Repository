package controller.frMng;

import java.util.Map;

import controller.Controller;
import dao.bkMng.CategoryDAO;

public class MyPageController implements Controller{
	
	CategoryDAO cateDAO;	
	
	public MyPageController setDAO(CategoryDAO cateDAO) {		
		this.cateDAO = cateDAO;		
		return this;
	}	

	@Override
	public String execute(String flag, Map<String, Object> model) throws Exception {
		
		model.put("navbar", cateDAO.frCateList());
		return "frMng/fr_user_info.jsp";
		
	}

}
