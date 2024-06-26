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
		//System.out.println("-------------2");
		String returnValue="";
				
		if(flag.equals("navbar")) {		
			System.out.println("-------------3");
			returnValue = navbar(flag, model);
		}
		
		return returnValue;
		
	}
	
	
	public String navbar(String flag, Map<String, Object> model) throws Exception{
		
		List<CategoryVO> cvo  = cateDAO.frCateList();
						
		HttpSession session = (HttpSession)model.get("session");
		
		//System.out.println("-------------4");
		
		session.setAttribute("frCateList", cvo);
		
		System.out.println("-------------5");
		
		//http://localhost:8080/teamPJT/view/index.jsp
	    //return "/view/frMng/main2.jsp";
	    return "frMng/main2.jsp";
	    //return "/view/frMng/main2.jsp";
		//return null;
		
	}

}
