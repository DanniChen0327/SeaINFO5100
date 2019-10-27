package assignment6.ATM;

public class User {
    private String name;
    private int age;
    private String address;
    private int phoneNumber;
    private int bankAccountNumber;

    //public User(){}

    public User(String name, int age, String address, int phoneNumber, int bankAccountNumber){
        this.name = name;
        this.age = age;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.bankAccountNumber = bankAccountNumber;

    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setAge(int age){
        this.age = age;
    }

    public int getAge(){
        return this.age;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public String getAddress(){
        return this.address;
    }

    public void setPhoneNumber(int phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public int getPhoneNumber(){
        return this.phoneNumber;
    }

    public void setBankAccountNumber(int bankAccountNumber){
        this.bankAccountNumber = bankAccountNumber;
    }

    public int getBankAccountNumber(){
        return this.bankAccountNumber;
    }

}
