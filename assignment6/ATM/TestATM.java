package assignment6.ATM;

import java.util.ArrayList;
import java.util.HashMap;

public class TestATM {
    public static void main(String[] args){
        User user1 = new User("Danni" , 22, "8th Ave" , 12381 , 872);
        User user2 = new User("Grace" , 21, "7th Ave" , 12763 , 233);
        ArrayList<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        ArrayList<ArrayList<User>> userData = new ArrayList<ArrayList<User>>();
        userData.add(users);
        HashMap<Integer,Integer> usersAccount = new HashMap<>();
        usersAccount.put(872,1234);
        Atm test = new Atm(100000, 15, userData, users,usersAccount);
        test.begining();

    }
}
