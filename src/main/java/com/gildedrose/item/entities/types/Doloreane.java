package com.gildedrose.item.entities.types;

import com.gildedrose.Item;
import com.gildedrose.Updatable;
import com.gildedrose.item.entities.ItemWrapper;

public class Doloreane extends ItemWrapper implements Updatable {

  public Doloreane(Item item, boolean isConjured) {
    super(item, isConjured);
  }

  @Override
  public void update() {
    sellIn++;
  }
}
