package com.zakariyya.security01.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zakariyya.security01.domain.Menu;
import com.zakariyya.security01.service.MenuService;
import com.zakariyya.security01.mapper.MenuMapper;
import org.springframework.stereotype.Service;

/**
* @author zakariyya
* @description 针对表【ums_menu】的数据库操作Service实现
* @createDate 2023-12-15 13:09:06
*/
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu>
    implements MenuService{

}




