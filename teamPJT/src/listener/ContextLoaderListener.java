package listener;

import javax.naming.InitialContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

<<<<<<< HEAD
import controller.bkMng.Info_Controller;
=======
import controller.bkMng.Info_controller;
import controller.bkMng.LogOut_Controller;
import controller.bkMng.Maneger_Controller;
import controller.bkMng.User_Controller;
>>>>>>> branch 'main' of https://github.com/khmind/PJT1Repository
import dao.bkMng.InfoDAO;
import dao.bkMng.ManegerDAO;
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
<<<<<<< HEAD
			InitialContext ic=new InitialContext();
			
=======
			InitialContext ic = new InitialContext();
		
>>>>>>> branch 'main' of https://github.com/khmind/PJT1Repository
			DataSource ds=(DataSource)ic.lookup("java:comp/env/jdbc/myDB");
<<<<<<< HEAD
			
=======
		
>>>>>>> branch 'main' of https://github.com/khmind/PJT1Repository
			InfoDAO dao =  new InfoDAO();
<<<<<<< HEAD
			
=======
			ManegerDAO manegerDAO =  new ManegerDAO();
			UserDAO userDAO =  new UserDAO();
		
>>>>>>> branch 'main' of https://github.com/khmind/PJT1Repository
			dao.setDataSource(ds);
<<<<<<< HEAD
			
			sc.setAttribute("/view/bkMng/login.do", new Info_Controller().setInfoDAO(dao));
			//sc.setAttribute("view/bkMng/recipe_list.do", );
			
=======
			userDAO.setDataSource(ds);
		
			sc.setAttribute("/view/bkMng/login.do", new Info_controller().setInfoDAO(dao));
			sc.setAttribute("/view/bkMng/logout.do", new LogOut_Controller());
			sc.setAttribute("/view/bkMng/user.do", new User_Controller().setDAO(userDAO));
			sc.setAttribute("/view/bkMng/maneger.do", new Maneger_Controller().setDAO(manegerDAO));
		
>>>>>>> branch 'main' of https://github.com/khmind/PJT1Repository
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
