package com.fastcampus.ch2;

import java.io.IOException;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

// ��¥(��-��-��)�� �Է��ϸ�, �ش� ��¥�� � �������� �˷��ִ� ���α׷�
@Controller
public class YoilTellerMVC2 { // http://localhost/ch2/getYoilMVC2?year=2022&month=7&day=5
	@ExceptionHandler(Exception.class)
	String catcher(Exception ex) {
		ex.printStackTrace();
		return "yoilError";
	}
	
	@RequestMapping("/getYoilMVC2")
//	public void main(HttpServletRequest request, HttpServletResponse response) throws IOException {
	public String main(
			@RequestParam(required=true)int year, 
			@RequestParam(required=true)int month, 
			@RequestParam(required=true)int day, Model model
			) throws IOException {
		// 1. ��ȿ�� �˻�
		if(!isValid(year, month, day))
			return "yoilError";
		// 2. ó�� - ���� ���
		char yoil = getYoil(year, month, day);
		
		// 3. Model�� �۾� ��� ����
		model.addAttribute("year", year);
		model.addAttribute("month", month);
		model.addAttribute("day", day);
		model.addAttribute("yoil", yoil);
		
		return "yoil"; // WEB-INF/views/yoil.jsp
	}

	private boolean isValid(int year, int month, int day) {
		return true;
	}

	private char getYoil(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month - 1, day);
		
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); // 1:�Ͽ���, 2:������ ...
		return "�Ͽ�ȭ�������".charAt(dayOfWeek);
	}

}