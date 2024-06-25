package controller.bkMng;

import java.util.Map;

import controller.Controller;
import dao.bkMng.AskDAO;

import vo.bkMng.AskVO;

public class AskController implements Controller{
	
	AskDAO askDAO;
	
	public AskController setDAO(AskDAO askDAO) {
		this.askDAO = askDAO;
		return this;
	}
	
	@Override
	public String execute(String flag, Map<String, Object> model) throws Exception {
		String returnValue="";
		if(flag.equals("ask_list")) {
			returnValue = ask_list(flag, model);
		}else if(flag.equals("ask_update")) {
			returnValue = ask_update(flag, model);
		}else if(flag.equals("ask_register")) {
			returnValue = ask_register(flag,model);
		}else if(flag.equals("notice_delete")){
			//returnValue = notice_delete(flag,model);
		}
	 	return returnValue;

	}
	
	public String ask_list(String flag, Map<String, Object> model) throws Exception{
		
		model.put("asklist", askDAO.AskList());
		return "bk_ask.jsp";
	}
	public String ask_register(String flag, Map<String, Object> model)throws Exception{
		System.out.println("-------------------12"+model.get("ask_id"));
		if(model.get("ask_id")==null) {
			
			return "bk_ask_register.jsp";
			 
			 }else {
				 System.out.println("-------------------13");
				
			
				AskVO ask = (AskVO)model.get("ask_register"); 
				
				System.out.println(" ask :" + ask.getUser_id());
				
				
				askDAO.insert(ask);
				
				System.out.println(" regi------------result  : ");
				
				return "redirect:ask.do";
		 
			 	}
		
	}
	
	public String ask_update(String flag, Map<String, Object> model) throws Exception{
		System.out.println("----------------------------3");
		AskVO vo = (AskVO)model.get("ask_update");
		System.out.println("----------------------------4");
		if(vo.getRecomm_content() == null) {
			System.out.println("----------------------------5");
			String ask_id =  vo.getAsk_id();System.out.println("----------------------------5-1");
			AskVO ask = askDAO.selectOne(ask_id);
			model.put("ask", ask);
			System.out.println("----------------------------6"+ask.getAsk_id());
			return "bk_ask_modify.jsp";
		}
		System.out.println("----------------------------9"+vo.getRecomm_content());
		AskVO ask = (AskVO)model.get("ask_update");
		askDAO.update(ask);
		System.out.println("----------------------------17");
		return "redirect:ask.do";
	}
}
