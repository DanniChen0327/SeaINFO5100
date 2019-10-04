package assignment4.dessertshop;

public class IceCream extends DessertItem{
    private int cost;
    private String icecreamName;

    public IceCream(String icecreamName,int cost){
        super(icecreamName);
        this.cost = cost;
    }


    public int getCost(){
        return this.cost;

    }

    public String getQuality(){
        return " ";
    }
}
