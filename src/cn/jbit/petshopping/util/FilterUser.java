package cn.jbit.petshopping.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.jbit.petshopping.entity.Userinfo;

public class FilterUser implements Filter {
	private static Log log = LogFactory.getLog(FilterUser.class);
	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		String path = req.getServletPath();
        if(path.indexOf(".action")==-1 && path.indexOf(".jsp")==-1){ //只拦截action和jsp
        	chain.doFilter(request, response);
        	return;
        }else{
        	 String uri = path.substring(path.lastIndexOf("/",path.length()));
             if(uri.startsWith("/login!")
            		|| path.endsWith("/login.action") 
    				|| path.endsWith("/login.jsp")
    				|| path.endsWith("/register.action") 
    				|| path.endsWith("/register.jsp")){//登录无需判断权限
             	chain.doFilter(request, response);
             	return;
             }else{
            	 HttpSession session = req.getSession();
            	 Userinfo user = (Userinfo) session.getAttribute("userinfo");
     			if (user == null) {
     				log.debug("User doesn't exist in session");
     				HttpServletResponse res = (HttpServletResponse) response;
     				res.sendRedirect(req.getContextPath() + "/login.action");
     			} else {
     				chain.doFilter(request, response);
     			}
             }
        }

	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
