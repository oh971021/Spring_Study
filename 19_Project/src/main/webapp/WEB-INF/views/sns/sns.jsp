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

<c:forEach var="m" items="${msgs }">
	<table class="aSNSMsg">
		<tr>
		<td class="asmImgTd" align="center" valign="top" rowspan="4">
				<img src="resources/img/${m.m_photo }">
			</td>
		
			<td class="asmOwner">${m.s_owner }</td>
		</tr>
		<tr>
			<td><fmt:formatDate value="${m.s_date }" type="both"
					dateStyle="short" timeStyle="short" /></td>
		</tr>
		<tr>
			<td class="asmTxt">${m.s_txt }</td>
		</tr>	
		
		<tr>
			<td class="asmReply">
				<c:forEach var="sr" items="${m.s_reply }">
					<span class="asmrOwner">${sr.r_owner }</span>-&nbsp;${sr.r_txt }&nbsp;
					<span class="asmrWhen">(<fmt:formatDate value="${sr.r_when }" type="both" dateStyle="short" timeStyle="short"/>)</span>
					<c:if test="${sr.r_owner == sessionScope.loginMember.m_id }">
						<button class="asmrBtn" onclick="deleteSNSReply(${sr.r_no}, ${curPage });">삭제</button>
					</c:if>
					<br>
				</c:forEach>
				<c:if test="${sessionScope.loginMember != null }">
					<form action="sns.reply.write" onsubmit="return snsWriteReplyCheck(this);">
						<span class="asmrOwner">${sessionScope.loginMember.m_id }</span> 
						<input type="hidden" name="token" value="${token }">
						<input type="hidden" name="r_s_no" value="${m.s_no }">
						<input type="hidden" name="p" value="${curPage }">
						<input class="asmrInput" name="r_txt" maxlength="80" autocomplete="off">
						<button class="asmrBtn">쓰기</button>
					</form>
				</c:if>
			</td>
		</tr>
		
		
		
		
		<c:if test="${m.s_owner == sessionScope.loginMember.m_id }">			
			<tr>
				<td colspan="2" align="right">
					<button onclick="updateSNSMsg(${m.s_no}, '${m.s_txt}', ${curPage });" class="aSNSMsgBtn">수정</button>
					<button onclick="deleteSNSMsg(${m.s_no});" class="aSNSMsgBtn">삭제</button>
				</td>
			</tr>
		</c:if>
	</table>	
</c:forEach>
	

</body>
</html>