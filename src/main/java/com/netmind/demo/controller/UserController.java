package com.netmind.demo.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netmind.demo.model.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class UserController {

	@PostMapping("user")
	public ResponseEntity<User> login(@RequestParam("user") String username,
			@RequestParam("password") String pwd) {

		String token = getJWTToken(username);
		User user = new User();
		user.setUserName(username);
		user.setPwd(pwd);
		user.setToken(token);

		if (!user.getUserName().equals("test") || !user.getPwd().equals("test"))
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);

		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	private String getJWTToken(String username) {
		String claveSecreta = "miClaveSecreta";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER");

		String token = Jwts.builder().setId("softtekJWT").setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512, claveSecreta.getBytes())
				.compact();

		return "Bearer " + token;
	}

}