package com.openrun.ticket.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.openrun.ticket.service.UserService;
import com.openrun.ticket.vo.UserVO;


@Controller
//@RequestMapping("/user")
public class UserController {

	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@Autowired
	private JavaMailSender mailSender;

	// user 회원가입 동의서
	@GetMapping("/user/createUserAccountAgreementForm")
	public String createUserAccountAgreementForm() {
		System.out.println("userController / createUserAccountAgreementForm");

		String nextPage = "user/createUserAccountAgreementForm";
		return nextPage;
	}

	// user 회원가입 form
	@GetMapping("/user/createUserAccountForm")
	public String createUserAccountForm() {
		System.out.println("userController / createUserAccountForm");

		String naxtPage = "user/createUserAccountForm";
		return naxtPage;
	}

	// user 회원가입 데이터 전송
	@PostMapping("/user/insertUser")
	public String insertUser(UserVO userVO, Model model) throws Exception {
		System.out.println("userController / insertUser");
		userService.insertUser(userVO);

		model.addAttribute("u_name", userVO.getU_name());

		String nextPage = "user/createUserAccountOK";
		return nextPage;
	}

	// user 아이디 중복확인
	@PostMapping("/user/idCheck")
	@ResponseBody
	public String idCheck(@RequestParam("u_id") String u_id, Model model) {
		System.out.println("userController / idCheck");

		model.addAttribute("u_id", u_id);

		boolean isIdAvailable = userService.isIdAvailable(u_id);
		if (isIdAvailable) {
			return "1"; //사용 가능한 ID
		} else {
			return "0";// 중복된 ID
		}
	}

	// user 로그인
	@PostMapping("/user/loginUser")
	@ResponseBody
	public String Login(@ModelAttribute UserVO userVO, HttpSession session) {
		UserVO userLoginResult = userService.Login(userVO);

		if (userLoginResult != null) {
			session.setAttribute("userLoginResult", userLoginResult);
		
			return "1"; // 로그인 성공
		} else {
			return "0"; // 로그인 실패
		}
	}

	// user 로그인 완료
	@GetMapping("/user/loginOk")
	public String loginOk() {
		System.out.println("userController / loginOk");

		String nextPage = "user/loginOk";
		return nextPage;
	}

	// user 로그아웃-예시
	@GetMapping("/user/exLoginOut")
	public String exLoginOut(HttpSession session) {
		System.out.println("userController / exLoginOut");
		
		session.invalidate();
		
		String nextPage = "user/exLoginOut";
		return nextPage;
	}
	// user 로그인-예시
	@GetMapping("/user/exLoginOk")
	public String exLoginOk(HttpSession session) {
		System.out.println("userController / exLoginOk");
		
		String nextPage = "user/exLoginOk";
		return nextPage;
	}

	// user 이메일 인증
	@GetMapping("/user/emailSend")
	@ResponseBody
	public String emailSend(@RequestParam("u_email") String u_email, Model model) throws Exception {
		System.out.println("userController / emailSend");
		model.addAttribute("u_email", u_email);

		/* 인증번호 생성 */
		Random random = new Random();
		int checkNum = random.nextInt(888888) + 111111;
		System.out.println(checkNum);

		String setFrom = "openrun@gmail.com";
		String toMail = u_email;
		String title = "openrun 회원가입 인증 이메일 입니다.";
		String content = "openrun 홈페이지를 방문해주셔서 감사합니다." + "<br><br>" + "인증 번호는 " + checkNum + "입니다.";

		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
			helper.setFrom(setFrom);
			helper.setTo(toMail);
			helper.setSubject(title);
			helper.setText(content, true);
			mailSender.send(message);
			System.out.println("userController / 이메일 발송 완료");
		} catch (Exception e) {
			e.printStackTrace();
		}

		String num = Integer.toString(checkNum);
		return num;
	}

	// user 회원가입 완료
	@GetMapping("/user/createUserAccountOK")
	public String createUserAccountOK() {
		System.out.println("userController / createUserAccountOK");

		String nextPage = "user/createUserAccountOK";
		return nextPage;
	}

	// user 로그인 페이지 이동
	@GetMapping("/user/userLogin")
	public String userLogin() {
		System.out.println("userController / userLogin");

		String nextPage = "user/userLogin";
		return nextPage;
	}

	// user 아이디 찾기 페이지 이동
	@GetMapping("/user/userFindId")
	public String userFindId() {
		System.out.println("userController / userFindId");

		String nextPage = "user/userFindId";
		return nextPage;
	}

	// user 아이디 찾기
	@PostMapping("/user/findIdCheck")
	@ResponseBody
	public Map<String, Object> findIdCheck(UserVO userVO) {

		Map<String, Object> response = new HashMap<>();

		UserVO findResult = userService.findIdCheck(userVO);
		if (findResult != null) {
			response.put("result", "1");
			response.put("u_name", findResult.getU_name());
			response.put("u_id", findResult.getU_id());
		} else {
			response.put("result", "0");
		}

		return response;
	}
	// user 아이디 찾기 성공
	@GetMapping("/user/userFindIdOk")
	public String userFindIdOk() {
		System.out.println("userController / userFindIdOk");

		String nextPage = "user/userFindIdOk";
		return nextPage;
	}
	// user 비밀번호 찾기 페이지 이동
	@GetMapping("/user/userFindPw")
	public String userFindPw() {
		System.out.println("userController / userFindPw");

		String nextPage = "user/userFindPw";
		return nextPage;
	}
	// user 비밀번호 찾기 
	@PostMapping("/user/findPwCheck")
	@ResponseBody
	public Map<String, Object> findPwCheck(UserVO userVO) {

		Map<String, Object> response = new HashMap<>();

		UserVO findResult = userService.findPwCheck(userVO);
		if (findResult != null) {
			response.put("result", "1"); //회원가입 정보 찾기 성공
			response.put("u_id", findResult.getU_id());
		} else {
			response.put("result", "0"); //회원가입 정보 찾기 실패
		}

		return response;
	}
	// user 비밀번호 수정 페이지 이동
	@GetMapping("/user/userPwChange")
	public String userPwChange() {
		System.out.println("userController / userPwChange");

		String nextPage = "user/userPwChange";
		return nextPage;
	}
	//user 비밀번호 수정
	@PostMapping("/user/userPwChange") 
	@ResponseBody
	public String pwChange(UserVO userVO) {
		System.out.println("userController / pwChange");
	 
			String pwChangeResult = userService.pwChange(userVO);

			if (pwChangeResult == null) {
				System.out.println("비밀번호 수정 성공");
		        return "1"; // 비밀번호 수정 성공
		    } else {
		        System.out.println("비밀번호 수정 실패");
		        return "0"; // 비밀번호 수정 실패
		   }
	}
	// user 예매 취소-비밀번호 확인
	@GetMapping("/user/reservationCancel")
	public String reservationCancel() {
		System.out.println("userController / reservationCancel");

		String nextPage = "user/reservationCancel";
		return nextPage;
	}

	// user 예매 취소-비밀번호 확인 완료
	@GetMapping("/user/reservationCancelOk")
	public String reservationCancelOk() {
		System.out.println("userController / reservationCancelOk");

		String nextPage = "user/reservationCancelOk";
		return nextPage;
	}

	// 연결 test
	@GetMapping("/user/my")
	public String reservationCancelOk2(Model model) throws Exception {

		List<UserVO> list;
		list = userService.user();
		model.addAttribute("useTest", list);

		System.out.println("userController / reservationCancelOk2");
		String nextPage = "user/reservationCancelOk2";
		return nextPage;
	}

}
