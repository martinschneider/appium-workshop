package io.github.martinschneider.appium.android.demos;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.martinschneider.appium.android.base.CarousellBaseTest;
import io.github.martinschneider.appium.android.model.User;
import io.github.martinschneider.appium.android.model.pageobjects.WelcomePage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

/**
 *
 *
 * <h2>Demo Appium test for Carousell app #6</h2>
 *
 * Test: Verify successful login
 *
 * <p>Learning points:
 *
 * <ul>
 *   <li>method chaining
 *   <li>POJOs for test entities
 * </ul>
 *
 * @author Martin Schneider, mart.schneider@gmail.com
 */
@TestInstance(Lifecycle.PER_CLASS)
public class LoginTest06 extends CarousellBaseTest {

  @Test
  public void testLogin() {
    assertThat(new WelcomePage(driver).goToLogin().login(new User(username, password)).canISell())
        .as("sell button visible")
        .isEqualTo(true);
  }
}
