package com.poiboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.poiboard.domain.UserDTO;

import jakarta.servlet.http.HttpSession;

@Controller
public class RootController {

	@GetMapping("/")
	public String root(HttpSession session) {
		/* 세션이 추가되면 if문으로 각자 다른 경로로 return */
		
		/* 나중에 분리해야될 로직인 것 같은데 이미 로그인한 유저가 루트 컨텍스트로 갈 때
		 * home/poi로 가야됨.
		 */
		UserDTO loginUser = (UserDTO) session.getAttribute("loginUser");
		
		if(loginUser != null) {
			
			return "home/poi";
		}
		
		/* 처음 들어오면 로그인 페이지를 보여주자. */
		return "login";
	}
}
