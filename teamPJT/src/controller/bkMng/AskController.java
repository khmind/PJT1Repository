package controller.bkMng;

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
		}else if(flag.equals("ask_update")) {
			returnValue = ask_update(flag, model);
		}else if(flag.equals("ask_delete1")){
			returnValue = ask_delete1(flag,model);
		}else if(flag.equals("ask_delete2")){
			returnValue = ask_delete2(flag,model);
		}
	 	return returnValue;

	}
	
	public String ask_list(String flag, Map<String, Object> model) throws Exception{
		
		model.put("asklist", askDAO.AskList());
		return "bk_ask.jsp";
	}
	
	
	public String ask_update(String flag, Map<String, Object> model) throws Exception{
		
		System.out.println("-------------------12"+model.get("ask_update"));
		AskVO vo = (AskVO)model.get("ask_update");

		
		System.out.println("------getAsk_id---------"+ vo.getAsk_id());
		System.out.println("------getUser_id---------"+ vo.getUser_id());
		System.out.println("------getRecomm_content---------"+ vo.getRecomm_content());
		System.out.println("------getRecomm_user_id---------"+ vo.getRecomm_user_id());
		
		
		
		if(vo.getRecomm_content()==null) {
			String ask_id =  vo.getAsk_id();System.out.println("-------------------121"+model.get("ask_id"));
			AskVO ask = askDAO.selectOne(ask_id);System.out.println("-------------------122"+ask);
			model.put("ask", ask);System.out.println("-------------------123"+ask);
			return "bk_ask_modify.jsp";
			 
		}else {
				 System.out.println("-------------------13");
				//AskVO ask = (AskVO)model.get("ask_register"); 
			
				System.out.println(" ask :" + vo.getRecomm_user_id());
				askDAO.insert(vo);System.out.println(" 123123123143242");
				
				System.out.println(" regi------------result  : ");
				
				return "redirect:ask.do";
		 
			 	}

	}
	
	public String ask_delete1(String flag, Map<String, Object> model) throws Exception{
		
		  System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~14"); 
		  String ask_id = (String) model.get("ask_id");
		  System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~15"+ask_id);
		  askDAO.delete1(ask_id);
		  System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~15-1");
		
		return "redirect:ask.do";
	}
	
	public String ask_delete2(String flag, Map<String, Object> model) throws Exception{
		
		String[] no = (String[])model.get("no");
		//cateDAO.delete(no);
		int res = askDAO.delete2(no);
		System.out.println("?????????????????????"+res);
		return "redirect:ask.do";

	}
}
