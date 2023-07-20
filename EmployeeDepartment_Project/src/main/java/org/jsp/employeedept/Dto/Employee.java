package org.jsp.employeedept.Dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String desg;
	private double salary;
	private long phone;
	private String password;
	@ManyToOne
	@JoinColumn(name = "dept_id")
	private Department dept;

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDesg() {
		return desg;
	}

	public double getSalary() {
		return salary;
	}

	public long getPhone() {
		return phone;
	}

	public String getPassword() {
		return password;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDesg(String desg) {
		this.desg = desg;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
