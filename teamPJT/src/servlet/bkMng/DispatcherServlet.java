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

@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		
		
		String servletPath = arg0.getServletPath();
		
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
				
				
				
			}
			
			String viewUrl = contro.execute(model);
			
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
