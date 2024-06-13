package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//run실행시 자동으로 실행

@WebFilter(
	urlPatterns="/*",
	initParams={
		@WebInitParam(name="encoding",value="utf-8")
	})
public class CharacterEncodingFilter implements Filter{
	 
	FilterConfig config;
	
	@Override
	public void init(FilterConfig config) throws ServletException {
		this.config = config;
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,FilterChain nextFilter) throws IOException, ServletException {
		
		System.out.println("한글필터적용시작");
		request.setCharacterEncoding(config.getInitParameter("encoding"));
		//response.setCharacterEncoding(config.getInitParameter("encoding")); 
		response.setContentType("text/html;charset="+config.getInitParameter("encoding"));
		System.out.println("한글필터적용완료");
		
		HttpServletRequest req = (HttpServletRequest)request;
	    HttpServletResponse resp = (HttpServletResponse)response;
	      
	    String fileUri = req.getRequestURI();
	      
		if (fileUri.contains(".css")) {
			resp.setContentType("text/css; charset=utf-8");
		} 
		else if (fileUri.contains(".js")) {
			resp.setContentType("text/js; charset=utf-8");
		} 
		else if (fileUri.contains(".jpg")) {
			resp.setContentType("image/jpeg;");
		} 
		else if (fileUri.contains(".png")) {
			resp.setContentType("image/png;");
		} 
		else if (fileUri.contains(".svg")) {
			resp.setContentType("image/svg+xml;");
		} 
		else if (fileUri.contains(".ttf")) {
			resp.setContentType("font/ttf;");
		} 
		else if (fileUri.contains(".html")) {
			resp.setContentType("text/html; charset=utf-8");
		}
		
		nextFilter.doFilter(request, response);
	}

	@Override
	public void destroy() {}
}
