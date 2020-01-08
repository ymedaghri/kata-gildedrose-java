package com.gildedrose.item.entities;

import com.gildedrose.Item;
import com.gildedrose.Updatable;
import com.gildedrose.item.entities.types.AgedBrie;
import com.gildedrose.item.entities.types.BackstagePasses;
import com.gildedrose.item.entities.types.Others;
import com.gildedrose.item.entities.types.Sulfuras;

public final class ItemFactory {

  public static final String AGED_BRIE = "Aged Brie";
  public static final String BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT =
      "Backstage passes to a" + " TAFKAL80ETC concert";
  public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
  private static final String CONJURED = "Conjured";

  static Updatable buildFrom(Item item) {
    boolean isConjured = item.name.startsWith(CONJURED);
    String name = (isConjured) ? item.name.substring(CONJURED.length() + 1) : item.name;
    switch (name) {
      case AGED_BRIE:
        return new AgedBrie(item, isConjured);
      case BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT:
        return new BackstagePasses(item, isConjured);
      case SULFURAS_HAND_OF_RAGNAROS:
        return new Sulfuras(item, isConjured);
      default:
        return new Others(item, isConjured);
    }
  }

}
