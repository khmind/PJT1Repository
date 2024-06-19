package controller.bkMng;

import java.util.Map;

import controller.Controller;
import dao.bkMng.NoticeDAO;
import dao.bkMng.UserDAO;
import vo.bkMng.NoticeVO;

public class Notice_Controller implements Controller{
	
	NoticeDAO noticeDAO;
	
	
	public Notice_Controller setDAO(NoticeDAO noticeDAO) {
		this.noticeDAO = noticeDAO;
		return this;
	}
		
	
	@Override
	public String execute(String flag,Map<String, Object> model) throws Exception {
		System.out.println("-------------5");
	
		model.put("noticelist", noticeDAO.NoticeList());
		return "bk_announcement.jsp";
	}
}
