package com.lab1.oop.employee;

public class Intern extends Employee {
	private String majors;
	private int semester;
	private String university;

	public Intern(int id, String fullName, String birthDay, String phone, String email, int employeeType) {
		super(id, fullName, birthDay, phone, email, employeeType);
		// TODO Auto-generated constructor stub
	}
	
	public String getMajors() {
		return majors;
	}

	public void setMajors(String majors) {
		this.majors = majors;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	@Override
	public void showInfo() {
		System.out.println(super.toString()
				+ String.format(", Majors:%s, Semester:%s, University:%s", majors, semester, university));

	}

}
