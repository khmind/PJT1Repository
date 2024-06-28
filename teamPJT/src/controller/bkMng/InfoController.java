package controller.bkMng;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import controller.Controller;
import dao.bkMng.CategoryDAO;
import dao.bkMng.InfoDAO;
import vo.bkMng.CategoryVO;
import vo.bkMng.InfoVO;

public class InfoController implements Controller{

	InfoDAO infoDAO;
	CategoryDAO cateDAO;
	
	
	public InfoController setInfoDAO(InfoDAO infoDAO, CategoryDAO cateDAO) {
		this.infoDAO = infoDAO;
		this.cateDAO = cateDAO;
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
	
	public String login(String flag, Map<String, Object> model) throws Exception{
		
		if(model.get("adLogin") == null) {
			
			return "index.html";
			
		}
		else {
			
			InfoVO adLogin = (InfoVO)model.get("adLogin");
			InfoVO vo = infoDAO.exist(adLogin.getUser_email(), adLogin.getUser_pw());
			
			List<CategoryVO> cvo  = cateDAO.bkCateList();
			
			if(vo != null && vo.getUser_role().equals("A")) { 
				
				System.out.println(" id : " + vo.getUser_id());
				System.out.println(" name : " + vo.getUser_name());
				System.out.println(" name : " + vo.getUser_role());
				
				
					
					HttpSession session = (HttpSession)model.get("session");
					session.setAttribute("infoVO", vo);
					session.setAttribute("bkCateList", cvo);
					
				
				return "notice.do";
			}
			else {
				return "index.html";
			}
			
		}
	}

}
