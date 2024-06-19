package controller.bkMng;
import java.util.Map;
import controller.Controller;
import dao.bkMng.Notice_RegisterDAO; 
import vo.bkMng.NoticeVO;

public class Notice_RegisterController implements Controller{
 
	Notice_RegisterDAO notice_insertDAO;


 public Notice_RegisterController setDAO(Notice_RegisterDAO notice_insertDAO) {
	 
	 this.notice_insertDAO= notice_insertDAO; 
	 return this; 
 }
 
@Override 
public String execute(String flag,Map<String, Object> model) throws Exception {
	
	if(model.get("notice_register")==null) {
	
	return "bk_announcement_register.jsp";
	 
	 }else {
		 System.out.println("-------------------12");
		
	
		NoticeVO notice = (NoticeVO)model.get("notice_register"); 
		notice_insertDAO.insert(notice);
		
		System.out.println(" regi------------result  : ");
		
		return "redirect:notice.do";
 
	 	}
 
	} 
}
