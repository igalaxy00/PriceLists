package LikeAMarket;
import java.util.Objects;
import java.util.HashMap;

public class PriceList {
    private HashMap<Integer, Item> priceList = new HashMap<>();
    public boolean isEmpty(){
        return priceList.isEmpty();
    }
    public void clearItems(){
        priceList.clear();
    }
    public boolean addItem (int code , Item item){
        if (priceList.containsKey(code))
            throw new NullPointerException("предмет с таким кодом уже есть");
        priceList.put(code , item);
        return true;
    }
    public boolean removeItem(int code) {
        if (priceList.containsKey(code)){
            priceList.remove(code);
            }else{
            throw new NullPointerException("предмета с таким кодом уже/ещё нет");
        }
        return true;
    }
    public Price priceOfItems(int code , int amount){
        if (!priceList.containsKey(code)) throw new IllegalArgumentException();
        int cPennies = (priceList.get(code).price.rubles*100+priceList.get(code).price.pennies)*amount;
        return new Price( cPennies/100 ,cPennies%100 );

    }
    @Override
    public int hashCode() {
        return (Objects.hash(priceList));
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof PriceList) {
            PriceList other = (PriceList) obj;
            return priceList.equals(other.priceList);
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        priceList.forEach((Integer, Item) -> result.append("   ").append(Integer).append("   ").
                append("  ").append(Item).append(System.lineSeparator()));
        return result.toString();
    }
}
