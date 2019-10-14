package assignment5;

import assignment5.employee.Contractor;
import assignment5.employee.Employee;
import assignment5.employee.FullTime;

public class EmployeeTest {
    public static void main(String args[]){
        Contractor contractor = new Contractor("Danni",18,6);
        System.out.println(contractor.calculateSalary());
        FullTime fullTime = new FullTime("Grace",50);
        System.out.println(fullTime.calculateSalary());


    }
}
