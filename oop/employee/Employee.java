package com.lab1.oop.employee;

import java.util.*;

public abstract class Employee {
	private int id;
	private String fullName;
	private String birthDay;
	private String phone;
	private String email;
	private int employeeType;
	private List<Certificate> certificates = new ArrayList<>(); // per instance of employee has a certificates list 
	// static variables of class
	private static int employeeCount = 0;
	private static List<Employee> list = new LinkedList<>();
	
	protected Employee(int id, String fullName, String birthDay, String phone, String email,int employeeType) {
		this.id = id;
		this.fullName = fullName;
		this.birthDay = birthDay;
		this.phone = phone;
		this.email = email;
		this.employeeType = employeeType;
		employeeCount++;
		list.add(this);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(int employeeType) {
		this.employeeType = employeeType;
	}

	public static int getEmployeeCount() {
		return employeeCount;
	}
	
	public static void setEmployeeCount(int employeeCount) {
		Employee.employeeCount = employeeCount;
	}

	public abstract void showInfo();

	public List<Certificate> getCertificates() {
		return certificates;
	}

	public void setCertificates(List<Certificate> certificates) {
		this.certificates = certificates;
	}

	public static List<Employee> getList() {
		return list;
	}

	public static void setList(List<Employee> list) {
		Employee.list = list;
	}

	@Override
	public String toString() {
		return String.format("ID:%d, Full name:%s, Birdday:%s, Phone:%s, Email:%s", id, fullName, birthDay, phone,
				email);
	}
}
