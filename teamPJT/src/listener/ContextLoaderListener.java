package listener;

import javax.naming.InitialContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

import controller.bkMng.Info_Controller;
import dao.bkMng.InfoDAO;

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
			InitialContext ic=new InitialContext();
			
			DataSource ds=(DataSource)ic.lookup("java:comp/env/jdbc/myDB");
			
			InfoDAO dao =  new InfoDAO();
			
			dao.setDataSource(ds);
			
			sc.setAttribute("/view/bkMng/login.do", new Info_Controller().setInfoDAO(dao));
			//sc.setAttribute("view/bkMng/recipe_list.do", );
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
