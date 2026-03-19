package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    /*
    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("fixme", app.items[0].name);
    }
    */

    @Test
    void agedBrie() {
        Item[] items = new Item[] {
                new Item("Aged Brie", 0, 0),
                new Item("Aged Brie", 0, 100),
                new Item("Backstage passes to a TAFKAL80ETC concert", 0, 0),
                new Item("Backstage passes to a TAFKAL80ETC concert", 0, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 100, 0),
                new Item("Backstage passes to a TAFKAL80ETC concert", 100, 49),
                new Item("Sulfuras, Hand of Ragnaros", 0, 0),
                new Item("Sulfuras, Hand of Ragnaros", 0, 100),
                new Item("Sulfuras, Hand of Ragnaros", -1, 100),
                new Item("Sulfuras, Hand of Ragnaros", 100, 100),
                new Item("autre", 0, 0),
                new Item("autre", 0, 100),
                new Item("Aged Brie", 2, 0),
                new Item("autre", 2, 100),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie, -1, 2", app.items[0].toString());
        assertEquals("Aged Brie, -1, 100", app.items[1].toString());
        assertEquals("Backstage passes to a TAFKAL80ETC concert, -1, 0", app.items[2].toString());
        assertEquals("Backstage passes to a TAFKAL80ETC concert, -1, 0", app.items[3].toString());
        assertEquals("Backstage passes to a TAFKAL80ETC concert, 99, 1", app.items[4].toString());
        assertEquals("Backstage passes to a TAFKAL80ETC concert, 99, 50", app.items[5].toString());
        assertEquals("Sulfuras, Hand of Ragnaros, 0, 0", app.items[6].toString());
        assertEquals("Sulfuras, Hand of Ragnaros, 0, 100", app.items[7].toString());
        assertEquals("Sulfuras, Hand of Ragnaros, -1, 100", app.items[8].toString());
        assertEquals("Sulfuras, Hand of Ragnaros, 100, 100", app.items[9].toString());
        assertEquals("autre, -1, 0", app.items[10].toString());
        assertEquals("autre, -1, 98", app.items[11].toString());
        /*
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[2].name);
        assertEquals("Sulfuras, Hand of Ragnaros", app.items[4].name);
        assertEquals("autre", app.items[6].name);
        */
    }

}
