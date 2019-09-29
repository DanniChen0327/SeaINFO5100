package assignment3;

public class CountAndSay {
    public String countAndSay(int n){
        String str = "1";   //start from 1
        int start = 1;
        int i;
        while(start < n){
            StringBuilder sb = new StringBuilder();
            int count = 1;
            for(i = 1; i< str.length(); i++){
                if(str.charAt(i) == str.charAt(i-1)){       //count the same number
                    count++;
                }
                else{
                    sb.append(count);      //put the count and number to new String
                    sb.append(str.charAt(i-1));
                    count  = 1;       // count from 1 all the time
                }
            }
            sb.append(count);
            sb.append(str.charAt(i-1));
            str = sb.toString();
            start ++;

        }
        return str;

    }

    public static void main(String[] args){
        CountAndSay test = new CountAndSay();

        System.out.println(test.countAndSay(4));
    }
}
