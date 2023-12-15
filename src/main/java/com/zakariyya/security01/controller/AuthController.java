package com.zakariyya.security01.controller;

import com.zakariyya.security01.dto.LoginParam;
import com.zakariyya.security01.service.SysUserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
public class AuthController {
    private final SysUserService userService;

    public AuthController(SysUserService userService) {
        this.userService = userService;
    }

    /**
     * 登录方法
     * @return Token令牌
     */
    @PostMapping("login")
    public String login(@RequestBody LoginParam loginParam){
        return userService.login(loginParam);
    }
}
