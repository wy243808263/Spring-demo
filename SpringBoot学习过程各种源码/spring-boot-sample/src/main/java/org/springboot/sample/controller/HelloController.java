package org.springboot.sample.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {
	
	@RequestMapping
	public String hello() {
		return "Hello Spring-Boot";
	}

	@RequestMapping("/info")
	public Map<String, String> getInfo(@RequestParam String name) {
		Map<String, String> map = new HashMap<>();
		map.put("name", name);
		if(true)
			throw new RuntimeException("错误");
		return map;
	}

	@RequestMapping("/list")
	public List<Map<String, String>> getList() {
		List<Map<String, String>> list = new ArrayList<>();
		Map<String, String> map = null;
		for (int i = 1; i <= 5; i++) {
			map = new HashMap<>();
			map.put("name", "Shanhy-" + i);
			list.add(map);
		}
		return list;
	}
	
}
