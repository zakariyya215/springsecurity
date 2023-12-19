package com.zakariyya.security01.config;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.zakariyya.security01.domain.Menu;
import com.zakariyya.security01.domain.Role;
import com.zakariyya.security01.domain.SysUser;
import com.zakariyya.security01.mapper.MenuMapper;
import com.zakariyya.security01.mapper.SysUserMapper;
import com.zakariyya.security01.service.MenuService;
import com.zakariyya.security01.service.SysUserService;
import com.zakariyya.security01.util.JwtUtils;
import jakarta.annotation.Resource;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Slf4j
@Service
public class SysUserDetailService implements UserDetailsService {
    private final SysUserMapper userMapper;
    private final MenuMapper menuMapper;

    public SysUserDetailService(SysUserMapper userMapper, MenuMapper menuMapper) {
        this.userMapper = userMapper;
        this.menuMapper = menuMapper;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("loadUserByUsername============>");
//        SysUser user = userService.getOne(Wrappers.lambdaQuery(SysUser.class)
//                .eq(SysUser::getUsername, username));
//        if (user != null) {
            //1.查询用户信息
            SysUser sysUser = userMapper.getUsersByUsername(username);
            log.info("{}",sysUser);
            if (sysUser != null){
                Set<Role> roleSet = sysUser.getRoleSet();
                sysUser.setRoleSet(roleSet);
                List<Long> roleIds = roleSet.stream().map(Role::getRoleId).toList();
                if (CollectionUtils.isNotEmpty(roleIds)){
                    //2.查询用户的权限信息
                    List<Menu> menuList = menuMapper.getPermissionsByRoleIds(roleIds);
                    Set<String> menuSet = menuList.stream().map(Menu::getPerms).collect(Collectors.toSet());
                    sysUser.setPermissions(menuSet);
                }
            }
        return sysUser;
    }
}
