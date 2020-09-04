# Employees Data Migration Project

Employees Data Migration Project is a Java program that uses a CSV file containing employee data of 10,000 rows to populate a database running on the local server. The employee data is validated against several validation standards in order to then populate the employeesDB schema (database). All invalid data is stored in a separate file as well as a file for the valid data. The task of writing a CSV file to the files and populating the database are measured for performance speed in milliseconds. 

## Installation

Clone the repository and open the program folder using a Java IDE such as IntelliJ to compile the classes.

## How It Works
1. Compile and run project.
2. Open the console and view the performance measures as well as the size of the array.
3. View the ValidData.txt file and InvalidData.txt files containing their respective data entries found under the Resources package.

## Usage

```java
Statement addStatement = connection.createStatement();
        for (Employee employee: list) {
            addStatement.executeUpdate("INSERT INTO employeesDB.employees" + " VALUES(" + employee.getEmployeeID() + ",'" + employee.getPrefix() + "','" + employee.getFirstName() + "','" + employee.getInitial() + "','" + employee.getLastName() + "','" + employee.getGender() + "','" + employee.getEmail() + "','" + employee.getDob() + "','" + employee.getJoinDate() + "'," + employee.getSalary() + ")");
        } // running query to populate the database with employees data from the CSV file
```

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.
