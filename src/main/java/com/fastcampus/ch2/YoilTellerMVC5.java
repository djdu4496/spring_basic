package com.fastcampus.ch2;

import java.io.IOException;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

// 날짜(연-월-일)를 입력하면, 해당 날짜가 어떤 요일인지 알려주는 프로그램
@Controller
public class YoilTellerMVC5 { 
	@ExceptionHandler(Exception.class)
	String catcher(Exception ex) {
		ex.printStackTrace();
		return "yoilError";
	}
	
	@RequestMapping("/getYoilMVC5") // http://localhost/ch2/getYoilMVC5
//	public String main(@ModelAttribute("myDate") MyDate date, Model model) throws IOException { 아래와 동일
	public String main(@ModelAttribute MyDate date, Model model) throws IOException {
		// 1. 유효성 검사
		if(!isValid(date))
			return "yoilError";
		// 2. 요일 계산
//		char yoil = getYoil(date);
		
//		 3. 계산한 결과를 model에 저장
//		model.addAttribute("myDate", date);
//		model.addAttribute("yoil", yoil);
		
		return "yoil"; // WEB-INF/views/yoil.jsp
	}

	private char getYoil(MyDate date) {
		// TODO Auto-generated method stub
		return getYoil(date.getYear(), date.getMonth(), date.getDay());
	}

	private @ModelAttribute("yoil")char getYoil(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month - 1, day);
		
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); // 1:일요일, 2:월요일 ...
		return "일월화수목금토".charAt(dayOfWeek);
	}
	
	private boolean isValid(MyDate date) {
		// TODO Auto-generated method stub
		return isValid(date.getYear(), date.getMonth(), date.getDay());
	}
	
    private boolean isValid(int year, int month, int day) {    
    	if(year==-1 || month==-1 || day==-1) 
    		return false;
    	
    	return (1<=month && month<=12) && (1<=day && day<=31); // 간단히 체크 
    }
}