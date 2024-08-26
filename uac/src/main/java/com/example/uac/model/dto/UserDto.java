package com.example.uac.model.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain=true)
public class UserDto {

    private String username;

    private String password;
}
