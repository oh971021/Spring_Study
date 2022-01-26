<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>전체 메뉴 조회</h1>
	
	<c:forEach var="m" items="${m }">
		<h3>메뉴명 : ${m.m_name } 가격 : ${m.m_price } </h3>
	</c:forEach>

</body>
</html>