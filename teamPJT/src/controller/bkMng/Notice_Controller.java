package controller.bkMng;

import java.util.Map;

import controller.Controller;
import dao.bkMng.NoticeDAO;
import vo.bkMng.NoticeVO;

public class Notice_Controller implements Controller{
	
	NoticeDAO noticeDAO;
	
	
	public Notice_Controller setDAO(NoticeDAO noticeDAO) {
		this.noticeDAO = noticeDAO;
		return this;
	}

	@Override
	public String execute(String flag,Map<String, Object> model) throws Exception {
		String returnValue="";
		if(flag.equals("notice_list")) {
			returnValue = notice_list(flag, model);
		}else if(flag.equals("notice_update")) {
			returnValue = notice_update(flag, model);
		}else if(flag.equals("notice_register")) {
			returnValue = notice_register(flag,model);
		}else if(flag.equals("notice_delete")){
			returnValue = notice_delete(flag,model);
		}
	 	return returnValue;
		
	}
	
	public String notice_list(String flag, Map<String, Object> model) throws Exception{
	
	
		model.put("noticelist", noticeDAO.NoticeList());
		return "bk_announcement.jsp";
	}
	
	public String notice_update(String flag, Map<String, Object> model) throws Exception{
		NoticeVO vo = (NoticeVO)model.get("notice_modify");
		
		if(vo.getNotice_title() == null) {
			String notice_id =  vo.getNotice_id();
			NoticeVO notice = noticeDAO.selectOne(notice_id);
			model.put("notice", notice);
			
			return "bk_announcement_modify.jsp";
		}
		
		NoticeVO notice = (NoticeVO)model.get("notice_modify");
		noticeDAO.update(notice);
		return "redirect:notice.do";
	}
	
	public String notice_register(String flag, Map<String, Object> model) throws Exception{
		if(model.get("notice_register")==null) {
			
			return "bk_announcement_register.jsp";
			 
			 }else {
				 System.out.println("-------------------12");
				
			
				NoticeVO notice = (NoticeVO)model.get("notice_register"); 
				
				System.out.println(" notice :" + notice.getUser_id());
				
				
				noticeDAO.insert(notice);
				
				System.out.println(" regi------------result  : ");
				
				return "redirect:notice.do";
		 
			 	}
		 
		} 
	public String notice_delete(String flag, Map<String, Object> model) throws Exception{
		
		  System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~14"); 
		  String notice_id = (String) model.get("notice_id");
		  System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~15"+notice_id);
		  noticeDAO.delete(notice_id);
		  System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~15-1");
		
		return "redirect:notice.do";
	}
	
}
