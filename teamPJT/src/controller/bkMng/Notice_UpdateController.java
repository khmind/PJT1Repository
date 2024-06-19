package controller.bkMng;

import java.util.Map;

import controller.Controller;
import dao.bkMng.NoticeDAO;
import dao.bkMng.Notice_UpdateDAO;
import vo.bkMng.NoticeVO;

public class Notice_UpdateController implements Controller{
	
	Notice_UpdateDAO notice_upadteDAO;
	
	
	public Notice_UpdateController setDAO(Notice_UpdateDAO notice_upadteDAO) {
		this.notice_upadteDAO = notice_upadteDAO;
		return this;
	}
	
	
	
	@Override
	public String execute(String flag,Map<String, Object> model) throws Exception {
		
		NoticeVO vo = (NoticeVO)model.get("notice_modify");
		
		if(vo.getNotice_title() == null) {

			String notice_id =  vo.getNotice_id();
			
			NoticeVO notice = notice_upadteDAO.selectOne(notice_id);
			
			model.put("notice", notice);
			
			
			return "bk_announcement_modify.jsp";
			
			
		} else {
			NoticeVO notice = (NoticeVO)model.get("notice_modify");
			notice_upadteDAO.update(notice);
			return "redirect:notice.do";
		}
		
	}
}
