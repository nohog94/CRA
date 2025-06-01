package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    public static final String NONAME = "noname";
    public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert";

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    public void should_be_nothing_when_no_item() {
        // given (arrange)
        Item[] items = new Item[]{};
        GildedRose gildedRose = new GildedRose(items);

        // when (act)
        gildedRose.updateQuality();

        // then (assert)
        assertEquals(0, items.length);
    }

    @Test
    public void noname_sellin_0_quality_0() {
        // given (arrange)
        Item[] items = new Item[]{ new Item(NONAME, 0, 0) };
        GildedRose gildedRose = new GildedRose(items);

        // when (act)
        gildedRose.updateQuality();

        // then (assert)
        assertEquals(-1, items[0].sellIn);
        assertEquals(0, items[0].quality);
    }

    @Test
    public void noname_sellin_0_quality_1() {
        // given (arrange)
        Item[] items = new Item[]{ new Item(NONAME, 0, 1) };
        GildedRose gildedRose = new GildedRose(items);

        // when (act)
        gildedRose.updateQuality();

        // then (assert)
        assertEquals(-1, items[0].sellIn);
        assertEquals(0, items[0].quality);
    }

    @Test
    public void sulfuras_sellin_0_quality_80() {
        // given (arrange)
        Item[] items = new Item[]{ new Item(SULFURAS_HAND_OF_RAGNAROS, 0, 80) };
        GildedRose gildedRose = new GildedRose(items);

        // when (act)
        gildedRose.updateQuality();

        // then (assert)
        assertEquals(0, items[0].sellIn);
        assertEquals(80, items[0].quality);
    }

    @Test
    public void agedBrie_sellin_0_quality_0() {
        // given (arrange)
        Item[] items = new Item[]{ new Item(AGED_BRIE, 0, 0) };
        GildedRose gildedRose = new GildedRose(items);

        // when (act)
        gildedRose.updateQuality();

        // then (assert)
        assertEquals(-1, items[0].sellIn);
        assertEquals(2, items[0].quality);
    }

    @Test
    public void backstage_pass_sellin_0_quality_0() {
        // given (arrange)
        Item[] items = new Item[]{ new Item(BACKSTAGE_PASS, 0, 0) };
        GildedRose gildedRose = new GildedRose(items);

        // when (act)
        gildedRose.updateQuality();

        // then (assert)
        assertEquals(-1, items[0].sellIn);
        assertEquals(0, items[0].quality);
    }

    @Test
    public void backstage_pass_sellin_0_quality_49() {
        // given (arrange)
        Item[] items = new Item[]{ new Item(BACKSTAGE_PASS, 0, 49) };
        GildedRose gildedRose = new GildedRose(items);

        // when (act)
        gildedRose.updateQuality();

        // then (assert)
        assertEquals(-1, items[0].sellIn);
        assertEquals(0, items[0].quality);
    }

    @Test
    public void backstage_pass_sellin_12_quality_0() {
        // given (arrange)
        Item[] items = new Item[]{ new Item(BACKSTAGE_PASS, 12, 0) };
        GildedRose gildedRose = new GildedRose(items);

        // when (act)
        gildedRose.updateQuality();

        // then (assert)
        assertEquals(11, items[0].sellIn);
        assertEquals(1, items[0].quality);
    }

    @Test
    public void sulfuras_sellin_m2_quality_80() {
        // given (arrange)
        Item[] items = new Item[]{ new Item(SULFURAS_HAND_OF_RAGNAROS, -2, 80) };
        GildedRose gildedRose = new GildedRose(items);

        // when (act)
        gildedRose.updateQuality();

        // then (assert)
        assertEquals(-2, items[0].sellIn);
        assertEquals(80, items[0].quality);
    }

    @Test
    public void agedBrie_sellin_0_quality_50() {
        // given (arrange)
        Item[] items = new Item[]{ new Item(AGED_BRIE, 0, 50) };
        GildedRose gildedRose = new GildedRose(items);

        // when (act)
        gildedRose.updateQuality();

        // then (assert)
        assertEquals(-1, items[0].sellIn);
        assertEquals(50, items[0].quality);
    }

    @Test
    public void noname_sellin_m1_quality_2() {
        // given (arrange)
        Item[] items = new Item[]{ new Item(NONAME, -1, 2) };
        GildedRose gildedRose = new GildedRose(items);

        // when (act)
        gildedRose.updateQuality();

        // then (assert)
        assertEquals(-2, items[0].sellIn);
        assertEquals(0, items[0].quality);
    }








}