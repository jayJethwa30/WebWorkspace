package com.lti.filter;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class AuditFilter
 */
@WebFilter(dispatcherTypes = {
				DispatcherType.REQUEST, 
				DispatcherType.FORWARD, 
				DispatcherType.INCLUDE, 
				DispatcherType.ERROR
		}
					, urlPatterns = { "/AccountServlet" })
public class AuditFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AuditFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("AUDIT FILTER ID DESTROYED");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		System.out.println("AUDIT FILTER ==> DO FILTER");
		HttpServletRequest req=(HttpServletRequest) request;
		String url=req.getRequestURI().toString(); //finding requested url
		System.out.println("URL INTERCEPTED ==> "+url);
		long start=System.currentTimeMillis(); //Start time

		// pass the request along the filter chain
		chain.doFilter(request, response); //This filter chain doFilter() passes the control to AccountServlet
		long end=System.currentTimeMillis(); //End time
		System.out.println("URL : "+url+" took time : "+(end-start)+"ms");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("AUDIT FILTER IS INITIALIZED");
	}

}
