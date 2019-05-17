package io.github.martinschneider.appium.advanced.demo5.screenRecord;

import io.appium.java_client.MobileBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSStartScreenRecordingOptions;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Base64;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 *
 * <h2>Demo Screen recording in appium</h2>
 *
 * Test: Record the test execution video
 *
 * <p>Learning points:
 *
 * <ul>
 *   <li>Usage of the Video Record Options in Appium
 * </ul>
 *
 * @author Syam Sasi, syamsasi99@gmail.com
 */
public class ScreenRecord {

  private String APP_IOS = System.getProperty("user.dir") + "/apps/TheApp.app";

  private IOSDriver driver;
  private WebDriverWait wait;

  private static By pickerScreen = MobileBy.AccessibilityId("Picker Demo");
  private static By pickers = MobileBy.className("XCUIElementTypePickerWheel");

  @BeforeEach
  public void setUp() throws IOException {
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability("platformName", "iOS");
    capabilities.setCapability("platformVersion", "11.4");
    capabilities.setCapability("deviceName", "iPhone 8");
    capabilities.setCapability("app", APP_IOS);

    driver = new IOSDriver<>(new URL("http://localhost:4723/wd/hub"), capabilities);
    wait = new WebDriverWait(driver, 10);
  }

  @AfterEach
  public void tearDown() {
    if (driver != null) {
      driver.quit();
    }
  }

  @Test
  public void testPicker() throws IOException, InterruptedException {

    IOSStartScreenRecordingOptions iOSStartScreenRecordingOptions =
        new IOSStartScreenRecordingOptions()
            .withVideoQuality(IOSStartScreenRecordingOptions.VideoQuality.HIGH)
            .withTimeLimit(Duration.ofSeconds(1800));

    driver.startRecordingScreen(iOSStartScreenRecordingOptions);

    // get to the picker view
    wait.until(ExpectedConditions.presenceOfElementLocated(pickerScreen)).click();

    // find the picker elements
    List<WebElement> pickerEls =
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(pickers));

    // use the sendKeys method to set the picker wheel values directly
    pickerEls.get(0).sendKeys("March");
    pickerEls.get(1).sendKeys("6");

    Thread.sleep(5000);

    String record = driver.stopRecordingScreen();
    byte[] decode = Base64.getDecoder().decode(record);

    File videoFile = new File(new StringBuilder().append("MyVideo.mp4").toString());
    FileUtils.writeByteArrayToFile(videoFile, decode);
  }
}
