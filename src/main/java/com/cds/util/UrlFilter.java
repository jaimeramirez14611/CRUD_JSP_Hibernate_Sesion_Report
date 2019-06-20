package com.cds.util;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class testFilter
 * https://stackoverflow.com/questions/49547/how-to-control-web-page-caching-across-all-browsers
 */
@WebFilter(urlPatterns = {/* "*", "/login"*/})
public class UrlFilter implements Filter {

    /**
     * Default constructor. 
     */
    public UrlFilter() {
        // TODO Auto-generated constructor stub
    	//System.out.println("Filtros");
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	   
		HttpServletRequest req = (HttpServletRequest)request;
	    HttpServletResponse res = (HttpServletResponse) response;
	    HttpSession session = req.getSession(false);
	    
	    String requestURI = req.getRequestURI();
	    String loginURI = req.getContextPath()+"/login";
	   
        
        
	    if(requestURI.contentEquals(loginURI)) {
	    	  chain.doFilter(req, res); // Logged-in user found, so just continue request.
	    }else {
	    	
	    	if (session == null || session.getAttribute("usuario") == null) {
	    		request.getRequestDispatcher("login.jsp").forward(request, response);
	 	       // res.sendRedirect("login.jsp"); // No logged-in user found, so redirect to login page.
	 	  
	    	} else {
	 	    	String usuario = (String) session.getAttribute("usuario");
	 	    	System.out.println(usuario);
	 	    	/*validar la ccahe y boton de retroceso del navegador */
	 	    	res.addHeader("Cache-Control", "no-cache, no-store, must-revalidate");// HTTP 1.1.
	 	    	res.addHeader("Pragma", "no-cache");// HTTP 1.0.
	 	    	res.addHeader("Expires", "0");// Proxies.
	 	    	
	 	        chain.doFilter(req, res); // Logged-in user found, so just continue request.
	 	    }
	 	
	    	
	    }
	       
		//chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
