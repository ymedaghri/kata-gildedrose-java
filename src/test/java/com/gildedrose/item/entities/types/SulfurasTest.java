package com.gildedrose.item.entities.types;

import static com.gildedrose.item.entities.ItemFactory.SULFURAS_HAND_OF_RAGNAROS;

import com.gildedrose.Updatable;
import com.gildedrose.item.entities.ItemBuilder;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class SulfurasTest {

  @Test
  void nothingHappensToTheLegendarySulfuras() {
    // Given
    Updatable sulfuras = new ItemBuilder().withName(SULFURAS_HAND_OF_RAGNAROS).withSellIn(10)
                                          .withQuality(20).build();

    // When
    sulfuras.update();

    // Then
    Assertions.assertThat(sulfuras.getQuality()).isEqualTo(20);
    Assertions.assertThat(sulfuras.getSellIn()).isEqualTo(10);
  }

}