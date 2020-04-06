import LikeAMarket.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
 class PriceTest {
    @Test
     void TestPrices() {
        PriceList market = new PriceList();
        Item wrongR = new Item("wrongR", new Price(2, 22));
        assertThrows(NullPointerException.class, () ->wrongR.setPrice(new Price(-1, 9)));
        Item wrongP = new Item("wrongP", new Price(2, 22));
        assertThrows(NullPointerException.class, () ->wrongP.setPrice(new Price(1, 666666)));
        Item pTest = new Item("pTest", new Price(6, 66));
        assertEquals(market.getPennies(pTest),66);
        assertEquals(market.getRubles(pTest),6);
    }
    @Test
     void ItemTest() {
        Item testItem = new Item("tItem", new Price(2, 22));
        assertEquals(testItem.getPrice().getPennies(),22);
        assertEquals(testItem.getPrice().getRubles(),2);
        assertEquals(testItem.getName(),"tItem");
        testItem.setName("newName");
        assertEquals(testItem.getName(),"newName");
        Price changePrice = new Price(33,10);
        testItem.setPrice(changePrice);
        assertEquals(testItem.getPrice(),changePrice);
    }
    @Test
     void PriceListTest() {
        PriceList market = new PriceList();
        assertTrue(market.isEmpty());
        Item item1 = new Item("item1", new Price(2, 22));
        Item item2 = new Item("item2", new Price(3, 33));
        Item item3 = new Item("item3", new Price(6, 55));
        Item originItem = new Item("originItem", new Price(6, 55));
        market.addItem(12312123,originItem);
        market.renameFromMarket(12312123,"newName");
       assertEquals(originItem.getName(),"newName");
       market.rePriceFromMarket(12312123,new Price(3, 33));
        market.addItem(123,item1);
        assertFalse(market.addItem(123,item2));
        market.removeItem(123);
        assertFalse(market.removeItem(6666));
        market.addItem(1,item1);
        market.addItem(12,item2);
        market.addItem(123,item3);
        Price manyItems = market.priceOfItems(new int[]{1,12}, new int[]{2,2});
        assertEquals(manyItems.getPennies(),10);
        assertEquals(manyItems.getRubles(),11);
        market.removeItem(123);
        market.addItem(123,item3);
        market.removeItem(123);
        market.clearItems();
        assertTrue(market.isEmpty());
    }
}
