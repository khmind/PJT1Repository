package controller.bkMng;

import java.util.Map;

import controller.Controller;
import dao.bkMng.NoticeDAO;
import vo.bkMng.NoticeVO;

public class NoticeController implements Controller{
	
	NoticeDAO noticeDAO;
	
	
	public NoticeController setDAO(NoticeDAO noticeDAO) {
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
		}else if(flag.equals("notice_delete1")){
			returnValue = notice_delete1(flag,model);
		}else if(flag.equals("notice_delete2")){
			returnValue = notice_delete2(flag,model);
		}
	 	return returnValue;
		
	}
	
	public String notice_list(String flag, Map<String, Object> model) throws Exception{
		System.out.println("-----------------------------6");
		
		NoticeVO notice = (NoticeVO)model.get("PageInfo");
		
		System.out.println("-----------------------------7");
		
		NoticeVO notice1 = noticeDAO.selectListCnt(notice);
		
		System.out.println("-----------------------------8");
		
		System.out.println("-------------------------getEndPage : " +notice1.getEndPage());
		
		
		model.put("PageInfo", notice1);
		model.put("noticelist", noticeDAO.selectList(notice1));
		
		System.out.println("-----------------------------9");
		
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
	
	public String notice_delete1(String flag, Map<String, Object> model) throws Exception{
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~14"); 
		String notice_id = (String) model.get("notice_delete");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~15"+notice_id);
		noticeDAO.delete1(notice_id);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~15-1");
		
		return "redirect:notice.do";
	}
	public String notice_delete2(String flag, Map<String, Object> model) throws Exception{
		
		String[] no = (String[])model.get("no");
		//cateDAO.delete(no);
		int res = noticeDAO.delete2(no);
		System.out.println("?????????????????????"+res);
		return "redirect:notice.do";
	}
	
}
