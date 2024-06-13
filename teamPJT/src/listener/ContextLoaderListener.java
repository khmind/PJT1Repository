package listener;

import javax.naming.InitialContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

import controller.bkMng.Info_controller;
import dao.bkMng.InfoDAO;

@WebListener
public class ContextLoaderListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("222222222222222222");
		ServletContext sc=sce.getServletContext();
		
		try {
			InitialContext ic=new InitialContext();
			System.out.println("==========1");
			DataSource ds=(DataSource)ic.lookup("java:comp/env/jdbc/myDB");
			System.out.println("==========2");
			InfoDAO dao =  new InfoDAO();
			System.out.println("==========3");
			dao.setDataSource(ds);
			System.out.println("==========4");
			sc.setAttribute("/view/bkMng/login.do", new Info_controller().setInfoDAO(dao));
			System.out.println("==========5");
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
