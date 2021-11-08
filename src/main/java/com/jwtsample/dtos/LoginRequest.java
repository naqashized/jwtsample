package com.jwtsample.dtos;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class LoginRequest {
    @NotBlank
    private String accessId;

    @NotBlank
    private String password;
    
    @NotBlank
    private String username;

}
