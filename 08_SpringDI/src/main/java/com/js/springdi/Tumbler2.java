package com.js.springdi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Tumbler2 {
	
	@Qualifier("catMaster")	// xml에 Human 클래슬 만들어진게 여러개가 있으면 자동으로 id를 통해 구분 해주는 친구
	@Autowired	// xml에 정의해논거 중에 Human 클래스로 만들어져있는걸 넣어준다.
	private Human owner;
	
	public Tumbler2() {
		// TODO Auto-generated constructor stub
	}

	public Tumbler2(Human owner) {
		super();
		this.owner = owner;
	}

	public Human getOwner() {
		return owner;
	}

	public void setOwner(Human owner) {
		this.owner = owner;
	}
	
	public void info() {
		owner.info();	// 주인의 이름, 나이, 키, 체중이 나옴
	}
}
