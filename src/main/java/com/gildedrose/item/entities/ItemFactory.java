package com.gildedrose.item.entities;

import com.gildedrose.Item;
import com.gildedrose.Updatable;
import com.gildedrose.item.entities.types.AgedBrie;
import com.gildedrose.item.entities.types.BackstagePasses;
import com.gildedrose.item.entities.types.Doloreane;
import com.gildedrose.item.entities.types.Others;
import com.gildedrose.item.entities.types.Sulfuras;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public final class ItemFactory {

  public static final String AGED_BRIE = "Aged Brie";
  public static final String BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT =
      "Backstage passes to a" + " TAFKAL80ETC concert";
  public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
  public static final String DOLOREANE = "Doloreane";
  private static final String CONJURED = "Conjured";

  private static Map<String, BiFunction<Item, Boolean, Updatable>> builder = new HashMap<>();

  static {
    builder.put(AGED_BRIE, AgedBrie::new);
    builder.put(BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT, BackstagePasses::new);
    builder.put(SULFURAS_HAND_OF_RAGNAROS, Sulfuras::new);
    builder.put(DOLOREANE, Doloreane::new);
  }

  static Updatable buildFrom(Item item) {
    boolean isConjured = item.name.startsWith(CONJURED);
    String name = (isConjured) ? item.name.substring(CONJURED.length() + 1) : item.name;
    return builder.getOrDefault(name, Others::new).apply(item, isConjured);
  }

}
