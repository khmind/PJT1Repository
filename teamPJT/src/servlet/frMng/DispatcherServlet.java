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
import vo.bkMng.AskVO;
import vo.bkMng.InfoVO;
import vo.bkMng.NoticeVO;
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
			else if("/view/notice.to".equals(servletPath)) {
				String pg = req.getParameter("page");
				System.out.println("pg--------1 : " + pg);
				
				pg = (pg==""||pg==null||pg.equals("null")) ? "1" : pg ;
				
				int page = Integer.parseInt(pg);
				
				model.put("PageInfo", new NoticeVO()						
							.setSearchText(req.getParameter("searchText"))
							.setPage(page)
						);
				flag = "notice_list";
			}
			else if("/view/notice_detail.to".equals(servletPath)) {
				model.put("detail", new NoticeVO()
						.setNotice_id(req.getParameter("notice_id"))
						);
				flag = "notice_detail";
			}
			else if("/view/ask.to".equals(servletPath)) {
				String pg = req.getParameter("page");
				
				pg = (pg==""||pg==null||pg.equals("null")) ? "1" : pg ;
				
				int page = Integer.parseInt(pg);
				model.put("PageInfo", new AskVO()
						.setSearchText(req.getParameter("searchText"))					
						.setPage(page)
						);
				flag = "ask_list";
			}else if("/view/ask_update.to".equals(servletPath)) {
				HttpSession session = (HttpSession)model.get("session");	
				InfoVO vo = (InfoVO)session.getAttribute("loginVO");	
				System.out.println("1"+req.getParameter("ask_update"));
				System.out.println("3-1"+req.getParameter("ask_id"));
				System.out.println("3-2"+req.getParameter("ask_title"));
				System.out.println("3-3"+req.getParameter("ask_content"));
				if(req.getParameter("ask_update")==null) {
					System.out.println("ask_update-----------1");
					model.put("ask_update", new AskVO()
							
							.setAsk_id(req.getParameter("ask_id"))
							.setAsk_title(req.getParameter("ask_title"))
							.setAsk_content(req.getParameter("ask_content")));	
					flag="ask_update";
				}else {
					
					System.out.println("ui-----------1" + vo.getUser_id());
					System.out.println("ai-----------2" + req.getParameter("ask_id"));
					System.out.println("at-----------3" + req.getParameter("ask_title"));
					System.out.println("ac-----------4" + req.getParameter("ask_content"));
					model.put("ask_update", new AskVO()
										.setUser_id(vo.getUser_id())
										.setAsk_id(req.getParameter("ask_id"))
										.setAsk_title(req.getParameter("ask_title"))
										.setAsk_content(req.getParameter("ask_content"))
										);
					System.out.println("3-4");
					flag="ask_update";
				}
			}
			else if("/view/ask_register.to".equals(servletPath)) {
				HttpSession session = (HttpSession)model.get("session");	
				InfoVO vo = (InfoVO)session.getAttribute("loginVO");	

				if(req.getParameter("ask_title")!=null) {
					System.out.println("2"+req.getParameter("ask_title"));
					System.out.println("2-1"+req.getParameter("ask_content"));
					model.put("ask_register", new AskVO()
							.setUser_id(vo.getUser_id())
							.setAsk_title(req.getParameter("ask_title"))
							.setAsk_content(req.getParameter("ask_content"))
							);
				}
				System.out.println("3");
				flag = "ask_register";
			}
			else if("/view/ask_delete1.to".equals(servletPath)) {
				model.put("ask_delete", req.getParameter("ask_id"));
				flag = "ask_delete1";
			}
			else if("/view/ask_delete2.to".equals(servletPath)) {
				String[] del =req.getParameterValues("del_id");
				for(int i=0; i<del.length; i++) {

				}
				String btn = req.getParameter("btn");
				if(btn.equals("delete")) {
					String[] ids= new String[del.length];
					for(int i=0; i<del.length; i++) {
						ids[i]=del[i];
					}
					model.put("no", ids);
				}
				flag = "ask_delete2";
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
