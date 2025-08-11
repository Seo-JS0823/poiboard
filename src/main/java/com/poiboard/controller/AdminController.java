package com.poiboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.poiboard.domain.MenuDTO;
import com.poiboard.domain.UserDTO;
import com.poiboard.mapper.MenuMapper;
import com.poiboard.mapper.UserMapper;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private MenuMapper menuMapper;
	
	@Autowired
	private UserMapper userMapper;
	
	@GetMapping("/on")
	public String adminOn(HttpSession session) {
		/* 관리자임을 판단하기위해 UserController 에서 넣었던 admin 세션을 받아오자. */
		Boolean isAdmin = (Boolean) session.getAttribute("admin");
		UserDTO admin = (UserDTO) session.getAttribute("loginUser");
		
		/* 관리자임을 판단하려면 if문에서
		 * 잘 보면 세션을 받아올 때 boolean이 아니라 Boolean이다.
		 * 검증을 잘하기 위해 null 체크까지 하려면 primitive 타입이 아니라
		 * 그것을 감싼 래퍼타입인 Boolean 클래스를 사용해야 한다.
		 */
		if(isAdmin == null || !isAdmin || !admin.getUserid().equals("poiadmin")) {
			session.invalidate();
			
			/* 관리자가 아닌 경우 로그인 페이지로 보낸다. */
			return "redirect:/error/access";
		}
		
		/* 저 if 조건에 해당하지 않으면 관리자라는게 확실하니 바로 admin.jsp 페이지를 보여준다. */
		
		return "admin";
	}
	
	@GetMapping("/out")
	public String adminOut(HttpSession session) {
		/* 어드민 유저가 가지고 있던 세션을 전부 삭제한다. */
		session.invalidate();
		
		/* 어드민 로그아웃 시 로그인 페이지로 보낸다. */
		return "redirect:/";
	}
	
	/* 관리자 기능 [유저 목록 관리] */
	@GetMapping("/userList")
	public ModelAndView userList(HttpSession session) {
		ModelAndView mav = new ModelAndView();

		/* 관리자임을 판단하기위해 UserController 에서 넣었던 admin 세션을 받아오자. */
		Boolean isAdmin = (Boolean) session.getAttribute("admin");
		UserDTO admin = (UserDTO) session.getAttribute("loginUser");
		
		/* 관리자가 아닐 시 보낼 페이지 */
		if(isAdmin == null || !isAdmin || !admin.getUserid().equals("poiadmin")) {
			session.invalidate();
			
			/* 관리자가 아닌 경우 로그인 페이지로 보낸다. */
			mav.setViewName("error/access");
			return mav;
		}
		
		List<MenuDTO> menus = menuMapper.getMenuList();
		List<UserDTO> users = userMapper.getUserList();
		
		
		mav.addObject("users", users);
		mav.addObject("menus", menus);
		mav.setViewName("users/userlist");
		return mav;
	}
	
}
