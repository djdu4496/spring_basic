package com.fastcampus.ch2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // 자동 import 단축키: ctrl + shift + o
public class TwoDice { 
	@RequestMapping("/rollDice")
	public static void main(HttpServletResponse response) throws IOException {
		int num1 = (int)(Math.random() * 6) + 1;
		int num2 = (int)(Math.random() * 6) + 1;
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter(); // response객체에서 출력스트림을 얻는다.
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<img src='resources/img/dice" + num1 + ".jpg'>");
		out.println("<img src='resources/img/dice" + num2 + ".jpg'>");
		out.println("</body>");
		out.println("</html>");
	}

}
