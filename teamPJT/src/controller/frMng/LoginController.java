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
		}else if(flag.equals("logAdd")) {
			returnValue= add(flag,model);
		}
		
		return returnValue;
		
	}
	private String add(String flag, Map<String, Object> model) throws Exception {
		if(model.get("add") != null) {
			System.out.println("add====4");
			InfoVO vo =(InfoVO)model.get("add");
			loginDAO.insert(vo);
			System.out.println("add====5");
			return "main.to";
		}
		return "main.to";
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
