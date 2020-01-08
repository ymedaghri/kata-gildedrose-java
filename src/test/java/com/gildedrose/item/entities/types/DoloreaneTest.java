package com.gildedrose.item.entities.types;


import com.gildedrose.Updatable;
import com.gildedrose.item.entities.ItemBuilder;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class DoloreaneTest {

  @Test
  public void shouldIncreaseSellInOnEveryUpdate() {
    // Given
    Updatable doloreane = new ItemBuilder().withName("Doloreane").withQuality(10).withSellIn(10)
                                           .build();

    // When
    doloreane.update();

    // Then
    Assertions.assertThat(doloreane.getSellIn()).isEqualTo(11);
  }
}
