package io.github.martinschneider.appium.advanced.demo6.grid;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.GsmCallActions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumGrid {

  /**
   * *
   *
   * <p>java -cp *:. org.openqa.grid.selenium.GridLauncherV3 -role hub -port 4443 appium
   * --nodeconfig node-config-device4724.json -p 4724 -cp 4726 appium --nodeconfig
   * node-config-device4725.json -p 4725 -cp 2727
   */
  private String APP = System.getProperty("user.dir") + "/apps/TheApp.apk";

  private AndroidDriver driver;
  private String PHONE_NUMBER = "99949239192";

  @Before
  public void setUp() throws MalformedURLException {
    DesiredCapabilities capabilities = new DesiredCapabilities();

    // final String UDID="emulator-5554";
    // final int SYSTEM_PORT=5724;
    final String UDID = "emulator-5556";
    final int SYSTEM_PORT = 5725;

    capabilities.setCapability("platformName", "Android");
    capabilities.setCapability("deviceName", UDID);
    capabilities.setCapability("automationName", "UiAutomator2");
    capabilities.setCapability("app", APP);
    capabilities.setCapability("udid", UDID);
    capabilities.setCapability("systemPort", SYSTEM_PORT);

    driver = new AndroidDriver(new URL("http://192.168.1.92:4443/wd/hub"), capabilities);
  }

  @After
  public void tearDown() {
    if (driver != null) {
      driver.quit();
    }
  }

  @Test
  public void testPhoneCall() throws InterruptedException {
    // do something in our app
    Thread.sleep(5000); // pause just for effect
    driver.findElementByAccessibilityId("Login Screen").click();

    // receive and accept a call
    driver.makeGsmCall(PHONE_NUMBER, GsmCallActions.CALL);
    Thread.sleep(2000); // pause just for effect
    driver.makeGsmCall(PHONE_NUMBER, GsmCallActions.ACCEPT);

    // continue to do something in our app
    driver.findElementByAccessibilityId("username").sendKeys("hi");
    Thread.sleep(2000); // pause just for effect

    // end the call
    driver.makeGsmCall(PHONE_NUMBER, GsmCallActions.CANCEL);
    Thread.sleep(2000); // pause just for effect
  }
}
