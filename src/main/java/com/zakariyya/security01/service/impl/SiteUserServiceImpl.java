package com.zakariyya.security01.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zakariyya.security01.domain.SiteUser;
import com.zakariyya.security01.service.SiteUserService;
import com.zakariyya.security01.mapper.SiteUserMapper;
import org.springframework.stereotype.Service;

/**
* @author zakariyya
* @description 针对表【ums_site_user(外部用户表)】的数据库操作Service实现
* @createDate 2023-12-15 13:09:07
*/
@Service
public class SiteUserServiceImpl extends ServiceImpl<SiteUserMapper, SiteUser>
    implements SiteUserService{

}




