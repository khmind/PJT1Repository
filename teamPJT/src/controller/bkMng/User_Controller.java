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
	public String execute(Map<String, Object> model) throws Exception {
		
		
		//UserVO user = (UserVO) userDAO.selectList();
		System.out.println("-------------1");
		
		//String a = sel2
		model.put("userlist", userDAO.selectList());
		return "bk_user.jsp";
	}

}
