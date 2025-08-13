package com.poiboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.poiboard.domain.MenuDTO;
import com.poiboard.domain.UserDTO;
import com.poiboard.mapper.MenuMapper;
import com.poiboard.mapper.UserMapper;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	
	/* Autowired 애노테이션으로 UserMapper 구현체에 대해서 의존성을 주입받기 */
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private MenuMapper menuMapper;
	
	/* 회원가입 폼 */
	@GetMapping("/signinForm")
	public String signinForm(Model model) {
		List<MenuDTO> menus = menuMapper.getMenuList();
		
		model.addAttribute("menus", menus);
		
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
		List<MenuDTO> menus = menuMapper.getMenuList();
		
		model.addAttribute("menus", menus);
		
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
	
	/* 로그아웃 로직 */
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		/* 세션 삭제 */
		session.invalidate();
		
		/* 로그아웃 하면 보여줄 루트 컨텍스트 */
		return "redirect:/";
	}
	
	/* 유저 정보 변경 폼 보여주기 */
	@GetMapping("/updateUserForm")
	public ModelAndView updateUser(HttpSession session, UserDTO user) {
		ModelAndView mav = new ModelAndView();
		
		/* 유저 검색 */
		UserDTO target = (UserDTO) session.getAttribute("loginUser");
		if(target == null) {
			
			mav.setViewName("error/access");
			return mav;
		}
		mav.addObject("target", target);
		
		
		/* 메뉴 리스트 */
		List<MenuDTO> menus = menuMapper.getMenuList();
		mav.addObject("menus", menus);
		
		/* 보여줄 페이지 */
		mav.setViewName("users/update");
		return mav;
	}
	
	/* 유저 정보 변경 로직 */
	
}
