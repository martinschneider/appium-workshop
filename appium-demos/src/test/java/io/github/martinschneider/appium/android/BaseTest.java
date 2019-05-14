package io.github.martinschneider.appium.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import java.io.File;
import java.io.IOException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

public class BaseTest {
  protected AndroidDriver<WebElement> driver;

  protected static String appPath;

  protected DesiredCapabilities capabilities = new DesiredCapabilities();

  @BeforeAll
  public void setUp() throws IOException {
    File classpathRoot = new File(System.getProperty("user.dir"));
    File appDir = new File(classpathRoot, "apps");
    File app = new File(appDir.getCanonicalPath(), appPath);
    capabilities.setCapability("deviceName", "Android Emulator");
    capabilities.setCapability("automationName", "UiAutomator2");
    capabilities.setCapability("app", app.getAbsolutePath());
    driver = new AndroidDriver<WebElement>(capabilities);
    PageFactory.initElements(new AppiumFieldDecorator(driver), this);
  }

  @AfterAll
  public void tearDown() {
    driver.quit();
  }
}
