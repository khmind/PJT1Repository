package servlet.frMng;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import vo.bkMng.InfoVO;
import vo.bkMng.RecipeVO;

@WebServlet("*.to")
public class DispatcherServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String servletPath = req.getServletPath();

		String flag = "";

		System.out.println(servletPath);

		try {
			ServletContext sc = this.getServletContext();

			HashMap<String, Object> model = new HashMap<String, Object>();
			model.put("session", req.getSession());

			Controller contro = (Controller) sc.getAttribute(servletPath);

			if ("/view/main.to".equals(servletPath)) {
				
				flag = "main";
				
			}
			else if("/view/login.to".equals(servletPath)) {
				System.out.println("==========="+servletPath);
				if(req.getParameter("email") != null) {
					model.put("log", new InfoVO()
							.setUser_email(req.getParameter("email"))
							.setUser_pw(req.getParameter("pass"))
							);
				}
				flag="login";
			} 
			else if("/view/recipeSearch.to".equals(servletPath)) {
				
				String pg = req.getParameter("page");
				System.out.println("pg--------1 : " + pg);
				
				pg = (pg==""||pg==null||pg.equals("null")) ? "1" : pg ;
				
				int page = Integer.parseInt(pg);
				
				System.out.println("sel1 : " + req.getParameter("sel1"));
				System.out.println("searchText : " + req.getParameter("searchText"));
				System.out.println("h_orderby : " + req.getParameter("h_orderby"));
				System.out.println("classId : " + req.getParameter("classId"));
				
				model.put("PageInfo", new RecipeVO()
							.setSel1(req.getParameter("sel1"))							
							.setSearchText(req.getParameter("searchText"))
							.setPage(page)
							.setClass_id(req.getParameter("classId"))
							.setOrderby(req.getParameter("h_orderby"))
						);

				flag="search";
			}			
			else if("/view/recipeDetail.to".equals(servletPath)) {
				System.out.println("frrrrrrrrrr======="+req.getParameter("recipe_id"));
				if(req.getParameter("recipe_id") !=null) {
					System.out.println(req.getParameter("recipe_id")+"?????????????//");
					model.put("recipe_detail", new RecipeVO()
							.setRecipe_id(req.getParameter("recipe_id"))
							.setRecipe_title(req.getParameter("reci_title"))
							.setClass_name(req.getParameter("class_name"))
							.setImg_path_01(req.getParameter("upload1"))
							.setImg_path_02(req.getParameter("upload2"))
							.setImg_path_03(req.getParameter("upload3"))
							.setRecipe_level(req.getParameter("level"))
							.setRecipe_stuff(req.getParameter("stuff"))
							.setRecipe_content(req.getParameter("content"))
							);
				}	
				flag="detail";
			}
			
			
			String viewUrl = contro.execute(flag, model);

			for (String key : model.keySet()) {
				req.setAttribute(key, model.get(key));
			}

			if (viewUrl.startsWith("redirect:")) {
				resp.sendRedirect(viewUrl.substring(9));
			} else {
				RequestDispatcher rd = req.getRequestDispatcher(viewUrl);
				rd.forward(req, resp);
			}

		} catch (Exception e) {

		}

	}
	
}
