package controller.frMng;

import java.util.Map;

import controller.Controller;

public class MyPageController implements Controller{
	
	public MyPageController () {		
		return;
	}	

	@Override
	public String execute(String flag, Map<String, Object> model) throws Exception {
		
		return "userInfo.to";
		
	}

}
