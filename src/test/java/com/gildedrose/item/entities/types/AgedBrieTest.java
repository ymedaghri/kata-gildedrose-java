package com.gildedrose.item.entities.types;

import static com.gildedrose.item.entities.ItemFactory.AGED_BRIE;

import com.gildedrose.Updatable;
import com.gildedrose.item.entities.ItemBuilder;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class AgedBrieTest {

  @ParameterizedTest(name = "when sellIn equals {arguments}")
  @ValueSource(ints = {-50, -10, 0, 10, 100})
  void sellInDecreasesByOneOnEveryUpdate(int sellIn) {
    // Given
    Updatable agedBrie = new ItemBuilder().withName(AGED_BRIE).withSellIn(sellIn).withQuality(20)
                                          .build();

    // When
    agedBrie.updateQuality();

    // Then
    Assertions.assertThat(agedBrie.getSellIn()).isEqualTo(sellIn - 1);
  }

  @ParameterizedTest(name = "when quality equals {arguments}")
  @ValueSource(ints = {50, 51, 100})
  void theQualityOfAnItemCanNeverBeMoreThanFifty(int quality) {
    // Given
    Updatable agedBrie = new ItemBuilder().withName(AGED_BRIE).withSellIn(10).withQuality(quality)
                                          .build();

    // When
    agedBrie.updateQuality();

    // Then
    Assertions.assertThat(agedBrie.getQuality()).isEqualTo(quality);
  }

  @Test
  void qualityIncreaseByOneOnEveryUpdate() {
    // Given
    Updatable agedBrie = new ItemBuilder().withName(AGED_BRIE).withSellIn(10).withQuality(20)
                                          .build();

    // When
    agedBrie.updateQuality();

    // Then
    Assertions.assertThat(agedBrie.getQuality()).isEqualTo(21);
  }
}