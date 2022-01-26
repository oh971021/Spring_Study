<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>입력 페이지</h1>
	<form action="calc.do">
		x : <input name="x"> y : <input name="y">
		<button>계산</button>
	</form>

	<hr>

	<form action="item.puchase">
		가격 : <input name="price" type="number"> <br>
		갯수 : <input name="count" type="number">
		<button>계산</button>
	</form>
	
	<hr>
	
	<form action="calc.do2">
		x : <input type="number" name="x"> <br>
		y : <input type="number" name="y"> <br>
		<select name="sign">
			<option value="1"> +
			<option value="2"> -
		</select>
		<button>계산</button>
	</form>
	
</body>
</html>