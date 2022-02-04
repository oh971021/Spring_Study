<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
							<!-- Top level의 경로까지 써줘야 함 -->
	<button onclick="location.href='/ajax/shop.getjson'">json 얻기</button>
	<!-- 풀경로를 써주는 경우도 있음 -->
	<!-- <button onclick="location.href='http://localhost/ajax/shop.getjson'">json 얻기</button> -->

	<button onclick="location.href='/ajax/shop.getxml'">xml 얻기</button>
	
	
	
</body>
</html>