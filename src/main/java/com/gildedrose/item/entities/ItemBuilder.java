package com.gildedrose.item.entities;

import com.gildedrose.Item;
import com.gildedrose.Updatable;

public class ItemBuilder {

  private String name;
  private int quality;
  private int sellIn;

  public ItemBuilder withName(String name) {
    this.name = name;
    return this;
  }

  public ItemBuilder withQuality(int quality) {
    this.quality = quality;
    return this;
  }

  public ItemBuilder withSellIn(int sellIn) {
    this.sellIn = sellIn;
    return this;
  }

  public Updatable build() {
    return ItemFactory.buildFrom(new Item(name, sellIn, quality));
  }
}
