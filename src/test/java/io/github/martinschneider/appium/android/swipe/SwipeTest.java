package io.github.martinschneider.appium.android.swipe;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

/**
 *
 *
 * <h2>Demo Appium Swipe Actions</h2>
 *
 * Test: Swipe up,down, left and right
 *
 * <p>Learning points:
 *
 * <ul>
 *   <li>Detecting coordinates
 *   <li>Different swiping actions
 * </ul>
 *
 * @author Syam Sasi, syamsasi99@gmail.com
 */
public class SwipeTest extends BaseTest {

  protected void doSwipe(String direction) throws InterruptedException {

    TouchAction touch = new TouchAction((MobileDriver) driver);
    TouchAction swipe = null;
    WebElement rootElement = getRootElement();

    if (direction.equals("down")) {

      int x1 = rootElement.getSize().width / 2;
      int y1 = rootElement.getSize().height / 2;
      int x2 = rootElement.getSize().width / 2;
      int y2 = (rootElement.getSize().height * 9) / 10;

      swipe =
          touch
              .press(ElementOption.element(rootElement, x2, y2))
              .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
              .moveTo(ElementOption.element(rootElement, x1, y1))
              .release();
    } else if (direction.equals("up")) {

      int x1 = rootElement.getSize().width / 2;
      int y1 = (rootElement.getSize().height * 8) / 10;
      int x2 = rootElement.getSize().width / 2;
      int y2 = rootElement.getSize().height / 2;

      swipe =
          touch
              .press(ElementOption.element(rootElement, x2, y2))
              .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
              .moveTo(ElementOption.element(rootElement, x1, y1))
              .release();
    } else if (direction.equals("right")) {

      int x1 = rootElement.getSize().width / 10;
      int y1 = rootElement.getSize().height / 2;
      int x2 = (rootElement.getSize().width * 9) / 10;
      int y2 = rootElement.getSize().height / 2;

      swipe =
          touch
              .press(ElementOption.element(rootElement, x2, y2))
              .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
              .moveTo(ElementOption.element(rootElement, x1, y1))
              .release();
    } else if (direction.equals("left")) {

      int x1 = (rootElement.getSize().width * 9) / 10;
      int y1 = rootElement.getSize().height / 2;
      int x2 = rootElement.getSize().width / 10;
      int y2 = rootElement.getSize().height / 2;

      swipe =
          touch
              .press(ElementOption.element(rootElement, x2, y2))
              .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
              .moveTo(ElementOption.element(rootElement, x1, y1))
              .release();
    }

    swipe.perform();
  }

  private WebElement getRootElement() throws InterruptedException {

    WebElement rootElement = null;
    By xpathLocator = By.xpath("//*");
    try {
      rootElement = driver.findElement(xpathLocator);
    } catch (StaleElementReferenceException e) {
      Thread.sleep(5000);
      rootElement = driver.findElement(xpathLocator);
    }
    return rootElement;
  }

  protected void goToNativeComponents() throws InterruptedException {

    if (driver instanceof AndroidDriver) {
      MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("ReferenceApp");
      AppiumHelper.waitForElementVisible(driver, el1);
      el1.click();
      Thread.sleep(1000);
      MobileElement el2 =
          (MobileElement)
              driver.findElementByXPath("//android.widget.TextView[@text='Native Components']");
      AppiumHelper.waitForElementVisible(driver, el2);
      el2.click();
      MobileElement el3 =
          (MobileElement)
              driver.findElementByXPath("//android.widget.TextView[@text='Image Collection']");

    } else {

      MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("Native");
      AppiumHelper.waitForElementVisible(driver, el2);
      el2.click();
      MobileElement el3 = (MobileElement) driver.findElementByAccessibilityId("Scrolling View");
      AppiumHelper.waitForElementVisible(driver, el3);
      el3.click();
      Thread.sleep(2000);
    }
  }
}
