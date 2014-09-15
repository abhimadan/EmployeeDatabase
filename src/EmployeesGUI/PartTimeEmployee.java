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
 * This class is instantiated as an employee that works part time (i.e. they
 * receive an hourly wage rather than an annual salary).
 * @author Abhishek Madan 493385
 * @author Jeffrey Ying 525947
 */
public class PartTimeEmployee extends Employee {

    private double hourlyWage;
    private double hrsPerWeek;
    private int weeksPerYear;

    public PartTimeEmployee(String fn, String ln, int num, char gen, double rate, double wage, double hrs, int weeks) {
        super(fn, ln, num, gen, rate);   //calls constructor from superclass
        hourlyWage = wage;
        hrsPerWeek = hrs;
        weeksPerYear = weeks;
    }

    public double getHourlyWage() {
        return hourlyWage;
    }

    public double getHrsPerWeek() {
        return hrsPerWeek;
    }

    public int getWeeksPerYear() {
        return weeksPerYear;
    }

    public void setHourlyWage(double wage) {
        hourlyWage = wage;
    }

    public void setHrsPerWeek(double hours) {
        hrsPerWeek = hours;
    }

    public void setWeeksPerYear(int weeks) {
        weeksPerYear = weeks;
    }
    
    /**
     * This method displays all employee information to the screen,
     * but is not used in the GUI. Overrides reportInfo method 
     * from Employee class.
     */
    public void reportInfo() {
        super.reportInfo();
        System.out.println("Hourly Wage: $" + new DecimalFormat("#.00").format(hourlyWage));
        System.out.println("Hours per Week: " + hrsPerWeek);
        System.out.println("Weeks Per Year: " + weeksPerYear);
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
        return hrsPerWeek * hourlyWage * weeksPerYear;
    }
    
    /** 
     * This method returns the employee's net annual pay.
     */ 
    public double calcNetAnnualPay() {
        return calcGrossAnnualPay() * (1 - (deductionsRate / 100));
    }
}
