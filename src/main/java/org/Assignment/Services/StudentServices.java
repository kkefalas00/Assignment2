package org.Assignment.Services;

import org.Assignment.Repository.StudentRepository;

import org.Assignment.Exceptions.StudentExceptions;
import org.Assignment.Domain.Student;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentServices {

    private StudentRepository studentRepository;
    private ArrayList<Student> students = new ArrayList();

    public StudentServices(Connection connection) {

        studentRepository = new StudentRepository(connection);
    }


    public Student findStudentWithId(int student_id) throws SQLException, StudentExceptions {

        Student s = studentRepository.getStudentUsingId(student_id);
        return s;
    }

    public ArrayList<Student> getAllStudents() throws SQLException, StudentExceptions{

        studentRepository.findAll();

        return students;
    }

    public void InsertStudentsToDatabase(int student_id,int department_id,String name,String lastName, int phone) throws SQLException {
        studentRepository.InsertStudentToDb(student_id,department_id,name,lastName,phone);
    }

    public void updateStudentFirstNameAndLastNameWithId(int student_id,String name,String lastName) throws SQLException{
        studentRepository.updateStudent(student_id,name,lastName);
    }

    public void deleteRowFromStudentUsingId(int student_id) throws SQLException{
        studentRepository.deleteStudentRowUsingId(student_id);
    }

}
