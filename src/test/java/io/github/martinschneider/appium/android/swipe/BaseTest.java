package io.github.martinschneider.appium.android.swipe;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import java.net.MalformedURLException;
import java.net.URL;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.remote.DesiredCapabilities;

/** Setting android and ios capabilities here */
public class BaseTest {
  protected static AppiumDriver<MobileElement> driver;

  private static void androidCaps() throws MalformedURLException {
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel1");
    capabilities.setCapability("avd", "Pixel1");
    capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 120);
    capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");
    capabilities.setCapability(
        MobileCapabilityType.APP, System.getProperty("user.dir") + "/apps/aws.apk");
    driver =
        new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
  }

  private static void iosCaps() throws MalformedURLException {
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 6");
    capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
    capabilities.setCapability(IOSMobileCapabilityType.LAUNCH_TIMEOUT, 120);
    capabilities.setCapability("fullReset", Boolean.FALSE);

    capabilities.setCapability(
        MobileCapabilityType.APP, System.getProperty("user.dir") + "/apps/aws.app");
    driver = new IOSDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
  }

  public void launchApp(String platform) throws MalformedURLException {
    if (platform.equalsIgnoreCase("android")) {
      androidCaps();
    } else {
      iosCaps();
    }
  }

  @AfterEach
  public void quitApp() {
    if (driver != null) {
      driver.quit();
    }
  }
}
