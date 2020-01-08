package com.gildedrose.item.entities.types;

import static com.gildedrose.item.entities.ItemFactory.BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT;

import com.gildedrose.Updatable;
import com.gildedrose.item.entities.ItemBuilder;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BackStagePassesTest {

  @ParameterizedTest(name = "when sellIn equals {arguments}")
  @ValueSource(ints = {-50, -10, 0, 10, 100})
  void sellInDecreasesByOneOnEveryUpdate(int sellIn) {
    // Given
    Updatable backStagePasses = new ItemBuilder().withName(
        BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT).withSellIn(sellIn).withQuality(20).build();

    // When
    backStagePasses.update();

    // Then
    Assertions.assertThat(backStagePasses.getSellIn()).isEqualTo(sellIn - 1);
  }

  @ParameterizedTest(name = "when sellIn equals {arguments}")
  @ValueSource(ints = {-50, -10, 0})
  void qualityDropsToZeroAfterTheConcert(int sellIn) {
    // Given
    Updatable backStagePasses = new ItemBuilder().withName(
        BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT).withSellIn(sellIn).withQuality(20).build();

    // When
    backStagePasses.update();

    // Then
    Assertions.assertThat(backStagePasses.getQuality()).isEqualTo(0);
  }

  @ParameterizedTest(name = "when quality equals {arguments}")
  @ValueSource(ints = {50, 51, 100})
  void theQualityOfAnItemCanNeverBeMoreThanFifty(int quality) {
    // Given
    Updatable backStagePasses = new ItemBuilder().withName(
        BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT).withSellIn(10).withQuality(quality).build();

    // When
    backStagePasses.update();

    // Then
    Assertions.assertThat(backStagePasses.getQuality()).isEqualTo(quality);
  }

  @ParameterizedTest(name = "when sellIn equals {arguments}")
  @ValueSource(ints = {11, 20, 100})
  void qualityIncreaseByOneIfSellInIsGreaterThan10(int sellIn) {
    // Given
    Updatable backStagePasses = new ItemBuilder().withName(
        BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT).withSellIn(sellIn).withQuality(20).build();

    // When
    backStagePasses.update();

    // Then
    Assertions.assertThat(backStagePasses.getQuality()).isEqualTo(21);
  }

  @ParameterizedTest(name = "when sellIn equals {arguments}")
  @ValueSource(ints = {6, 7, 8, 9, 10})
  void qualityIncreaseByTwoWhenThereAreBetween6And10DaysLeft(int sellIn) {
    // Given
    Updatable backStagePasses = new ItemBuilder().withName(
        BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT).withSellIn(sellIn).withQuality(20).build();

    // When
    backStagePasses.update();

    // Then
    Assertions.assertThat(backStagePasses.getQuality()).isEqualTo(22);
  }

  @ParameterizedTest(name = "when sellIn equals {arguments}")
  @ValueSource(ints = {1, 2, 3, 4, 5})
  void qualityIncreaseByThreeWhenThereAreBetween1And5DaysLeft(int sellIn) {
    // Given
    Updatable backStagePasses = new ItemBuilder().withName(
        BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT).withSellIn(sellIn).withQuality(20).build();

    // When
    backStagePasses.update();

    // Then
    Assertions.assertThat(backStagePasses.getQuality()).isEqualTo(23);
  }

}