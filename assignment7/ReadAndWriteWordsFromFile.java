package assignment7;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Scanner;

public class ReadAndWriteWordsFromFile {
    private String file= "/Users/chendanni/Desktop/assignment7 Q1.txt";
    private String words;

    public void readWordFromFile() throws Exception{
        File f = new File(file);
        FileInputStream fis = new FileInputStream(f);
        Scanner scanner = new Scanner(fis);
        while(scanner.hasNext()){
            this.words = scanner.nextLine();
        }
        fis.close();
    }

    public void writeWordIntoFile() throws Exception{
        File f1 = new File("/Users/chendanni/Desktop/assignment7 Q1 result.txt");
        FileOutputStream fos = new FileOutputStream(f1);
        String reverseWords = reverseWords(this.words);
        fos.write(reverseWords.getBytes());
        System.out.println(reverseWords);
        fos.close();
    }

    public String reverseWords(String str){
        String newString = str.trim();      //The input string does not contain leading or trailing spaces.
        String[] aftersplit = newString.split("\\s+");   //split the String to words and The words are always separated by a single space.
        int len = aftersplit.length;
        for(int i = 0; i< aftersplit.length /2; i++){

            String temp = aftersplit[i];
            aftersplit[i] = aftersplit[len -1-i];
            aftersplit[len -1-i] = temp;
        }
        StringBuilder sb = new StringBuilder();      //change the string[] to String and add space between words
        for(int j = 0; j< len-1; j++){
            sb.append(aftersplit[j]);
            sb.append(" ");

        }
        sb.append(aftersplit[len-1]);    //the end word has no space
        String output = sb.toString();

        return output;
    }

    public static void main(String[] args) throws Exception{
        ReadAndWriteWordsFromFile test = new ReadAndWriteWordsFromFile();
        test.readWordFromFile();
        test.writeWordIntoFile();
    }
}
