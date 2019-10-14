package assignment5.cat;

import assignment5.boardable.Boardable;
import assignment5.pet.Pet;

public class Cat extends Pet implements Boardable {
    private String hairlength;
    private int startmonth;
    private int startday;
    private int startyear;
    private int endmonth;
    private int endday;
    private int endyear;

    public Cat(String name, String ownerName, String color, String hairLength){
        super(name,ownerName,color);
        this.hairlength = hairLength;

    }
    public void setBoardStart(int month, int day, int year){
        this.startmonth = month;
        this.startday = day;
        this.startyear = year;

    }

    @Override
    public void setBoardEnd(int month, int day, int year) {
        this.endmonth = month;
        this.endday = day;
        this.endyear = year;
    }

    @Override
    public boolean boarding(int month, int day, int year) {
        String yearstr = Integer.toString(year);
        if(month < 1 || month > 12)
            throw new IllegalArgumentException("the month should between 1 and 12");
        if(day < 1 || day > 31)
            throw new IllegalArgumentException("the day should between 1 and 31");
        if(yearstr.length() != 4)
            throw new IllegalArgumentException("the length of year should be 4");


        if((this.startday <= day) && (day <= this.endday)
         && (this.startmonth <= month) && (month <= this.endmonth)
        && (this.startyear <= year) && (year <= this.endyear)){
            return true;
        }
        else
            return false;
    }

    public String getHairlength(){
        return this.hairlength;
    }

    public String toString(){
        String catres = null;
        catres = "CAT: \n" + super.getPetName() + " owned by " + super.getOwnerName() + "\n";
        catres += "Color: " + super.getColor() + "\n";
        catres += "Sex: " + super.getSex() + "\n";
        catres += "Hair: " + getHairlength();
        return catres;
    }

    public static void main(String args[]){
        Cat cat = new Cat("Tom","Bob", "black", "short");
        cat.setSex(2);
        System.out.println(cat.toString());

        cat.setBoardStart(01,01,2019);
        cat.setBoardEnd(12,31,2019);

        System.out.println(cat.boarding(1,1,2019));
    }



}
