package com.jwtsample.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BasicUserInfoDTO {
    private long id;
    private String username;
}
