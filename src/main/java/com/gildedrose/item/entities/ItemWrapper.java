package com.gildedrose.item.entities;

import com.gildedrose.Item;

public abstract class ItemWrapper {

  public ItemWrapper(Item item, boolean isConjured) {
    quality = item.quality;
    sellIn = item.sellIn;
    this.isConjured = isConjured;
  }

  protected void decreaseQualityByOneOrTwoIfConjured() {
    quality-= (isConjured)?2:1;
  }

  protected void increaseQualityByOne() {
    quality++;
  }

  protected void decreaseSellInByOne() {
    sellIn--;
  }

  protected void resetQualityToZero() {
    quality = 0;
  }

  public int getSellIn(){
    return sellIn;
  }

  public int getQuality(){
    return quality;
  }

  protected int quality;
  protected int sellIn;
  protected boolean isConjured;
}
