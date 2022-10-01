package com.lab1.oop.employee;

public class Fresher extends Employee {
	
	private String graduationDate;
	private String graduaionRank;
	private String education;
	
	public Fresher(int id, String fullName, String birthDay, String phone, String email, int employeeType) {
		super(id, fullName, birthDay, phone, email, employeeType);
		
	}

	public String getGraduationDate() {
		return graduationDate;
	}

	public void setGraduationDate(String graduationDate) {
		this.graduationDate = graduationDate;
	}

	public String getGraduaionRank() {
		return graduaionRank;
	}

	public void setGraduaionRank(String graduaionRank) {
		this.graduaionRank = graduaionRank;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	@Override
	public void showInfo() {
		System.out.println(super.toString() + String.format(", Graduation date:%s, Graduation rank:%s, Education:%s",
				graduationDate, graduaionRank, education));
	}
}
