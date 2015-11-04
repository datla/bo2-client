package com.kthree.servlet.filters;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;

import com.kthree.ws.ServerStatus;
import com.kthree.ws.ServerStatusService;

/**
 * Servlet Filter implementation class BO2ClientFilter
 */
@WebFilter("/BO2HttpFilter")
public class BO2HttpFilter implements Filter {

	private ServletContext context;
	private String redirectPagePath = null; 
	
	public void init(FilterConfig fConfig) throws ServletException {
		this.context = fConfig.getServletContext();
		this.context.log("BO2ClientFilter initialized");
		System.out.println("BO2ClientFilter initialized");
		Enumeration<String> initParams = fConfig.getInitParameterNames();
		while(initParams.hasMoreElements()){
			String name = initParams.nextElement();
			String value = fConfig.getInitParameter(name);
			if(name!=null && !name.isEmpty() && name.equals("html-redirect-page")){
				redirectPagePath = value;
			}
			this.context.log("::Request Params::{"+name+"="+value+"}");
			System.out.println("::Request Params::{"+name+"="+value+"}");
		}
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println(" *** Service check start ***");
		ServerStatusService statusService = new ServerStatusService();
		ServerStatus status = statusService.getServerStatusPort();
		boolean serverStatus = status.getServerStatus(); 
		System.out.println("Server status>"+serverStatus);
		if(serverStatus){
			//System.out.println(" *** Service available ***");
			//Response.status(Response.Status.OK).build();
			chain.doFilter(request, response);
		}else{
			System.out.println(" *** Service unavailable ***");
			Response.status(Response.Status.SERVICE_UNAVAILABLE).build();
			HttpServletResponse res = (HttpServletResponse) response;
			if(redirectPagePath!=null && !redirectPagePath.isEmpty()){
				res.sendRedirect("bo2_system_unavailable.html");
			}else{
				res.sendRedirect("/home.html");
			}
		}
		System.out.println(" *** Service check finished ***");
		return;
	}

	public void destroy() {
		//we can close resources here
	}

}
