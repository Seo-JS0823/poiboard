package com.poiboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.poiboard.domain.BoardDTO;
import com.poiboard.domain.MenuDTO;
import com.poiboard.domain.UserDTO;
import com.poiboard.mapper.BoardMapper;
import com.poiboard.mapper.MenuMapper;
import com.poiboard.mapper.UserMapper;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardMapper boardMapper;
	
	@Autowired
	private MenuMapper menuMapper;
	
	@Autowired
	private UserMapper userMapper;
	
	@RequestMapping("/write")
	public ModelAndView boardWrite(@RequestParam("menuid") String menuid, BoardDTO boardDto, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
		/* 메뉴 리스트 */
		List<MenuDTO> menus = menuMapper.getMenuList();
		mav.addObject("menus", menus);
		
		/* 유저 검색 */
		UserDTO target = (UserDTO) session.getAttribute("loginUser");
		if(target == null || boardDto == null) {
			
			mav.setViewName("error/access");
			return mav;
		}
		
		/* 게시글 추가 */
		boardMapper.insertBoard(boardDto);
		
		mav.setViewName("redirect:/poi");
		return mav;
	}
	
	@GetMapping("/list")
	public String boardListForm(@RequestParam("menuid") String menuid, HttpSession session, Model model) {
		
		UserDTO loginUser = (UserDTO) session.getAttribute("loginUser");
		model.addAttribute("target", loginUser);
		
		List<MenuDTO> menus = menuMapper.getMenuList();
		model.addAttribute("menus", menus);
		
		MenuDTO menu = menuMapper.getMenu(menuid);
		model.addAttribute("menu", menu.getMenuname());
		
		if(loginUser == null) {
			session.invalidate();
			
			model.addAttribute("menuSee", "로그인을 해주세요.");
			
			return "login";
		}
		
		List<BoardDTO> boards = boardMapper.getBoardList(menuid);
		model.addAttribute("boards", boards);
		
		return "home/boardlist";
	}
	
	@GetMapping("/search")
	public String seacrhTitle(@RequestParam("search") String search, BoardDTO boardDto, Model model, HttpSession session) {
		UserDTO loginUser = (UserDTO) session.getAttribute("loginUser");
		model.addAttribute("target", loginUser);
		
		model.addAttribute("menu", "-- Search --");
		
		List<MenuDTO> menus = menuMapper.getMenuList();
		model.addAttribute("menus", menus);
		
		if(loginUser == null) {
			session.invalidate();
			
			model.addAttribute("menuSee", "로그인을 해주세요.");
			
			return "login";
		}
		
		List<BoardDTO> boards = boardMapper.searchTitle(search);
		model.addAttribute("boards", boards);
		
		return "home/boardlist";
	}
	
}
