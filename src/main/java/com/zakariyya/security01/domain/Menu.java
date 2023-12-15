package com.zakariyya.security01.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 
 * @TableName ums_menu
 */
@TableName(value ="ums_menu")
@Data
public class Menu implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 父id
     */
    @TableField(value = "parent_id")
    private Long parentId;

    /**
     * 菜单名
     */
    @TableField(value = "menu_name")
    private String menuName;

    /**
     * 访问路径
     */
    @TableField(value = "path")
    private String path;

    /**
     * 排序
     */
    @TableField(value = "sort")
    private Integer sort;

    /**
     * 权限标识
     */
    @TableField(value = "perms")
    private String perms;

    /**
     * 类型：0，目录，1菜单，2：按钮
     */
    @TableField(value = "menu_type")
    private Integer menuType;

    /**
     * 图标
     */
    @TableField(value = "icon")
    private String icon;

    /**
     * 是否删除
     */
    @TableField(value = "deleted")
    private Integer deleted;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    @TableField(value = "update_time")
    private LocalDateTime updateTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}