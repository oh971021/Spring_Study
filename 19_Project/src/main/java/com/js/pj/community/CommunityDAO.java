package com.js.pj.community;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.js.pj.member.Member;

@Service
public class CommunityDAO {

	@Autowired
	SqlSession ss;
	
	// 메세지하는 멤버 가져오는 기능
	public void getMember(HttpServletRequest req) {
		try {
			req.setAttribute("members", ss.getMapper(CommunityMapper.class).getMember());
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	// 메시지 가져오는 기능
	public void getMsg(HttpServletRequest req) {
		try {
			Member m = (Member) req.getSession().getAttribute("loginMember");
			req.setAttribute("msgs", ss.getMapper(CommunityMapper.class).getMsg(m));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 메세지 삭제하는 기능
	public void deleteMsg(CommunityMsg cm, HttpServletRequest req) {
		try {
			if (ss.getMapper(CommunityMapper.class).deleteMsg(cm) == 1) {
				req.setAttribute("result", "쪽지삭제성공");
			} else {
				req.setAttribute("result", "쪽지삭제실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "쪽지삭제실패");
		}
	}
	
	// 메세지 보내는 기능
	public void sendMsg(CommunityMsg cm, HttpServletRequest req) {
		try {
			Member m = (Member) req.getSession().getAttribute("loginMember");
			cm.setC_from(m.getM_id());
			if (ss.getMapper(CommunityMapper.class).sendMsg(cm) == 1) {
				req.setAttribute("result", "쪽지보내기성공");
			} else {
				req.setAttribute("result", "쪽지보내기실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "쪽지보내기실패");
		}
	}

}
