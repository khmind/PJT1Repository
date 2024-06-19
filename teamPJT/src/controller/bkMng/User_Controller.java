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
		
		
		//UserVO user = (UserVO) userDAO.selectList();	
		String retrunValue = "";
		
		if (flag.equals("list")) {
		
			UserVO user = (UserVO)model.get("user");
	
			model.put("userlist", userDAO.selectList(user));
			
			retrunValue = "bk_user.jsp";
			
		}
		return retrunValue;
	}

}
