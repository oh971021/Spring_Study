function goHome() {
	location.href='index.go';
}

function logout() {
	let ok = confirm("정말?")
	if(ok){
		location.href='member.logout';
	}
}

function bye() {
	var ok = confirm("?");
	if (ok) {
		location.href = "member.bye";
	}
}

function deleteFile(n, f) {
	var ok = confirm("?");
	if (ok) {
		location.href = "dataroom.delete?d_no=" + n + "&d_file=" + f;
	}
}


function deleteSNSMsg(n) {
	var ok = confirm("?");
	if (ok) {
		location.href = "sns.delete?s_no=" + n;
	}
}

function deleteSNSReply(n, p) {
	var ok = confirm("?");
	if (ok) {
		location.href = "sns.reply.delete?r_no=" + n + "&p=" + p;
	}
}

function updateSNSMsg(n, t, p) {
	t = prompt("말", t);
	if (t != null && t.length > 0 && t.length < 250) {
		location.href = "sns.update?s_no=" + n + "&s_txt=" + t + "&p=" + p;
	}
}


function goJoin() {
	location.href = "member.join.go";
}

function goMemberInfo() {
	location.href = "member.info";
}


function deleteCommunityMsg(n) {
	var ok = confirm("?");
	if (ok) {
		location.href = "community.delete?c_no=" + n;
	}
}


function sendCommunityMsg(to) {
	var t = prompt("말", t);
	if (t != null && t.length > 0 && t.length < 180) {
		location.href = "community.send?c_to=" + to + "&c_txt=" + t;
	}
}



// 카카오 로그인
//function logout2(){
//	let ok = confirm('로그아웃 하시겠습니까?');
//	if(ok){
//		location.href='https://kauth.kakao.com/oauth/logout?client_id=3329760d3806e669eb2fc2fe665d6bba&logout_redirect_uri=http://localhost/pj/kakao.logout';
//	}	
//}





