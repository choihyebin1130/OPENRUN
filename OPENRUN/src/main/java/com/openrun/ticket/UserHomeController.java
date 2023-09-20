package com.openrun.ticket;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/home")
public class UserHomeController {
	
	@RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
	public String home(){
		System.out.println("home()페이지 성공");
		
		
		String nextPage = "home/home";
		
		return nextPage;
	}
}