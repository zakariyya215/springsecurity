package com.zakariyya.security01.controller;

import com.zakariyya.security01.dto.MyUser;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@EnableMethodSecurity
public class TestController {

    @GetMapping("test")
    public String test(){
        return "";
    }
    /**
     * 测试@PreAuthorize
     * 拥有指定权限才可访问
     * 语法为Spring EL语言
     */
    @PreAuthorize("hasAuthority('test:show')")
    @GetMapping("pre/test")
    public String show(){
        return "showed";
    }

    /**
     * 处理完成后，方法返回时的校验
     * 此处的功能为返回的结果长度大于3时合法
     */
    @PostAuthorize("returnObject.length() > 3")
    @GetMapping("post/result")
    public String result(){
        return "showed";
    }
    /**
     * 过滤符合条件的数据返回
     */
    @PostFilter("filterObject.length() > 3")
    @GetMapping("user/list")
    public List<String> userList(){
        System.out.println("返回用户名");
        return Stream.of("1","11","111").collect(Collectors.toList());
    }
    /**
     * 筛选符合条件的数据，数据必须为Collection,Map,Array
     */
    @PreFilter(value = "filterObject.username.length() > 2")
    @PostMapping("addUser")
    public List<MyUser> addUser(@RequestBody List<MyUser> userList){
        userList.forEach(System.out::println);
        return userList;
    }

}
