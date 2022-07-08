<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<h1>year=<%=request.getParameter("year") %></h1>
<h1>month=<%=request.getParameter("month") %></h1>
<h1>day=<%=request.getParameter("day") %></h1>
	<P>${myDate.year}년 ${myDate.month}월 ${myDate.day}일은 ${yoil}요일 입니다.</P> <!-- 아래 코드와 동일 -->
<!--<P>${myDate.getYear()}년 ${myDate.getMonth()}월 ${myDate.getDay()}일은 ${yoil}요일 입니다.</P>  -->
</body>
</html>