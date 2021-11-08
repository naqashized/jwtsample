//package com.jwtsample.services;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
//public class UserPrincipal implements UserDetails {
//    private Long userId;
//    private String userTitle;
//    //private int channelId;
//    private boolean enabled;
//    private boolean accountNonLocked;
//    private boolean credentialsNonExpired;
//    private boolean accountNonExpired;
//
////    @JsonIgnore
////    private String password;
//
//    private Collection<? extends GrantedAuthority> authorities;
//
//    public UserPrincipal(Long id, String accessId, Collection<? extends GrantedAuthority> authorities) {
//        this.userId = id;
//        this.userTitle = accessId;
//        //this.channelId = channelId;
//        //this.password = password;
//        this.authorities = authorities;
//    }
//
//    public static UserPrincipal createUserAuthInfo(_UserAuthInfo  user) {
//        List<GrantedAuthority> authorities = new ArrayList<>();
//        final List<GrantedAuthority> grantedAuths = new ArrayList<>();
//        grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));
//    	//user.getRoles().stream().map(role ->
////                new SimpleGrantedAuthority(role.getName().name())
////        ).collect(Collectors.toList());
//
//        return new UserPrincipal(
//                Long.valueOf(user.getUserId()),
//                user.getLoginId(),
////                user.getChannelId(),
////                user.getPassword(),
//                grantedAuths
//        );
//    }
//
////    public static UserPrincipal create(com.jwtsample.jwtsample.models.User user) {
////        List<GrantedAuthority> authorities = new ArrayList<>();
////    	//user.getRoles().stream().map(role ->
//////                new SimpleGrantedAuthority(role.getName().name())
//////        ).collect(Collectors.toList());
////
////        return new UserPrincipal(
////                user.getUserId(),
////                user.getUserTitle(),
//////                user.getChannelId(),
//////                user.getPassword(),
////                authorities
////        );
////    }
//
////    public Long getId() {
////        return id;
////    }
////
////
////
////    public String getAccessId() {
////		return accessId;
////	}
//
////	public void setAccessId(String accessId) {
////		this.accessId = accessId;
////	}
////
////	public int getChannelId() {
////		return channelId;
////	}
//
////	public void setChannelId(int channelId) {
////		this.channelId = channelId;
////	}
////
////	public void setId(Long id) {
////		this.id = id;
////	}
////
////	public void setPassword(String password) {
////		this.password = password;
////	}
//
//	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
//		this.authorities = authorities;
//	}
//
////	@Override
////    public String getPassword() {
////        return password;
////    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return authorities;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
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
//	public Long getUserId() {
//		return userId;
//	}
//
//	public void setUserId(Long userId) {
//		this.userId = userId;
//	}
//
//	public String getUserTitle() {
//		return userTitle;
//	}
//
//	public void setUserTitle(String userTitle) {
//		this.userTitle = userTitle;
//	}
//
////    @Override
////    public boolean equals(Object o) {
////        if (this == o) return true;
////        if (o == null || getClass() != o.getClass()) return false;
////        UserPrincipal that = (UserPrincipal) o;
////        return Objects.equals(id, that.id);
////    }
////
////    @Override
////    public int hashCode() {
////
////        return Objects.hash(id);
////    }
//
////	@Override
////	public String getUsername() {
////		return this.accessId;
////	}
//
//
//}