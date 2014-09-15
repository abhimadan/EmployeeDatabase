/**
 * The purpose of this package is to create a small, easy-to-use database with 
 * a Graphical User Interface (GUI). It uses Object-Oriented Programming and 
 * data structure design (i.e. the hash table) to organize and store all of the
 * data in the database. The database is backed up every time the program is 
 * closed.
 */

package EmployeesGUI;

/**
 * This class is used as an abstract superclass of the two different types of
 * employees: part time and full time. Since it is abstract, it is never 
 * instantiated.
 * @author Abhishek Madan 493385
 * @author Jeffrey Ying 525947
 */
abstract public class Employee {

    protected String firstName;
    protected String lastName;
    protected int empNumber;
    protected char sex;
    protected double deductionsRate;

    public Employee(String fn, String ln, int num, char gen, double rate) {
        firstName = fn;
        lastName = ln;
        empNumber = num;
        sex = gen;
        deductionsRate = rate;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getEmpNumber() {
        return empNumber;
    }

    public char getSex() {
        return sex;
    }

    public double getDeductionsRate() {
        return deductionsRate;
    }

    public void setFirstName(String fn) {
        firstName = fn;
    }

    public void setLastName(String ln) {
        lastName = ln;
    }

    public void setEmpNumber(int num) {
        empNumber = num;
    }

    public void setSex(char gen) {
        sex = gen;
    }

    public void setDeductionsRate(double rate) {
        deductionsRate = rate;
    }
    
    /**
     * This method displays all employee information to the screen,
     * but is not used in the GUI. 
     */
    public void reportInfo() {
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Employee Number: " + empNumber);
        System.out.println("Sex: " + sex);
        System.out.println("Deductions Rate: " + deductionsRate + "%");
    }
}