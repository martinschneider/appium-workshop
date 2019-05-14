package io.github.martinschneider.appium.android;

import static org.assertj.core.api.Assertions.assertThat;

import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.openqa.selenium.WebElement;

/**
 *
 *
 * <h2>Demo Appium test for Android Counter app #3</h2>
 *
 * Test: Increase the counter by one and verify
 *
 * <p>Learning points:
 *
 * <ul>
 *   <li>different location strategies
 * </ul>
 */
@TestInstance(Lifecycle.PER_CLASS)
public class CounterTest03 extends CounterBaseTest {

  @AndroidFindBy(id = ID_PREFIX + "counterLabel")
  private WebElement counter;

  @AndroidFindBy(id = ID_PREFIX + "incrementButton")
  private WebElement incrementButtonId;

  @AndroidFindBy(xpath = "//*[@resource-id=\"me.tsukanov.counter:id/incrementButton\"]")
  private WebElement incrementButtonXPath1;

  @AndroidFindBy(
      xpath =
          "//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.widget.FrameLayout[2]/android.support.v4.widget.DrawerLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.Button[1]")
  private WebElement incrementButtonXPath2;

  @AndroidFindBy(
      uiAutomator = "new UiSelector().resourceId(\"me.tsukanov.counter:id/incrementButton\")")
  private WebElement incrementButtonUIAutomator1;

  @AndroidFindBy(uiAutomator = "new UiSelector().text(\"+\")")
  private WebElement incrementButtonUIAutomator2;

  private PointOption<ElementOption> counterCoordinates =
      new PointOption<ElementOption>().withCoordinates(105, 540);

  @Test
  public void testCounterIncreaseId() {
    int oldCount = Integer.parseInt(counter.getText());
    incrementButtonId.click();
    int newCount = Integer.parseInt(counter.getText());
    assertThat(newCount - oldCount).as("check counter increased").isEqualTo(1);
  }

  @Test
  public void testCounterIncreaseXPath1() {
    int oldCount = Integer.parseInt(counter.getText());
    incrementButtonXPath1.click();
    int newCount = Integer.parseInt(counter.getText());
    assertThat(newCount - oldCount).as("check counter increased").isEqualTo(1);
  }

  @Test
  public void testCounterIncreaseXPath2() {
    int oldCount = Integer.parseInt(counter.getText());
    incrementButtonXPath2.click();
    int newCount = Integer.parseInt(counter.getText());
    assertThat(newCount - oldCount).as("check counter increased").isEqualTo(1);
  }

  @Test
  public void testCounterIncreaseUIautomator1() {
    int oldCount = Integer.parseInt(counter.getText());
    incrementButtonUIAutomator1.click();
    int newCount = Integer.parseInt(counter.getText());
    assertThat(newCount - oldCount).as("check counter increased").isEqualTo(1);
  }

  @Test
  public void testCounterIncreaseUIautomator2() {
    int oldCount = Integer.parseInt(counter.getText());
    incrementButtonUIAutomator2.click();
    int newCount = Integer.parseInt(counter.getText());
    assertThat(newCount - oldCount).as("check counter increased").isEqualTo(1);
  }

  @Test
  public void testCounterIncreaseCoordinates() {
    int oldCount = Integer.parseInt(counter.getText());
    new TouchAction(driver).tap(counterCoordinates).perform();
    int newCount = Integer.parseInt(counter.getText());
    assertThat(newCount - oldCount).as("check counter increased").isEqualTo(1);
  }

  @Test
  public void testCounterIncreaseImage() {
    int oldCount = Integer.parseInt(counter.getText());
    driver
        .findElementByImage(
            "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")
        .click();
    int newCount = Integer.parseInt(counter.getText());
    assertThat(newCount - oldCount).as("check counter increased").isEqualTo(1);
  }
}
