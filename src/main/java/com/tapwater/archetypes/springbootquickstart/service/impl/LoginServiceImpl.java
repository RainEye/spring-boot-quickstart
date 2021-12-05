package com.tapwater.archetypes.springbootquickstart.service.impl;

import com.tapwater.archetypes.springbootquickstart.dao.SysUserMapper;
import com.tapwater.archetypes.springbootquickstart.entity.SysUser;
import com.tapwater.archetypes.springbootquickstart.exception.BusinessException;
import com.tapwater.archetypes.springbootquickstart.service.LoginService;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    private SysUserMapper sysUserMapper;

    public LoginServiceImpl(SysUserMapper sysUserMapper) {
        this.sysUserMapper = sysUserMapper;
    }

    @Override
    public void login(String username, String password) {
        SysUser sysUser = sysUserMapper.selectByUsername(username);
        // 示例不做密码校验，正式环境需要
        if(sysUser == null) {
            throw new BusinessException("用户名或密码错误");
        }
    }
}
