<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL - fmt 1</title>
</head>
<body>
	<h4>숫자 포맷 설정</h4>
	<c:set var="number1" value="12345" />
	콤마 O : <fmt:formatNumber value="${number1 }" /> <br />
	콤마 X : <fmt:formatNumber value="${number1 }" groupingUsed="false" /> <br />
	<fmt:formatNumber value="" />
</body>
</html>