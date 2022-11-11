package org.Assignment.Repository;


import org.Assignment.Domain.Department;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class CsvRepository {

    public static void writeDepartmentToCsvFile(String filename, Department department) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(filename);
        String line = department.getDepartment_id() + "," + department.getDepartmentName() + "," + department.getNumberOfTracks();
        pw.println(line);
        pw.close();
    }
}
