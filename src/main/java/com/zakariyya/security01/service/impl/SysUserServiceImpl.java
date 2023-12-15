package com.zakariyya.security01.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zakariyya.security01.domain.SysUser;
import com.zakariyya.security01.dto.LoginParam;
import com.zakariyya.security01.service.SysUserService;
import com.zakariyya.security01.mapper.SysUserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
* @author zakariyya
* @description 针对表【ums_sys_user(后台用户表)】的数据库操作Service实现
* @createDate 2023-12-15 13:09:07
*/
@Slf4j
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser>
    implements SysUserService{
    private final AuthenticationManager authenticationManager;

    public SysUserServiceImpl(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public String login(LoginParam loginParam) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginParam.getUsername(), loginParam.getPassword());
        //会自动调用loadUserByUsername方法，返回的结果就是UserDetails
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        SysUser user = (SysUser) authenticate.getPrincipal();
        //生成一个Token返回给前端
        String token = UUID.randomUUID().toString().replace("-", "");
        log.info("登录的用户信息:{}",user);
        return token;
    }
}




