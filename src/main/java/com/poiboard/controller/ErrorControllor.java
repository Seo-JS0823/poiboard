package com.poiboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error")
public class ErrorControllor {
	
	@GetMapping("/access")
	public String accessNot() {
		
		return "error/access";
	}
}
