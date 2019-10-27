package assignment6.ATM;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Atm {
    private int availableAmountInMachine;
    private int transactionFee;
    private ArrayList<ArrayList<User>> userData = new ArrayList<ArrayList<User>>();

    ArrayList<User> userInfo = new ArrayList<User>();

    private int bankAccountNumber;
    private int password;
    HashMap<Integer, Integer> usersAccount = new HashMap<>();

    private int availableBalance;
    private int withdrawal;
    private int deposit;

    StringBuffer sb = new StringBuffer("Recent trans action:" + "\n");
    int transTime =0;


    public Atm(int availableAmountInMachine, int transactionFee, ArrayList<ArrayList<User>> userData, ArrayList<User> userInfo, HashMap<Integer,Integer> usersAccount){
        this.availableAmountInMachine = availableAmountInMachine;
        this.transactionFee = transactionFee;
        this.userData = userData;
        this.userInfo = userInfo;
        this.usersAccount = usersAccount;
        for(int key: usersAccount.keySet()){
            this.bankAccountNumber = key;
            System.out.println("banknumber is:" + this.bankAccountNumber);
            this.password= usersAccount.get(key);
            System.out.println("password is: " + this.password);
        }
        //begining();

    }
    public void begining(){  //instruct user to create account or login
        System.out.println("Welcome! Please entry the number of the behavior your would like to do." + "\n" + "1. create account." + "\n" + "2. login.");
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        if(line.equals("1")){
            createAccount();  //go to createAccount function
        }else
            login();// go to login function

    }

    public void createAccount(){
        int accountNum = (int) (Math.random() * 1000);   //create unique bankAccountNumber and password
        int password = (int) (Math.random() * 100000);
        this.bankAccountNumber = accountNum;
        this.password = password;
        usersAccount.put(this.bankAccountNumber, this.password);   // add the new user into hashmap
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input your name, age, address, phoneNumber and divide them with ','.");
        String line = scanner.nextLine();
        String[] lines = line.split(",");
        userInfo.add(new User(lines[0], Integer.parseInt(lines[1]), lines[2],Integer.parseInt(lines[3]), this.bankAccountNumber)); // add the new user information into userInfo
        //userData.add(userInfo);

        System.out.println("created account successfully! Your bankAccountNumber is : " + this.bankAccountNumber + ", your password is: " + this.password);

        login();
    }

    public void login(){
        System.out.println("please input your account number and password to login");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] lines = line.split(",");
        this.bankAccountNumber = Integer.parseInt(lines[0]);
        this.password = Integer.parseInt(lines[1]);

        if(usersAccount.containsKey(this.bankAccountNumber)){   //check whether the account has in the map
            if(this.password == usersAccount.get(bankAccountNumber)) {
                System.out.println("Successful login");
                accountActivity();
            }
            else{
                System.out.println("the password is wrong, please press '1' to try again or press '2' to reset password");
                Scanner scanner1 = new Scanner(System.in);
                String line1 = scanner1.nextLine();
                if(line1.equals("1")){
                    login();
                }else
                    forgetPassword(this.bankAccountNumber);
            }

        }else{
            System.out.println("the user is not exist, please press '1' to try again or press '2' to sign up");
            Scanner scanner1 = new Scanner(System.in);
            String line1 = scanner1.nextLine();
            if(line1.equals("1"))
                login();
            else
                createAccount();
        }

    }

    public void forgetPassword(int bankAccountNumber){
        User currUser = findTheUser(bankAccountNumber);
        if(currUser != null){
            Boolean verified = verify(currUser);
            if(verified){
                System.out.println("your password has been reset. Your password is :" + this.password + ". Please login");
                login();
            }else{
                System.out.println("your information is not correct, please try again");
                verify(currUser);
            }
        }

    }

    public User findTheUser(int bankAccountNumber){
        for(User user : userInfo){
            if(user.getBankAccountNumber() ==  bankAccountNumber){
                return user;
            }
        }
        return null;
    }


    public Boolean verify(User currUser){
        System.out.println("please input your name, age and phoneNumber to verify your account");
        Scanner scanner = new Scanner(System.in);    //user input name
        String line = scanner.nextLine();
        String[] lines = line.split(",");
        String name = lines[0];
        int age = Integer.parseInt(lines[1]);
        int phoneNumber = Integer.parseInt(lines[2]);
        if(name.equals(currUser.getName()) && age == currUser.getAge() && phoneNumber == currUser.getPhoneNumber()){     //check the name, age and phoneNumber
            int newPassword = (int) (Math.random() * 100000);    //reset password
            this.password = newPassword;
            usersAccount.put(bankAccountNumber, this.password);

            return true;

        }else{
            return false;
        }
    }

    public void accountActivity(){
        System.out.println("your account balance is : " + this.availableBalance);
        System.out.println("please choose the activity." + "\n" + "1. Deposit" + "\n" + "2. Withdraw" + "\n" + "3. recentTransactions" + "\n" + "4. changePassword" + "\n" + "5. exit");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        if(line.equals("1")){
            deposit();
        }else if(line.equals("2")){
            withdraw();
        }else if(line.equals("3")){
            recentTransaction(sb);
        }else if(line.equals("4")){
            forgetPassword(this.bankAccountNumber);
        }else if(line.equals("5")){
            exit();
        }


    }

    public int deposit(){
        System.out.println("please entry the amount you would like to deposit.");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int deposit = Integer.parseInt(line);
        this.deposit = deposit;
        this.availableBalance = this.availableBalance + this.deposit - this.transactionFee;  //reset the money of user account
        this.availableAmountInMachine += this.deposit - this.transactionFee;   //reset the amount of money in atm
        transTime++;
        if(transTime <= 10){
            sb.append("deposit -- $" + this.deposit + "\n");     // add the action to recent trans action
        }

        System.out.println("the money successfully deposited");
        accountActivity();
        return this.availableBalance;
    }

    public int withdraw(){
        System.out.println("please entry the amount you would like to withdraw.");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int withdrawal = Integer.parseInt(line);
        this.withdrawal = withdrawal;
        if(this.withdrawal <= this.availableAmountInMachine && this.withdrawal <= this.availableBalance){
            this.availableBalance = this.availableBalance - this.withdrawal - this.transactionFee;   //reset the money of user account
            this.availableAmountInMachine = this.availableAmountInMachine - this.withdrawal + this.transactionFee; //reset the amount of money in atm
            transTime++;
            if(transTime <= 10){
                sb.append("withdraw -- $" + this.withdrawal + "\n");   // add the action to recent trans action
            }
            System.out.println("the money successfully withdrew");
            accountActivity();

        }

        else{
            System.out.println("the account do not has so much money, please try again");
            withdraw();
        }

        return this.availableBalance;

    }

    public void recentTransaction(StringBuffer stringBuffer){
        sb = stringBuffer;
        System.out.println(sb);
        accountActivity();
    }

    public void exit(){
        System.out.println("Exit successfully");
        begining();

    }


    public void setAvailableAmountInMachine(int availableAmountInMachine){
        this.availableAmountInMachine = availableAmountInMachine;
    }

    public int getAvailableAmountInMachine(){
        return this.availableAmountInMachine;
    }

    public void setTransactionFee(int transactionFee){
        this.transactionFee = transactionFee;
    }

    public int getTransactionFee(){
        return this.transactionFee;
    }


}
