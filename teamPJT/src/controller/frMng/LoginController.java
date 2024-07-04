package controller.frMng;

import java.util.Map;

import javax.servlet.http.HttpSession;

import controller.Controller;
import dao.bkMng.CategoryDAO;
import dao.bkMng.InfoDAO;
import vo.bkMng.InfoVO;

public class LoginController implements Controller{

	InfoDAO loginDAO;
	CategoryDAO cateDAO;
	
	public LoginController setLoginDAO(InfoDAO loginDAO ,CategoryDAO cateDAO) {
		this.loginDAO = loginDAO;
		this.cateDAO=cateDAO;
		return this;
	}

	@Override
	public String execute(String flag, Map<String, Object> model) throws Exception {
		
		String returnValue="";
		if(flag.equals("login")) {
			returnValue = login(flag, model);
		}
		return returnValue;
		
	}

	private String login(String flag, Map<String, Object> model) throws Exception {
		
		model.put("navbar", cateDAO.frCateList());
		InfoVO vo=(InfoVO)model.get("log");
		InfoVO ivo=loginDAO.exist(vo.getUser_email(), vo.getUser_pw());
		if(ivo !=null) { 
			HttpSession session = (HttpSession)model.get("session");
			session.setAttribute("loginVO", ivo);
		}

		return "main.to";
	}

}
