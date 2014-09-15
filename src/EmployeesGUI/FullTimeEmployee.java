/**
 * The purpose of this package is to create a small, easy-to-use database with 
 * a Graphical User Interface (GUI). It uses Object-Oriented Programming and 
 * data structure design (i.e. the hash table) to organize and store all of the
 * data in the database. The database is backed up every time the program is 
 * closed.
 */

package EmployeesGUI;

import java.text.*;

/**
 * This class is instantiated as an employee that works full time (i.e. they
 * receive an annual salary rather than an hourly wage).
 * @author Abhishek Madan 493385
 * @author Jeffrey Ying 525947
 */
public class FullTimeEmployee extends Employee {

    private double annualSalary;

    public FullTimeEmployee(String fn, String ln, int num, char gen, double rate, double salary) {
        super(fn, ln, num, gen, rate); //calls constructor from superclass
        annualSalary = salary;
    }

    public double getAnnualSalary() {
        return annualSalary;
    }

    public void setAnnualSalary(double salary) {
        annualSalary = salary;
    }

    /**
     * This method displays all employee information to the screen,
     * but is not used in the GUI. Overrides reportInfo method 
     * from Employee class.
     */
    public void reportInfo() {
        super.reportInfo();
        System.out.println("Annual Salary: $" + new DecimalFormat("#.00").format(annualSalary));
    }

    /** 
     * This method returns and formats the employee's gross annual pay
     * to two decimal places.
     */
    public String getGrossAnnualPay() {
        return new DecimalFormat("#.00").format(calcGrossAnnualPay());
    }

    /**
     * This method returns and formats the employee's net annual pay 
     * to two decimal places.
     */
    public String getNetAnnualPay() {
        return new DecimalFormat("#.00").format(calcNetAnnualPay());
    }

    /**
     * This method returns the employee's gross annual pay.
     */
    public double calcGrossAnnualPay() {
        return annualSalary;
    }
    
    /**
     * This method returns the employee's net annual pay.
     */
    public double calcNetAnnualPay() {
        return annualSalary * (1 - (deductionsRate / 100));
    }
}
