package controller.frMng;

import java.util.Map;

import controller.Controller;
import dao.bkMng.CategoryDAO;
import dao.frMng.AskFrDAO;
import vo.bkMng.AskVO;

public class AskFrController implements Controller{
	
	AskFrDAO askFrDAO;
	CategoryDAO cateDAO;
	
	public AskFrController setDAO(AskFrDAO askFrDAO, CategoryDAO cateDAO) {
		this.askFrDAO = askFrDAO;
		this.cateDAO = cateDAO;
		return this;
	}
	
	@Override
	public String execute(String flag, Map<String, Object> model) throws Exception {
		String returnValue="";
		if(flag.equals("ask_list")) {
			returnValue = ask_list(flag, model);
		}else if(flag.equals("ask_update")) {
			returnValue = ask_update(flag, model);
		}else if(flag.equals("ask_delete1")){
			returnValue = ask_delete1(flag,model);
		}else if(flag.equals("ask_delete2")){
			returnValue = ask_delete2(flag,model);
		}else if(flag.equals("ask_register")) {
			returnValue = ask_register(flag,model);
		}
	 	return returnValue;

	}
	
	public String ask_list(String flag, Map<String, Object> model) throws Exception{
		AskVO ask = (AskVO)model.get("PageInfo");
		AskVO ask1 = askFrDAO.selectListCnt(ask);
		model.put("navbar", cateDAO.frCateList());
		model.put("PageInfo", ask1);
		model.put("asklist", askFrDAO.selectList(ask1));
		return "frMng/fr_ask.jsp";
	}
	
	
	public String ask_update(String flag, Map<String, Object> model) throws Exception{
		System.out.println("4");
		AskVO vo = (AskVO)model.get("ask_update");
		model.put("navbar", cateDAO.frCateList());
		System.out.println(vo.getAsk_update()+"999999999999999");
		
		System.out.println("--------- 3 : " + vo.getUser_id());
		
		if(vo.getUser_id()==null) {
			System.out.println("5");
			String ask_id =  vo.getAsk_id();System.out.println("6");
			AskVO ask = askFrDAO.selectOne(ask_id);System.out.println("7");
			model.put("ask", ask);System.out.println("8");
			return "frMng/fr_ask_detail.jsp";
			 
		}else {
			System.out.println("9");
			askFrDAO.update(vo);System.out.println("10");
				return "redirect:ask.to";
		 
			 	}

	}
	
	public String ask_delete1(String flag, Map<String, Object> model) throws Exception{
		
		  String ask_id = (String) model.get("ask_delete");
		  askFrDAO.delete1(ask_id);
		
		return "redirect:ask.to";
	}
	
	public String ask_delete2(String flag, Map<String, Object> model) throws Exception{
		
		String[] no = (String[])model.get("no");
		askFrDAO.delete2(no);
		return "redirect:ask.to";

	}
	public String ask_register(String flag, Map<String, Object> model) throws Exception{
		model.put("navbar", cateDAO.frCateList());
		System.out.println("4");
		if(model.get("ask_register")==null) {
			System.out.println("5");
			return "frMng/fr_ask_register.jsp";
			 
			 }else {
				System.out.println("6");
				AskVO ask = (AskVO)model.get("ask_register"); 	System.out.println("7");
				askFrDAO.insert(ask);System.out.println("8");

				return "redirect:ask.to";
		 
			 	}
		 
		} 
}
