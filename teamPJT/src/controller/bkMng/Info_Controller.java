package controller.bkMng;

import java.util.Map;

import javax.servlet.http.HttpSession;

import controller.Controller;
import dao.bkMng.InfoDAO;
import vo.bkMng.InfoVO;

public class Info_Controller implements Controller{

	InfoDAO infoDAO;
	
	
	public Info_Controller setInfoDAO(InfoDAO infoDAO) {
		this.infoDAO = infoDAO;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		System.out.println("=====6");
		if(model.get("adLogin") == null) {
			return "/bkMng/index.html";
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
				return "/bkMng/index.html";
			}
		}
		
	}

}
