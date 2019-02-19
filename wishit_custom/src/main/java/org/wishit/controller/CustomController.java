package org.wishit.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.wishit.domain.AccountVO;
import org.wishit.domain.CustomVO;
import org.wishit.service.CustomService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/wishit/*")
@Log4j
public class CustomController {

	@Setter( onMethod_ = @Autowired )
	private CustomService service;
	
	
	@GetMapping("/list")
	public void getList(Model model) {

		Map<String, Object> map = service.getList();
		
		model.addAttribute("custom", map.get("custom"));
		model.addAttribute("account", map.get("account"));
	}
	
//	@GetMapping("/get")
	public void get(@RequestParam("busiNum") String busiNum, Model model) {
		
		Map<String, Object> map = service.get(busiNum);
		
		model.addAttribute("custom", map.get("custom"));
		model.addAttribute("account", map.get("account"));
	}
	
	@PostMapping("/insert")
	public void insert( CustomVO custom, AccountVO account ) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("custom", custom);
		map.put("account", account);
		service.insert(map);
	}
	
	@PostMapping("/update")
	public void update( CustomVO custom, AccountVO account ) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("custom", custom);
		map.put("account", account);
		
		service.update(map);
		
	}
	
	@PostMapping
	public void delete(@RequestParam("busiNum") String busiNum) {
		
		service.delete(busiNum);
	}
	
	
	
}



















