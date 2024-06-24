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
		
		System.out.println("## flag : " + flag);
	
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
		
		//System.out.println("userlistcount a: " + user1.getSel1() + ", b : " + user1.getSel2() + ", c : " + user1.getSearchText());		
		//System.out.println( "userlistcount startP : " + user1.getStartPage()+ ", endP :" + user1.getEndPage());
		
		return "bk_user.jsp";
		
	}
		
	public String modify(String flag, Map<String, Object> model) throws Exception {
		
		UserVO user = (UserVO)model.get("modify");
				
		if ( user.getUser_email() == null) {
			
			model.put("getUser", userDAO.getUser(user.getUser_id()));		
			return "bk_user_modify.jsp";
			
		}else {
			
			userDAO.update(user);
			return "user.do";
			
		}
		
	}	
		
}
