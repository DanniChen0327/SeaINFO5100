package assignment4.dessertshop;

import java.util.Vector;

public class Checkout {
    Vector<DessertItem> vector = new Vector();
    int cost = 0;

    DessertShop ds = new DessertShop();

    public Checkout(){}

    public int numberOfItems() {
        return vector.size();
    }

    public void enterItem(DessertItem item){
        vector.add(item);
        cost += item.getCost();

    }

    public void clear(){
        vector.clear();
        cost = 0;

    }

    public int totalCost(){
        return cost;
    }

    public int totalTax(){
        ds.setTaxRate(0.065);
        return (int)ds.getTax(cost);
    }

    public java.lang.String toString(){
        ds.setShopname("         M & M Dessert Shop");
        String res = ds.getShopname() + "\n         ------------------" +"\n";
        for(int i = 0; i< vector.size();i++){
            DessertItem item = vector.get(i);
            res += item.getQuality() + "\n" + item.getName() +"         " + DessertShop.cents2dollarAndCentsmethod(item.getCost()) + "\n";
        }
        res +="\n" + "Tax                     " + DessertShop.cents2dollarAndCentsmethod((int)ds.getTax(cost)) + "\n";
        res += "Total Cost              " + DessertShop.cents2dollarAndCentsmethod((int)ds.getTax(cost) + cost) + "\n";

        return res;
    }
}
