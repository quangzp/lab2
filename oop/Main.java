package com.lab1.oop;

import java.util.regex.Pattern;

import com.lab1.oop.employee.Employee;
import com.lab1.oop.employee.Experienced;
import com.lab1.oop.employee.Fresher;
import com.lab1.oop.employee.Intern;
import com.lab1.oop.exception.BirthDayException;
import com.lab1.oop.exception.EmailException;
import com.lab1.oop.exception.FullNameException;
import com.lab1.oop.exception.PhoneException;

public class Main {

	public static void main(String[] args) {

	}

	public static void createOrUpdate(int id, String fullName, String birthDay, String phone, String email,
			int employeeType) {

		try {
			// check exception
			if (!patternMatches(fullName, Regex.FULL_NAME))
				throw new FullNameException("Invalid:" + fullName);
			if (!patternMatches(birthDay, Regex.DATE))
				throw new BirthDayException("Incorrect format:" + birthDay);
			if (!patternMatches(phone, Regex.PHONE))
				throw new PhoneException("Invalid:" + phone);
			if (!patternMatches(email, Regex.DATE))
				throw new EmailException("Invalid:" + email);

			Employee emp = findById(id);
			if (emp != null) { // update
				emp.setFullName(fullName);
				emp.setBirthDay(birthDay);
				emp.setPhone(phone);
				emp.setEmail(email);
			} else { // create
				if (employeeType == 0) {
					emp = new Experienced(id, fullName, birthDay, phone, email, employeeType);
				} else if (employeeType == 1) {
					emp = new Fresher(id, fullName, birthDay, phone, email, employeeType);
				} else {
					emp = new Intern(id, fullName, birthDay, phone, email, employeeType);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static boolean delete(int id) {
		Employee emp = findById(id);
		if (emp != null) {
			Employee.getList().remove(emp);
			Employee.setEmployeeCount(Employee.getList().size());
		}
		return false;
	}

	public static boolean patternMatches(String value, String regexPattern) {
		return Pattern.compile(regexPattern).matcher(value).matches();
	}

	public static Employee findById(int id) {
		for (Employee e : Employee.getList()) {
			if (e.getId() == id)
				return e;
		}
		return null;
	}
}
