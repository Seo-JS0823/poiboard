package com.poiboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.poiboard.domain.MenuDTO;
import com.poiboard.domain.UserDTO;
import com.poiboard.mapper.MenuMapper;
import com.poiboard.mapper.UserMapper;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	
	@Autowired
	private MenuMapper menuMapper;
	
	@Autowired
	private UserMapper userMapper;
	
	/* 홈 화면 보여주기 */
	@GetMapping("/poi")
	public ModelAndView homeForm(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
		UserDTO loginUser = (UserDTO) session.getAttribute("loginUser");
		
		List<MenuDTO> menus = menuMapper.getMenuList();
		
		if(loginUser != null) {
			mav.addObject("target", loginUser);
		}
		
		mav.addObject("menus", menus);
		mav.setViewName("home/poi");
		return mav;
	}
}
