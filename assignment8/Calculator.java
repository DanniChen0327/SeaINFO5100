package assignment8;
import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;

import static com.sun.glass.ui.Cursor.setVisible;

public class Calculator {

    private JTextField firstText, secondText,resultText;
    private JComboBox options;
    private JButton resultButton;
    //private JLabel resultLabel;

    public void create(){
        JFrame frame = new JFrame("Danni Chen's calculator");

        Container con = frame.getContentPane();
        FlowLayout fl = new FlowLayout(FlowLayout.CENTER);
        con.setLayout(fl);

        firstText = new JTextField(10);
        secondText = new JTextField(10);
        resultText = new JTextField(10);

        options = new JComboBox(new String[] { "+", "-", "x", "/" });
        resultButton = new JButton("=");
        add(con);
        addListeners();
        frame.setSize(600,200);
        frame.setVisible(true);
    }

    public void add(Container con){
        con.add(firstText);
        con.add(options);
        con.add(secondText);
        con.add(resultButton);
        con.add(resultText);

    }

    public void calculate(){
        int a = 0;
        try{
            a = Integer.parseInt(firstText.getText());
        }catch(RuntimeException e){
            System.out.printf("Number should be entered in the first text field");
            throw e;
        }
        int b = Integer.parseInt(secondText.getText());
        String choice = options.getSelectedItem().toString();
        int result = getResult(a,b,choice);
        resultText.setText(Integer.toString(result));
    }

    public int getResult(int a, int b, String choice){
        if(choice.equals("+"))
            return a+b;
        else if(choice.equals("-"))
            return a-b;

        else if(choice.equals("/") && b != 0)
            return a/b;
        else
            return a*b;
    }



    public void addListeners() {
        resultButton.addActionListener((e) -> calculate());

    }



    public static void main(String[] args){
        Calculator test = new Calculator();
        test.create();

    }


}
