package io.github.martinschneider.appium.android;

import static org.assertj.core.api.Assertions.assertThat;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.openqa.selenium.WebElement;

@TestInstance(Lifecycle.PER_CLASS)
public class CounterTest02 extends BaseTest {

  @AndroidFindBy(id = ID_PREFIX + "counterLabel")
  private WebElement counter;

  @Test()
  public void testCounterIncrease() {
    for (int i = 1; i <= 10; i++) {
      int oldCount = Integer.parseInt(counter.getText());
      counter.click();
      int newCount = Integer.parseInt(counter.getText());
      assertThat(newCount - oldCount).as("check counter increased").isEqualTo(1);
    }
  }
}
