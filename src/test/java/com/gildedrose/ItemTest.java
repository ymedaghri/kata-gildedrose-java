package com.gildedrose;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


class ItemTest {

  @Test
  void shouldInstanciateAnItemAndDisplayIt() {
    //Given
    Item item = new Item("Onigiri", 3, 10);

    // When - Then
    Assertions.assertThat(item.toString()).isEqualTo("Onigiri, 3, 10");
  }
}