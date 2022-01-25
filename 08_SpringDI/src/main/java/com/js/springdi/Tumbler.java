package com.js.springdi;

public class Tumbler {

	private Human2 owner;
	
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
