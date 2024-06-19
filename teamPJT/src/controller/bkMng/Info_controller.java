package controller.bkMng;

import java.util.Map;

import javax.servlet.http.HttpSession;

import controller.Controller;
import dao.bkMng.InfoDAO;
import vo.bkMng.InfoVO;

public class Info_controller implements Controller{

	InfoDAO infoDAO;
	
	
	public Info_controller setInfoDAO(InfoDAO infoDAO) {
		this.infoDAO = infoDAO;
		return this;
	}

	@Override
	public String execute(String flag, Map<String, Object> model) throws Exception {
				
		if(model.get("adLogin") == null) {
			return "index.html";
		}
		else {
			InfoVO adLogin = (InfoVO)model.get("adLogin");
			InfoVO vo = infoDAO.exist(adLogin.getUser_email(), adLogin.getUser_pw());
			
			if(vo != null) {
				HttpSession session = (HttpSession)model.get("session");
				session.setAttribute("infoVO", vo);
				
				return "/view/bkMng/bk_announcement.html";
			}
			else {
				return "index.html";
			}
		}
		
	}

}
