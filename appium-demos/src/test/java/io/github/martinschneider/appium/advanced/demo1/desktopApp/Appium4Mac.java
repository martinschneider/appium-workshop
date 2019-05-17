package io.github.martinschneider.appium.advanced.demo1.desktopApp;

import io.appium.java_client.AppiumDriver;
import io.github.martinschneider.appium.advanced.secret.Secret;
import java.io.IOException;
import java.net.URL;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 *
 * <h2>Demo Appium test for Mac App</h2>
 *
 * Test: Open activity monitor and verify search result
 *
 * <p>Learning points:
 *
 * <ul>
 *   <li>Understand Appium for mac
 * </ul>
 *
 * @author Syam Sasi, syamsasi99@gmail.com
 *     <p>Ref: https://appiumpro.com/editions/52
 */
public class Appium4Mac implements Secret {

  private AppiumDriver driver;

  @BeforeAll
  public void setUp() throws IOException {
    DesiredCapabilities caps = new DesiredCapabilities();

    caps.setCapability("platformName", "Mac");
    caps.setCapability("deviceName", "Mac");

    caps.setCapability("app", "Activity Monitor");
    driver = new AppiumDriver(new URL("http://localhost:4723/wd/hub"), caps);
  }

  @AfterAll
  public void tearDown() {
    try {
      driver.quit();
    } catch (Exception ign) {
    }
  }

  @Test
  public void testActivityMonitor() throws InterruptedException {
    String baseAXPath = "/AXApplication[@AXTitle='Activity Monitor']/AXWindow";
    String tabSelectorTemplate =
        baseAXPath + "/AXToolbar/AXGroup/AXRadioGroup/AXRadioButton[@AXTitle='%s']";
    driver.findElementByXPath(String.format(tabSelectorTemplate, "Memory")).click();
    driver.findElementByXPath(String.format(tabSelectorTemplate, "Energy")).click();
    driver.findElementByXPath(String.format(tabSelectorTemplate, "Disk")).click();
    driver.findElementByXPath(String.format(tabSelectorTemplate, "Network")).click();
    driver.findElementByXPath(String.format(tabSelectorTemplate, "CPU")).click();

    WebElement searchField =
        driver.findElementByXPath(
            baseAXPath + "/AXToolbar/AXGroup/AXTextField[@AXSubrole='AXSearchField']");
    searchField.sendKeys("node");
    Thread.sleep(5000);
    WebDriverWait wait = new WebDriverWait(driver, 20);
    WebElement firstRow =
        wait.until(
            ExpectedConditions.visibilityOf(
                driver.findElementByXPath(
                    baseAXPath + "/AXScrollArea/AXOutline/AXRow[0]/AXStaticText")));
    Assertions.assertEquals(" node", firstRow.getText());
  }
}
