package assignment5.dog;

import assignment5.boardable.Boardable;
import assignment5.pet.Pet;

public class Dog extends Pet implements Boardable {
    private String size;
    private int startmonth;
    private int startday;
    private int startyear;
    private int endmonth;
    private int endday;
    private int endyear;

    public Dog(String name, String ownerName, String color, String size){
        super(name, ownerName,color);
        this.size = size;
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

    public String toString(){
        String dogres = null;
        dogres ="DOG: \n" + super.getPetName() + " owned by " + super.getOwnerName() + "\n";
        dogres += "Color: " + super.getColor() + "\n";
        dogres += "Sex: " + super.getSex() + "\n";
        dogres += "Size: " + getSize();
        return dogres;
    }

    public String getSize(){
        return this.size;
    }

    public static void main(String args[]){
        Dog dog = new Dog("Spot", "Susan","white", "medium");
        dog.setSex(2);
        System.out.println(dog.toString());

        dog.setBoardStart(01,01,2019);
        dog.setBoardEnd(12,31,2019);

        System.out.println(dog.boarding(12,6,2020));
    }
}
