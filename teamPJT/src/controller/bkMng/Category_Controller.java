package controller.bkMng;

import java.util.Map;

import controller.Controller;
import dao.bkMng.CategoryDAO;
import vo.bkMng.CategoryVO;

public class Category_Controller implements Controller{

	CategoryDAO cateDAO;
	
	public Category_Controller setCateDAO(CategoryDAO cateDAO) {
		this.cateDAO = cateDAO;
		return this;
	}

	@Override
	public String execute(String flag,Map<String, Object> model) throws Exception {
		
		String returnValue="";
		if(flag.equals("cate_list")) {
			returnValue = cate_list(flag, model);
		}
		else if(flag.equals("cate_update")) {
			returnValue = cate_update(flag, model);
		}
		else if(flag.equals("cate_add")) {
			returnValue = cate_add(flag,model);
		}
		else if(flag.equals("cate_delete")){
			returnValue = cate_delete(flag,model);
		}
	 	return returnValue;
		
		
	}

	private String cate_delete(String flag, Map<String, Object> model) throws Exception {
		
		String[] no = (String[])model.get("no");
		cateDAO.delete(no);
		
		return "redirect:category.do";
	}

	private String cate_add(String flag, Map<String, Object> model) throws Exception{
		if(model.get("add") !=null) {
			CategoryVO cateVO=(CategoryVO)model.get("add");
			cateDAO.insert(cateVO);
			return "redirect:category.do";
		}
		return null;
	} 

	private String cate_update(String flag, Map<String, Object> model) throws Exception{
		
		return null;
	}

	private String cate_list(String flag, Map<String, Object> model) throws Exception{
		model.put("cateList", cateDAO.cateList());
		return "bk_category.jsp";
	}
}
