package assignment5.employee;

public class FullTime extends Employee{

    public FullTime(String name, int paymentPerHour)
    {
        super(name,paymentPerHour);
    }

    public int calculateSalary(){

        int salary = this.getPaymentPerHour() *8;
        return salary;
    }
}
