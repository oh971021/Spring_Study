<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function del(val) {
		let ok = confirm('삭제?');
		
		if (ok) {
			location.href = 'menu.del.do?m_no=' + val;
		}
	}
	
	function update(val) {
		let price = prompt("수정?");
		
		alert(price);
		
		if(price != '' && price != null) {
			location.href='menu.update.do?m_no=' + val + '&m_price=' + price;
		}
	}
</script>
</head>
<body>

	<h1>전체 메뉴 조회</h1>
	
	<c:forEach var="m" items="${m }">
		<h3>메뉴명 : ${m.m_name } 가격 : ${m.m_price } 
			<button type="button" onclick="del(${m.m_no})">삭제</button>
			<button type="button" onclick="update(${m.m_no})">수정</button>
			<button type="button" onclick="location.href='menu.modi.go?m_no=${m.m_no}'">수정(jsp)</button>
			<button type="button" onclick="location.href='menu.detail.go?m_no=${m.m_no}&m_name=${m.m_name }'">상세조회</button>
		</h3>
	</c:forEach>

</body>
</html>