package io.github.raineye.archetypes.springbootquickstart.service.impl;

import io.github.raineye.archetypes.springbootquickstart.dao.SysUserMapper;
import io.github.raineye.archetypes.springbootquickstart.entity.SysUser;
import io.github.raineye.archetypes.springbootquickstart.exception.BusinessException;
import io.github.raineye.archetypes.springbootquickstart.service.LoginService;
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
