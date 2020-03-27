package LikeAMarket;

public class Price {
    public int rubles;
    public int pennies;
    public Price(int r , int p){
        if (p<100 && r>=0 && p>=0){
            this.pennies=p;
            this.rubles = r;
        }else{
            throw new NullPointerException("цена введена неверно");
        }
    }
    public static int getRubles(Item item){
        return item.price.rubles;
    }
    public static int getPennies(Item item){
        return item.price.pennies;
    }
}
