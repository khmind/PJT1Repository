package servlet.bkMng;

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
import vo.bkMng.CategoryVO;
import vo.bkMng.InfoVO;
import vo.bkMng.NoticeVO;
import vo.bkMng.RecipeVO;
import vo.bkMng.UserVO;

@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {

		String servletPath = arg0.getServletPath();

		String flag = "";

		System.out.println(servletPath);

		try {
			ServletContext sc = this.getServletContext();

			HashMap<String, Object> model = new HashMap<String, Object>();
			model.put("session", arg0.getSession());

			Controller contro = (Controller) sc.getAttribute(servletPath);

			if ("/view/bkMng/login.do".equals(servletPath)) {
				
				flag = "login";
				if (arg0.getParameter("email") != null) {
					model.put("adLogin", new InfoVO().setUser_email(arg0.getParameter("email"))
							.setUser_pw(arg0.getParameter("password")));
				}
				flag = "login";
				
			}
			else if ("/view/bkMng/user.do".equals(servletPath)) { 

				String pg = arg0.getParameter("page");
				
				pg = (pg==""||pg==null||pg.equals("null")) ? "1" : pg ;
				
				int page = Integer.parseInt(pg);
				
				model.put("PageInfo", new UserVO()
							.setSel1(arg0.getParameter("sel1"))
							.setSel2(arg0.getParameter("sel2"))
							.setSearchText(arg0.getParameter("searchText"))
							.setPage(page)
							.setMethodFlag("G")
						);
				
				flag = "list";		

			} 
			else if ("/view/bkMng/userModify.do".equals(servletPath)) {
				
				model.put("modify", new UserVO()
						.setUser_id(arg0.getParameter("user_id"))						
						.setUser_email(arg0.getParameter("user_email"))
						.setUser_pw(arg0.getParameter("user_pw"))
						.setUser_role(arg0.getParameter("user_role"))
						.setMethodFlag("G")
					);				
				
				flag = "modify";	
				
			}
			else if ("/view/bkMng/maneger.do".equals(servletPath)) { 

				String pg = arg0.getParameter("page");
				
				pg = (pg==""||pg==null||pg.equals("null")) ? "1" : pg ;
				
				int page = Integer.parseInt(pg);
				
				model.put("PageInfo", new UserVO()
							.setSel1(arg0.getParameter("sel1"))
							.setSel2(arg0.getParameter("sel2"))
							.setSearchText(arg0.getParameter("searchText"))
							.setPage(page)
							.setMethodFlag("A")
						);
				
				flag = "list";		

			}
			else if ("/view/bkMng/manegerModify.do".equals(servletPath)) {
				
				model.put("modify", new UserVO()
						.setUser_id(arg0.getParameter("user_id"))						
						.setUser_email(arg0.getParameter("user_email"))
						.setUser_pw(arg0.getParameter("user_pw"))
						.setUser_role(arg0.getParameter("user_role"))
						.setMethodFlag("A")
					);				
				
				flag = "modify";	
				
			}
			else if ("/view/bkMng/notice.do".equals(servletPath)) {
				String pg = arg0.getParameter("page");
				pg = (pg==""||pg==null||pg.equals("null")) ? "1" : pg ;
				int page = Integer.parseInt(pg);
				model.put("PageInfo", new NoticeVO()
							.setSel1(arg0.getParameter("sel1"))
							.setSearchText(arg0.getParameter("searchText"))
							.setPage(page)
							);
							
				flag = "notice_list";
			} 
			else if ("/view/bkMng/notice_update.do".equals(servletPath)) {
				
				if (arg0.getParameter("notice_id") != null) {
					model.put("notice_modify",
							new NoticeVO().setNotice_id(arg0.getParameter("notice_id"))
									.setNotice_title(arg0.getParameter("notice_title"))
									.setNotice_content(arg0.getParameter("notice_content")));
					flag = "notice_update";
				} else {
					model.put("notice_modify",
							new NoticeVO().setNotice_id(arg0.getParameter("notice_id"))
									.setNotice_title(arg0.getParameter("notice_title"))
									.setNotice_content(arg0.getParameter("notice_content")));
				}
				flag = "notice_update";

			}
			else if("/view/bkMng/notice_register.do".equals(servletPath)){				
				
				HttpSession session = (HttpSession)model.get("session");	
				InfoVO vo = (InfoVO)session.getAttribute("infoVO");				
					
					if(arg0.getParameter("notice_title")!=null) {
						
						model.put("notice_register", new NoticeVO()
								.setUser_id(vo.getUser_id())
								.setNotice_title(arg0.getParameter("notice_title"))
								.setNotice_content(arg0.getParameter("notice_content"))
								);		

					}
					flag = "notice_register";
				}
				else if("/view/bkMng/notice_delete1.do".equals(servletPath)){
					model.put("notice_delete", arg0.getParameter("notice_id"));
					flag = "notice_delete1";
				
				}
				else if("/view/bkMng/notice_delete2.do".equals(servletPath)){
					String[] del =arg0.getParameterValues("del_id");
					for(int i=0; i<del.length; i++) {
	
					}
					String btn = arg0.getParameter("btn");
					if(btn.equals("delete")) {
						String[] ids= new String[del.length];
						for(int i=0; i<del.length; i++) {
							ids[i]=del[i];
						}
						model.put("no", ids);
					}
					flag = "notice_delete2";
				
				}
				else if("/view/bkMng/ask.do".equals(servletPath)) {
					String pg = arg0.getParameter("page");
					pg = (pg==""||pg==null||pg.equals("null")) ? "1" : pg ;
					int page = Integer.parseInt(pg);
					model.put("PageInfo", new AskVO()
								.setSel1(arg0.getParameter("sel1"))
								.setSel2(arg0.getParameter("sel2"))
								.setSearchText(arg0.getParameter("searchText"))
								.setPage(page)
								);
					flag = "ask_list";
					

				}else if("/view/bkMng/ask_update.do".equals(servletPath)) {
					HttpSession session = (HttpSession)model.get("session");	
					InfoVO vo = (InfoVO)session.getAttribute("infoVO");				
					if(arg0.getParameter("recomm_content")==null) {
							
						model.put("ask_update", new AskVO().setAsk_id(arg0.getParameter("ask_id")));	
						flag="ask_update";
					}else {
						model.put("ask_update", new AskVO()
													.setUser_id(arg0.getParameter("user_id"))
													.setAsk_id(arg0.getParameter("ask_id"))
													.setRecomm_content(arg0.getParameter("recomm_content"))
													.setRecomm_user_id(vo.getUser_id())
								);	
						flag="ask_update";
					}
				
				}else if("/view/bkMng/ask_delete1.do".equals(servletPath)) {
					model.put("ask_id", arg0.getParameter("ask_id"));
					flag = "ask_delete1";
				}else if("/view/bkMng/ask_delete2.do".equals(servletPath)) {
					String[] del=arg0.getParameterValues("del_id");
					for(int i=0; i<del.length; i++) {
					}
					String btn = arg0.getParameter("btn");
					if(btn.equals("delete")) {
						String[] ids= new String[del.length];
						for(int i=0; i<del.length; i++) {
							ids[i]=del[i];
						}
						model.put("no", ids);
					}
					flag = "ask_delete2";
				}

			else if("/view/bkMng/category.do".equals(servletPath)) {
				flag="cate_list";
			}
			else if("/view/bkMng/cate_add.do".equals(servletPath)) {
				System.out.println("add=========1");
				
				if(arg0.getParameter("cate_id") != null) {
					System.out.println("add=========2");
					model.put("add", new CategoryVO()
							.setCate_id(arg0.getParameter("cate_id").trim())
							.setCate_name(arg0.getParameter("cate_name").trim())
							.setCate_order(arg0.getParameter("cate_order").trim())
							.setCate_place(arg0.getParameter("cate_place").trim())
							.setAction(arg0.getParameter("action"))
							);
				}
				flag = "cate_add";
			}
			else if("/view/bkMng/cate_delete.do".equals(servletPath)) {
				System.out.println("delete======1");
				String[] del=arg0.getParameterValues("del_id");
				for(int i=0; i<del.length; i++) {
					
					System.out.println("delete======1"+del[i]);
				}
				String btn = arg0.getParameter("btn");
				if(btn.equals("delete")) {
					String[] ids= new String[del.length];
					for(int i=0; i<del.length; i++) {
						ids[i]=del[i];
					}
					model.put("no", ids);
				}
				flag = "cate_delete";
			}
			else if("/view/bkMng/cate_edit.do".equals(servletPath)) {
				
				System.out.println("edit======1");
				if(arg0.getParameter("cate_id") !=null) {
					System.out.println(arg0.getParameter("cate_id")+"?????????????//");
					model.put("cate_edit", new CategoryVO()
							.setCate_id(arg0.getParameter("cate_id"))
							.setCate_name(arg0.getParameter("cate_name"))							
							.setCate_order(arg0.getParameter("cate_order"))
							.setCate_place(arg0.getParameter("cate_place"))
							.setAction(arg0.getParameter("action"))
							);
				}

				flag="cate_edit";
			}
			else if (("/view/bkMng/recipe.do".equals(servletPath)) || ("/view/recipe.do".equals(servletPath))
					|| ("/view/recipe_in.do".equals(servletPath)) || ("/view/recipe_co.do".equals(servletPath))) {
				System.out.println("++++++++++"+servletPath);
				
				if("/view/recipe.do".equals(servletPath)) {
					
					flag="recipe_listFr";
				}
				else if("/view/recipe_in.do".equals(servletPath)) {
					flag="recipe_listFr1";
				}
				else if ("/view/recipe_co.do".equals(servletPath)) {
					flag="recipe_listFr2";
				}
				else {
					
					flag = "recipe_listBk";
				}
			}
			else if(("/view/bkMng/recipe_edit.do".equals(servletPath)) || ("/view/recipe_edit.do".equals(servletPath))) {
				System.out.println("servletPath"+servletPath);	
				if(arg0.getParameter("recipe_id") !=null) {
					System.out.println(arg0.getParameter("recipe_id")+"?????????????//");
					model.put("recipe_edit", new RecipeVO()
							.setRecipe_id(arg0.getParameter("recipe_id"))
							.setRecipe_title(arg0.getParameter("reci_title"))
							.setClass_name(arg0.getParameter("class_name"))
							.setImg_path_01(arg0.getParameter("upload1"))
							.setImg_path_02(arg0.getParameter("upload2"))
							.setImg_path_03(arg0.getParameter("upload3"))
							.setRecipe_level(arg0.getParameter("level"))
							.setRecipe_stuff(arg0.getParameter("stuff"))
							.setRecipe_content(arg0.getParameter("content"))
							);
					System.out.println(arg0.getParameter("reci_title")+"wwwwwwwwwwwwwwwwwww");
					 
					flag="recipe_edit";
				}
			}
			else if(("/view/bkMng/recipe_add.do".equals(servletPath)) || ("/view/recipe_add.do".equals(servletPath))) {
				System.out.println("add===============1");
				HttpSession session = (HttpSession)model.get("session");	
				InfoVO vo = (InfoVO)session.getAttribute("loginVO");				
					
				System.out.println("add===============2");
				System.out.println("add===============2"+arg0.getParameter("recipe_id"));
				System.out.println("add===============2"+arg0.getParameter("reci_title"));
				System.out.println("????????????????????????????00/ "+vo.getUser_id());
				if(arg0.getParameter("reci_title") != null) {	
			
						model.put("recipe_new", new RecipeVO()
								.setUser_id(vo.getUser_id())
								.setRecipe_title(arg0.getParameter("reci_title"))
								.setClass_id(arg0.getParameter("class_name"))
								.setImg_path_01(arg0.getParameter("upload1"))
								.setImg_path_02(arg0.getParameter("upload2"))
								.setImg_path_03(arg0.getParameter("upload3"))
								.setRecipe_level(arg0.getParameter("level"))
								.setRecipe_stuff(arg0.getParameter("reci_stuff"))
								.setRecipe_content(arg0.getParameter("reci_content"))
								);	
						
						flag="recipe_add";
					}
				flag="recipe_add";
				System.out.println("add============2-2");
			}
			else if("/view/bkMng/recipe_delete.do".equals(servletPath)) {
				System.out.println("delete======1");
				String[] del=arg0.getParameterValues("del_id");
				
				for(int i=0; i<del.length; i++) {
					
					System.out.println("delete======1"+del[i]);
				}
				String btn = arg0.getParameter("btn");
				if(btn.equals("delete")) {
					String[] ids= new String[del.length];
					for(int i=0; i<del.length; i++) {
						ids[i]=del[i];
					}
					model.put("reci", ids);
				}
				flag = "recipe_delete";
			}
			else if("/view/frMng/recipe_comment.to".equals(servletPath)) {
				HttpSession session = (HttpSession)model.get("session");	
				InfoVO vo = (InfoVO)session.getAttribute("infoVO");	
				if(arg0.getParameter("recipe_reply") != null) {
					model.put("recipe_comment", new RecipeVO()
							.setUser_id(vo.getUser_id())
							.setComment_content(arg0.getParameter("recipe_reply")));
					flag="recipe_comment";
				}
			}
			
			
			
			
			//System.out.println("############# flag1 : " + flag);
			System.out.println("add============2-3"+flag);
			String viewUrl = contro.execute(flag, model);
			System.out.println("add============2-4");
			
			//System.out.println("############# flag2 : " + flag);

			for (String key : model.keySet()) {
				arg0.setAttribute(key, model.get(key));
			}

			if (viewUrl.startsWith("redirect:")) {
				arg1.sendRedirect(viewUrl.substring(9));
			} else {
				RequestDispatcher rd = arg0.getRequestDispatcher(viewUrl);
				rd.forward(arg0, arg1);
			}

		} catch (Exception e) {

		}

	}
}
