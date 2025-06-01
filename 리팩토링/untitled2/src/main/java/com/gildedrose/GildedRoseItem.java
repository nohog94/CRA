package com.gildedrose;

public abstract class GildedRoseItem {
    protected final Item item;

    public GildedRoseItem(Item item) {
        this.item = item;
    }

    public abstract void updateQuality(Item item);
}
