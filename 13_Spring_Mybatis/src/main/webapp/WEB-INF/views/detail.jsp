<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table>
		<tr>
			<td>메뉴번호</td>
			<td>메뉴명</td>
			<td>메뉴가격</td>
		</tr>
		<tr>
			<td>${m.m_no }</td>
			<td>${m.m_name }</td>
			<td>${m.m_price }</td>
		</tr>
	</table>
	
	<button onclick="history.back()">돌아가기</button>

<!-- 파라미터값을 Bean에 자동 매핑해준다. -->
	<h3>${menu }</h3>
	<h3>${menu.m_no }</h3>
	<h3>${menu.m_name }</h3>

</body>
</html>