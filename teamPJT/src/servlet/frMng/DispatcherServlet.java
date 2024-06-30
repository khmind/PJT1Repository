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
import vo.bkMng.CategoryVO;
import vo.bkMng.InfoVO;
import vo.bkMng.NoticeVO;
import vo.bkMng.RecipeVO;
import vo.bkMng.UserVO;

@WebServlet("*.to")
public class DispatcherServlet extends HttpServlet {

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
				System.out.println("-------------1");
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
