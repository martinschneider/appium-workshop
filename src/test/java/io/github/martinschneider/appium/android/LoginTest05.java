package io.github.martinschneider.appium.android;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.martinschneider.appium.android.model.pageobjects.HomePage;
import io.github.martinschneider.appium.android.model.pageobjects.LoginPage;
import io.github.martinschneider.appium.android.model.pageobjects.WelcomePage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

/**
 *
 *
 * <h2>Demo Appium test for Carousell app #5</h2>
 *
 * Test: Verify successful login
 *
 * <p>Learning points:
 *
 * <ul>
 *   <li>Page Object design pattern
 * </ul>
 *
 * @author Martin Schneider, mart.schneider@gmail.com
 */
@TestInstance(Lifecycle.PER_CLASS)
public class LoginTest05 extends CarousellBaseTest {

  @Test
  public void testLogin() {
    WelcomePage welcome = new WelcomePage(driver);
    welcome.goToLogin();
    LoginPage login = new LoginPage(driver);
    login.login(username, password);
    HomePage home = new HomePage(driver);
    assertThat(home.canISell()).as("sell button visible").isEqualTo(true);
  }
}
