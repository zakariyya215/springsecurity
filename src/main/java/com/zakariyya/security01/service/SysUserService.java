package com.zakariyya.security01.service;

import com.zakariyya.security01.domain.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zakariyya.security01.dto.LoginParam;

/**
* @author zakariyya
* @description 针对表【ums_sys_user(后台用户表)】的数据库操作Service
* @createDate 2023-12-15 13:09:07
*/
public interface SysUserService extends IService<SysUser> {

    String login(LoginParam loginParam);
}
