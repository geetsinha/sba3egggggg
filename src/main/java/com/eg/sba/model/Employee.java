package com.eg.sba.model;

public class Employee {
	
	private String empno;
	private String empName;
	private String position;
	
	public Employee() {}
	
	
	
	public Employee(String empno, String empName, String position) {
		super();
		this.empno = empno;
		this.empName = empName;
		this.position = position;
	}
	public String getEmpno() {
		return empno;
	}
	public void setEmpno(String empno) {
		this.empno = empno;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	

}
