package com.closet.SE8.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.closet.SE8.dto.UserDTO;
import com.closet.SE8.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/team8")
public class UserController {
	@Autowired
	UserService userService;
  
	@PostMapping("/join")
	public ResponseEntity<Void> join(@RequestBody UserDTO user, HttpServletRequest request) {
		user.setRole("normal");
		Long no = userService.join(user);
		System.out.println(no);
		return ResponseEntity.ok(null);
	}
}