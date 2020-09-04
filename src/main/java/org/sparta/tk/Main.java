package org.sparta.tk;
import org.sparta.tk.FileHandler.FileReader;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, SQLException {
        List<Employee> employees;
        employees = FileReader.readEmployeesFromCSV();
        EmployeeDAO.establishConnection(employees);
    }
}
