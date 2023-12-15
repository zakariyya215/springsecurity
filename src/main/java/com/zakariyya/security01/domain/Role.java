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
 * @TableName ums_role
 */
@TableName(value ="ums_role")
@Data
public class Role implements Serializable {
    /**
     * 角色id
     */
    @TableId(value = "role_id", type = IdType.AUTO)
    private Long roleId;

    /**
     * 角色标识
     */
    @TableField(value = "role_label")
    private String roleLabel;

    /**
     * 角色名字
     */
    @TableField(value = "role_name")
    private String roleName;

    /**
     * 排序
     */
    @TableField(value = "sort")
    private Integer sort;

    /**
     * 状态：0：可用，1：不可用
     */
    @TableField(value = "status")
    private Integer status;

    /**
     * 是否删除：0: 未删除，1：已删除
     */
    @TableField(value = "deleted")
    private Integer deleted;

    /**
     * 备注
     */
    @TableField(value = "remark")
    private String remark;

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