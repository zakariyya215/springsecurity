package com.zakariyya.security01.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class GiteeOAuthLoginVO {
    /**
     * access_token
     */
    private String accessToken;
    /**
     * token类型
     */
    private String tokenType;
    /**
     * refreshToken
     */
    private String refreshToken;
    /**
     * token创建时间
     */
    private Timestamp createdAt;
}
