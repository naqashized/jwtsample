package com.jwtsample.config;

import com.jwtsample.models.User;
import com.jwtsample.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomAuthenticationProvider implements AuthenticationProvider{
	private final AuthenticationService authenticationService;
	private final PasswordEncoder passwordEncoder;
    
	@Override
	public Authentication authenticate(Authentication authentication) {
		try {
			String name = authentication.getName();
			String password = authentication.getCredentials().toString();
			CustomAuthenticationToken auth = (CustomAuthenticationToken) authentication;
			String channelId = auth.getChannelId();
			User user = authenticationService.authenticateUser(name,channelId);
			final List<GrantedAuthority> grantedAuths = new ArrayList<>();
			grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));
			final Authentication auth2 = new UsernamePasswordAuthenticationToken(user, passwordEncoder.encode(password), grantedAuths);
			return auth2;

		} catch (Exception e) {
			throw new BadCredentialsException("Authentication failed");
		}

	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
	


}
