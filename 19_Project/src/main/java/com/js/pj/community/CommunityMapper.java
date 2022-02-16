package com.js.pj.community;

import java.util.List;

import com.js.pj.member.Member;

public interface CommunityMapper {

	public List<Member> getMember();
	public List<CommunityMsg> getMsg(Member m);
	public int deleteMsg(CommunityMsg cm);
	public int sendMsg(CommunityMsg cm);

}
