package io.github.martinschneider.appium.advanced.demo3.optionalIntentArgs;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.ios.IOSDriver;
import static io.github.martinschneider.appium.advanced.secret.Secret.AUTH_PASS;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.URL;

@RunWith(JUnit4.class)
public class OptionalIntentArguments {

  private String APP_IOS = "/Users/carousell/Desktop/Carousell.app";

  private String AUTH_USER = "tvm.appium.demo";

  @Test
  public void testLoginSlowIOS() throws IOException, InterruptedException {
    IOSModel model = new IOSModel();
    IOSDriver driver = new IOSDriver<>(new URL("http://localhost:4723/wd/hub"), model.caps);
    runStepByStepTest(driver, model);
  }

  @Test
  public void testIntentAgs() throws IOException {
    IOSModel model = new IOSModel();
    IOSDriver driver = new IOSDriver<>(new URL("http://localhost:4723/wd/hub"), model.procesArCaps);
    runIntentArgTest(driver, model);
  }

  private void runStepByStepTest(AppiumDriver driver, Model model) throws InterruptedException {
    WebDriverWait wait = new WebDriverWait(driver, 10);

    try {
      wait.until(ExpectedConditions.presenceOfElementLocated(model.loginScreen)).click();
      wait.until(ExpectedConditions.presenceOfElementLocated(model.username)).sendKeys(AUTH_USER);
      wait.until(ExpectedConditions.presenceOfElementLocated(model.password)).sendKeys(AUTH_PASS);
      wait.until(ExpectedConditions.presenceOfElementLocated(model.loginBtn)).click();

      Thread.sleep(5000);
    } finally {
      driver.quit();
    }
  }

  private void runIntentArgTest(AppiumDriver driver, Model model) {
    WebDriverWait wait = new WebDriverWait(driver, 30);

    try {
      wait.until(ExpectedConditions.presenceOfElementLocated(model.seeTheSellButton()));
    } finally {
      driver.quit();
    }
  }

  public abstract class Model {
    public By loginScreen = MobileBy.AccessibilityId("welcome_page_login_button");
    public By loginBtn = MobileBy.AccessibilityId("login_page_login_button");
    public By username;
    public By password;

    public DesiredCapabilities caps;
    public DesiredCapabilities procesArCaps;

    public abstract By seeTheSellButton();
  }

  public class IOSModel extends Model {
    IOSModel() {
      username = MobileBy.AccessibilityId("login_page_username_text_field");
      password = MobileBy.AccessibilityId("login_page_password_text_field");

      caps = new DesiredCapabilities();
      caps.setCapability("platformName", "iOS");
      caps.setCapability("deviceName", "iPhone 8");
      caps.setCapability("platformVersion", "11.4");
      caps.setCapability("app", APP_IOS);

      procesArCaps = new DesiredCapabilities();
      procesArCaps.setCapability("platformName", "iOS");
      procesArCaps.setCapability("deviceName", "iPhone 8");
      procesArCaps.setCapability("platformVersion", "11.4");
      procesArCaps.setCapability("app", APP_IOS);
      procesArCaps.setCapability(
          "processArguments", String.format("{\"args\": [\"%s\",\"%s\"]}", AUTH_USER, AUTH_PASS));
    }

    public By seeTheSellButton() {
      return MobileBy.AccessibilityId("header_page_sell_button");
    }
  }
}
