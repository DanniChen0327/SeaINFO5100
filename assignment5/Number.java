package assignment5;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Number {
    public void count(String a, String b){
        double div = Double.parseDouble(a);
        double divisor = Double.parseDouble(b);
        double c = div / divisor;
        if(divisor == 0)
            throw new ZeroException();
        if(div %1 != 0 || divisor %1 != 0)
            throw new TypeException();

        System.out.println("the answer is : " + c);


    }



    public static void main(String args[]){
        while(true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("please input two integer: ");

            Number test = new Number();
            try{
                String a = scanner.next();
                String b = scanner.next();
                test.count(a,b);

            }catch (ZeroException ze){
                System.out.println("the devisor cannot be 0");
            }catch(TypeException te){
                System.out.println("your type is wrong, please input integer");
            }

        }

    }

}

class ZeroException extends IllegalArgumentException{

}

class TypeException extends InputMismatchException {

}
