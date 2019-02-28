package org.wishit.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.wishit.domain.AccountVO;
import org.wishit.domain.CustomVO;
import org.wishit.service.CustomService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/wishit")
@Log4j
public class CustomController {

	@Setter( onMethod_ = @Autowired )
	private CustomService service;
	
	
	@GetMapping( value = "/list/{busiNum}/{custom}",
			produces = 	MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<CustomVO> getList( @PathVariable("busiNum") String busiNum,
									@PathVariable("custom") String custom) {

		CustomVO customVO = new CustomVO();
		customVO.setBusiNum(busiNum);
		customVO.setCustom(custom);
		
		List<CustomVO> customList = service.getList(customVO);
		
		System.out.println( "\n\n\n customVO : " + customVO.toString() );
		
		return customList;
	}
	
	
	@GetMapping( value = "/detail/{busiNum}",
			produces = 	MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Map<String, Object> get(@PathVariable("busiNum") String busiNum ) {
		
		Map<String, Object> map = service.get(busiNum);
		
		System.out.println( map.get("custom") );
		System.out.println( map.get("account") );
		
		return map;
	}
	
	@PostMapping( 	value = "/insert", 
					consumes = "application/json",
					produces = 	{ MediaType.TEXT_PLAIN_VALUE })
	public void insert( @RequestBody CustomVO custom ) throws IOException {
		
		System.out.println("register...");
		System.out.println("CustomVO : "+custom);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("custom", custom);
//		map.put("account", account);
		
		
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



















