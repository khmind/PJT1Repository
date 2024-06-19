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
import vo.bkMng.InfoVO;
import vo.bkMng.NoticeVO;
import vo.bkMng.UserVO;

@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		
		
		String servletPath = arg0.getServletPath();
		
		String flag ="";
		
		
		
		System.out.println(servletPath);
		
		try {
			ServletContext sc=this.getServletContext();
		
			HashMap<String, Object> model = new HashMap<String, Object>();			
			model.put("session", arg0.getSession());
		
			Controller contro=(Controller)sc.getAttribute(servletPath);
			
			if("/view/bkMng/login.do".equals(servletPath)) {
				
				if(arg0.getParameter("email") != null) {
					model.put("adLogin", new InfoVO()
							.setUser_email(arg0.getParameter("email"))
							.setUser_pw(arg0.getParameter("password"))
							);
				}
			}else if("/view/bkMng/user.do".equals(servletPath)) {
				
				String a = arg0.getParameter("sel1");
				String b = arg0.getParameter("sel2");
				String c = arg0.getParameter("searchText");
				
				System.out.println( " a : " + a + ", b : "+ b +", c : " +c);	
				
				model.put("user", new UserVO()
							.setSel1(arg0.getParameter("sel1"))
							.setSel2(arg0.getParameter("sel2"))
							.setSearchText(arg0.getParameter("searchText"))
						);
				
				flag = "list";
				
			}else if("/view/bkMng/recipe.do".equals(servletPath)) {

				
			}else if("/view/bkMng/notice.do".equals(servletPath)) {
				
			}else if("/view/bkMng/notice_update.do".equals(servletPath)) {
					
					if(arg0.getParameter("notice_id")!=null) {
						System.out.println("-------------7");
						model.put("notice_modify", new NoticeVO()
								.setNotice_id(arg0.getParameter("notice_id"))
								.setNotice_title(arg0.getParameter("notice_title"))
								.setNotice_content(arg0.getParameter("notice_content"))
								);
					}else {
						System.out.println("-------------11");
						model.put("notice_modify", new NoticeVO()
								.setNotice_id(arg0.getParameter("notice_id"))
								.setNotice_title(arg0.getParameter("notice_title"))
								.setNotice_content(arg0.getParameter("notice_content"))
								);					
					}
					
			}else if("/view/bkMng/notice_register.do".equals(servletPath)){
					
					if(arg0.getParameter("notice_title")!=null) {
						model.put("notice_register", new NoticeVO()
								//.setNotice_id(arg0.getParameter("notice_id"))
								.setNotice_title(arg0.getParameter("notice_title"))
								.setNotice_content(arg0.getParameter("notice_content"))
								);		
						System.out.println(arg0.getParameter("notice_title")+"**********************");
					}
				} 
			
			
			
			
			String viewUrl = contro.execute(flag, model);
			
			for(String key : model.keySet()) {
				arg0.setAttribute(key, model.get(key));
			}
			
			if(viewUrl.startsWith("redirect:")) {
				arg1.sendRedirect(viewUrl.substring(9));
			}else {
				RequestDispatcher rd = arg0.getRequestDispatcher(viewUrl);
				rd.forward(arg0, arg1);
			}
			
		}catch (Exception e) {
			
		}
		
	}
}
