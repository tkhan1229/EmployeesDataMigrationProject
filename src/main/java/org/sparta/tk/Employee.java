package org.sparta.tk;

public class Employee {
    String employeeID;
    String prefix;
    String firstName;
    String initial;
    String lastName;
    String gender;
    String email;
    String dob;
    String joinDate;
    String salary;

    public Employee(String employeeID, String prefix, String firstName, String initial, String lastName, String gender, String email, String dob, String joinDate, String salary) {
        this.employeeID = employeeID;
        this.prefix = prefix;
        this.firstName = firstName;
        this.initial = initial;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.dob = dob;
        this.joinDate = joinDate;
        this.salary = salary;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getInitial() {
        return initial;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public String getDob() {
        return dob;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public String getSalary() {
        return salary;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setInitial(String initial) {
        this.initial = initial;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}
