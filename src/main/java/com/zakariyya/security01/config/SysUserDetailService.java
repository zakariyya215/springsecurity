package com.zakariyya.security01.config;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.zakariyya.security01.domain.SysUser;
import com.zakariyya.security01.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class SysUserDetailService implements UserDetailsService {
    private final SysUserService userService;

    public SysUserDetailService(SysUserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("loadUserByUsername============");
        return userService.getOne(Wrappers.lambdaQuery(SysUser.class)
                .eq(SysUser::getUsername, username));
    }
}
