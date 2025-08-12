package com.poiboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.poiboard.domain.BoardDTO;
import com.poiboard.domain.MenuDTO;
import com.poiboard.domain.UserDTO;
import com.poiboard.mapper.BoardMapper;
import com.poiboard.mapper.MenuMapper;
import com.poiboard.mapper.UserMapper;
import com.poiboard.service.BoardService;
import com.poiboard.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardMapper boardMapper;
	
	@Autowired
	private MenuMapper menuMapper;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private BoardService boardService;
	
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
		
		/* 게시글 추가에 따른 포인트 증가 로직 */
		int upPoint = userService.plusPoint(target.getPoint(), boardDto.getContent());
		target.setPoint(upPoint);
		userMapper.contentPlusPoint(target);
		
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
	public String searchTitle(@RequestParam("search") String search, Model model, HttpSession session) {
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
	
	@GetMapping("/content")
	public String searchIdxContent(@RequestParam("idx") int idx, HttpSession session, Model model) {
		UserDTO loginUser = (UserDTO) session.getAttribute("loginUser");
		model.addAttribute("target", loginUser);
		
		List<MenuDTO> menus = menuMapper.getMenuList();
		model.addAttribute("menus", menus);
		
		if(loginUser == null) {
			session.invalidate();
			
			model.addAttribute("menuSee", "로그인을 해주세요.");
			
			return "login";
		}
		
		BoardDTO content = boardMapper.getIdxContent(idx);
		
		/* 조회수 증가 */
		
		content.setHit(boardService.hitCount(content.getHit()));
		boardMapper.hitUp(content);
		
		/* 모델에 조회수 추가 로직 적용 후 등록 (DB에서 해도 됨) */
		model.addAttribute("content", content);
		
		return "home/content";
	}
	
}
