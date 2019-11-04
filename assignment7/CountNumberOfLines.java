package assignment7;

import java.io.*;
import java.util.Scanner;

public class CountNumberOfLines {
    private String filename;


    public void countNumberOfLines(String filename) throws Exception{
        this.filename = filename;
        String filePath = "/Users/chendanni/Desktop/" + filename;
        File file = new File(filePath);
        if(!file.exists())
            throw new FileNotFoundException();
        else{
            int lines = 0;
            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);
            while(br.readLine() != null){
                lines++;

            }
            System.out.println(filename + "---> " +String.valueOf(lines));
            fr.close();
            br.close();

        }

    }

    public static void main(String[] args) throws Exception{
        CountNumberOfLines test = new CountNumberOfLines();
        System.out.println("please input the name of files with ',' to separate names ");
        String file = null;

        Scanner scanner = new Scanner(System.in);
        String files = scanner.nextLine();
        String[] filename = files.split(",");

        for(int i = 0; i< filename.length;i++){
            file = filename[i];
            try{
                test.countNumberOfLines(file);

            }catch(Exception e){
                System.out.println(file + " is not exist");
            }

        }

    }
}
