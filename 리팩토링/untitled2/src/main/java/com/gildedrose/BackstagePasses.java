package com.gildedrose;

public class BackstagePasses extends GildedRoseItem {

    public BackstagePasses(Item item) {
        super(item);
    }

    @Override
    public void updateQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;

            if (item.sellIn < 11) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }

            if (item.sellIn < 6) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }
        }
        if (item.sellIn < 1) {
            item.quality = item.quality - item.quality;
        }
    }
}
