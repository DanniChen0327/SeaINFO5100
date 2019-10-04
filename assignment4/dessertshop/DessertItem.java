package assignment4.dessertshop;

abstract class DessertItem {
    private String name;
    public DessertItem(){}

    public DessertItem(java.lang.String name){
        this.name = name;
    }

    public final java.lang.String getName(){
        return this.name;

    }

    public abstract int getCost();

    public abstract String getQuality();

}
