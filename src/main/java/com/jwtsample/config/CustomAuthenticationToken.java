package com.jwtsample.config;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class CustomAuthenticationToken extends UsernamePasswordAuthenticationToken {

    private String channelId;

    public CustomAuthenticationToken(Object principal, Object credentials, String channelId) {
        super(principal, credentials);
        this.channelId = channelId;
        super.setAuthenticated(false);
    }

    public CustomAuthenticationToken(Object principal, Object credentials, String channelId, 
        Collection<? extends GrantedAuthority> authorities) {
        super(principal, credentials, authorities);
        this.channelId = channelId;
        super.setAuthenticated(true); // must use super, as we override
    }

    public String getChannelId() {
        return this.channelId;
    }
}
