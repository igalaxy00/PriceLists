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
            return false;
        priceList.put(code , item);
        return true;
    }

    public void renameFromMarket(int code , String newName){
        priceList.get(code).setName(newName);
    }
    public void rePriceFromMarket(int code , Price newPrice){
        priceList.get(code).setPrice(newPrice);
    }

    public boolean removeItem(int code) {
        if (priceList.containsKey(code)){
            priceList.remove(code);
            }else{
            return false;
        }
        return true;
    }

    public Price[] priceOfItems(int[] code , int[] amount){
        Price[] price = new Price[code.length];
        for (int i = 0; i < code.length; i++) {
            if (!priceList.containsKey(code[i])) throw new IllegalArgumentException();

            int current = (priceList.get(code[i]).getPrice().rubles * 100 + priceList.get(code[i]).getPrice().pennies) * amount[i];
            price[i]=new Price( current/100 ,current%100 );
        }
        return price;
    }

    public  int getRubles(Item item){
        return item.getPrice().rubles;
    }
    public  int getPennies(Item item){
        return item.getPrice().pennies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PriceList priceList1 = (PriceList) o;
        return Objects.equals(priceList, priceList1.priceList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(priceList);
    }

    @Override
    public String toString() {
        return "PriceList{" +
                "priceList=" + priceList +
                '}';
    }

}
