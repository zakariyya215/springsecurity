package com.zakariyya.security01;

import com.zakariyya.security01.util.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
class Security01ApplicationTests {
	@Resource
	private JwtUtils jwtUtils;

	@Test
	void contextLoads() {
		Map<String, Object> tokenMap = new HashMap<>();
		tokenMap.put("id",1L);
		tokenMap.put("username","docker");
		tokenMap.put("perms", Stream.of("p1","p2","p3").collect(Collectors.toSet()));
		String token = jwtUtils.generateToken(tokenMap);
		System.out.println(jwtUtils.parseToken(token));
	}

}
