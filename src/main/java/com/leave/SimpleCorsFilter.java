package com.leave;


	import java.io.IOException;
	import javax.servlet.Filter;
	import javax.servlet.FilterChain;
	import javax.servlet.FilterConfig;
	import javax.servlet.ServletException;
	import javax.servlet.ServletRequest;
	import javax.servlet.ServletResponse;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	import org.springframework.core.annotation.Order;
	import org.springframework.stereotype.Component;



	@Component
	@Order(Integer.MIN_VALUE)
	public class SimpleCorsFilter
	  implements Filter
	{
	  public SimpleCorsFilter() {}
	  
	  public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
	    throws IOException, ServletException
	  {
	    HttpServletResponse response = (HttpServletResponse)res;
	    HttpServletRequest request = (HttpServletRequest)req;
	    response.setHeader("Access-Control-Allow-Origin", "*");
	    response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT");
	    response.setHeader("Access-Control-Max-Age", "3600");
	    response.setHeader("Access-Control-Allow-Headers", "x-requested-with, authorization, Content-Type");
	    
	    if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
	      response.setStatus(200);
	    } else {
	      chain.doFilter(req, res);
	    }
	  }
	  
	  public void init(FilterConfig filterConfig) {}
	  
	  public void destroy() {}
	}


