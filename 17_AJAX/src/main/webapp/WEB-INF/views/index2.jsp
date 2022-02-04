<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/jQuery.js"></script>
<script type="text/javascript">
$(function(){
	
	$('#i1').keyup(function(){
	
		let inputVal = $('i1').val();
		
		if($('#i1').val() != "") {
			$.ajax({
				// 서버로 보낼 주소
				url : "/ajax/menu.get.json.name",
				// 요청 타입
				type : 'GET',
				// 요청한 데이터 형식 (제이슨으로 읽겠다)
				dataType : 'json',
				// 전송할 데이터
				data : {
					// 파라미터
					"m_name" : inputVal
				},
				success : function(data) {
					$('mainTbl').empty();
					
					console.log(data);
					
					// ajax 문법이 아니라 커스텀 메소드
					successcall(data);
					
				}
			});
		}
	});
});

function successcall(data) {
	data = data["menus"];
	// alert(data[1]["m_name"]);
	$.each(data, function(i, m){
		// console.log(data[i]);
		// console.log(m);
		$('mainTbl').append("<tr><td id='td"+ i + "'></td></tr>");
		$('td' + i).text(m.m_name);
	});
};

</script>
</head>
<body>
	<input name="i1" id="i1" autocomplete="off" placeholder="메뉴명 검색">
	<button>확인</button>
	
	<hr>

	<a href="menu.get.json">json 받기</a>
	<a href="menu.get.xml">xml 받기</a>
	
	<hr>
	
	<table id="mainTbl"></table>
</body>
</html>