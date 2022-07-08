package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 1. 원격 호출 가능한 프로그램으로 등록
@Controller
public class Hello {
	int iv = 10;         // iv, 인스턴스 변수
	static int cv = 20;  // cv, static 변수
	
	// 2. URL과 메서드 연결
	@RequestMapping("/hello")
	private void main(String[] args) {  // im, 인스턴스 메서드 - cv, iv 사용 가능
		System.out.println("Hello - private");
		System.out.println(iv);
		System.out.println(cv);
	}
	
	public static void main2() {        // cm, static 메서드 - cv만 사용 가능
//		System.out.println(iv); // 에러. Cannot make a static reference to the non-static field iv
		System.out.println(cv);
	}

}
