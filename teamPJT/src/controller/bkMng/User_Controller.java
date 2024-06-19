package controller.bkMng;

import java.util.Map;

import controller.Controller;
import dao.bkMng.UserDAO;
import vo.bkMng.UserVO;

public class User_Controller implements Controller{
	
	UserDAO userDAO;
	
	public User_Controller setDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
		return this;
	}
	

	@Override
	public String execute(String flag, Map<String, Object> model) throws Exception {
		
		String retrunValue = "";
	
		if (flag.equals("list")) {
		
			retrunValue = list(flag, model);
			
		}else if (flag.equals("getOne")) {
			
			retrunValue = getOne(flag, model);
			
		}else if (flag.equals("modify")) {
			
			retrunValue = modify(flag, model);
			
		}else if (flag.equals("del")) {
			
			retrunValue = del(flag, model);
		}
		
		return retrunValue;
		
	}
	
	
	
	public String list(String flag, Map<String, Object> model) throws Exception {
		
		UserVO user = (UserVO)model.get("user");	
		model.put("userlist", userDAO.selectList(user));
		
		return "bk_user.jsp";
		
	}
	
	public String getOne(String flag, Map<String, Object> model) throws Exception {
		
		return null;
		
	}
	
	
	public String modify(String flag, Map<String, Object> model) throws Exception {
		
		return null;
		
	}	
	
	public String del(String flag, Map<String, Object> model) throws Exception {
		
		return null;
		
	}		

	
}
