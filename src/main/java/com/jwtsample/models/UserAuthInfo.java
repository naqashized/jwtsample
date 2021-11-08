//package com.jwtsample.models;
//
//import java.util.Collection;
//import java.util.List;
//import java.util.Set;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import com.safari.pg.cbs.def._UserAuthInfo;
//
//public class UserAuthInfo implements UserDetails{
//	private  _UserAuthInfo userInfo;
//	private String password;
//	List<GrantedAuthority> authorities;
//	
//	public UserAuthInfo() {}
//	public UserAuthInfo(_UserAuthInfo userInfo, String password, List<GrantedAuthority> grantedAuths) {
//		this.userInfo = userInfo;
//		this. password = password;
//		this.authorities = grantedAuths;
//	}
//
//	public _UserAuthInfo getUserInfo() {
//		return userInfo;
//	}
//
//	public void setUserInfo(_UserAuthInfo userInfo) {
//		this.userInfo = userInfo;
//	}
//
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		return (Collection<? extends GrantedAuthority>) authorities;
//	}
//
//	@Override
//	public String getPassword() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String getUsername() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public boolean isAccountNonExpired() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public boolean isAccountNonLocked() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public boolean isCredentialsNonExpired() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public boolean isEnabled() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	public void setAuthorities(List<GrantedAuthority> authorities) {
//		this.authorities = authorities;
//	}
//	
//	
//
//}
