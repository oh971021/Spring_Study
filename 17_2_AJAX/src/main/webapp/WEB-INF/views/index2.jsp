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
	
	// 버튼을 누르면 ajax를 실행함
	//$('button').click(function(){
	$('#i1').keyup(function(){
		// 버튼 클릭 시 인풋값 가져옴
		let inputVal = $('#i1').val();
		
		if($('#i1').val() != "") {
		
			// jQuery ajax 메소드의  통합적인 기능을 가지고 있다.
			$.ajax({
				
				// 서버로 요청 할 주소
				url : "/ajax/menu.get.json.name",
				// 요청 타입
				type : 'GET',
				// 요청 할 형식 (어떤 파일로 받을 지)
				dataType : 'json',
				// 전송 할 데이터를 뜻함 (Parameter)
				data : {
					"m_name" : inputVal // 파라미터를 전송한다 
				},
				// 요청한 주소로 응답이 성공하면 success를 실행시킨다.
				success : function(data){
					$('#mainTbl').empty();
					
					console.log(data);
					
					// 우리가 따로 만드는 메소드 : 가서 파싱하기 위해 데이터를 넘겨준다.
					successcall(data);
				}
				
			});
		}
	});
	
	$('#b2').click(function(){
		let inputVal = $('#i2').val();
		if($('#i2').val() != "") {
			$.ajax({
				url : "/ajax/menu.get.xml.name",
				type : 'GET',
				dataType : 'xml',
				data : {
					"m_name" : inputVal 
				},
				success : function(data){
					$('#mainTbl').empty();
					//console.log(data);
					successcall2(data);
				}
			});
		}
	});
});

function successcall(data) {
	
	data = data["menus"];	// JSON 객체 접근법

	$.each(data, function(i,d){
		// console.log(data[i]);
		// console.log('같은 결과');
		// console.log(d);
		
		$('#mainTbl').append("<tr><td id='td"+i+"'></td></tr>");
		$('#td'+i).text(d.m_name);
	})
	
}

function successcall2(data) {
	
	data = $(data).find('menus');	// XML 객체 접근법
	console.log(data);
	
	$.each(data, function(i,d){
		
		console.log(data[i]);	
	
		let name = $(this).find('m_name').text();
		// console.log(name);
		
		$('#mainTbl').append("<tr><td>"+ name +"</td></tr>");
		//$('#td'+i).text(d.m_name);
	})
}

</script>
<body>

	<input id="i1" autocomplete="off" placeholder="메뉴명 검색">
	<button>확인</button>

	<input id="i2" autocomplete="off" placeholder="메뉴명 검색">
	<button id="b2">확인</button>
	
	<hr>
	
	<table id="mainTbl">
		
	</table>

	<hr> 

	<a href="menu.get.json">json 받기</a>
	<a href="menu.get.xml">xml 받기</a>
	
</body>
</html>