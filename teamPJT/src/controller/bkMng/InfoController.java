package controller.bkMng;

import java.util.Map;

import javax.servlet.http.HttpSession;

import controller.Controller;
import dao.bkMng.InfoDAO;
import vo.bkMng.InfoVO;

public class InfoController implements Controller{

	InfoDAO infoDAO;
	
	
	public InfoController setInfoDAO(InfoDAO infoDAO) {
		this.infoDAO = infoDAO;
		return this;
	}

	@Override
	public String execute(String flag, Map<String, Object> model) throws Exception {
				
		System.out.println("-------------5");
		String returnValue="";
		if(flag.equals("login")) {
			returnValue = login(flag, model);
		}
		return returnValue;
		
	}
	
	public String login(String flag, Map<String, Object> model) throws Exception{
		if(model.get("adLogin") == null) {
			return "index.html";
		}
		else {
			InfoVO adLogin = (InfoVO)model.get("adLogin");
			InfoVO vo = infoDAO.exist(adLogin.getUser_email(), adLogin.getUser_pw());
			if(vo != null) {
				
				System.out.println(" id : " + vo.getUser_id());
				System.out.println(" name : " + vo.getUser_name());
				
				HttpSession session = (HttpSession)model.get("session");
				session.setAttribute("infoVO", vo);
				return "notice.do";
			}
			else {
				return "index.html";
			}
		}
	}

}
