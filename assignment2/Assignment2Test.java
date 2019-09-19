import java.util.Arrays;

public class Assignment2Test {
    public static void main(String args[] ){
        Employee empDanni = new Employee(23,"Danni",22, 5001.00);
        Employee empGrace = new Employee(12,"Grace",26, 4600.00);

        Employee[] Employees = new Employee[8];
        Employees[0] = new Employee(56,"john",24,5400.00);
        Employees[1] = new Employee(78,"Sara",26,6300.00);
        Employees[2] = new Employee(34,"Noah",32,5300.00);
        Employees[3] = new Employee(72,"Jill",34,6800.00);
        Employees[4] = new Employee(47,"Chris",51,7600.00);
        Employees[5] = new Employee(32,"Ching",25,3800.00);
        Employees[6] = new Employee(62,"Yue",28,4200.00);
        Employees[7] = new Employee(42,"Helen",30,4900.00);

        Assignment2 assignment  = new Assignment2();

        //salaryGreaterThanFiveThousand
        System.out.println("-------------------------");
        System.out.println("the sum of salaries of employees having salary greater than 5000 is : " + assignment.salaryGreaterThanFiveThousand(Employees));

        System.out.println("-------------------------");
        assignment.fizzBuzz(empDanni);          //fizzBuzz

        System.out.println("-------------------------");
        assignment.swap(empDanni,empGrace);           //swap
        System.out.println("Danni's salary after swap is: " + empDanni.getSalary());

        System.out.println("-------------------------");
        assignment.calculateTax(empDanni);                    //calculateTax
        System.out.println("the tax Danni should pay is : " + assignment.calculateTax(empDanni));

        System.out.println("-------------------------");
        System.out.println("the number of employees whose age is greater than 50 is : " + assignment.employeesAgeGreaterThan50(Employees));

        System.out.println("-------------------------");
        assignment.reverseFirstName(empDanni);         //reverseFirstName
        System.out.println("Danni's name after reverse is : " + empDanni.getFirstName());

        System.out.println("-------------------------");
        assignment.isContainDigit(empDanni);        //isContainDigit

        System.out.println("-------------------------");
        assignment.tripleSalary(empDanni);         //tripleSalary

        String[] EmpoloyeeStr = new String[]{
                "1,John,24,7500",
                "2,Hail,28,7899.90",
        };
        assignment.createEmployees(EmpoloyeeStr);





    }
}
