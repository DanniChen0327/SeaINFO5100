package assignment4.dessertshop;

public class Candy extends DessertItem {
    private String candyName;
    private double weight;
    private int pricePerPound;
    private double cost;

    public Candy(String candyName, double weight, int pricePerPound){
        super(candyName);
        this.weight = weight;
        this.pricePerPound = pricePerPound;
    }

    public String getCandyName(){
        return candyName;
    }

    public int getCost(){
        this.cost = this.weight * this.pricePerPound;
        return (int)Math.round(this.cost);
    }

    public String getQuality(){
        return this.weight + " lbs. @ " + this.pricePerPound +" /lb";
    }
}
