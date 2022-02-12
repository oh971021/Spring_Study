package com.js.pj.sns;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.js.pj.SiteOption;

@Service
public class SNSDAO {

	@Autowired
	private SqlSession ss;
	
	@Autowired	// context.xml에서 같은이름이 선언된 클래스의 초기화값을 가져온다
	private SiteOption so;
	
	public SNSDAO() {
		// TODO Auto-generated constructor stub
	}
	
	// ---------------- 댓글 갯수 ----------------- //
	private int allMsgCount;
	
	public SNSDAO(int allMsgCount) {
		super();
		this.allMsgCount = allMsgCount;
	}
	
	public int getAllMsgCount() {
		return allMsgCount;
	}

	public void setAllMsgCount(int allMsgCount) {
		this.allMsgCount = allMsgCount;
	}
	// --------------- //댓글 갯수 ---------------- //
	
	public void calcAllMsgCount() {
		SNSSelector sSel = new SNSSelector("", null, null);	// 검색어, 숫자두개
		allMsgCount = ss.getMapper(SNSMapper.class).getMsgCount(sSel);
	}

	
	// 게시글 표시하는 기능
	public void getMsg(int pageNo, HttpServletRequest req) {

		// 한 페이지에 몇 개의 게시글을 보여줄거냐?
		int count = so.getSnsCountPerpage();
		int start = (pageNo - 1) * count + 1;
		int end = start + (count - 1);

		SNSSelector search = (SNSSelector) req.getSession().getAttribute("search");
		int msgCount = 0;

		if (search == null) {
			search = new SNSSelector("", new BigDecimal(start), new BigDecimal(end));
			msgCount = allMsgCount;	// 전체 댓글 수 (출력 값 숫자)
		} else {
			search.setStart(new BigDecimal(start));
			search.setEnd(new BigDecimal(end));
			msgCount = ss.getMapper(SNSMapper.class).getMsgCount(search);
		}

		List<SNSMsg> msgs = ss.getMapper(SNSMapper.class).getMsg(search);
		
		for (SNSMsg snsMsg : msgs) {	// 게시글 하나가 가지고 있는 댓글들을 출력함
			snsMsg.setS_reply(ss.getMapper(SNSMapper.class).getReply(snsMsg));
			// snsMsg : List 댓글들을 담는 속성					// 리스트 (댓글들이 들어있음)
							
		}

		int pageCount = (int) Math.ceil(msgCount / (double) count);	// 댓글을 몇 페이지로 나눠서 표시할지 나타냄
		req.setAttribute("pageCount", pageCount);

		req.setAttribute("msgs", msgs);
		req.setAttribute("curPage", pageNo);

	}

	
}
