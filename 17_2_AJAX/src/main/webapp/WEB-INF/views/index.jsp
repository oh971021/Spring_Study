<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="resources/jQuery.js"></script>
<script type="text/javascript">
	$(function(){
		$('#btn').click(function(){
			
			let start = $('#start').val();
			let end = $('#end').val();
			
			// jQuery 에서 구현이 된 기능 : getJSON(url, callback(jsonFile)) url을 열어서 받은 파일을 j로 받는다. 
			$.getJSON("http://localhost/ajax/shop.search?start="+start+"&end="+end, function(j){
				$('table').empty();
				
				console.log(j);

				// console.log(JSON.stringify(j)); // JSON file을 문자열로 쭉 풀어서 보여줌 
				
				// $.each(배열, function(인덱스, 객체 하나하나))
				$.each(j.shops, function(i,s){
					// console.log(s); // JSON의 shops들을 다 뿌려줌
					let td1 = $('<td></td>').text(s.b_floor); // s.b_floor의 정보가 td하나하나 안에 하나하나 들어감
					let td2 = $('<td></td>').text(s.b_shopName);
					let tr = $('<tr></tr>').append(td1, td2); // DOM객체 안에 td1, td2 DOM들이 들어간다.
					
					$('table').append(tr); // 마찬가지로 table 안에 td를 가지고 있는 tr을 넣어줌.
				});
				
				$('input').keyup(function(){
					// 값을 재설정 해줘야 공백값이 안넘어간다.
					start = $('#start').val();
					end = $('#end').val();
					
					if(start.length >= 1 && end.length >= 1){
						// 조건에 맞을때만 클릭이 되도록한다.
						$('#btn').trigger('click');
					}
				});
				
			});사
		});
	});
</script>
<body>
	
<!-- 	<button onclick="location.href='ajax/shop.getjson'">json 얻기</button> -->
	<button onclick="location.href='http://localhost/ajax/shop.getjson'">json 얻자</button>
	<button onclick="location.href='http://localhost/ajax/shop.getxml'">xml 얻자</button>
	
	<hr>
	
	<input name="start" id="start"> <br>
	<input name="end" id="end"> <br>
	<button id="btn">찾기</button>
	
	<hr>
	
	<table border="1">
		
	</table>
	
</body>
</html>