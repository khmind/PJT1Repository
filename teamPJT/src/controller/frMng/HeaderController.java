package controller.frMng;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import controller.Controller;
import dao.bkMng.CategoryDAO;
import vo.bkMng.CategoryVO;


public class HeaderController implements Controller{

	CategoryDAO cateDAO;
	
	public HeaderController setInfoDAO(CategoryDAO cateDAO) {		
		this.cateDAO = cateDAO;
		return this;
	}

	@Override
	public String execute(String flag, Map<String, Object> model) throws Exception {

		String returnValue="";
		
		if(flag.equals("navbar")) {
			returnValue = navbar(flag, model);
		}
		
		return returnValue;
		
	}
	
	
	public String navbar(String flag, Map<String, Object> model) throws Exception{
		
		List<CategoryVO> cvo  = cateDAO.frCateList();
		System.out.println("-------------2");				
		HttpSession session = (HttpSession)model.get("session");			
		session.setAttribute("frCateList", cvo);
		System.out.println("-------------3");			
		return "main.jsp";
		//return null;
		
	}

}
