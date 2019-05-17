package io.github.martinschneider.appium.ios;

import static org.assertj.core.api.Assertions.assertThat;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.github.martinschneider.appium.android.swipe.AppiumHelper;
import java.net.MalformedURLException;
import java.net.URL;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 *
 *
 * <h2>Demo Input a text on iOS Simulator textfield</h2>
 *
 * Test: Enter a text on textfield
 *
 * <p>Learning points:
 *
 * <ul>
 *   <li>How to run a basic appium script on ios simulator
 * </ul>
 *
 * @author Syam Sasi, syamsasi99@gmail.com
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class IOSTest {
  AppiumDriver<MobileElement> driver;

  @BeforeAll
  public void setUp() throws MalformedURLException {

    DesiredCapabilities caps = new DesiredCapabilities();
    caps.setCapability("platformVersion", "11.4");
    caps.setCapability("deviceName", "iPhone 8");
    caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
    caps.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") + "/apps/aws.app");
    caps.setCapability("noReset", Boolean.TRUE);
    driver = new IOSDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
  }

  @AfterAll
  public void tearDown() {
    driver.quit();
  }

  @Test
  public void enterStringOnTextField() throws InterruptedException {

    MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("Inputs");
    AppiumHelper.waitForElementVisible(driver, el2);
    el2.click();
    MobileElement el3 = (MobileElement) driver.findElementByXPath("//XCUIElementTypeTextView");
    AppiumHelper.waitForElementVisible(driver, el3);
    AppiumHelper.clearTextField(driver, el3);
    String myText = "I love Appium";
    el3.sendKeys(myText);
    assertThat(el3.getAttribute("value"))
        .as("Check the text has displayed or not")
        .isEqualTo(myText);
  }
}
