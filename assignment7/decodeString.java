package assignment7;

import java.util.Stack;

public class decodeString {
    public String decodeString(String s) {

        int len = s.length();
        Stack<Character> stack = new Stack<>();
        String temp = "";
        String result = "";

        for(int bit = 0; bit < len; bit ++){
            char str = s.charAt(bit);
            if(str != ']'){
                stack.push(str);
            }else{
                char ch = stack.pop();
                while(ch != '['){
                    temp = ch + temp;
                    ch = stack.pop();
                }
                String times = "";
                while(!stack.isEmpty()){   //write this for the bottom of the stack
                    ch = stack.pop();
                    if(Character.isDigit(ch)){
                        times = ch + times;
                    }else{
                        stack.push(ch);
                        break;
                    }
                }
                for(int i = 0; i< Integer.parseInt(times); i++){
                    for(int j = 0; j < temp.length();j++){
                        stack.push(temp.charAt(j));
                    }
                }
                temp = ""; //pop again;

            }
        }

        while(!stack.isEmpty()){
            result = stack.pop() + result;
        }
        return result;
    }

    public static void main(String[] args){
        decodeString test = new decodeString();
        System.out.println(test.decodeString("2[abc]3[cd]ef"));
    }

}
