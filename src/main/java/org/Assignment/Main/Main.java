package org.Assignment.Main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import org.Assignment.Exceptions.StudentExceptions;
import org.Assignment.Exceptions.DepartmentExceptions;
import org.Assignment.Domain.Student;
import org.Assignment.Domain.Department;
import org.Assignment.Services.DepartmentServices;
import org.Assignment.Services.StudentServices;
import org.Assignment.Services.FileServices;

public class Main {

    private ArrayList<Department> departments = new ArrayList();
    private static Connection connection = null;
    private static Properties dbProperties = null;

    public static void main(String[] args) throws SQLException {

        initiateDatabase();
       // CreateThreeDepartments();
       // UpdateDepartment();
        //DeleteHistoryDepartment(Integer.parseInt(dbProperties.getProperty("delete.historyId")));
        //CreateThreeStudents();
    }



    private static void CreateThreeDepartments() {

        Department department = null;

        try {
            InsertDepartmentToDatabase(Integer.parseInt(dbProperties.getProperty("create.department.departmentId1")),dbProperties.getProperty("create.department.departmentNumberOfTracks1"),dbProperties.getProperty("create.department.departmentName1"));
            InsertDepartmentToDatabase(Integer.parseInt(dbProperties.getProperty("create.department.departmentId2")),dbProperties.getProperty("create.department.departmentNumberOfTracks2"),dbProperties.getProperty("create.department.departmentName2"));
            InsertDepartmentToDatabase(Integer.parseInt(dbProperties.getProperty("create.department.departmentId3")),dbProperties.getProperty("create.department.departmentNumberOfTracks3"),dbProperties.getProperty("create.department.departmentName3"));
        } catch (SQLException e) {
            System.out.println("Problem with business sql: " + e.getMessage());
        } catch (DepartmentExceptions e) {
            throw new RuntimeException(e);
        }

    }


    private static void CreateThreeStudents() {

        Student student = null;

        try {
            InsertStudentsToDatabase(Integer.parseInt(dbProperties.getProperty("studentId1")),Integer.parseInt(dbProperties.getProperty("departmentid1")),dbProperties.getProperty("student.name"),dbProperties.getProperty("student.lastname"),Integer.parseInt(dbProperties.getProperty("student.phone")));
            InsertStudentsToDatabase(Integer.parseInt(dbProperties.getProperty("studentId2")),Integer.parseInt(dbProperties.getProperty("departmentid2")),dbProperties.getProperty("student.name2"),dbProperties.getProperty("student.lastname2"),Integer.parseInt(dbProperties.getProperty("student.phone2")));
            InsertStudentsToDatabase(Integer.parseInt(dbProperties.getProperty("studentId3")),Integer.parseInt(dbProperties.getProperty("departmentid3")),dbProperties.getProperty("student.name3"),dbProperties.getProperty("student.lastname3"),Integer.parseInt(dbProperties.getProperty("student.phone3")));
        } catch (SQLException e) {
            System.out.println("Problem with business sql: " + e.getMessage());
        } catch (DepartmentExceptions e) {
            throw new RuntimeException(e);
        }

    }





    private static void UpdateDepartment() throws SQLException {
        UpdateDepartmentUsId(Integer.parseInt(dbProperties.getProperty("update.departmnent.Id")),dbProperties.getProperty("update.departmnent.managemnent"));

    }



    private static void initiateDatabase() {
        try {
            readProperties();
            useMySqlDriver();
            connectToDatabase(dbProperties.getProperty("connection.schema"));
            //System.out.println("connected");
        } catch (SQLException e) {
            System.out.println("Problem with system SQL: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Problem with system file: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Problem with system: " + e.getMessage());
        }
    }


    private static void readProperties() throws IOException {
        InputStream inStream = Main.class.getClassLoader().getResourceAsStream("sql.properties");
        dbProperties = new Properties();
        dbProperties.load(inStream);
    }

    private static void useMySqlDriver() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
    }

    private static Connection connectToDatabase(String schema) throws SQLException {
        String dbUrl = dbProperties.getProperty("connection.url");
        String username = dbProperties.getProperty("connection.username");
        String password = dbProperties.getProperty("connection.password");
        connection = DriverManager.getConnection(dbUrl + "/" + schema, username, password);
        return connection;
    }

    //Insert departments

    private static void InsertDepartmentToDatabase(int departmentid,String numberoftracks,String departmentname) throws SQLException, DepartmentExceptions {
        DepartmentServices service = new DepartmentServices(connection);
        service.InsertDepartmentToDb(departmentid,numberoftracks,departmentname);
    }

    private static void InsertStudentsToDatabase(int student_id,int department_id,String name,String lastName, int phone) throws SQLException, DepartmentExceptions {
        StudentServices service = new StudentServices(connection);
        service.InsertStudentsToDatabase(student_id,department_id,name,lastName,phone);
    }

    private static void UpdateDepartmentUsId(int departmentid,String departmentname) throws SQLException {
        DepartmentServices service = new DepartmentServices(connection);
        service.updateDepartmentNameId(departmentid,departmentname);
    }

    private static void DeleteHistoryDepartment(int departmentid) throws SQLException {
        DepartmentServices service = new DepartmentServices(connection);
        service.deleteRowFromDepartmentUsingId(departmentid);
    }

}
