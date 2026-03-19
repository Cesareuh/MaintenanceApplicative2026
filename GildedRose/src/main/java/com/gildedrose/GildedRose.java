package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void doBrie(int i) {
        items[i].sellIn = items[i].sellIn - 1;
        if (items[i].quality < 50) {
            items[i].quality = items[i].quality + 1;
            if (items[i].sellIn < 0) {
                items[i].quality = items[i].quality + 1;
            }
        }
    }

    public void doConcert(int i) {
        items[i].sellIn = items[i].sellIn - 1;
        items[i].quality = items[i].quality + 1;

        if (items[i].quality < 50) {
            if (items[i].sellIn < 6) {
                items[i].quality = items[i].quality + 1;
            }
            if (items[i].sellIn < 11) {
                items[i].quality = items[i].quality + 1;
            }
        }
        if (items[i].sellIn < 0) {
            items[i].quality = 0;
        }
    }

    public void doSulfuras(int i) {

    }

    public void doOther(int i) {
        items[i].sellIn = items[i].sellIn - 1;
        if (items[i].quality > 0) {
            items[i].quality = items[i].quality - 1;
            if (items[i].sellIn < 0) {
                items[i].quality = items[i].quality - 1;
            }
        }
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (items[i].name.equals("Aged Brie")) {
                doBrie(i);
            } else if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                doConcert(i);
            } else if (items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                doSulfuras(i);
            } else {
                doOther(i);
            }
        }
    }
}
