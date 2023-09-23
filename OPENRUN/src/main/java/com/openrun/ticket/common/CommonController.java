package com.openrun.ticket.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home/member")
public class CommonController {

	//기본 회원가입
	@GetMapping("/createAccountForm")
	public String createAccountForm() {
		System.out.println("[UserController] createAccountForm()");
		String nextPage = "home/member/create_account_form";
				
		return nextPage;
	}

}
