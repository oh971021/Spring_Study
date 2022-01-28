<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table>
		<tr>
			<th>상품 번호</th>
			<th>사진</th>
			<th>품명</th>
			<th>가격</th>
			<th>유통기한</th>
		</tr>
		<c:forEach var="p" items="${products }">
			<tr>
				<td>${p.p_no }</td>
				<td><img width="50px" height="50px" alt="상품이미지" src="resources/file/${p.p_img }"></td>
				<td>${p.p_name }</td>
				<td><fmt:formatNumber value="${p.p_price }" type="currency"></fmt:formatNumber></td>
				<td><fmt:formatDate value="${p.p_exp }" dateStyle="long"/></td>
			</tr>
		</c:forEach>
	</table>

	<a href="/smb2">돌아가기</a>

	<h3>상품 등록</h3>
	<form action="product.reg.do" enctype="multipart/form-data" method="post">
		 품명 : <input name="p_name"> <br>
		 사진 : <input name="p_img" type="file"> <br>
		 가격 : <input name="p_price" type="number"> <br>
		 유통기한 : <input name="p_exp" type="date"> <br>
		 <button>등록</button>
	</form>
	
	<h3>상품 삭제</h3>
	<form action="product.del.do">
		번호 : <input name="p_no">
		<button>삭제</button>
	</form>

	<h3>품명 검색(포함 검색)</h3>
	<form action="product.searchName.do">
		검색어 (품명) : <input name="p_name"> 
		<button>검색</button>
	</form>

	<h3>가격 이하 검색</h3>
	<form action="product.getPrice.do">
		<input type="number" name="p_price">이하 
		<button>검색</button>
	</form>

	<h3>가격대 설정 검색</h3>
	<form action="product.getPriceToPrice.do">
		<input type="number" name="price1"> ~ <input type="number" name="price2"> 사이 
		<button>검색</button>
	</form>

	<h3>가격 인상</h3>
	<form action="product.updatePrice.do">
		<input type="number" name="price1">원 <input type="number" name="price2">원으로 
		<button>인상</button>
	</form>

</body>
</html>