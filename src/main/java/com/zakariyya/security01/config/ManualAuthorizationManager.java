package com.zakariyya.security01.config;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.zakariyya.security01.domain.Menu;
import com.zakariyya.security01.mapper.MenuMapper;
import com.zakariyya.security01.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.access.intercept.RequestAuthorizationContext;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.function.Supplier;

@Slf4j
@Component
public class ManualAuthorizationManager implements AuthorizationManager<RequestAuthorizationContext> {
    private final MenuService menuService;

    public ManualAuthorizationManager(MenuService menuService) {
        this.menuService = menuService;
    }

    @Override
    public AuthorizationDecision check(Supplier<Authentication> authentication, RequestAuthorizationContext requestAuthorizationContext) {
        String uri = requestAuthorizationContext.getRequest().getRequestURI();
        StringBuffer url = requestAuthorizationContext.getRequest().getRequestURL();
        log.info("uri=============>{}",uri);
        log.info("url=============>{}",url);
        //一种是不需要校验的路径
        if ("/logout".equals(uri) || "/auth/login".equals(uri) || "/error".equals(uri)){
            return new AuthorizationDecision(true);
        }
        //一种是没有权限要求的路径
        Menu menu = menuService.getOne(Wrappers.lambdaQuery(Menu.class)
                .eq(Menu::getPath, uri));
        if (menu == null || StringUtils.isEmpty(menu.getPerms())){
            return new AuthorizationDecision(true);
        }
        //与用户访问权限集合
        Collection<? extends GrantedAuthority> authorities = authentication.get().getAuthorities();
        for (GrantedAuthority authority : authorities) {
            String perms = menu.getPerms();
            if (authority.equals(perms)){
                return new AuthorizationDecision(true);
            }
        }
        return new AuthorizationDecision(false);
    }
}
