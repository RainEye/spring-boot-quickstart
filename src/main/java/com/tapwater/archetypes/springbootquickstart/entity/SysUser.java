package com.tapwater.archetypes.springbootquickstart.entity;

import lombok.Data;

@Data
public class SysUser {

    private Integer id;

    private String username;

    private String password;
}
