package com.SE_8.closet.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping
public class TestController {
	
	@GetMapping("/test")
	public ResponseEntity<Map<String, Object>> list(){
		Map<String, Object> map = new HashMap<>();
		map.put("test", "success");
		
		return ResponseEntity.ok(map);
	}
}
