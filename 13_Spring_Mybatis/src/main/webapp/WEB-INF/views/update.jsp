<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="menu.modi.do">
		메뉴명 : <input name="m_name">
		가격 : <input name="m_price" type="number">
		<input type="hidden" value="${param.m_no }" name="m_no">
		<button>수정</button>
	</form>

</body>
</html>