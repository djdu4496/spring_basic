package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 1. ���� ȣ�� ������ ���α׷����� ���
@Controller
public class Hello {
	int iv = 10;         // iv, �ν��Ͻ� ����
	static int cv = 20;  // cv, static ����
	
	// 2. URL�� �޼��� ����
	@RequestMapping("/hello")
	private void main(String[] args) {  // im, �ν��Ͻ� �޼��� - cv, iv ��� ����
		System.out.println("Hello - private");
		System.out.println(iv);
		System.out.println(cv);
	}
	
	public static void main2() {        // cm, static �޼��� - cv�� ��� ����
//		System.out.println(iv); // ����. Cannot make a static reference to the non-static field iv
		System.out.println(cv);
	}

}
