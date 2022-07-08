package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {
//	@RequestMapping(value="/register/add", method={RequestMethod.GET, RequestMethod.POST})
//	@RequestMapping("/register/add")
//	@GetMapping("/register/add")
//	public String register() { // 신규회원 가입 화면
//		return "registerForm"; // WEB-INF/views/registerForm.jsp
//	}
//	@RequestMapping(value="/register/save", method=RequestMethod.POST)
	@PostMapping("/register/save") // 4.3부터
	public String save(User user, Model model) {
		// 1. 유효성 검사
		
		// 2. DB에 신규회원 정보를 저장
		return "registerInfo";
	}
}