package com.zakariyya.security01.filter;

import com.zakariyya.security01.domain.SysUser;
import com.zakariyya.security01.util.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 捕获请求中的请求头，判断是否可以获取到用户信息
 * 使用Authentication告知，将信息存储在SecurityContext -> SecurityContextHolder
 * 登录的时候请求中包含用户名和密码
 * 后面的请求判断权限时，只需要用户的信息（不包含密码）即可
 */
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final JwtUtils jwtUtils;

    public JwtAuthenticationFilter(JwtUtils jwtUtils) {
        this.jwtUtils = jwtUtils;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("Authorization");
        //login请求没有token直接放行
        if (token == null) {
            doFilter(request, response, filterChain);
            return;
        }
        //有Token时，通过JWT工具类解析用户信息
        Claims claims = jwtUtils.parseToken(token);
        if (claims == null) {
            doFilter(request, response, filterChain);
            return;
        }
        Long id = claims.get("id", Long.class);
        String username = claims.get("username", String.class);
        List<String> perms = claims.get("perms", ArrayList.class);
        Set<String> permsSet = new HashSet<>(perms);
        SysUser user = new SysUser();
        user.setId(id);
        user.setUsername(username);
        user.setPermissions(permsSet);
        System.out.println(user);
//        throw new BadCredentialsException("登录暂停");
        //获取到用户信息后，需要将用户信息告知SpringSecurity，SpringSecurity会判断是否包含接口权限
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, null, user.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        //放行
        doFilter(request, response, filterChain);
    }
}
