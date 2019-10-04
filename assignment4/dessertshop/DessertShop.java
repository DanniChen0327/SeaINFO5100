package assignment4.dessertshop;

public class DessertShop {
    private double taxrate;
    private String shopname;
    private String itemname;
    private int width;
    private double dollar;

    public void setTaxRate(double taxrate){
        this.taxrate = taxrate;
    }

    public double getTax(int cost){
        return (int)Math.round(this.taxrate * cost);
    }

    public void setShopname(String shopname){
        this.shopname = shopname;
    }

    public String getShopname(){
        return this.shopname = shopname;
    }

    public void setItemname(String itemname){
        this.itemname = itemname;
        if(itemname.length() < 0 || itemname.length()> 100){
            throw new IllegalArgumentException("the length of item name should between 0 and 100, please tey another name");
        }
    }

    public String getItemname(){
        return itemname;
    }

    public void setWidth(int width){
        this.width = width;
        if(width> 5){
            System.out.println("the width should under 5 digit");     //////////////////

        }
    }

    public static String cents2dollarAndCentsmethod(int cent){

        return String.format("%.2f",cent * 0.01);
    }
}
