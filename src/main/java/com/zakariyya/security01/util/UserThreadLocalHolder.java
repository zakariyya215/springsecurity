package com.zakariyya.security01.util;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.zakariyya.security01.domain.Role;
import com.zakariyya.security01.domain.SysUser;
import com.zakariyya.security01.service.RoleService;
import org.springframework.security.authentication.BadCredentialsException;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public class UserThreadLocalHolder {
    private static final ThreadLocal<SysUser> CONTEXT = new ThreadLocal<>();
    public static void put(SysUser sysUser){
        CONTEXT.set(sysUser);
    }
    public static Optional<SysUser> get(){
        return Optional.ofNullable(CONTEXT.get());
    }
    public static void remove(){
        CONTEXT.remove();
    }
    //获取ThreadLocal中用户账号
    public static String getUsername(){
        SysUser user = CONTEXT.get();
        if (user == null){
            throw new BadCredentialsException("未登录");
        }
        return user.getUsername();
    }
}
