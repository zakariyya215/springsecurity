package com.zakariyya.security01;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class Security01ApplicationTests {
	@Resource
	private PasswordEncoder passwordEncoder;

	@Test
	void contextLoads() {
		//生成密码加密后的字符串
		String pwd = "pwd";
		passwordEncoder.encode(pwd);
	}

}
