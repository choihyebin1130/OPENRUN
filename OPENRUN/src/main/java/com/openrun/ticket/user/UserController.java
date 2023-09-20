package com.openrun.ticket.user;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	//회원가입
	//@RequestMapping(value = "/createAccountForm", method = RequestMethod.GET)
	@GetMapping("/createAccountForm")
	public String createAccountForm() {
		System.out.println("[UserController] createAccountForm()");
		String nextPage = "home/user/create_account_form";
			
		return nextPage;
	}
	@PostMapping("/createAccountConfirm")
	public String createAccountConfirm(UserVo userVo) {
		System.out.println("[UserController] createAccountConfirm()");
		
		//기본값을 성공할때 return 되는 페이지
		String nextPage = "home/user/create_account_ok";
		
		int result = userService.createAccountConfirm(userVo);
		//정상적으로 처리 되지 않았을 경우 에러 페이지
		if (result <= 0) {
			nextPage = "home/user/create_account_ng";
		}
		return nextPage;
	}


}
