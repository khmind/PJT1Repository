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
import controller.frMng.MainController;
import controller.frMng.MyPageController;
import controller.frMng.NoticeFrController;
import controller.frMng.RecipeSearchController;
import controller.frMng.UserInfoController;
import controller.frMng.AskFrController;
import controller.frMng.LogOutFrController;
import controller.frMng.LoginController;
import dao.bkMng.AskDAO;
import dao.bkMng.CategoryDAO;
import dao.bkMng.InfoDAO;
import dao.bkMng.ManegerDAO;
import dao.bkMng.NoticeDAO;

import dao.bkMng.RecipeDAO;
import dao.bkMng.UserDAO;
import dao.frMng.AskFrDAO;
import dao.frMng.NoticeFrDAO;
import dao.frMng.RecipeFrDAO;
import dao.frMng.UserInfoDAO;
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
			
			RecipeFrDAO recipeFrDAO = new RecipeFrDAO();
			NoticeFrDAO noticeFrDAO = new NoticeFrDAO();
			AskFrDAO askFrDAO = new AskFrDAO();
			UserInfoDAO userinfoDAO = new UserInfoDAO();
			
			dao.setDataSource(ds);
			userDAO.setDataSource(ds);
			recipeDAO.setDs(ds); 
			noticeDAO.setDataSource(ds);
			cateDAO.setDs(ds);
			askDAO.setDataSource(ds);
			
			recipeFrDAO.setDs(ds);
			noticeFrDAO.setDataSource(ds);
			userinfoDAO.setDataSource(ds);
			askFrDAO.setDataSource(ds);
			

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
			sc.setAttribute("/view/bkMng/notice_delete1.do", new NoticeController().setDAO(noticeDAO));
			sc.setAttribute("/view/bkMng/notice_delete2.do", new NoticeController().setDAO(noticeDAO));
			
			sc.setAttribute("/view/bkMng/category.do", new CategoryController().setCateDAO(cateDAO));
			sc.setAttribute("/view/bkMng/cate_add.do", new CategoryController().setCateDAO(cateDAO));
			sc.setAttribute("/view/bkMng/cate_delete.do", new CategoryController().setCateDAO(cateDAO));
			sc.setAttribute("/view/bkMng/cate_edit.do", new CategoryController().setCateDAO(cateDAO));
			
			sc.setAttribute("/view/bkMng/recipe.do", new RecipeController().setRecipeDAO(recipeDAO, cateDAO));
			sc.setAttribute("/view/bkMng/recipe_edit.do", new RecipeController().setRecipeDAO(recipeDAO, cateDAO));
			sc.setAttribute("/view/bkMng/recipe_add.do", new RecipeController().setRecipeDAO(recipeDAO, cateDAO));
			sc.setAttribute("/view/bkMng/recipe_delete.do", new RecipeController().setRecipeDAO(recipeDAO, cateDAO));
			
			sc.setAttribute("/view/bkMng/ask.do", new AskController().setDAO(askDAO));
			sc.setAttribute("/view/bkMng/ask_delete1.do", new AskController().setDAO(askDAO));
			sc.setAttribute("/view/bkMng/ask_delete2.do", new AskController().setDAO(askDAO));
			sc.setAttribute("/view/bkMng/ask_update.do", new AskController().setDAO(askDAO));
						
			/*###  fkMng  ###*/			
			sc.setAttribute("/view/main.to", new MainController().setInfoDAO(cateDAO, recipeFrDAO));
			
			sc.setAttribute("/view/login.to", new LoginController().setLoginDAO(dao, cateDAO));
			sc.setAttribute("/view/logout.to", new LogOutFrController());
			sc.setAttribute("/view/myPage.to", new MyPageController() );			
			sc.setAttribute("/view/addLogin.to", new LoginController().setLoginDAO(dao, cateDAO));
			
			sc.setAttribute("/view/notice.to", new NoticeFrController().setDAO(noticeFrDAO, cateDAO));
			sc.setAttribute("/view/notice_detail.to", new NoticeFrController().setDAO(noticeFrDAO, cateDAO));
			
			sc.setAttribute("/view/ask.to", new AskFrController().setDAO(askFrDAO, cateDAO));
			sc.setAttribute("/view/ask_update.to", new AskFrController().setDAO(askFrDAO, cateDAO));
			sc.setAttribute("/view/ask_register.to", new AskFrController().setDAO(askFrDAO, cateDAO));
			sc.setAttribute("/view/ask_delete1.to", new AskFrController().setDAO(askFrDAO, cateDAO));
			sc.setAttribute("/view/ask_delete2.to", new AskFrController().setDAO(askFrDAO, cateDAO));
			
			sc.setAttribute("/view/recipeSearch.to", new RecipeSearchController().setDAO(cateDAO, recipeFrDAO,recipeDAO));
			sc.setAttribute("/view/recipeDetail.to", new RecipeSearchController().setDAO(cateDAO, recipeFrDAO, recipeDAO));
			sc.setAttribute("/view/recipe_edit.do", new RecipeController().setRecipeDAO(recipeDAO, cateDAO));
			sc.setAttribute("/view/recipe_add.do", new RecipeController().setRecipeDAO(recipeDAO, cateDAO));
			sc.setAttribute("/view/recipe.do", new RecipeController().setRecipeDAO(recipeDAO, cateDAO));
			sc.setAttribute("/view/recipe_in.do", new RecipeController().setRecipeDAO(recipeDAO, cateDAO));
			sc.setAttribute("/view/recipe_co.do", new RecipeController().setRecipeDAO(recipeDAO, cateDAO));
			sc.setAttribute("/view/recipe_delete.do", new RecipeController().setRecipeDAO(recipeDAO, cateDAO));
			
			sc.setAttribute("/view/userInfo.to", new UserInfoController().setDAO(cateDAO, userinfoDAO));
			sc.setAttribute("/view/userInfoModify.to", new UserInfoController().setDAO(cateDAO, userinfoDAO));

		}catch (Exception e) {
			e.printStackTrace(); 
		}
		 
	}

}
