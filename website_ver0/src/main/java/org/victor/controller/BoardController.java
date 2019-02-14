package org.victor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.victor.domain.BoardVO;
import org.victor.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@AllArgsConstructor
@RequestMapping("/board/*")
public class BoardController {
	
	
	private BoardService service;
	
	
	@GetMapping("/list")
	public void getList( Model model ) {

		model.addAttribute("list", service.getList() );
	}
	
	
	@GetMapping( {"/get", "/modify"} )
	public void get( @RequestParam("bno") Long bno, Model model ) {
		
		model.addAttribute("board", service.get(bno));
	}
	
	@GetMapping("/register")
	public void register() {
		
	}
	
	@PostMapping("/register")
	public String register( BoardVO board, RedirectAttributes rttr ) {
		
		service.register(board);
		rttr.addFlashAttribute( "result", board.getBno() );
			
		return "redirect:/board/list";
	}
	
	
	@PostMapping("/modify")
	public String modify( BoardVO board, RedirectAttributes rttr ) {
		
		if( service.modify(board) ) 
			rttr.addFlashAttribute( "result", "success" );
		
		return "redirect:/board/list";
	}
	
	
	@PostMapping("/remove")
	public String remove( @RequestParam("bno") Long bno, RedirectAttributes rttr) {
		
		if( service.remove(bno) )
			rttr.addFlashAttribute( "result", "success" );
		
		return "redirect:/board/list";
	}
}






























