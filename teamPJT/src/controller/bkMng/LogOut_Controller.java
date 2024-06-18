package controller.bkMng;

import java.util.Map;

import javax.servlet.http.HttpSession;

import controller.Controller;

public class LogOut_Controller implements Controller{

	@Override
	public String execute(Map<String, Object> model) throws Exception {

		HttpSession session = (HttpSession)model.get("session");
		session.invalidate();
		
		return "login.do";
		
	}

}
