import LikeAMarket.*;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class PriceTest {
    @Test
    public void TestPrices() {
        Item wrongR = new Item("wrongR", new Price(2, 22));
        assertThrows(NullPointerException.class, () ->wrongR.newPrice(new Price(-1, 9)));
        Item wrongP = new Item("wrongP", new Price(2, 22));
        assertThrows(NullPointerException.class, () ->wrongP.newPrice(new Price(1, 666666)));
        Item pTest = new Item("pTest", new Price(6, 66));
        assertEquals(Price.getPennies(pTest),66);
        assertEquals(Price.getRubles(pTest),6);
    }
    @Test
    public void ItemTest() {
        Item testItem = new Item("tItem", new Price(2, 22));
        assertEquals(testItem.getPrice().pennies,22);
        assertEquals(testItem.getPrice().rubles,2);
        assertEquals(testItem.getName(),"tItem");
        testItem.newName("newName");
        assertEquals(testItem.getName(),"newName");
        Item pen = new Item("Pen", new Price(30, 90));
        Price changePrice = new Price(33,10);
        testItem.newPrice(changePrice);
        assertEquals(testItem.getPrice(),changePrice);
    }
    @Test
    public void PriceListTest() {
        PriceList market = new PriceList();
        assertTrue(market.isEmpty());
        Item item1 = new Item("item1", new Price(2, 22));
        Item item2 = new Item("item2", new Price(3, 33));
        Item item3 = new Item("item3", new Price(6, 55));
        market.addItem(123,item1);
        assertThrows(IllegalArgumentException.class, () ->market.addItem(123,item2));
        market.removeItem(123);
        assertThrows(IllegalArgumentException.class, () ->market.removeItem(6666));
        market.addItem(1,item1);
        market.addItem(12,item2);
        market.addItem(123,item3);
        Price a = market.priceOfItems(1,2);
        assertEquals(a.rubles , 4);
        assertEquals(a.pennies , 44);
        assertTrue(market.removeItem(123));
        assertTrue(market.addItem(123,item3));
        assertTrue(market.removeItem(123));
        market.clearItems();
        assertTrue(market.isEmpty());
    }
}
