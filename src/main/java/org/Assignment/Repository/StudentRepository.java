package org.Assignment.Repository;


import org.Assignment.Domain.Student;
import org.Assignment.Exceptions.StudentExceptions;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class StudentRepository {

    private Connection connection;
    private ArrayList<Student> students = new ArrayList();

    public StudentRepository (Connection connection){
        this.connection=connection;
    }

    public void InsertStudentToDb(int student_id,int department_id,String name,String lastName, int phone) throws SQLException{
        Statement statement = connection.createStatement();
        String sql = "INSERT INTO student(student_id,department_id,name,lastName,phone) VALUES ('"+student_id+"','" + department_id + "','" + name + "','" + lastName + "','" + phone+"')";
        statement.executeUpdate(sql);
        System.out.println("student is inserted");
    }

    public void updateStudent(int student_id,String name,String lastName) throws SQLException{
        Statement statement = connection.createStatement();
        String sql="UPDATE student SET name ='"+name +"',lastName ='"+lastName +"'  WHERE student_id="+student_id;
        statement.executeUpdate(sql);
        System.out.println("student is updated");
    }

    public void deleteStudentRowUsingId(int student_id) throws SQLException{
        Statement statement = connection.createStatement();
        String sql="delete from student WHERE student_id="+student_id;
        statement.executeUpdate(sql);
        System.out.println("student with id"+student_id+" was deleted");

    }

    public ArrayList<Student> findAll() throws SQLException, StudentExceptions {
        Statement statement = connection.createStatement();
        String sql = "select * from customer";
        ResultSet rs = statement.executeQuery(sql);
        Student student = null;
        if (rs.next()) {

            int student_id= Integer.parseInt(rs.getString("student_id"));
            int department_id= Integer.parseInt(rs.getString("department_id"));
            String name = rs.getString("name");
            String lastName = rs.getString("customer_lastName");
            int phone= Integer.parseInt(rs.getString("phone"));

            student = new Student(student_id,department_id,name,lastName,phone);

            students.add(student);
        }
        rs.close();
        if (students == null) {
            throw new StudentExceptions("Cannot find any student");
        }
        return students;
    }


    public Student getStudentUsingId(int student_id) throws SQLException, StudentExceptions {
        Statement statement = connection.createStatement();
        String sql = "select * from student where student_id=" + student_id;
        ResultSet rs = statement.executeQuery(sql);
        Student Student = null;
        if (rs.next()) {

            int department_id= Integer.parseInt(rs.getString("department_id"));
            String name = rs.getString("name");
            String lastName = rs.getString("customer_lastName");
            int phone= Integer.parseInt(rs.getString("phone"));

            Student = new Student(student_id,department_id,name,lastName,phone);
        }
        rs.close();
        if (Student == null) {
            throw new StudentExceptions("Cannot find Student with id=" + student_id);
        }
        return Student;
    }

}
