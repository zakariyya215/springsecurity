package com.zakariyya.security01.mapper;

import com.zakariyya.security01.domain.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author zakariyya
* @description 针对表【ums_menu】的数据库操作Mapper
* @createDate 2023-12-15 13:09:06
* @Entity com.zakariyya.security01.domain.Menu
*/
public interface MenuMapper extends BaseMapper<Menu> {

    List<String> getPermissionsByRoleIds(@Param("roleIdList") List<Long> roleIdList);
}




