package com.poiboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poiboard.domain.MenuDTO;
import com.poiboard.domain.UserDTO;
import com.poiboard.mapper.MenuMapper;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/menu")
public class MenuController {
	
	@Autowired
	private MenuMapper menuMapper;
	
	/* 메뉴 추가 폼 보여주기 */
	@GetMapping("/addForm")
	public String menuAddForm(HttpSession session, Model model) {
		/* 메뉴 추가는 관리자만 할 수 있으니 관리자 인지 검증한다. */
		Boolean isAdmin = (Boolean) session.getAttribute("admin");
		
		/* 관리자가 아니라면 에러 페이지로 보낸다. */
		if(isAdmin == null || !isAdmin) {
			
			return "";
		}
		
		/* 메뉴 리스트 불러오기 */
		List<MenuDTO> menuList = menuMapper.getMenuList();
		
		/* 모델에 담기 */
		model.addAttribute("menuList", menuList);
		
		/* if문에 안 걸러지면 관리자이니까 메뉴추가 폼을 보여준다. */
		return "menus/addmenu";
	}
	
	/* 메뉴 추가 로직 */
	@PostMapping("/add")
	public String menuAdd(@RequestParam String menuname,HttpSession session, Model model) {
		/* 메뉴 추가는 관리자만 할 수 있으니 관리자 인지 검증한다. */
		Boolean isAdmin = (Boolean) session.getAttribute("admin");
		
		menuMapper.addMenu(menuname);
		
		/* 관리자가 아니라면 에러 페이지로 보낸다. */
		if(isAdmin == null || !isAdmin) {
			
			return "";
		}
		
		return "redirect:/menu/addForm";
	}
	
	/* 일반 사용자도 볼 수 있는 메뉴 목록 */
	@GetMapping("/list")
	public String menuList(HttpSession session,Model model) {
		
		/* 로그인해야 볼 수 있게 Session으로 사용자를 검사한다. */
		UserDTO user = (UserDTO) session.getAttribute("loginUser");
		
		/* 로그인하지 않았으면 볼 수 없다. 누가 로그인을 했던 중요하지 않고
		 * 단지 로그인했다는 사실이 중요하다고 생각해서 null 체크만 했다. 
		 */
		if(user == null) {
			model.addAttribute("menuSee", "메뉴 목록은 로그인해야 볼 수 있습니다.");
			
			return "login";
		}
		
		List<MenuDTO> menuList = menuMapper.getMenuList();
		
		model.addAttribute("menuList", menuList);
		
		return "menus/menulist";
	}
	
}
