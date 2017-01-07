package com.java2.web.filter;

import java.io.IOException;
import java.util.Base64;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.java2.web.services.PersonServiceImpl;

public class AuthentecationFilter implements Filter{

	WebApplicationContext context;
	FilterConfig fc;
	
	@Override
	public void init(FilterConfig filterConfig) {
		fc = filterConfig;
		context = WebApplicationContextUtils.getRequiredWebApplicationContext(fc.getServletContext());
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//getUser info by userName.
		//compare userPassword in HttpRequest is equals password in DB
		
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		String casicCreditial = httpRequest.getHeader("Authorization");
		//Basic 
		String[] array = casicCreditial.split(" ");
		String creditial = new String(Base64.getDecoder().decode(array[1]));
		String[] creditialArray = creditial.split(":");
		String username = creditialArray[0];
		String password = creditialArray[1];
		
//		PersonServiceImpl ps = context.getBean("personServiceImpl" , PersonServiceImpl.class);
		
//		boolean passAuth = ps.isUserCreaditialValid(username, password);
		boolean passAuth = true;
		if(passAuth) {
			System.out.println("hello");
			chain.doFilter(request, response);
		}else{
			httpResponse.sendError(401, "password or username is not right");
			
		}
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
