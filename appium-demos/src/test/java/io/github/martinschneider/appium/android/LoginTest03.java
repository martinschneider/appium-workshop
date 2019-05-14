package io.github.martinschneider.appium.android;

import static org.assertj.core.api.Assertions.assertThat;

import io.appium.java_client.MobileBy;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.openqa.selenium.By;

/**
 *
 *
 * <h2>Demo Appium test for Carousell app #3</h2>
 *
 * Test: Verify successful login
 *
 * <p>Learning points:
 *
 * <ul>
 *   <li>implicit wait
 * </ul>
 */
@TestInstance(Lifecycle.PER_CLASS)
public class LoginTest03 extends CarousellBaseTest {
  private By welcomePageLoginButton =
      MobileBy.id("com.thecarousell.Carousell:id/welcome_page_login_button");
  private By usernameField = MobileBy.xpath("//*[@text=\"email or username\"]");
  private By passwordField = MobileBy.xpath("//*[@text=\"password\"]");
  private By loginButton = MobileBy.id("com.thecarousell.Carousell:id/login_page_login_button");
  private By sellButton = MobileBy.id("com.thecarousell.Carousell:id/button_sell");

  @Test
  public void testLogin() {
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.findElement(welcomePageLoginButton).click();
    driver.findElement(usernameField).sendKeys(username);
    driver.findElement(passwordField).sendKeys(password);
    driver.findElement(loginButton).click();
    assertThat(driver.findElement(sellButton).isDisplayed())
        .as("sell button is visible")
        .isEqualTo(true);
  }
}
