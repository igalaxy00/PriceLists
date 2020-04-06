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

    public Price priceOfItems(int[] code , int[] amount){
        int all = 0 ;
        for (int i = 0; i < code.length; i++) {
            if (!priceList.containsKey(code[i])) throw new IllegalArgumentException();
            int current = (priceList.get(code[i]).getPrice().getRubles() * 100 + priceList.get(code[i]).getPrice().getPennies()) * amount[i];
            all+=current;
        }
        return  new Price(all/100,all%100);
    }

    public  int getRubles(Item item){
        return item.getPrice().getRubles();
    }
    public  int getPennies(Item item){
        return item.getPrice().getPennies();
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
