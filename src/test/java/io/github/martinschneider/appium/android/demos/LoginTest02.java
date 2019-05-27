package io.github.martinschneider.appium.android.demos;

import static org.assertj.core.api.Assertions.assertThat;

import io.appium.java_client.MobileBy;
import io.github.martinschneider.appium.android.base.CarousellBaseTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.openqa.selenium.By;

/**
 *
 *
 * <h2>Demo Appium test for Carousell app #2</h2>
 *
 * Test: Verify successful login
 *
 * <p>Learning points:
 *
 * <ul>
 *   <li>static wait (please don't use)
 * </ul>
 *
 * @author Martin Schneider, mart.schneider@gmail.com
 */
@TestInstance(Lifecycle.PER_CLASS)
public class LoginTest02 extends CarousellBaseTest {
  private By welcomePageLoginButton =
      MobileBy.id("com.thecarousell.Carousell:id/welcome_page_login_button");
  private By usernameField = MobileBy.xpath("//*[@text=\"email or username\"]");
  private By passwordField = MobileBy.xpath("//*[@text=\"password\"]");
  private By loginButton = MobileBy.id("com.thecarousell.Carousell:id/login_page_login_button");
  private By sellButton = MobileBy.id("com.thecarousell.Carousell:id/button_sell");

  @Test
  public void testLogin() throws InterruptedException {
    Thread.sleep(3000);
    driver.findElement(welcomePageLoginButton).click();
    Thread.sleep(2000);
    driver.findElement(usernameField).sendKeys(username);
    driver.findElement(passwordField).sendKeys(password);
    driver.findElement(loginButton).click();
    Thread.sleep(5000);
    assertThat(driver.findElement(sellButton).isDisplayed())
        .as("sell button is visible")
        .isEqualTo(true);
  }
}
