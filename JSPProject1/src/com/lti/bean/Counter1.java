package com.lti.bean;

public class Counter1 {
	private int count;

	public Counter1() { }
	
	public int getCount() {
		return ++count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
}
