package org.Assignment.Domain;

public class Student {

    private int student_id;
    private int department_id;
    private String name;

    private String lastName;
    private int phone;

    public Student(){}

    public Student(int student_id,int department_id, String name,String lastName,int phone ){

        this.student_id=student_id;
        this.department_id=department_id;
        this.name=name;
        this.lastName=lastName;
        this.phone=phone;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Student{" +
                "student_id=" + student_id +
                ", department_id=" + department_id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone=" + phone +
                '}';
    }
}
