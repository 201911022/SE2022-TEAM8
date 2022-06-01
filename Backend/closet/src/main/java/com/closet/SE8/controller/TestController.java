package com.closet.SE8.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

  @GetMapping("/")
  public ResponseEntity<Map<String, Object>> test() {
	  Map<String, Object> map = new HashMap<>();
	  map.put("Test", "Success");
    return ResponseEntity.ok(map);
  }
}