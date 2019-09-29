package assignment3;

public class ReverseWords {
    public void reverseWords(String str){
        String newString = str.trim();      //The input string does not contain leading or trailing spaces.
        String[] aftersplit = newString.split("\\s+");   //split the String to words and The words are always separated by a single space.
        int len = aftersplit.length;
        for(int i = 0; i< aftersplit.length /2; i++){

            String temp = aftersplit[i];
            aftersplit[i] = aftersplit[len -1-i];
            aftersplit[len -1-i] = temp;
        }
        StringBuilder sb = new StringBuilder();      //change the string[] to String
        for(int j = 0; j< len-1; j++){
            sb.append(aftersplit[j]);
            sb.append(" ");

        }
        sb.append(aftersplit[len-1]);    //the end word has no space
        String output = sb.toString();
        System.out.println(output);
    }
    public static void main(String[] args){
        ReverseWords test = new ReverseWords();
        test.reverseWords(" hello world! ");

    }

}
