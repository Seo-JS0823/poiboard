package com.poiboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.poiboard.domain.MenuDTO;
import com.poiboard.domain.UserDTO;
import com.poiboard.mapper.MenuMapper;

import jakarta.servlet.http.HttpSession;

@Controller
public class RootController {

	@Autowired
	private MenuMapper menuMapper;
	
	@GetMapping("/")
	public String root(HttpSession session, Model model) {
		/* 세션이 추가되면 if문으로 각자 다른 경로로 return */
		
		
		/* 메뉴 목록 보여주기 */
		List<MenuDTO> menus = menuMapper.getMenuList();
		
		model.addAttribute("menus", menus);
		
		/* 나중에 분리해야될 로직인 것 같은데 이미 로그인한 유저가 루트 컨텍스트로 갈 때
		 * home/poi로 가야됨.
		 */
		UserDTO loginUser = (UserDTO) session.getAttribute("loginUser");
		
		System.out.println(loginUser);
		
		if(loginUser != null) {
			
			return "redirect:/poi";
		}
		
		/* 처음 들어오면 로그인 페이지를 보여주자. */
		return "login";
	}
}
