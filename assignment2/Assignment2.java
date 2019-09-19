public class Assignment2 {

    /*
        This method should return the sum of salaries of employees having salary greater than 5000
        Note: Employee array is passed, not employee
     */
    public double salaryGreaterThanFiveThousand(Employee[] employees) {
        // @TODO
        double sum = 0;

        for(int i = 0; i< employees.length; i++){
            if(employees[i].getSalary() > 5000){
                sum = sum+ employees[i].getSalary();
            }
            else
                break;
        }

        return sum;
    }

    /*
        This method should print either "Fizz", "Buzz" or "FizzBuzz"
        "Fizz" - if id of employee is divisible by 3
        "Buzz" - if id of employee is divisible by 5
        "FizzBuzz" - if id of employee is divisible by both 3 and 5
     */
    public void fizzBuzz(Employee employee) {
        // @TODO
        int id = employee.getId();
        if(id % 3 == 0){
            System.out.println("Fizz");
        }
        else if(id % 5 == 0){
            System.out.println("Buzz");
        }
        else if(id % 3 ==0 && id % 5 == 0){
            System.out.println("FizzBuzz");

        }
        else
            System.out.println("please change to another person");

    }

    /*
        This method should calculate tax for an employee in dollars
        If salary of employee is less than or equal to 2500, tax should be 10%
        If salary of employee is greater than 2500 but less than or equal to 5000, tax should be 25%
        If salary of employee is greater than 5000, tax should be 35%
    */
    public double calculateTax(Employee employee) {
        // @TODO
        double tax = 0;
        if (employee.getSalary() <= 2500){
            tax = employee.getSalary() * 0.1 ;
        }
        else if(employee.getSalary() > 2500 && employee.getSalary() <= 5000 ){
            tax = employee.getSalary() * 0.25 ;
        }
        else
            tax = employee.getSalary() * 0.35 ;
        return tax;
    }

    /*
        We are given two employee objects.
        Implement this method to swap salaries of employees
    */
    public void swap(Employee firstEmployee, Employee secondEmployee) {
        // @TODO
        double swapsalary = 0;
        swapsalary = firstEmployee.getSalary();
        firstEmployee.setSalary(secondEmployee.getSalary());
        secondEmployee.setSalary(swapsalary);
    }

    /*
        Return number of employees whose age is greater than 50
        Note: Employee array is passed, not employee
     */
    public int employeesAgeGreaterThan50(Employee[] employees) {
        // @TODO
        int number = 0;
        for(int i = 0; i < employees.length; i++){
            if(employees[i].getAge() > 50) {
                number++;
            }
            else
                continue;
        }
        return number;
    }

    /*
        Implement this method to reverse firstName of employee.
        Ex. Before: employee.getFirstName() -> "John"
        After : employee.getFirstName() -> "nhoJ"
     */
    public void reverseFirstName(Employee employee) {
        // @TODO
        String firstname = employee.getFirstName();
        char[] charfirstname = firstname.toCharArray();
        int len = charfirstname.length;
        int head = 0;
        int tail = len - 1;
        for(int i = 0; i< len / 2; i++){
            char temp = charfirstname[head];
            charfirstname[head] = charfirstname[tail];
            charfirstname[tail] = temp;
            head ++;
            tail --;

        }
        String reversedfirstname =  String.valueOf(charfirstname);
        employee.setFirstName(reversedfirstname);

    }


    /*
        Print "true" if employee's first name contain one or more digits
        Print "false" if employee's first name doesn't contain any digit
        Ex: employee.getFirstName() -> "ha8l" == true
        employee.getFirstName() -> "hail" == false

     */


    public void isContainDigit(Employee employee) {
        // @TODO
        String firstname = employee.getFirstName();
        char[] charfirstname = firstname.toCharArray();
        int i = 0;
        while(i< charfirstname.length){
            if(!Character.isDigit(charfirstname[i])){
                i++;
            }
            else {
                System.out.println(true);
                break;

            }
        }
        if(i >= charfirstname.length){
            System.out.println(false);
        }

    }



    /*
       Write a method to raise an employee's salary to three times of his/her original salary.
       Eg: original salary was 1000/month. After using this method, the salary is 3000/month.
       DO NOT change the input in this method.
       Try to add a new method in Employee class: public void raiseSalary(double byPercent)
       Call this new method.
    */
    public void tripleSalary(Employee employee) {
        // @TODO
        employee.raiseSalary(3);
        double raisedSalary = employee.getRaisedSalary();
        System.out.println("the salary after raised is : " + raisedSalary);

    }


    //Additional question for extra credit
    /*
        Implement this method to convert String[] to employees array.
        Ex: String[] employees = new String[]{"1,John,24,7500", "2,Hail,28,7899.90"};
        This String array of length 2 contains 2 employees in form of string, where
        id = 1
        firstName=John
        age=24
        salary=7500
        convert each string to employee object.
        Hint: Use String methods. Refer : https://docs.oracle.com/javase/7/docs/api/java/lang/String.html
     */
    public Employee[] createEmployees(String[] employeesStr) {
        Employee[] employees1 = new Employee[employeesStr.length];
        // @TODO
        String[] aftersplit = new String[2];
        int i = 0;
        for(i = 0; i< employeesStr.length; i++){
            aftersplit = employeesStr[i].split(",");
            for(int j = 0; j<aftersplit.length; j=j+4){
                employees1[i] = new Employee(Integer.parseInt(aftersplit[j]),aftersplit[j+1],Integer.parseInt(aftersplit[j+2]),Double.parseDouble(aftersplit[j+3]));
                System.out.println(employees1[i].getId());
                System.out.println(employees1[i].getFirstName());

            }

        }

        return employees1;
    }

}
