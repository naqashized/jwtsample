package com.jwtsample.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@Profile("!test")
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private com.jwtsample.config.CustomAuthenticationProvider authProvider;
    
    @Autowired
    com.jwtsample.config.CustomUserDetailsAuthenticationProvider userDetailsAuthenticationProvider;

    @Autowired
    private com.jwtsample.config.JwtAuthenticationEntryPoint unauthorizedHandler;
    
    public SecurityConfig() {
        super();
    }

    @Bean
    public com.jwtsample.config.JwtAuthenticationFilter jwtAuthenticationFilter() throws Exception {
    	com.jwtsample.config.CustomUsernamePasswordAuthenticationFilter filter = new com.jwtsample.config.CustomUsernamePasswordAuthenticationFilter();
        filter.setAuthenticationManager(authenticationManagerBean());
        return new com.jwtsample.config.JwtAuthenticationFilter();
    }

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authProvider());
	}

    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors()
                    .and()
                .csrf()
                    .disable()
                .exceptionHandling()
                    .authenticationEntryPoint(unauthorizedHandler)
                    .and()
                .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                    .and()
                .authorizeRequests()
                    .antMatchers("/",
                        "/favicon.ico",
                        "/**/*.png",
                        "/**/*.gif",
                        "/**/*.svg",
                        "/**/*.jpg",
                        "/**/*.html",
                        "/**/*.css",
                        "/**/*.js")
                        .permitAll()
                    .antMatchers("/auth/**")
                        .permitAll()
                    .anyRequest()
                        .authenticated();

        // Add our custom JWT security filter
        http.addFilterBefore(jwtAuthenticationFilter(), com.jwtsample.config.CustomUsernamePasswordAuthenticationFilter.class);

    }
    
    public com.jwtsample.config.CustomUsernamePasswordAuthenticationFilter authenticationFilter() throws Exception {
    	com.jwtsample.config.CustomUsernamePasswordAuthenticationFilter filter = new com.jwtsample.config.CustomUsernamePasswordAuthenticationFilter();
        filter.setAuthenticationManager(authenticationManagerBean());
        //filter.setAuthenticationFailureHandler(failureHandler());
        return filter;
    }
    
    public AuthenticationProvider authProvider() {
        com.jwtsample.config.CustomUserDetailsAuthenticationProvider provider
        = new com.jwtsample.config.CustomUserDetailsAuthenticationProvider(passwordEncoder(), authProvider);
        return provider;
    }
}