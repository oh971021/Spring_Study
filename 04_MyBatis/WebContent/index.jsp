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
<style>
div {
	positon: fixed;
	right: 50px;
	top: 50op;
}
</style>
<body>
	<table border="1" style="text-align: center; width: 100%;">
		<tr>
			<td>상품번호</td>
			<td>상품이름</td>
			<td>상품가격</td>
			<td>상품이미지</td>
			<td>생성일자</td>
		</tr>
		<c:forEach var="i" items="${products }">
			<tr>
				<td>${i.p_no }</td>
				<td>${i.p_name }</td>
				<td><fmt:formatNumber value="${i.p_price }" type="currency"/></td>
				<td><img src="img/${i.p_img }" style="max-width: 50px;"></td>
				<td><fmt:formatDate value="${i.p_exp }" type="date" dateStyle="short"/></td>
			</tr>
		</c:forEach>
	</table>
	
	<div>
		<h3>상품 등록</h3>
		<form action="RegController" method="post" enctype="multipart/form-data">
			품명 : <input type="text" name="p_name"> <br>
			가격 : <input type="number" name="p_price"> <br>
			사진 : <input type="file" name="p_file"> <br>
			기한 : <input type="date" name="p_exp"> <br>
			<button>등록</button>
		</form>
	</div>
	
	<h3>품명으로 검색</h3>
	<form action="SearchController">
		품명 : <input type="text" name="p_name">
		<button> 검색 </button>
	</form>
		
	<h3>품번으로 삭제</h3>
	<form action="DeleteController">
		품번 : <input type="number" name="p_no">
		<button> 삭제 </button>
	</form>
		
	<h3>가격으로 검색</h3>
	<form action="PriceSearchController" method="post">
		<input type="number" name="p_price">원 이하 검색 <button> 검색 </button>
	</form>
	
	<h3>가격대 설정 검색</h3>
	<form action="PriceSearchController">
		<input type="number" name="p_price1">원 ~ <input type="number" name="p_price2">원
		<button> 검색 </button>
	</form>
	
	<h3>가격 인상</h3>
	<form action="UpdateController">
		<input type="number" name="p_price1">원 인거 <input type="number" name="p_price2">원 으로 
		 <button> 인상하기 </button>
	</form>
	
</body>
</html>