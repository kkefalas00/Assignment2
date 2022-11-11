package org.Assignment.Services;


import org.Assignment.Repository.DepartmentRepository;
import org.Assignment.Exceptions.DepartmentExceptions;
import org.Assignment.Domain.Department;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;


public class DepartmentServices {

    private DepartmentRepository departmentRepository;
    private ArrayList<Department> departments = new ArrayList();

    public DepartmentServices(Connection connection) {

        departmentRepository = new DepartmentRepository(connection);
    }


    public Department findDepartmentWithId(int department_id) throws SQLException, DepartmentExceptions {

        Department d = departmentRepository.getDepartmentUsingId(department_id);
        return d;
    }

    public ArrayList<Department> getAllDepartments() throws SQLException, DepartmentExceptions{

        departmentRepository.findAllDepartments();

        return departments;
    }

    public void InsertDepartmentToDb(int departmentid,String numberoftracks,String departmentname) throws SQLException {
        departmentRepository.InsertDepartmentToDb(departmentid,numberoftracks,departmentname);
    }

    public void updateDepartmentNameId(int departmentid,String departmentname) throws SQLException{
        departmentRepository.updateDepartment(departmentid,departmentname);
    }

    public void deleteRowFromDepartmentUsingId(int departmentid) throws SQLException{
        departmentRepository.deleteDepartmentRowUsingId(departmentid);
    }


}
