package listener;

import javax.naming.InitialContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

import controller.bkMng.AskController;
import controller.bkMng.Category_Controller;
import controller.bkMng.Info_controller;
import controller.bkMng.LogOutController;
import controller.bkMng.ManegerController;
import controller.bkMng.NoticeController;
import controller.bkMng.Recipe_list_Controller;
import controller.bkMng.UserController;
import dao.bkMng.AskDAO;
import dao.bkMng.CategoryDAO;
import dao.bkMng.InfoDAO;
import dao.bkMng.ManegerDAO;
import dao.bkMng.NoticeDAO;

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
			CategoryDAO cateDAO=new CategoryDAO();
			AskDAO askDAO = new AskDAO();
			dao.setDataSource(ds);
			userDAO.setDataSource(ds);
			listDAO.setDs(ds); 
			noticeDAO.setDataSource(ds);
			cateDAO.setDs(ds);
			askDAO.setDataSource(ds);
			
			sc.setAttribute("/view/bkMng/login.do", new Info_controller().setInfoDAO(dao));
			sc.setAttribute("/view/bkMng/logout.do", new LogOutController());
			sc.setAttribute("/view/bkMng/user.do", new UserController().setDAO(userDAO));
			sc.setAttribute("/view/bkMng/maneger.do", new ManegerController().setDAO(manegerDAO));
			sc.setAttribute("/view/bkMng/notice.do", new NoticeController().setDAO(noticeDAO));
			sc.setAttribute("/view/bkMng/notice_update.do", new NoticeController().setDAO(noticeDAO));
			sc.setAttribute("/view/bkMng/notice_register.do", new NoticeController().setDAO(noticeDAO));
			sc.setAttribute("/view/bkMng/notice_delete.do", new NoticeController().setDAO(noticeDAO));
			sc.setAttribute("/view/bkMng/recipe.do", new Recipe_list_Controller().setRecipeListDAO(listDAO));
			sc.setAttribute("/view/bkMng/category.do", new Category_Controller().setCateDAO(cateDAO));
			sc.setAttribute("/view/bkMng/cate_add.do", new Category_Controller().setCateDAO(cateDAO));
			sc.setAttribute("/view/bkMng/cate_delete.do", new Category_Controller().setCateDAO(cateDAO));
			sc.setAttribute("/view/bkMng/cate_edit.do", new Category_Controller().setCateDAO(cateDAO));
			sc.setAttribute("/view/bkMng/ask.do", new AskController().setDAO(askDAO));
			
		}catch (Exception e) {
			e.printStackTrace(); 
		}
		 
	}

}
