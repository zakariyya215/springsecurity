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
 * @TableName persistent_logins
 */
@TableName(value ="persistent_logins")
@Data
public class PersistentLogins implements Serializable {
    /**
     * 
     */
    @TableId(value = "series")
    private String series;

    /**
     * 
     */
    @TableField(value = "username")
    private String username;

    /**
     * 
     */
    @TableField(value = "token")
    private String token;

    /**
     * 
     */
    @TableField(value = "last_used")
    private LocalDateTime lastUsed;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}