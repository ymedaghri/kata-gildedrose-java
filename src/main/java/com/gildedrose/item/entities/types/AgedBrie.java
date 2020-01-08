package com.gildedrose.item.entities.types;

import com.gildedrose.Item;
import com.gildedrose.Updatable;
import com.gildedrose.item.entities.ItemWrapper;

public class AgedBrie extends ItemWrapper implements Updatable {

  public AgedBrie(Item item, boolean isConjured) {
    super(item, isConjured);
  }

  @Override
  public void update() {
    if (quality < 50) {
      increaseQualityByOne();
    }
    decreaseSellInByOne();

    if (sellIn < 0) {
      if (quality < 50) {
        increaseQualityByOne();
      }
    }
  }
}
