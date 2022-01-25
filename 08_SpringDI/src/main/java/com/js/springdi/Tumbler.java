package com.js.springdi;

import org.springframework.beans.factory.annotation.Autowired;

public class Tumbler {

	@Autowired	// 자동으로 만들고 연결해주는 ... (DI)
	private Human2 owner;	// 휴먼2로 만들어진 친구를 찾음..
								// 그 찾은 빈을 이 곳에 대입시킨다..	
								// 그 빈의 데이터는 xml의 id를 통해 찾아간다
	
	public Tumbler() {
		// TODO Auto-generated constructor stub
	}

	public Tumbler(Human2 owner) {
		super();
		this.owner = owner;
	}

	public Human2 getOwner() {
		return owner;
	}

	public void setOwner(Human2 owner) {
		this.owner = owner;
	}
	
	public void info() {
		owner.info();
	}
	
}
