package com.closet.SE8.controller;

import java.util.HashMap;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.closet.SE8.dto.UserDTO;
import com.closet.SE8.entities.UserEntity;
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
	
	@PostMapping("/login")
	public ResponseEntity<Void> login(@RequestBody HashMap<String, String> map, HttpServletRequest request){
		HttpSession session = request.getSession();
		if(userService.login(map)) {
			session.setAttribute("loginId", map.get("userId"));
			return ResponseEntity.ok(null);
		}
		else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}
	
	@PostMapping("/logout")  
	public ResponseEntity<Void> logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
        session.invalidate();
        request.getSession(true);
        return ResponseEntity.ok(null);
	}
	
	@PostMapping("/update/pw/{id}")
	public ResponseEntity<Void> updatePw(@PathVariable(name="id") String id, @RequestBody HashMap<String, String> map, HttpServletRequest request){
		if(userService.updatePassword(map, id)) {
			return ResponseEntity.ok(null);
		}
		else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}
	
	@PostMapping("/update/info/{id}")
	public ResponseEntity<Void> updateInfo(@PathVariable(name="id") String id, @RequestBody HashMap<String, String> map, HttpServletRequest request){
		if(userService.updateInfo(map, id)) {
			return ResponseEntity.ok(null);
		}
		else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}
	
	@PostMapping("/delete/{id}")
	public ResponseEntity<Void> delete(@PathVariable(name="id") String id, HttpServletRequest request){
		if(userService.delete(id)) {
			return ResponseEntity.ok(null);
		}
		else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}
	
	@GetMapping("/myinfo/{id}")
	public ResponseEntity<Optional<UserEntity>> myinfo(@PathVariable(name="id") String id, HttpServletRequest request){
		if(id == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
		Optional<UserEntity> user = userService.myinfo(id);
        return ResponseEntity.ok(user);
	}
}