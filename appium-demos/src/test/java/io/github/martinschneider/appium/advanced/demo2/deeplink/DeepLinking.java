package io.github.martinschneider.appium.advanced.demo2.deeplink;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.ios.IOSDriver;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.URL;

/**
 *
 *
 * <h2>Demo Deeplinking in Appium</h2>
 *
 * Test: Login with Deeplink
 *
 * <p>Learning points:
 *
 * <ul>
 *   <li>The execution time saving with deeplink</li>
 * </ul>
 *
 * @author Syam Sasi, syamsasi99@gmail.com
 *
 * Ref: https://appiumpro.com/editions/7
 *
 */
@RunWith(JUnit4.class)
public class DeepLinking {

  private String APP_IOS = System.getProperty("user.dir") + "/apps/TheApp.app";
  private String AUTH_USER = "alice";
  private String AUTH_PASS = "mypassword";

  @Test
  public void testLoginSlowIOS() throws IOException {
    IOSModel model = new IOSModel();
    IOSDriver driver = new IOSDriver<>(new URL("http://localhost:4723/wd/hub"), model.caps);
    runStepByStepTest(driver, model);
  }

  @Test
  public void testDeepLinkForDirectNavIOS() throws IOException {
    IOSModel model = new IOSModel();
    IOSDriver driver = new IOSDriver<>(new URL("http://localhost:4723/wd/hub"), model.caps);
    runDeepLinkTest(driver, model);
  }

  private void runStepByStepTest(AppiumDriver driver, Model model) {
    WebDriverWait wait = new WebDriverWait(driver, 10);

    try {
      wait.until(ExpectedConditions.presenceOfElementLocated(model.loginScreen)).click();
      wait.until(ExpectedConditions.presenceOfElementLocated(model.username)).sendKeys(AUTH_USER);
      wait.until(ExpectedConditions.presenceOfElementLocated(model.password)).sendKeys(AUTH_PASS);
      wait.until(ExpectedConditions.presenceOfElementLocated(model.loginBtn)).click();
      wait.until(ExpectedConditions.presenceOfElementLocated(model.getLoggedInBy(AUTH_USER)));
    } finally {
      driver.quit();
    }
  }

  private void runDeepLinkTest(AppiumDriver driver, Model model) {
    WebDriverWait wait = new WebDriverWait(driver, 30);

    try {
      driver.get("theapp://login/" + AUTH_USER + "/" + AUTH_PASS);
      wait.until(ExpectedConditions.presenceOfElementLocated(model.getLoggedInBy(AUTH_USER)));
    } finally {
      driver.quit();
    }
  }

  private abstract class Model {
    public By loginScreen = MobileBy.AccessibilityId("Login Screen");
    public By loginBtn = MobileBy.AccessibilityId("loginBtn");
    public By username;
    public By password;

    public DesiredCapabilities caps;

    abstract By getLoggedInBy(String username);
  }

  private class IOSModel extends Model {
    IOSModel() {
      username = By.xpath("//XCUIElementTypeTextField[@name=\"username\"]");
      password = By.xpath("//XCUIElementTypeSecureTextField[@name=\"password\"]");

      caps = new DesiredCapabilities();
      caps.setCapability("platformName", "iOS");
      caps.setCapability("deviceName", "iPhone 8");
      caps.setCapability("platformVersion", "11.4");
      caps.setCapability("app", APP_IOS);
    }

    public By getLoggedInBy(String username) {
      return MobileBy.AccessibilityId("You are logged in as " + username);
    }
  }
}
