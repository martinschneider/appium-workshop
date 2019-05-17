package io.github.martinschneider.appium.android.swipe;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 *
 * <h2>Appium Helper class for wait and clear text field</h2>
 *
 * @author Syam Sasi, syamsasi99@gmail.com
 */
public class AppiumHelper {

  public static WebElement driver(AppiumDriver driver, By by) {
    return driver.findElement(by);
  }

  public static WebElement waitForElementVisible(AppiumDriver driver, WebElement ele) {

    WebDriverWait wait = new WebDriverWait(driver, 20);
    return wait.until(ExpectedConditions.visibilityOf(ele));
  }

  public static void clearTextField(AppiumDriver driver, WebElement element) {
    if (driver instanceof IOSDriver) {
      try {
        waitForElementVisible(driver, element).click();
        TouchAction action = new TouchAction((IOSDriver) driver);
        action
            .longPress(
                LongPressOptions.longPressOptions().withElement(ElementOption.element(element)))
            .release()
            .perform();

        WebElement selectAll = ((IOSDriver) driver).findElementByAccessibilityId("Select All");
        waitForElementVisible(driver, selectAll);
        selectAll.click();
        WebElement delete = null;
        try {
          delete = ((IOSDriver) driver).findElementByAccessibilityId("delete");
          waitForElementVisible(driver, delete);
        } catch (WebDriverException e) {
          delete = ((IOSDriver) driver).findElementByAccessibilityId("Delete");
        }
        waitForElementVisible(driver, delete);
        delete.click();
      } catch (WebDriverException e) {
        e.printStackTrace();
      }

    } else {
      element.clear();
    }
  }
}
