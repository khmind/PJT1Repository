package listener;

import java.util.List;

import javax.naming.InitialContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import controller.bkMng.AskController;
import controller.bkMng.CategoryController;
import controller.bkMng.InfoController;
import controller.bkMng.LogOutController;
import controller.bkMng.NoticeController;
import controller.bkMng.RecipeController;
import controller.bkMng.UserController;
import controller.frMng.HeaderController;
import dao.bkMng.AskDAO;
import dao.bkMng.CategoryDAO;
import dao.bkMng.InfoDAO;
import dao.bkMng.ManegerDAO;
import dao.bkMng.NoticeDAO;

import dao.bkMng.RecipeDAO;
import dao.bkMng.UserDAO;
import vo.bkMng.CategoryVO;

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
			UserDAO userDAO =  new UserDAO();
			RecipeDAO recipeDAO = new RecipeDAO();
			NoticeDAO noticeDAO = new NoticeDAO();
			CategoryDAO cateDAO=new CategoryDAO();
			AskDAO askDAO = new AskDAO();
			dao.setDataSource(ds);
			userDAO.setDataSource(ds);
			recipeDAO.setDs(ds); 
			noticeDAO.setDataSource(ds);
			cateDAO.setDs(ds);
			askDAO.setDataSource(ds);

			/*###  bkMng  ###*/
			sc.setAttribute("/view/bkMng/login.do", new InfoController().setInfoDAO(dao, cateDAO));
			sc.setAttribute("/view/bkMng/logout.do", new LogOutController());
			
			sc.setAttribute("/view/bkMng/user.do", new UserController().setDAO(userDAO));
			sc.setAttribute("/view/bkMng/userModify.do", new UserController().setDAO(userDAO));
			
			sc.setAttribute("/view/bkMng/maneger.do", new UserController().setDAO(userDAO));
			sc.setAttribute("/view/bkMng/manegerModify.do", new UserController().setDAO(userDAO));  
			
			sc.setAttribute("/view/bkMng/notice.do", new NoticeController().setDAO(noticeDAO));
			sc.setAttribute("/view/bkMng/notice_update.do", new NoticeController().setDAO(noticeDAO));
			sc.setAttribute("/view/bkMng/notice_register.do", new NoticeController().setDAO(noticeDAO));
			sc.setAttribute("/view/bkMng/notice_delete.do", new NoticeController().setDAO(noticeDAO));
			
			sc.setAttribute("/view/bkMng/category.do", new CategoryController().setCateDAO(cateDAO));
			sc.setAttribute("/view/bkMng/cate_add.do", new CategoryController().setCateDAO(cateDAO));
			sc.setAttribute("/view/bkMng/cate_delete.do", new CategoryController().setCateDAO(cateDAO));
			sc.setAttribute("/view/bkMng/cate_edit.do", new CategoryController().setCateDAO(cateDAO));
			
			sc.setAttribute("/view/bkMng/recipe.do", new RecipeController().setRecipeDAO(recipeDAO));
			sc.setAttribute("/view/bkMng/recipe_edit.do", new RecipeController().setRecipeDAO(recipeDAO));
			sc.setAttribute("/view/frMng/recipe_add.do", new RecipeController().setRecipeDAO(recipeDAO));
			
			sc.setAttribute("/view/bkMng/ask.do", new AskController().setDAO(askDAO));
			sc.setAttribute("/view/bkMng/ask_register.do", new AskController().setDAO(askDAO));
			sc.setAttribute("/view/bkMng/ask_update.do", new AskController().setDAO(askDAO));
						
			/*###  fkMng  ###*/
			sc.setAttribute("/view/frMng/header.do", new HeaderController().setInfoDAO(cateDAO));
			
			
		}catch (Exception e) {
			e.printStackTrace(); 
		}
		 
	}

}
