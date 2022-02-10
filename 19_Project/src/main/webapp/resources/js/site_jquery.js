function connectAddrSearchEvent() {
	$('#addrSearchBtn').click(function() {
		new daum.Postcode({
			oncomplete : function(data) {
				$('#jm_addr3Input').val(data.zonecode);
				$('#jm_addr1Input').val(data.roadAddress);
			}
		}).open();
	});
};

function showAqicn() {
	_aqiFeed({
		container : "city-aqi-container",
		display : "<span style='%style;font-size:10pt;z-index:3;padding:5px 5px;font-weight:800;font-family:'a';'>공기 : %aqi(%impact)</span>",
		city : "seoul",
		lang : "kr"
	});
};

function connectShowWeatherEvent() {
	$(document).contextmenu(function() {
		return false;
	});

	$("html").mousedown(function(e) {
		if (e.button == 2) { // 2 : 마우스 우클릭
			var url = "http://api.openweathermap.org/data/2.5/weather?q=seoul&appid=e7b1a57cd2158c8d195bfb24b7597bad&units=metric&lang=kr";
			$.getJSON(url, function(data){
				var icon = "https://openweathermap.org/img/wn/"+data.weather[0].icon+".png";
				$("#weatherImg").attr("src", icon);
				$("#weatherDesc").text(data.weather[0].description);
				$("#weatherTemp").text(data.main.temp + "℃(" + data.main.humidity + "%)");
				
				$("#weatherArea").css("opacity", "1");
				$("#weatherArea").css("top", (e.pageY - 30) + "px");
				$("#weatherArea").css("left", (e.pageX - 70) + "px");
				
				setTimeout(function(){
					$("#weatherArea").css("opacity", "0");
				}, 2000);
			});
		}
	});
};

function connectMenuSummonEvent() {
	$("#siteTitleArea").mouseenter(function() {
		$("#siteTitleArea").css("top", "0px");
		$("#siteLoginArea").css("top", "105px");
	});
	$("#siteTitleArea").mouseleave(function() {
		$("#siteTitleArea").css("top", "-40px");
		$("#siteLoginArea").css("top", "65px");
	});
}

// jQuery 메소드 부르기 위해 Ready 시킴
$(function(){
	connectAddrSearchEvent();
	connectShowWeatherEvent();
	showAqicn();
	connectMenuSummonEvent();
});