package com.zakariyya.security01.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 * 配置类的变化,多使用Lambda实现
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public UserDetailsService userDetailsService() {
        /*
         * 定义管理员信息
         * UserDetailService
         * UserDetail
         */
        UserDetails adminUser = User.withUsername("zhangsan")
                .password("$2a$10$6w8AAhUcRr7icQTxtauGE.G/xh9Gt7j6w/kSGLQoc5TkNlMRzF6E2")
                .roles("admin", "user")
                .build();
        UserDetails vipUser = User.withUsername("lisi")
                .password("$2a$10$6w8AAhUcRr7icQTxtauGE.G/xh9Gt7j6w/kSGLQoc5TkNlMRzF6E2")
                .roles("user")
                .build();
        //将用户信息存储到SpringSecurity中
        return new InMemoryUserDetailsManager(adminUser, vipUser);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //配置权限相关
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf(AbstractHttpConfigurer::disable);
        httpSecurity.authorizeHttpRequests(auth -> auth.requestMatchers("/toLogin").permitAll()
                .anyRequest().authenticated());
        //基于表单登录
        httpSecurity.formLogin(form -> form
                .loginPage("/toLogin")
                .loginProcessingUrl("/doLogin") // 处理前端登录请求
                .usernameParameter("username")
                .passwordParameter("password")
                .defaultSuccessUrl("/index")
                .failureUrl("/toLogin?error")
                .failureForwardUrl("/toLogin"));
        return httpSecurity.build();
    }

}