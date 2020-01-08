package com.gildedrose.item.entities.types;

import com.gildedrose.Item;
import com.gildedrose.Updatable;
import com.gildedrose.item.entities.ItemWrapper;

public class BackstagePasses extends ItemWrapper implements Updatable {

  public BackstagePasses(Item item, boolean isConjured) {
    super(item, isConjured);
  }

  @Override
  public void update() {
    if (quality < 50) {
      increaseQualityByOne();

      if (sellIn < 11) {
        increaseQualityByOne();
      }

      if (sellIn < 6) {
        increaseQualityByOne();
      }
    }
    decreaseSellInByOne();
    if (sellIn < 0) {
      resetQualityToZero();
    }
  }
}
