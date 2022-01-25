package com.js.springdi;

public class Cat {
	
	private Human master;
	
	public Cat() {
		// TODO Auto-generated constructor stub
	}

	public Cat(Human master) {
		super();
		this.master = master;
	}

	public Human getMaster() {
		return master;
	}

	public void setMaster(Human master) {
		this.master = master;
	}
	
	public void info() {
		master.info();
	}
}
