package org.sparta.tk.FileHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sparta.tk.Employee;
import org.sparta.tk.ValidateDataUtilityClass;

import java.util.*;
import java.io.*;

public class FileReader {
    private static final Logger logger = LogManager.getLogger();

    public static List<Employee> readEmployeesFromCSV() throws IOException {
        List<Employee> employees = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader("src/main/resources/employees.csv"));
        var line = "";
        double start = System.nanoTime();
        bufferedReader.readLine();
        BufferedWriter invalidBufferedWriter = WriteToFile.createInvalidTextFile();
        BufferedWriter validBufferedWriter = WriteToFile.createValidTextFile();
        logger.info("Reading from CSV file");
        while ((line = bufferedReader.readLine()) != null) {
            String[] employeeRow = line.split(",");
            if(ValidateDataUtilityClass.cleanData(employeeRow) && !ValidateDataUtilityClass.containsDuplicates(employees, employeeRow[0], employeeRow[6])){
                employees.add(new Employee(employeeRow[0], employeeRow[1], employeeRow[2], employeeRow[3], employeeRow[4], employeeRow[5], employeeRow[6], employeeRow[7], employeeRow[8], employeeRow[9]));
                WriteToFile.writeToValidDataFile(employeeRow,validBufferedWriter);
            }else{
                WriteToFile.writeToInvalidDataFile(employeeRow, invalidBufferedWriter);
            }
        }
        logger.info("Finished writing to ValidData.txt file");
        validBufferedWriter.close();
        logger.info("Finished writing to InvalidData.txt file");
        invalidBufferedWriter.close();
        double finish = System.nanoTime();
        double totalTime = finish - start;
        System.out.println(("\nTime taken to import CSV file to program: " + totalTime / 1000000 + " milliseconds"));
        System.out.println("Number of valid rows: " + employees.size());
        bufferedReader.close();
        return employees;
    }

}
