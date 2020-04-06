package LikeAMarket;

import java.util.Objects;

public class Price {
     private int rubles;
     private int pennies;
    public Price(int rubles , int pennies){
        if (pennies<100 && rubles>=0 && pennies>=0){
            this.pennies=pennies;
            this.rubles = rubles;
        }else{
            throw new NullPointerException("цена введена неверно");
        }
    }

    public int getRubles() {
        return rubles;
    }

    public int getPennies() {
        return pennies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price = (Price) o;
        return rubles == price.rubles &&
                pennies == price.pennies;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rubles, pennies);
    }

    @Override
    public String toString() {
        return "Price{" +
                "rubles=" + rubles +
                ", pennies=" + pennies +
                '}';
    }
}
