package org.sparta.tk;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;

public class ValidateDataUtilityClass {
    private static final Logger logger = LogManager.getLogger();
    private static final String email_regex =
            "^[_A-Za-z0-9-+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public static boolean cleanData(String[] rowToClean) {
        char[] firstName = rowToClean[2].toCharArray();
        String initial = rowToClean[3];
        char[] lastName = rowToClean[4].toCharArray();
        String gender = rowToClean[5];
        String email = rowToClean[6];
        String dob = rowToClean[7];
        String joinDate = rowToClean[8];
        String salary = rowToClean[9];

        if (checkEmployeeID(rowToClean[0])) {
            if (checkPrefix(rowToClean[1])) {
                if (checkName(firstName)) {
                    if (checkName(lastName)) {
                        if (checkInitial(initial)) {
                            if (checkGender(gender)) {
                                if (checkEmail(email)) {
                                    if (checkDates(dob, joinDate)) {
                                        return checkSalary(salary);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public static boolean checkEmployeeID(String employeeID){
        //check if employee ID is all integers
        try {
            Integer.parseInt(employeeID);
        } catch (NumberFormatException e) {
            logger.warn("Employee ID is not an integer data type");
            return false;
        }
        //check employee ID is 6 digits long
        int length = employeeID.length();
        return length == 6;
    }

    public static boolean checkPrefix(String prefix){
        String[] acceptedPrefixes = new String[] {"Prof.", "Mrs.", "Mr.", "Ms.", "Dr.", "Drs.", "Hon."};
        for (String acceptedPrefix: acceptedPrefixes) {
            if(acceptedPrefix.equals(prefix)){
                return true;
            }
        }
        return false;
    }

    public static boolean checkName(char[] nameToCheck){
        for (char c : nameToCheck) {
            if(!Character.isLetter(c)) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkInitial(String initial){
        return initial.length() == 1;
    }

    public static boolean checkGender(String gender){
        return gender.equalsIgnoreCase("f") || gender.equalsIgnoreCase("m");
    }

    public static boolean checkEmail(String email){
        return email.matches(email_regex);
    }

    public static boolean checkDates(String dob, String startDate){
        int dobYear = Integer.parseInt(dob.substring(dob.length() - 4));
        int startYear = Integer.parseInt(startDate.substring(startDate.length() - 4));
        return startYear - dobYear > 0;
    }

    public static boolean checkSalary(String employeeSalary){
        try {
            Integer.parseInt(employeeSalary);
        } catch (NumberFormatException e) {
            logger.warn("Salary is not an integer data type");
            return false;
        }
        int length = employeeSalary.length();
        return length <= 7;
    }

    public static boolean containsDuplicates(final List<Employee> list, final String employeeID, String email){
        logger.warn("Employee details contains duplicate ID or email address");
        return list.stream().anyMatch(o -> o.getEmployeeID().equals(employeeID)) || list.stream().anyMatch(o -> o.getEmail().equals(email));
    }
}
