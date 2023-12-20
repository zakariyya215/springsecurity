package com.zakariyya.security01.controller;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.zakariyya.security01.dto.GiteeOAuthLoginVO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("oauth")
public class OAuthController {
    @Value("${spring.security.oauth2.client.registration.gitee.client-id}")
    private String clientId;
    @Value("${spring.security.oauth2.client.registration.gitee.client-secret}")
    private String clientSecret;
    @Value("${spring.security.oauth2.client.registration.gitee.authorization-grant-type}")
    private String authorizationGrantType;
    @Value("${spring.security.oauth2.client.registration.gitee.redirect-uri}")
    private String redirectUri;
    @Value("${spring.security.oauth2.client.provider.gitee.authorization-uri}")
    private String authorizationUri;
    @Value("${spring.security.oauth2.client.provider.gitee.token-uri}")
    private String tokenUri;
    @Value("${spring.security.oauth2.client.provider.gitee.user-info-uri}")
    private String userInfoUri;


    //gitee回调
    @GetMapping("notify")
    public String oauthNotify(@RequestParam("code")String code){
        //获取Token
        Map<String,Object> map = new HashMap<>();
        map.put("grant_type",authorizationGrantType);
        map.put("code",code);
        map.put("client_id",clientId);
        map.put("client_secret",clientSecret);
        map.put("redirect_uri",redirectUri);
        //通过code获取access_token
        String post = HttpUtil.post(tokenUri, map);
        System.out.println(post);
        GiteeOAuthLoginVO giteeBody = JSONUtil.toBean(post, GiteeOAuthLoginVO.class);
        String userInfo = HttpUtil.get(userInfoUri + "?access_token=" + giteeBody.getAccessToken());
        return (String) JSONUtil.parseObj(userInfo).get("name");
    }
}
