package com.poiboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {

	@GetMapping("/")
	public String root() {
		/* 세션이 추가되면 if문으로 각자 다른 경로로 return */
		
		
		/* 처음 들어오면 로그인 페이지를 보여주자. */
		return "login";
	}
}
