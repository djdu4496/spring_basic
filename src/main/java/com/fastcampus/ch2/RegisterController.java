package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {
//	@RequestMapping(value="/register/add", method={RequestMethod.GET, RequestMethod.POST})
//	@RequestMapping("/register/add")
//	@GetMapping("/register/add")
//	public String register() { // �ű�ȸ�� ���� ȭ��
//		return "registerForm"; // WEB-INF/views/registerForm.jsp
//	}
//	@RequestMapping(value="/register/save", method=RequestMethod.POST)
	@PostMapping("/register/save") // 4.3����
	public String save(User user, Model model) {
		// 1. ��ȿ�� �˻�
		
		// 2. DB�� �ű�ȸ�� ������ ����
		return "registerInfo";
	}
}