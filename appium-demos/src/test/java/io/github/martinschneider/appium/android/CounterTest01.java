package io.github.martinschneider.appium.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import java.io.File;
import java.io.IOException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

@TestInstance(Lifecycle.PER_CLASS)
public class CounterTest01 {
  private AndroidDriver<WebElement> driver;

  @BeforeAll
  public void setUp() throws IOException {
    File classpathRoot = new File(System.getProperty("user.dir"));
    File appDir = new File(classpathRoot, "apps");
    File app = new File(appDir.getCanonicalPath(), "counter.apk");
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability("deviceName", "Android Emulator");
    capabilities.setCapability("app", app.getAbsolutePath());
    capabilities.setCapability("automationName", "UiAutomator2");
    driver = new AndroidDriver<WebElement>(capabilities);
  }

  @AfterAll
  public void tearDown() {
    driver.quit();
  }

  @Test()
  public void testCounterIncrease() {
    AndroidElement counter =
        (AndroidElement) driver.findElementById("me.tsukanov.counter:id/counterLabel");
    for (int i = 1; i <= 10; i++) {
      int oldCount = Integer.parseInt(counter.getText());
      counter.click();
      int newCount = Integer.parseInt(counter.getText());
      Assertions.assertEquals(newCount - oldCount, 1);
    }
  }
}
