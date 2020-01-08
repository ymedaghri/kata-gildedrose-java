package com.gildedrose;


import com.gildedrose.item.entities.ItemBuilder;
import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;


class GildedRoseTest {

  @Test
  void shouldDescribeTheSystemBehavior() {
    // Given

    Updatable elixir_of_the_mongoose = new ItemBuilder().withName("Elixir of the Mongoose")
                                                        .withSellIn(5).withQuality(7).build();

    GildedRose app = new GildedRose(Lists.newArrayList(elixir_of_the_mongoose));

    // When
    app.updateQuality();

    // Then
    Assertions.assertThat(elixir_of_the_mongoose.getQuality()).isEqualTo(6);
    Assertions.assertThat(elixir_of_the_mongoose.getSellIn()).isEqualTo(4);
  }
}
