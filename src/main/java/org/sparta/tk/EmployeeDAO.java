package org.sparta.tk;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.List;
import java.util.Properties;

public class EmployeeDAO {
    private static final Logger logger = LogManager.getLogger();

    public static void establishConnection(List<Employee> list) throws IOException, SQLException {
        Properties properties = new Properties();
        properties.load(new FileReader("src/main/resources/login.properties"));
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeesDB?serverTimezone=GMT", properties.getProperty("username"), properties.getProperty("password"));
        logger.info("Database connection established");

        Statement deleteStatement = connection.createStatement();
        deleteStatement.executeUpdate("TRUNCATE TABLE employeesDB.employees");
        logger.info("All previous data from table removed");

        double start = System.nanoTime();
        Statement addStatement = connection.createStatement();
        for (Employee employee: list) {
            addStatement.executeUpdate("INSERT INTO employeesDB.employees" + " VALUES(" + employee.getEmployeeID() + ",'" + employee.getPrefix() + "','" + employee.getFirstName() + "','" + employee.getInitial() + "','" + employee.getLastName() + "','" + employee.getGender() + "','" + employee.getEmail() + "','" + employee.getDob() + "','" + employee.getJoinDate() + "'," + employee.getSalary() + ")");
        }
        logger.info("Imported all valid employee data to database");
        double finish = System.nanoTime();
        double totalTime = finish - start;
        System.out.println(("\nTime taken to populate database: " + totalTime / 1000000 + " milliseconds"));

    }
}
