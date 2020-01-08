package com.gildedrose.item.entities.types;

import com.gildedrose.Item;
import com.gildedrose.Updatable;
import com.gildedrose.item.entities.ItemWrapper;

public class Others extends ItemWrapper implements Updatable {

  public Others(Item item, boolean isConjured) {
    super(item, isConjured);
  }

  @Override
  public void updateQuality() {
    if (quality > 0) {
      decreaseQualityByOneOrTwoIfConjured();
    }
    decreaseSellInByOne();
    if (sellIn < 0) {
      if (quality > 0) {
        decreaseQualityByOneOrTwoIfConjured();
      }
    }
  }
}
