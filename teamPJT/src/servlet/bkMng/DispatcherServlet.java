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

import controller.Controller;
import vo.bkMng.CategoryVO;
import vo.bkMng.InfoVO;
import vo.bkMng.NoticeVO;
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

				String a = arg0.getParameter("sel1");
				String b = arg0.getParameter("sel2");
				String c = arg0.getParameter("searchText");
				String page = arg0.getParameter("page");
				
				page = (page==null||page.equals("null")) ? "0" : page ;
				
				System.out.println( " a : " + a + ", b : "+ b +", c : " +c);	
				
				model.put("PageInfo", new UserVO()
							.setSel1(arg0.getParameter("sel1"))
							.setSel2(arg0.getParameter("sel2"))
							.setSearchText(arg0.getParameter("searchText"))
							.setPage(page)
						);
				
				flag = "list";		

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
			else if ("/view/bkMng/notice_register.do".equals(servletPath)) {

				if (arg0.getParameter("notice_title") != null) {
					model.put("notice_register", new NoticeVO()
							// .setNotice_id(arg0.getParameter("notice_id"))
							.setNotice_title(arg0.getParameter("notice_title"))
							.setNotice_content(arg0.getParameter("notice_content")));
					System.out.println(arg0.getParameter("notice_title") + "**********************");
				}
				flag = "notice_register";
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
					
					System.out.println("delete======2"+del[i]);
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
				if(arg0.getParameter("vv") !=null) {
					model.put("cate_edit", new CategoryVO()
							.setCate_id("cate_id")
							.setCate_name("cate_name")
							.setCate_order("cate_order")
							.setCate_place("cate_place"));
				}
				flag="cate_edit";
			}

			
			
			String viewUrl = contro.execute(flag, model);

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
