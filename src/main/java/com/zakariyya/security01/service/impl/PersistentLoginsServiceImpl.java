package com.zakariyya.security01.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zakariyya.security01.domain.PersistentLogins;
import com.zakariyya.security01.service.PersistentLoginsService;
import com.zakariyya.security01.mapper.PersistentLoginsMapper;
import org.springframework.stereotype.Service;

/**
* @author zakariyya
* @description 针对表【persistent_logins】的数据库操作Service实现
* @createDate 2023-12-15 13:09:06
*/
@Service
public class PersistentLoginsServiceImpl extends ServiceImpl<PersistentLoginsMapper, PersistentLogins>
    implements PersistentLoginsService{

}




