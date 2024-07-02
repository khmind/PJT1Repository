package controller.frMng;

import java.util.Map;

import controller.Controller;
import dao.bkMng.CategoryDAO;
import dao.frMng.NoticeFrDAO;
import vo.bkMng.NoticeVO;

public class NoticeListController implements Controller{
	CategoryDAO cateDAO;
	NoticeFrDAO noticeFrDAO;
	NoticeVO vo;
	
	public NoticeListController setDAO(NoticeFrDAO noticeFrDAO, CategoryDAO cateDAO) {
		this.noticeFrDAO = noticeFrDAO;
		this.cateDAO = cateDAO;
		return this;
	}

	@Override
	public String execute(String flag,Map<String, Object> model) throws Exception {
		String returnValue="";
		if(flag.equals("notice_list")) {
			returnValue = notice_list(flag, model);
		}else if(flag.equals("notice_detail")) {
			returnValue = notice_one(flag,model);
		}
	 	return returnValue;
		
	}
	
	public String notice_list(String flag, Map<String, Object> model) throws Exception{
		
		NoticeVO notice = (NoticeVO)model.get("PageInfo");		
		NoticeVO notice1 = noticeFrDAO.selectListCnt(notice);
	
		model.put("PageInfo", notice1);
		model.put("noticelist", noticeFrDAO.selectList(notice1));
		
		return "frMng/fr_announcement.jsp";
	}
	public String notice_one(String flag, Map<String, Object> model) throws Exception{
		NoticeVO vo = (NoticeVO)model.get("detail");
		String notice_id = vo.getNotice_id();
		NoticeVO notice = noticeFrDAO.selectOne(notice_id);
		model.put("notice", notice);
		return "frMng/fr_announcement_detail.jsp";
	}
	
}	