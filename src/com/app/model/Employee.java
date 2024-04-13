package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "emp")
public class Employee {
	
	@Id
	@Column(name = "id", length = 250)
	private int emp_id;
	@Column(name = "name", length = 250)
	private String emp_name;
	@Column(name = "dept", length = 250)
	private String dept_name;
	@Column(name = "sallary", length = 250)
	private int emp_sall;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(int emp_id, String emp_name, String dept_name, int emp_sall) {
		super();
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.dept_name = dept_name;
		this.emp_sall = emp_sall;
	}

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	public int getEmp_sall() {
		return emp_sall;
	}

	public void setEmp_sall(int emp_sall) {
		this.emp_sall = emp_sall;
	}

	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", emp_name=" + emp_name + ", dept_name=" + dept_name + ", emp_sall="
				+ emp_sall + "]";
	}
	
	

}
