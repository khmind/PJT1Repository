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
		}else if(flag.equals("ask_delete1")){
			returnValue = ask_delete1(flag,model);
		}else if(flag.equals("ask_delete2")){
			returnValue = ask_delete2(flag,model);
		}
	 	return returnValue;

	}
	
	public String ask_list(String flag, Map<String, Object> model) throws Exception{
		
		AskVO ask = (AskVO)model.get("PageInfo");
		AskVO ask1 = askDAO.selectListCnt(ask);

		model.put("PageInfo", ask1);
		model.put("asklist", askDAO.selectList(ask1));

		return "bk_ask.jsp";
	}
	
	
	public String ask_update(String flag, Map<String, Object> model) throws Exception{

		AskVO vo = (AskVO)model.get("ask_update");

		if(vo.getRecomm_content()==null) {
			String ask_id =  vo.getAsk_id();
			AskVO ask = askDAO.selectOne(ask_id);
			model.put("ask", ask);
			return "bk_ask_modify.jsp";
			 
		}else {
				askDAO.insert(vo);
				return "redirect:ask.do";
		 
			 	}

	}
	
	public String ask_delete1(String flag, Map<String, Object> model) throws Exception{
		
		  String ask_id = (String) model.get("ask_id");
		  askDAO.delete1(ask_id);
		
		return "redirect:ask.do";
	}
	
	public String ask_delete2(String flag, Map<String, Object> model) throws Exception{
		
		String[] no = (String[])model.get("no");
		askDAO.delete2(no);
		return "redirect:ask.do";

	}
}
