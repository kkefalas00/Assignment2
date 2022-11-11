package org.Assignment.Services;

import org.Assignment.Domain.Department;
import java.io.FileNotFoundException;
import org.Assignment.Repository.CsvRepository;

public class FileServices {

    public FileServices(){}

    private String filename;

    public FileServices(String filename) {

        this.filename = filename;
    }

    public void saveDepartment(Department department) throws FileNotFoundException {
        CsvRepository.writeDepartmentToCsvFile(filename,department);
    }


}
