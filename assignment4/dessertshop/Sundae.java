package assignment4.dessertshop;

public class Sundae extends IceCream{
    private String nameTop;
    private int costTop;
    public Sundae(String name, int cost,String nameTop, int costTop){
        super(name,cost);
        this.costTop = costTop;
        this.nameTop = nameTop;
    }

    public int getCost(){
        return this.costTop + super.getCost();

    }
    public String getQuality(){
        return " ";

    }
}
