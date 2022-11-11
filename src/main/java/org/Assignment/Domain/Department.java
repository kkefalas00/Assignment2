package org.Assignment.Domain;

public class Department {
    private int department_id;
    private String departmentName;
    private String numberOfTracks;

    public Department(){}

    public Department(int department_id, String departmentName,String numberOfTracks){

        this.department_id=department_id;
        this.departmentName=departmentName;
        this.numberOfTracks=numberOfTracks;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getNumberOfTracks() {
        return numberOfTracks;
    }

    public void setNumberOfTracks(String numberOfTracks) {
        this.numberOfTracks = numberOfTracks;
    }

    @Override
    public String toString() {
        return "Department{" +
                "department_id=" + department_id +
                ", departmentName='" + departmentName + '\'' +
                ", numberOfTracks='" + numberOfTracks + '\'' +
                '}';
    }
}
