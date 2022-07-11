package com.fastcampus.ch2;

import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {
	@RequestMapping("/login")
	public String loginForm() {
		return "loginForm";
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		// 1. ������ ����
		session.invalidate();
		// 2. Ȩ���� �̵�
		return "redirect:/";
	}
	@PostMapping("/login") 
	public String login(String id, String pwd, String toURL, boolean rememberId, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 1. id�� pwd�� Ȯ��
		if(!loginCheck(id, pwd)) {
			// 2-1. ��ġ���� ������, loginForm���� �̵�
			String msg = URLEncoder.encode("id �Ǵ� �н����尡 ��ġ���� �ʽ��ϴ�.", "utf-8");
			return "redirect:/login/login?msg="+msg;
		}
		// 2-2.id�� pwd�� ��ġ�ϸ�, 
		/** session��ü�� ������  */
		HttpSession session = request.getSession();
		/** session��ü�� id�� ���� */
		session.setAttribute("id", id);
		// rememberId �����ϴ� ���
		if(rememberId) {
			// ��Ű�� ����
			//	1. ��Ű�� ����
			Cookie cookie = new Cookie("id", id); // ctrl+shift+o �ڵ� import
			//	2. ���信 ����
			response.addCookie(cookie);
		} else {		// rememberId �������� �ʴ� ���
			// ��Ű�� ����
			Cookie cookie = new Cookie("id", id); // ctrl+shift+o �ڵ� import			
			cookie.setMaxAge(0);
		}
		//	3. Ȩ���� �̵�
		toURL = toURL==null || toURL.equals("") ? "/" : toURL;
		return "redirect:/"+toURL;
	}
	private boolean loginCheck(String id, String pwd) {
		// TODO Auto-generated method stub
		return "asdf".equals(id) && "1234".equals(pwd);
	}
}