package com.openrun.ticket.user;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home/member")
public class UserController {
	
	@Autowired
	UserService userService;
	
	//기본 회원가입
	@GetMapping("/createAccountForm")
	public String createAccountForm() {
		System.out.println("[UserController] createAccountForm()");
		String nextPage = "home/member/create_account_form";
			
		return nextPage;
	}
	//구매자 회원가입 약관동의
	@GetMapping("/createUserAccountAgreementForm")
	public String createUserAccountAgreementForm() {
		System.out.println("[UserController] createUserAccountAgreementForm()");
		String nextPage = "home/member/user/create_user_account_agreement_form";
				
		return nextPage;
	}
	//판매자 회원가입 약관동의
	@GetMapping("/createSellerAccountAgreementForm")
	public String createSellerAccountAgreementForm() {
		System.out.println("[UserController] createSellerAccountAgreementForm()");
		String nextPage = "home/member/seller/create_seller_account_agreement_form";
			
		return nextPage;
	}
	//구매자 회원가입
	//@RequestMapping(value = "/createAccountForm", method = RequestMethod.GET)
	@GetMapping("/createUserAccountForm")
	public String createUserAccountForm() {
		System.out.println("[UserController] createUserAccountForm()");
		String nextPage = "home/member/user/create_user_account_form";
			
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

	//판매자 회원가입
	//@RequestMapping(value = "/createAccountForm", method = RequestMethod.GET)
	@GetMapping("/createSellerAccountForm")
	public String createSellerAccountForm() {
		System.out.println("[UserController] createSellerAccountForm()");
		String nextPage = "home/member/seller/create_seller_account_form";
				
		return nextPage;
	}
	//판매자 회원가입 확인
	@PostMapping("/createSellerAccountConfirm")
	public String createSellerAccountConfirm(UserVo userVo) {
		System.out.println("[UserController] createSellerAccountConfirm()");
			
		//기본값을 성공할때 return 되는 페이지
		String nextPage = "home/member/seller/create_seller_account_ok";
		
		int result = userService.createSellerAccountConfirm(userVo);
		//정상적으로 처리 되지 않았을 경우 에러 페이지
		if (result <= 0) {
			nextPage = "home/member/seller/create_seller_account_ng";
		}
		return nextPage;
	}
	
	//로그인
	@GetMapping("/loginForm")
	public String loginForm() {
		System.out.println ("[UserController] loginForm()");
		String nextPage = "home/member/login_form";
		
		return nextPage;
	}


}
