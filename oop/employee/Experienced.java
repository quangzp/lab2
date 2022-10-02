package com.lab1.oop.employee;

public class Experienced extends Employee {
    private int expInYear;
    private String proSkill;

    public Experienced() {
        super();
    }

    public Experienced(int id, String fullName, String birthDay, String phone, String email, int employeeType) {
        super(id, fullName, birthDay, phone, email, employeeType);
    }

    public int getExpInYear() {
        return expInYear;
    }

    public void setExpInYear(int expInYear) {
        this.expInYear = expInYear;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }

    @Override
    public void showInfo() {
        System.out
                .println(super.toString() + String.format(", Experience years:%d, Pro skill:%s", expInYear, proSkill));
    }

}
