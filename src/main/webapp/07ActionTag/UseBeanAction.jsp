<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>액션 태그 - useBean</title>
</head>
<body>
	<h3>액션 태그로 폼 값 한번에 받기</h3>
	<jsp:useBean id="person" class="common.Person"/>
	<jsp:setProperty property="*" name="person"/>
	<ul>
		<li>이름 : <jsp:getProperty name="person" property="name" /> </li>
		<li>이름 : <jsp:getProperty name="person" property="age" /> </li>
	</ul>
</body>
</html>