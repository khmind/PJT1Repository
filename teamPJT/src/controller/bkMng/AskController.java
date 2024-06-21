package controller.bkMng;

import java.util.List;
import java.util.Map;

import controller.Controller;
import dao.bkMng.AskDAO;

import vo.bkMng.AskVO;
import vo.bkMng.NoticeVO;

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
		}else if(flag.equals("notice_update")) {
			//returnValue = notice_update(flag, model);
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
		
		if(model.get("aks_register")==null) {
			
			return "bk_ask_register.jsp";
			 
			 }else {
				 System.out.println("-------------------12");
				
			
				NoticeVO notice = (NoticeVO)model.get("notice_register"); 
				
				System.out.println(" notice :" + notice.getUser_id());
				
				
				//AskDAO.insert(notice);
				
				System.out.println(" regi------------result  : ");
				
				return "redirect:notice.do";
		 
			 	}
		
		//return "bk_ask.jsp";
	}
}
