package com.poiboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.poiboard.domain.UserDTO;
import com.poiboard.mapper.UserMapper;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	
	/* Autowired 애노테이션으로 UserMapper 구현체에 대해서 의존성을 주입받기 */
	@Autowired
	private UserMapper userMapper;
	
	/* 회원가입 폼 */
	@GetMapping("/signinForm")
	public String signinForm() {
		return "signin";
	}
	
	/* 회원가입 로직 */
	@PostMapping("/signin")
	public String signin(UserDTO user) {
		/* 사용자 추가하기 */
		userMapper.addUser(user);
		
		return "redirect:/";
	}
	
	/* 로그인 로직 */
	@PostMapping("/login")
	public String login(UserDTO user, HttpSession session, Model model) {
		UserDTO target = userMapper.getUser(user);
		
		/* 로그인에 실패하면 보낼 로그인 재시도 페이지 */
		if(target == null) {
			model.addAttribute("errorMsg", "존재하지 않는 아이디입니다.");
			
			return "login";
		}
		
		/* 로그인한 유저의 세션에 유저 정보를 저장시킨다. */
		session.setAttribute("loginUser", target);
		
		/* 로그인 성공 테스트 */
		System.out.println(target);
		
		/* 관리자인 경우의 로직 */
		if(target.getUserid().equals("poiadmin")) {
			session.setAttribute("admin", true);
			
			return "redirect:/admin/on";
		}
		
		/* 로그인하면 보여줄 페이지 */
		return "redirect:/poi";
	}
	
}
