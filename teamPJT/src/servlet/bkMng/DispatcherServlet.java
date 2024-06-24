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
						);
				
				flag = "list";		

			} 
			else if ("/view/bkMng/userModify.do".equals(servletPath)) {
				
				model.put("modify", new UserVO()
						.setUser_id(arg0.getParameter("user_id"))						
						.setUser_email(arg0.getParameter("user_email"))
						.setUser_pw(arg0.getParameter("user_pw"))
						.setUser_role(arg0.getParameter("user_role"))
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
						);
				
				flag = "list";		

			} 
			else if ("/view/bkMng/manegerModify.do".equals(servletPath)) {
				
				model.put("modify", new UserVO()
						.setUser_id(arg0.getParameter("user_id"))						
						.setUser_email(arg0.getParameter("user_email"))
						.setUser_pw(arg0.getParameter("user_pw"))
						.setUser_role(arg0.getParameter("user_role"))
					);				
				
				flag = "modify";	
				
			}			
			else if ("/view/bkMng/notice.do".equals(servletPath)) {
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
				else if("/view/bkMng/notice_delete.do".equals(servletPath)){
					System.out.println("---------------------------------555 " +arg0.getParameter("notice_id"));
					model.put("notice_delete", arg0.getParameter("notice_id"));
					flag = "notice_delete";
				
				}
			
			else if ("/view/bkMng/recipe.do".equals(servletPath)) {
				flag = "recipe_list";
				
			} 
			else if("/view/bkMng/category.do".equals(servletPath)) {
				flag="cate_list";
			}
			else if("/view/bkMng/cate_add.do".equals(servletPath)) {
				System.out.println("add=========1");
				
				if(arg0.getParameter("cate_id") != null) {
					System.out.println("add=========2");
					model.put("add", new CategoryVO()
							.setCate_id(arg0.getParameter("cate_id"))
							.setCate_name(arg0.getParameter("cate_name"))
							.setCate_order(arg0.getParameter("cate_order"))
							.setCate_place(arg0.getParameter("cate_place"))
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
							.setCate_place(arg0.getParameter("cate_place")));
				}
//				else {
//					System.out.println("edit===========99999999");
//					model.put("cate_edit", new CategoryVO()
//							.setCate_id(arg0.getParameter("cate_id"))
//							.setCate_name(arg0.getParameter("cate_name"))
//							.setCate_order(arg0.getParameter("cate_order"))
//							.setCate_place(arg0.getParameter("cate_place")));
//					
//					System.out.println("=================1"+arg0.getParameter("cate_id"));
//					System.out.println("=================1"+arg0.getParameter("cate_name"));
//					System.out.println("=================1"+arg0.getParameter("cate_order"));
//					System.out.println("=================1"+arg0.getParameter("cate_place"));
//				}
				flag="cate_edit";
			}
			else if ("/view/bkMng/recipe.do".equals(servletPath)) {
				flag = "recipe_list";
			}
			else if("/view/frMng/recipe_edit.do".equals(servletPath)) {
				if(arg0.getParameter("recipe_id") !=null) {
					System.out.println(arg0.getParameter("recipe_id")+"?????????????//");
					model.put("recipe_edit", new RecipeVO()
							.setRecipe_id(arg0.getParameter("recipe_id")));
					
					flag="recipe_edit";
				}
			}
			//System.out.println("############# flag1 : " + flag);
			
			String viewUrl = contro.execute(flag, model);
			
			
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
