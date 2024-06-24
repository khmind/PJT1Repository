package controller.bkMng;

import java.util.Map;

import controller.Controller;
import dao.bkMng.CategoryDAO;
import vo.bkMng.CategoryVO;

public class CategoryController implements Controller{

	CategoryDAO cateDAO;
	
	public CategoryController setCateDAO(CategoryDAO cateDAO) {
		this.cateDAO = cateDAO;
		return this;
	}

	@Override
	public String execute(String flag,Map<String, Object> model) throws Exception {
		
		String returnValue="";
		if(flag.equals("cate_list")) {
			returnValue = cate_list(flag, model);
		}
		else if(flag.equals("cate_edit")) {
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
		//cateDAO.delete(no);
		int res = cateDAO.delete(no);
		System.out.println("?????????????????????"+res);
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
		
		CategoryVO vo = (CategoryVO)model.get("cate_edit");
		
		System.out.println("edit==========2");
		System.out.println("edit==========2"+vo.getCate_id());
		System.out.println("edit==========2"+vo.getCate_name());
		
		if(vo.getCate_name() == null) {
			
			String id = vo.getCate_id();
			System.out.println(id+"8888888888888888888888");
			CategoryVO cateVO=cateDAO.detail(id);
			model.put("cateUp", cateVO);
			
			return "bk_category_edit.jsp";
		}
		
			System.out.println("edit==========5=====================");
			//CategoryVO catevo = (CategoryVO)model.get("cate_edit2");
			cateDAO.update(vo);
			
			return "redirect:category.do";
		
	}

	private String cate_list(String flag, Map<String, Object> model) throws Exception{
		model.put("cateList", cateDAO.cateList());
		return "bk_category.jsp";
	}
}
