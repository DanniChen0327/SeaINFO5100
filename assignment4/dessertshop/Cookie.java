package assignment4.dessertshop;

public class Cookie extends DessertItem {
    private String cookieName;
    private double cost;
    private int number;
    private int pricePerDozen;

    public Cookie(String cookieName, int number, int pricePerDozen ){
        super(cookieName);
        this.number = number;
        this.pricePerDozen = pricePerDozen;

    }

    public int getCost(){
        this.cost = (double)this.number/12 * this.pricePerDozen;
        return (int)Math.round(this.cost);
    }
    public String getQuality(){
        return "\n"+ this.number + " @ " + this.pricePerDozen + " /dz.";
    }

}
