package io.github.raineye.archetypes.springbootquickstart.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.raineye.archetypes.springbootquickstart.entity.SysUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface SysUserMapper extends BaseMapper<SysUser> {

    @Select("select username, password from sys_user where username=#{username}")
    SysUser selectByUsername(@Param("username") String username);
}
