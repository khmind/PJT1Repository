package listener;

import javax.naming.InitialContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

import controller.bkMng.Info_controller;
import controller.bkMng.LogOut_Controller;
import controller.bkMng.Maneger_Controller;
import controller.bkMng.Notice_Controller;
import controller.bkMng.Notice_RegisterController;
import controller.bkMng.Notice_UpdateController;
import controller.bkMng.Recipe_list_Controller;
import controller.bkMng.User_Controller;
import dao.bkMng.InfoDAO;
import dao.bkMng.ManegerDAO;
import dao.bkMng.NoticeDAO;
import dao.bkMng.Notice_RegisterDAO;
import dao.bkMng.Notice_UpdateDAO;
import dao.bkMng.Recipe_listDAO;
import dao.bkMng.UserDAO;

@WebListener
public class ContextLoaderListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		ServletContext sc=sce.getServletContext();
		
		try {
			InitialContext ic = new InitialContext();
		
			DataSource ds=(DataSource)ic.lookup("java:comp/env/jdbc/myDB");
		
			InfoDAO dao =  new InfoDAO();
			ManegerDAO manegerDAO =  new ManegerDAO();
			UserDAO userDAO =  new UserDAO();
			Recipe_listDAO listDAO = new Recipe_listDAO();
			NoticeDAO noticeDAO = new NoticeDAO();
			Notice_UpdateDAO notice_updateDAO = new Notice_UpdateDAO();
			Notice_RegisterDAO notice_registerDAO = new Notice_RegisterDAO();
			dao.setDataSource(ds);
			userDAO.setDataSource(ds);
			listDAO.setDs(ds); 
			noticeDAO.setDataSource(ds);
			notice_updateDAO.setDataSource(ds);
			notice_registerDAO.setDataSource(ds);
			
			sc.setAttribute("/view/bkMng/login.do", new Info_controller().setInfoDAO(dao));
			sc.setAttribute("/view/bkMng/logout.do", new LogOut_Controller());
			sc.setAttribute("/view/bkMng/user.do", new User_Controller().setDAO(userDAO));
			sc.setAttribute("/view/bkMng/maneger.do", new Maneger_Controller().setDAO(manegerDAO));
			sc.setAttribute("/view/bkMng/recipe.do", new Recipe_list_Controller().setRecipeListDAO(listDAO));
			sc.setAttribute("/view/bkMng/notice.do", new Notice_Controller().setDAO(noticeDAO));
			sc.setAttribute("/view/bkMng/notice_update.do", new Notice_UpdateController().setDAO(notice_updateDAO));
			sc.setAttribute("/view/bkMng/notice_register.do", new Notice_RegisterController().setDAO(notice_registerDAO));
			
		
		}catch (Exception e) {
			e.printStackTrace(); 
		}
		
	}

}
