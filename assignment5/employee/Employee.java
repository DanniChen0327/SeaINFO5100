package assignment5.employee;


public abstract class Employee {
    private String name;
    private int paymentPerHour;

    public Employee(String name, int paymentPerHour){
        this.name = name;
        this.paymentPerHour = paymentPerHour;
    }

    public abstract int calculateSalary();

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getPaymentPerHour(){
        return this.paymentPerHour;
    }

    public void setPaymentPerHour(){
        this.paymentPerHour = paymentPerHour;
    }

}
