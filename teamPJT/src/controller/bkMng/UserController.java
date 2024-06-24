package controller.bkMng;

import java.util.Map;

import controller.Controller;
import dao.bkMng.UserDAO;
import vo.bkMng.UserVO;

public class UserController implements Controller{
	
	UserDAO userDAO;
	
	public UserController setDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
		return this;
	}

	@Override
	public String execute(String flag, Map<String, Object> model) throws Exception {		
		
		String retrunValue = "";
	
		if (flag.equals("list")) {
		
			retrunValue = list(flag, model);
			
		}else if (flag.equals("modify")) {
			
			retrunValue = modify(flag, model);
		}
		
		return retrunValue;
		
	}
	
	public String list(String flag, Map<String, Object> model) throws Exception {
		
		UserVO user = (UserVO)model.get("PageInfo");		
		UserVO user1 = userDAO.selectListCnt(user);
		
		model.put("PageInfo", user1);
		model.put("userlist", userDAO.selectList(user1));
		
		if (user.getMethodFlag().equals("G")) {		
			return "bk_user.jsp";
		}else {
			return "bk_maneger.jsp";
		}
		
	}
		
	public String modify(String flag, Map<String, Object> model) throws Exception {
		
		UserVO user = (UserVO)model.get("modify");
				
		if ( user.getUser_email() == null) {
			
			model.put("getUser", userDAO.getUser(user.getUser_id()));		
			
			if (user.getMethodFlag().equals("G")) {		
				return "bk_user_modify.jsp";
			}else {
				return "bk_maneger_modify.jsp";
			}			
			
		}else {
			
			userDAO.update(user);
			
			if (user.getMethodFlag().equals("G")) {
				return "user.do";
			}else {
				return "maneger.do";
			}
			
		}
		
	}	
		
}
