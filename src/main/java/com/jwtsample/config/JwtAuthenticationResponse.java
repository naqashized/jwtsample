package com.jwtsample.config;

import com.jwtsample.models.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtAuthenticationResponse {
    private String accessToken;
    private String tokenType = "Bearer";
    private User userInfo;

    public JwtAuthenticationResponse(String accessToken, Object userInfo) {
        this.accessToken = accessToken;
        this.userInfo = (User) userInfo;
    }

    
}
