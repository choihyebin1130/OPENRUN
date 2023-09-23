package com.openrun.ticket.seller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home/member/seller")
public class SellerController {
	
	@Autowired
	SellerService sellerService;

	//판매자 회원가입
	//@RequestMapping(value = "/createAccountForm", method = RequestMethod.GET)
	@GetMapping("/createSellerAccountForm")
	public String createSellerAccountForm() {
		System.out.println("[UserController] createSellerAccountForm()");
		String nextPage = "home/member/seller/create_seller_account_form";
					
		return nextPage;
	}
	//판매자 회원가입 약관동의
	@GetMapping("/createSellerAccountAgreementForm")
	public String createSellerAccountAgreementForm() {
		System.out.println("[SellerController] createSellerAccountAgreementForm()");
		String nextPage = "home/member/seller/create_seller_account_agreement_form";
				
		return nextPage;
	}
	//판매자 회원가입 확인
	@PostMapping("/createSellerAccountConfirm")
	public String createSellerAccountConfirm(SellerVo sellerVo) {
		System.out.println("[UserController] createSellerAccountConfirm()");
			
		//기본값을 성공할때 return 되는 페이지
		String nextPage = "home/member/seller/create_seller_account_ok";
		
		int result = sellerService.createSellerAccountConfirm(sellerVo);
		//정상적으로 처리 되지 않았을 경우 에러 페이지
		if (result <= 0) {
			nextPage = "home/member/seller/create_seller_account_ng";
		}
		return nextPage;
	}
}
