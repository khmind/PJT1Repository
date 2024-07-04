package controller.frMng;

import java.util.Map;

import javax.servlet.http.HttpSession;

import controller.Controller;

public class LogOutFrController implements Controller{

	@Override
	public String execute(String flag, Map<String, Object> model) throws Exception {

		HttpSession session = (HttpSession)model.get("session");
		session.invalidate();
		
		return "main.to";		
		
	}

}
