package com.zakariyya.security01.mapper;

import com.zakariyya.security01.domain.Role;
import com.zakariyya.security01.domain.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author zakariyya
* @description 针对表【ums_sys_user(后台用户表)】的数据库操作Mapper
* @createDate 2023-12-15 13:09:07
* @Entity com.zakariyya.security01.domain.SysUser
*/
public interface SysUserMapper extends BaseMapper<SysUser> {

    SysUser getUsersByUsername(@Param("username") String username);
}




