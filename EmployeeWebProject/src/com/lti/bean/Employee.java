package com.lti.bean;

import java.time.LocalDate;

public class Employee {

	private int id;
	private String fname;
	private String iname;
	private LocalDate doj;
	private int dept;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(int id, String fname, String iname, LocalDate doj, int dept) {
		super();
		this.id = id;
		this.fname = fname;
		this.iname = iname;
		this.doj = doj;
		this.dept = dept;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getFname() {
		return fname;
	}



	public void setFname(String fname) {
		this.fname = fname;
	}



	public String getIname() {
		return iname;
	}



	public void setIname(String iname) {
		this.iname = iname;
	}



	public LocalDate getDoj() {
		return doj;
	}



	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}
	

	public int getDept() {
		return dept;
	}

	public void setDept(int dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", fname=" + fname + ", iname=" + iname +", doj=" + doj + ", dept=" + dept + "]";
	}

	
}
