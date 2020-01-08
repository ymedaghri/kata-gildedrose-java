package com.gildedrose.item.entities.types;

import com.gildedrose.Updatable;
import com.gildedrose.item.entities.ItemBuilder;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class OthersTest {

  @ParameterizedTest(name = "when sellIn equals {arguments}")
  @ValueSource(ints = { -50, -10, 0, 10,100 })
  void sellInDecreasesByOneOnEveryUpdate(int sellIn) {
    // Given
    Updatable beerKeg = new ItemBuilder().withName("Beer Keg").withSellIn(sellIn).withQuality(20).build();

    // When
    beerKeg.update();

    // Then
    Assertions.assertThat(beerKeg.getSellIn()).isEqualTo(sellIn-1);
  }

  @Test
  void qualityCanNeverBecomeNegative() {
    // Given
    Updatable beerKeg = new ItemBuilder().withName("Beer Keg").withSellIn(2).withQuality(0).build();

    // When
    beerKeg.update();

    // Then
    Assertions.assertThat(beerKeg.getQuality()).isEqualTo(0);
  }

  @Test
  void onceTheSellByDateHasPassedTheQualityDegradesTwiceAsFast() {
    // Given
    Updatable beerKeg = new ItemBuilder().withName("Beer Keg").withSellIn(0).withQuality(6).build();

    // When
    beerKeg.update();

    // Then
    Assertions.assertThat(beerKeg.getQuality()).isEqualTo(4);
  }


  @Test
  void conjuredItemsDegradesInQualityTwiceAsFast() {
    // Given
    Updatable beerKeg = new ItemBuilder().withName("Conjured Beer Keg").withSellIn(0).withQuality(6).build();

    // When
    beerKeg.update();

    // Then
    Assertions.assertThat(beerKeg.getQuality()).isEqualTo(2);
  }
}