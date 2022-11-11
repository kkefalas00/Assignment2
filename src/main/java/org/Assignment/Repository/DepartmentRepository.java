package org.Assignment.Repository;

import org.Assignment.Domain.Department;
import org.Assignment.Exceptions.DepartmentExceptions;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DepartmentRepository {

    private Connection connection;
    private ArrayList<Department> departments = new ArrayList();


    public DepartmentRepository (Connection connection){
        this.connection=connection;
    }

    public void InsertDepartmentToDb(int departmentid,String numberoftracks,String departmentname) throws SQLException{
        Statement statement = connection.createStatement();
        String sql = "INSERT INTO department(departmentid,numberoftracks,departmentname) VALUES ('"+departmentid+"','" + numberoftracks + "','" + departmentname + "')";
        statement.executeUpdate(sql);
        System.out.println("department is inserted");
    }

    public void updateDepartment(int departmentid,String departmentname) throws SQLException{
        Statement statement = connection.createStatement();
        String sql="UPDATE department SET departmentname ='"+departmentname +"'  WHERE departmentid="+departmentid;
        statement.executeUpdate(sql);
        System.out.println("department is updated");
    }

    public void deleteDepartmentRowUsingId(int departmentid) throws SQLException{
        Statement statement = connection.createStatement();
        String sql="delete from department WHERE departmentid="+departmentid;
        statement.executeUpdate(sql);
        System.out.println("Department with id"+departmentid+" was deleted");

    }

    public ArrayList<Department> findAllDepartments() throws SQLException, DepartmentExceptions {
        Statement statement = connection.createStatement();
        String sql = "select * from department";
        ResultSet rs = statement.executeQuery(sql);
        Department department = null;
        if (rs.next()) {

            int departmentId= Integer.parseInt(rs.getString("departmentid"));
            String numberOfTracks= rs.getString("numberoftracks");
            String departmentname = rs.getString("departmentname");


            department = new Department(departmentId,numberOfTracks,departmentname);

            departments.add(department);
        }
        rs.close();
        if (departments == null) {
            throw new DepartmentExceptions("Cannot find any department");
        }
        return departments;
    }


    public Department getDepartmentUsingId(int departmentid) throws SQLException, DepartmentExceptions {
        Statement statement = connection.createStatement();
        String sql = "select * from department where departmentid=" + departmentid;
        ResultSet rs = statement.executeQuery(sql);
        Department Department = null;
        if (rs.next()) {

            int department_id= Integer.parseInt(rs.getString("department_id"));
            String numberOfTracks= rs.getString("numberoftracks");
            String departmentname = rs.getString("departmentname");


            Department = new Department(department_id,numberOfTracks,departmentname);
        }
        rs.close();
        if (Department == null) {
            throw new DepartmentExceptions("Cannot find department with id=" + departmentid);
        }
        return Department;
    }

}
