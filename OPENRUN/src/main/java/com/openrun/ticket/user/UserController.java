package com.openrun.ticket.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home/member/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	//구매자 회원가입
	//@RequestMapping(value = "/createAccountForm", method = RequestMethod.GET)
	@GetMapping("/createUserAccountForm")
	public String createUserAccountForm() {
		System.out.println("[UserController] createUserAccountForm()");
		String nextPage = "home/member/member/create_common_account_form";
			
		return nextPage;
	}
	//구매자 회원가입 약관동의
	@GetMapping("/createUserAccountAgreementForm")
	public String createUserAccountAgreementForm() {
		System.out.println("[UserController] createUserAccountAgreementForm()");
		String nextPage = "home/member/user/create_user_account_agreement_form";
				
		return nextPage;
	}
	//구매자 회원가입 확인
	@PostMapping("/createUserAccountConfirm")
	public String createUserAccountConfirm(UserVo userVo) {
		System.out.println("[UserController] createUserAccountConfirm()");
		
		//기본값을 성공할때 return 되는 페이지
		String nextPage = "home/member/user/create_user_account_ok";
		
		int result = userService.createUserAccountConfirm(userVo);
		//정상적으로 처리 되지 않았을 경우 에러 페이지
		if (result <= 0) {
			nextPage = "home/member/user/create_user_account_ng";
		}
		return nextPage;
	}
	//구매자 로그인
	@GetMapping("/loginUserForm")
	public String loginUserForm() {
		System.out.println ("[UserController] loginUserForm()");
		String nextPage = "home/member/login_user_form";
		
		return nextPage;
	}


}
