package com.gildedrose;

import java.util.List;

class GildedRose {

  public GildedRose(List<Updatable> items) {
    this.items = items;
  }

  public void updateQuality() {
    for (Updatable item : items) {
      item.update();
    }
  }

  private List<Updatable> items;
}