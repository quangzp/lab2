package com.lab1.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
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
        createOrUpdate(2, "Quang Hoai Duc", "2022-10-12", "0967199112", "quangng9112@gmail.com", 2);
        System.out.println(Employee.getEmployeeCount());
        System.out.println(Employee.getList().get(0));
    }

    public static void createOrUpdate(int id, String fullName, String birthDay, String phone, String email, int employeeType) {

        try {
            // check exception
            if (!patternMatches(fullName, Regex.FULL_NAME))
                throw new FullNameException("Invalid full name:" + fullName);
            if (!patternMatches(birthDay, Regex.DATE))
                throw new BirthDayException("Invalid birth day:" + birthDay);
            if (!patternMatches(phone, Regex.PHONE))
                throw new PhoneException("Invalid phone:" + phone);
            if (!patternMatches(email, Regex.EMAIL))
                throw new EmailException("Invalid email:" + email);

            System.out.println(delete(id));

            Employee e = buildEmp(employeeType);
            e.setId(id);
            e.setFullName(fullName);
            e.setBirthDay(birthDay);
            e.setPhone(phone);
            e.setEmail(email);
            e.setEmployeeType(employeeType);

            inputSubAttribute(e);

            Employee.getList().add(e);
            Employee.setEmployeeCount(Employee.getList().size());

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public static boolean delete(int id) {
        Employee emp = findById(id);
        if (emp != null) {
            Employee.getList().remove(emp);
            Employee.setEmployeeCount(Employee.getList().size());
            return true;
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

    public static List<Employee> findByEmployeeType(int type) {
        List<Employee> lizt = new ArrayList<>();
        for (Employee e : Employee.getList()) {
            if (e.getEmployeeType() == type) {
                lizt.add(e);
            }
        }
        return lizt;
    }

    public static Employee buildEmp(int type) {
        if (type == 0) return new Experienced();
        else if (type == 1) return new Fresher();
        return new Intern();
    }

    public static void inputSubAttribute(Employee e) {
        Scanner sc = new Scanner(System.in);
        if (e instanceof Experienced) {
            System.out.println("nhap so nam kinh nghiem:");
            int expYear = Integer.parseInt(sc.nextLine());
            System.out.println("Nhap ky nang chuyen mon");
            String skill = sc.nextLine();

            ((Experienced) e).setExpInYear(expYear);
            ((Experienced) e).setProSkill(skill);
        } else if (e instanceof Fresher) {
            System.out.println("Thoi gian tot nghiep:");
            String graduationDate = sc.nextLine();
            System.out.println("Xep loai tot nghiep:");
            String graduationRank = sc.nextLine();
            System.out.println("Truong tot nghiep:");
            String education = sc.nextLine();

            ((Fresher) e).setGraduationDate(graduationDate);
            ((Fresher) e).setGraduaionRank(graduationRank);
            ((Fresher) e).setEducation(education);
        } else if (e instanceof Intern) {

            System.out.println("Chuyen nganh dang hoc:");
            String majors = sc.nextLine();
            System.out.println("Hoc ki:");
            int semester = Integer.parseInt(sc.nextLine());
            System.out.println("Truong dang hoc:");
            String universityName = sc.nextLine();

            ((Intern) e).setMajors(majors);
            ((Intern) e).setSemester(semester);
            ((Intern) e).setUniversity(universityName);
        }
        sc.close();
    }
}
