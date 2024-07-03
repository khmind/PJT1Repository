package controller.frMng;

import java.util.Map;

import controller.Controller;
import dao.bkMng.CategoryDAO;
import dao.bkMng.UserDAO;
import dao.frMng.UserInfoDAO;
import vo.bkMng.UserVO;

public class UserInfoController implements Controller{
	
	UserInfoDAO userinfoDAO;
	CategoryDAO cateDAO;	
	
	public UserInfoController setDAO(CategoryDAO cateDAO, UserInfoDAO userinfoDAO) {
		this.userinfoDAO = userinfoDAO;
		this.cateDAO = cateDAO;
		return this;
	}

	@Override
	public String execute(String flag, Map<String, Object> model) throws Exception {		
		
		String retrunValue = "";
		
		retrunValue = getUserInfo(flag, model);
		
		return retrunValue;
		
	}
	
	public String getUserInfo(String flag, Map<String, Object> model) throws Exception {
		
		model.put("navbar", cateDAO.frCateList());
		
		return "frMng/fr_user_info.jsp";
		
	}
	
		
	/*
	 * public String modify(String flag, Map<String, Object> model) throws Exception
	 * {
	 * 
	 * 
	 * }
	 */
		
}
