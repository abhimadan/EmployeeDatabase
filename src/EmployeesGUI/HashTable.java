/**
 * The purpose of this package is to create a small, easy-to-use database with 
 * a Graphical User Interface (GUI). It uses Object-Oriented Programming and 
 * data structure design (i.e. the hash table) to organize and store all of the
 * data in the database. The database is backed up every time the program is 
 * closed.
 */

package EmployeesGUI;

import java.io.*;
import java.util.*;

/**
 * This class is what is instantiated as a data structure to store all of the
 * employee information in the database.
 * @author Abhishek Madan 493385
 * @author Jeffrey Ying 525947
 */
public class HashTable {

    private ArrayList<Employee>[] buckets;
    private int numBuckets;
    private int numEmployees;

    public HashTable(int num) {
        numBuckets = num;
        buckets = new ArrayList[numBuckets];

        for (int i = 0; i < numBuckets; i++) {
            buckets[i] = new ArrayList();
        }
    }

    public HashTable() {
        this(3);    //default to 3 buckets in the hash table 
    }

    /**
     * @param employee - the reference to the employee being added
     * to the database
     * 
     * This method hashes the given employee's employee number to the 
     * appropriate bucket, to which it is added.
     */
    public void addEmployee(Employee employee) {
        buckets[employee.getEmpNumber() % numBuckets].add(employee);
        numEmployees++;
    }

    /**
     * @param empNum - the employee number of an employee to be deleted
     * 
     * This method deletes the employee with the employee number empNum 
     * from the hash table by hashing to the appropriate bucket
     * and removing it. Does not remove anything if empNum is not found.
     */
    public void deleteEmployee(int empNum) {
        int index = searchEmployee(empNum);

        if (index > -1) {
            numEmployees--;
            buckets[empNum % numBuckets].remove(index);
        }
    }

    /**
     * @param empNum - the given employee number of an employee
     * 
     * This method returns the index of an employee in its bucket, 
     * given their employee number. It does not return which bucket, 
     * since hashing the employee number already determines this; 
     * returns -1 if empNum is not found in the database.
     */
    private int searchEmployee(int empNum) {
        ArrayList<Employee> tempBucket = buckets[empNum % numBuckets];

        for (int i = 0; i < tempBucket.size(); i++) {
            if (tempBucket.get(i).getEmpNumber() == empNum) {
                return i;
            }
        }

        return -1;
    }

    /**
     * @param empNum - the employee number of an employee 
     * 
     * This method returns an employee when given their employee 
     * number. Returns null if no employee with the given employee 
     * number is found.
     */
    public Employee getEmployee(int empNum) {
        int index = searchEmployee(empNum);
        if (index > -1) {
            return buckets[empNum % numBuckets].get(index);
        }
        return null;
    }

    /**
     * This method returns an array of all employees in the hash table.
     */
    public Employee[] listEmployees() {
        Employee[] nums = new Employee[numEmployees];
        int index = 0;

        for (int i = 0; i < numBuckets; i++) {
            for (int j = 0; j < buckets[i].size(); j++) {
                nums[index] = buckets[i].get(j);
                index++;
            }
        }

        return nums;
    }

    /**
     * @param empNum - the employee number of an employee as a string, since
     * the value would come from a text box in the GUI
     * 
     * This method returns an ArrayList of employees whose employee number 
     * starts with the given employee number fragment as a string, not used 
     * in the program.
     */
    public ArrayList<Employee> searchBar(String empNum) {
        ArrayList<Employee> searchResults = new ArrayList();
        String match;

        if (empNum.length() == 0) {
            return null;
        } else {
            for (int i = 0; i < numBuckets; i++) {
                for (int j = 0; j < buckets[i].size(); j++) {
                    match = String.valueOf(buckets[i].get(j).getEmpNumber());

                    if (match.length() >= empNum.length()) {
                        match = match.substring(0, empNum.length());
                    }

                    if (empNum.equals(match)) {
                        searchResults.add(buckets[i].get(j));
                    }
                }
            }
        }

        return searchResults;
    }

    /**
     * This method writes a backup file with the contents of the hash table  
     * in the given file format.
     */
    public void backup() {
        try {
            FileOutputStream fstream = new FileOutputStream("employees.txt"); //open file
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fstream)); // create bufferedwriter to write data
            Employee[] contents = listEmployees();

            bw.write(String.valueOf(numEmployees));
            bw.newLine();
            bw.newLine();
            for (int i = 0; i < numEmployees; i++) {
                if (contents[i] instanceof PartTimeEmployee) {
                    bw.write("PTE");
                    bw.newLine();
                    bw.write(contents[i].getFirstName());
                    bw.newLine();
                    bw.write(contents[i].getLastName());
                    bw.newLine();
                    bw.write(String.valueOf(contents[i].getEmpNumber()));
                    bw.newLine();
                    bw.write(contents[i].getSex());
                    bw.newLine();
                    bw.write(String.valueOf(contents[i].getDeductionsRate()));
                    bw.newLine();
                    bw.write(String.valueOf(((PartTimeEmployee) contents[i]).getHourlyWage()));
                    bw.newLine();
                    bw.write(String.valueOf(((PartTimeEmployee) contents[i]).getHrsPerWeek()));
                    bw.newLine();
                    bw.write(String.valueOf(((PartTimeEmployee) contents[i]).getWeeksPerYear()));
                    bw.newLine();
                } else {
                    bw.write("FTE");
                    bw.newLine();
                    bw.write(contents[i].getFirstName());
                    bw.newLine();
                    bw.write(contents[i].getLastName());
                    bw.newLine();
                    bw.write(String.valueOf(contents[i].getEmpNumber()));
                    bw.newLine();
                    bw.write(contents[i].getSex());
                    bw.newLine();
                    bw.write(String.valueOf(contents[i].getDeductionsRate()));
                    bw.newLine();
                    bw.write(String.valueOf(((FullTimeEmployee) contents[i]).getAnnualSalary()));
                    bw.newLine();
                }
                bw.newLine();
            }
            bw.close();
            fstream.close();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
