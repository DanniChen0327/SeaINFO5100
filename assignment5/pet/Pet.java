package assignment5.pet;

public class Pet {
    private String name;
    private String ownerName;
    private String color;
    protected int sex;

    static final int MALE=0;
    static final int FEMALE=1;
    static final int SPAYED=2;
    static final int NEUTERED=3;



    public Pet(String name, String ownerName, String color){
        this.name = name;
        this.ownerName = ownerName;
        this.color = color;
    }

    public String getPetName(){
        return this.name;
    }

    public String getOwnerName(){
        return this.ownerName;
    }

    public String getColor(){
        return this.color;
    }

    public void setSex(int sexid){
        this.sex = sexid;
    }

    public String getSex(){
        if(this.sex == 0)
            return "male";
        else if(this.sex ==1)
            return "female";
        else if(this.sex ==2)
            return "spayed";
        else
            return "neutered";
    }

    public String toString(){
        String res = null;
        res = this.name + " owned by " + this.ownerName + "\n";
        res += "Color: " + this.color + "\n";
        res += "Sex: " + getSex();

        return res;
    }

    public static void main(String args[]){
        Pet pet = new Pet("Spot", "Mary","Black and White");
        pet.setSex(0);
        System.out.println(pet.toString());
    }

}
