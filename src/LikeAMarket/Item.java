package LikeAMarket;

import java.util.Objects;

public class Item {
    private String name;
    private Price price;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(name, item.name) &&
                Objects.equals(price, item.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + System.lineSeparator() +
                ", price=" + price +
                '}';
    }
}
