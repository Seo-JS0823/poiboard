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
			
			return "error/access";
		}
		
		/* 메뉴 리스트 불러오기 */
		List<MenuDTO> menuList = menuMapper.getMenuList();
		
		/* 모델에 담기 */
		model.addAttribute("menuList", menuList);
		
		List<MenuDTO> menus = menuMapper.getMenuList();
		
		model.addAttribute("menus", menus);
		
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
			session.invalidate();
			
			return "error/access";
		}
		
		return "redirect:/menu/addForm";
	}
	
	/* 메뉴 업데이트 폼 보여주기 */
	@GetMapping("/upd")
	public String menuUpdateForm(@RequestParam("menuid") String menuid, Model model, HttpSession session) {
		/* 메뉴 추가는 관리자만 할 수 있으니 관리자 인지 검증한다. */
		Boolean isAdmin = (Boolean) session.getAttribute("admin");
		
		/* 관리자가 아니라면 에러 페이지로 보낸다. */
		if(isAdmin == null || !isAdmin) {
			session.invalidate();
			
			return "error/access";
		}
		
		/* 상단 헤더에 보여줄 메뉴 목록 가져오기 */
		List<MenuDTO> menus = menuMapper.getMenuList();
		model.addAttribute("menus", menus);
		
		/* 업데이트 할 메뉴 아이디 히든 태그에 추가하기 */
		model.addAttribute("menuid", menuid);
		
		return "menus/menuupdate";
	}
	
	/* 메뉴 업데이트 로직 */
	@PostMapping("/update_run")
	public String menuUpdateRun(@RequestParam("menuid") String menuid, @RequestParam("menuname") String menuname) {
		
		menuMapper.updateMenuname(menuid, menuname);
		
		return "redirect:/admin/on";
	}
	
	/* 메뉴 삭제 로직 */
	@GetMapping("/del")
	public String menuDelete(@RequestParam("menuid") String menuid) {
		menuMapper.deleteMenu(menuid);
		
		return "redirect:/menu/addForm";
	}
	
}
