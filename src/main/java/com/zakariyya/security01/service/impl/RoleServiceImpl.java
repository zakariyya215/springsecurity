package com.zakariyya.security01.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zakariyya.security01.domain.Role;
import com.zakariyya.security01.service.RoleService;
import com.zakariyya.security01.mapper.RoleMapper;
import org.springframework.stereotype.Service;

/**
* @author zakariyya
* @description 针对表【ums_role】的数据库操作Service实现
* @createDate 2023-12-15 13:09:06
*/
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role>
    implements RoleService{

}




