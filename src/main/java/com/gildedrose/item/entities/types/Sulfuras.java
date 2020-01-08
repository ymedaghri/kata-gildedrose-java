package com.gildedrose.item.entities.types;

import com.gildedrose.Item;
import com.gildedrose.Updatable;
import com.gildedrose.item.entities.ItemWrapper;

public class Sulfuras extends ItemWrapper implements Updatable {

  public Sulfuras(Item item, boolean isConjured) {
    super(item, isConjured);
  }

  @Override
  public void updateQuality() {}
}
