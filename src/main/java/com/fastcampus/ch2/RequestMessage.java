package com.fastcampus.ch2;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RequestMessage {
	@RequestMapping("/requestMessage")
	public void main(HttpServletRequest request) throws Exception {
		
		// 1. request line
		String requestLine = request.getMethod();       // GET �Ǵ� POST
		requestLine += " " + request.getRequestURI();   // /ch2/requestMessage
		
		String queryString = request.getQueryString();  // year=2021&month=10&day=1
		requestLine += queryString == null ? "" : "?"+queryString;  
		requestLine += " " + request.getProtocol();     // HTTP/1.1
		System.out.println(requestLine);	

		
		// 2. request headers
		Enumeration<String> e = request.getHeaderNames();

		while (e.hasMoreElements()) {
			String name = e.nextElement();
			System.out.println(name + ":" + request.getHeader(name));
		}
		
		// 3. request body - POST�� ���� �ش�, GET�� body�� ����(CONTENT_LENGTH=0)
		final int CONTENT_LENGTH = request.getContentLength();
//		System.out.println("content length="+CONTENT_LENGTH);
		
		if(CONTENT_LENGTH > 0) { // body�� ���� ��쿡�� ���
			byte[] content = new byte[CONTENT_LENGTH];

			InputStream in = request.getInputStream();
			in.read(content, 0, CONTENT_LENGTH);
			
			System.out.println(); // empty line
			System.out.println(new String(content, "utf-8")); // year=2021&month=10&day=1
		}  // if
	} // main
}

//	[������1] - GET ��û
//	GET /ch2/requestMessage?year=2022&month=7&day=5 HTTP/1.1	<--- ��û ����(request line)
//	host:localhost
//	connection:keep-alive
//	sec-ch-ua:".Not/A)Brand";v="99", "Google Chrome";v="103", "Chromium";v="103"
//	sec-ch-ua-mobile:?0
//	sec-ch-ua-platform:"Windows"
//	upgrade-insecure-requests:1
//	user-agent:Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/103.0.0.0 Safari/537.36
//	accept:text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9
//	sec-fetch-site:none
//	sec-fetch-mode:navigate
//	sec-fetch-user:?1
//	sec-fetch-dest:document
//	accept-encoding:gzip, deflate, br
//	accept-language:ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7

//	[������2] - POST ��û		
//	POST /ch2/requestMessage HTTP/1.1	<--- ��û ����(request line)
//	host:localhost
//	connection:keep-alive
//	content-length:23
//	sec-ch-ua:".Not/A)Brand";v="99", "Google Chrome";v="103", "Chromium";v="103"
//	cache-control:no-cache
//	content-type:application/x-www-form-urlencoded
//	sec-ch-ua-mobile:?0
//	user-agent:Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/103.0.0.0 Safari/537.36
//	sec-ch-ua-platform:"Windows"
//	accept:*/*
//	origin:chrome-extension://coohjcphdfgbiolnekdpbcijmhambjff
//	sec-fetch-site:none
//	sec-fetch-mode:cors
//	sec-fetch-dest:empty
//	accept-encoding:gzip, deflate, br
//	accept-language:ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7
//	                         <--- empty line
//	year=2022&month=7&day=5  <--- request body
		