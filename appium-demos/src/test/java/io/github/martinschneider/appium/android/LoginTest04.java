package io.github.martinschneider.appium.android;

import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 *
 * <h2>Demo Appium test for Carousell app #4</h2>
 *
 * Test: Verify successful login
 *
 * <p>Learning points:
 *
 * <ul>
 *   <li>explicit wait
 * </ul>
 */
@TestInstance(Lifecycle.PER_CLASS)
public class LoginTest04 extends CarousellBaseTest {
  private By welcomePageLoginButton =
      MobileBy.id("com.thecarousell.Carousell:id/welcome_page_login_button");
  private By usernameField = MobileBy.xpath("//*[@text=\"email or username\"]");
  private By passwordField = MobileBy.xpath("//*[@text=\"password\"]");
  private By loginButton = MobileBy.id("com.thecarousell.Carousell:id/login_page_login_button");
  private By sellButton = MobileBy.id("com.thecarousell.Carousell:id/button_sell");

  @Test
  public void testLogin() {
    WebDriverWait wait = new WebDriverWait(driver, 10);
    wait.until(presenceOfElementLocated(welcomePageLoginButton)).click();
    wait.until(presenceOfElementLocated(usernameField)).sendKeys(username);
    driver.findElement(passwordField).sendKeys(password);
    driver.findElement(loginButton).click();
    assertThat(wait.until(presenceOfElementLocated(sellButton)).isDisplayed())
        .as("sell button is visible")
        .isEqualTo(true);
  }
}
