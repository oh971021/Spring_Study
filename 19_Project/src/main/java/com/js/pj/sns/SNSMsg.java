package com.js.pj.sns;

import java.util.Date;
import java.util.List;

public class SNSMsg {
	
	private int s_no;
	private String s_owner;
	private String s_txt;
	private Date s_date;

	// 글을 등록한 유저의 사진이 표시되도록 한다.
	private String m_photo;
	
	// 댓글 여러개를 가지고 있다. (리스트 쓰는이유)
	private List<SNSReply> s_reply;
	
	public SNSMsg() {
		// TODO Auto-generated constructor stub
	}

	public SNSMsg(int s_no, String s_owner, String s_txt, Date s_date, String m_photo, List<SNSReply> s_reply) {
		super();
		this.s_no = s_no;
		this.s_owner = s_owner;
		this.s_txt = s_txt;
		this.s_date = s_date;
		this.m_photo = m_photo;
		this.s_reply = s_reply;
	}

	public int getS_no() {
		return s_no;
	}

	public void setS_no(int s_no) {
		this.s_no = s_no;
	}

	public String getS_owner() {
		return s_owner;
	}

	public void setS_owner(String s_owner) {
		this.s_owner = s_owner;
	}

	public String getS_txt() {
		return s_txt;
	}

	public void setS_txt(String s_txt) {
		this.s_txt = s_txt;
	}

	public Date getS_date() {
		return s_date;
	}

	public void setS_date(Date s_date) {
		this.s_date = s_date;
	}

	public String getM_photo() {
		return m_photo;
	}

	public void setM_photo(String m_photo) {
		this.m_photo = m_photo;
	}

	public List<SNSReply> getS_reply() {
		return s_reply;
	}

	public void setS_reply(List<SNSReply> s_reply) {
		this.s_reply = s_reply;
	}
	
	
	
}
