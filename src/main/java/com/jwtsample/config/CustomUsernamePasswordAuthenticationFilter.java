package com.jwtsample.config;

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@Component
public class CustomUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter{
	  @Override
	  public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) 
		        throws AuthenticationException {
	
		        if (!request.getMethod().equals("POST")) {
		            throw new AuthenticationServiceException("Authentication method not supported: " 
		              + request.getMethod());
		        }
	
		        CustomAuthenticationToken authRequest = getAuthRequest(request);
		        setDetails(request, authRequest);
		        return this.getAuthenticationManager().authenticate(authRequest);
	  }

    private CustomAuthenticationToken getAuthRequest(HttpServletRequest request) {
        String username = obtainUsername(request);
        String password = obtainPassword(request);
        String channelId = obtainDomain(request);

        if (username == null) {
            username = "";
        }
        if (password == null) {
            password = "";
        }
        if (channelId == null) {
        	channelId = "";
        }

        return new CustomAuthenticationToken(username, password, channelId);
    }

    private String obtainDomain(HttpServletRequest request) {
        return request.getParameter("channelId");
    }
}
