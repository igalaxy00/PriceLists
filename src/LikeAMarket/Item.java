package LikeAMarket;

public class Item {
    private String name;
    Price price;
    public Item(String name, Price price) {
        this.name = name;
        this.price = price;
    }
    public Price getPrice(){
        return price;
    }
    public String getName(){
        return name;
    }
    public void newName(String name){
        this.name= name;
    }
    public void newPrice(Price price){
        this.price= price;
    }
}
