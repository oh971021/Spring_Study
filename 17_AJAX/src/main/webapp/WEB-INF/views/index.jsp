<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/jQuery.js"></script>
<script type="text/javascript">
	// main셋팅 (body의 내용을 다 읽고 script를 실행함.)
	$(function(){
		
		$('#btn').click(function(){
		// $('input').keyup(function(){
			// 인풋 파라미터값 받기 .val()
			let start = $('#start').val();
			let end = $('#end').val();
			
			// $.getJSON(url, callback)
				// 자바에서 static 메서드아 유사하고, jQuery에서는 전역 메소드라고 한다.
			$.getJSON("http://localhost/ajax/shop.search?start="+start+"&end="+end, function(j){
				$('table').empty();
				console.log(j); // 제이슨 오브젝트를 보여줌
				// console.log(JSON.stringify(j)); // 제이슨 전체를 보여줌
				
				// 반복문으로 json 값 읽기
					// 복습 : $.each(배열), callback(인덱스, 객체)
				$.each(j.shop, function(i, s){
					// console.log(s);
					let td1 = $("<td></td>").text(s.b_floor);
					let td2 = $("<td></td>").text(s.b_shopName);
										// DOM안에 더해주는 기능 : append
					let tr = $("<tr></tr>").append(td1,td2);		
							// table 태그 안에 tr을 넣는다.
					$('table').append(tr);
				});
				
				$('input').keyup(function(){
					start = $('#start').val();
					end = $('#end').val();
				
					if(start.length >= 1 && end.length >= 1) {
						$('#btn').trigger('click');
					};
				});
			});
		});
	});
</script>

<!-- 
	### 동기와 비동기 ###
	
	1. 동기 
		- 서버에 보내서 처리하면 동기처리 (요청 및 응답)
		
	2. 비동기
		- 작동한 위치에서 직접 & 바로 수정처리

 -->

</head>
<body>
							<!-- Top level의 경로까지 써줘야 함 -->
	<button onclick="location.href='/ajax/shop.getjson'">json 얻기</button>
	<!-- 풀경로를 써주는 경우도 있음 -->
	<!-- <button onclick="location.href='http://localhost/ajax/shop.getjson'">json 얻기</button> -->

	<button onclick="location.href='/ajax/shop.getxml'">xml 얻기</button>
	
	<hr>
	
	<input name="start" id="start">
	<input name="end" id="end">
	<button id="btn">찾기</button>
	
	<hr>
	
	<p>
	<table border="1">
		
	</table>
	</p>
	
	<hr>
	
</body>
</html>