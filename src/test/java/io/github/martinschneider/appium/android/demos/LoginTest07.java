package io.github.martinschneider.appium.android.demos;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.martinschneider.appium.android.base.SpringTest;
import io.github.martinschneider.appium.android.model.User;
import io.github.martinschneider.appium.android.model.pageobjects.spring.WelcomePage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 *
 * <h2>Demo Appium test for Carousell app #7</h2>
 *
 * Test: Verify successful login
 *
 * <p>Learning points:
 *
 * <ul>
 *   <li>Spring DI
 * </ul>
 *
 * @author Martin Schneider, mart.schneider@gmail.com
 */
public class LoginTest07 extends SpringTest {

  @Autowired private WelcomePage welcomePage;

  @Test
  public void testLogin() {
    assertThat(welcomePage.goToLogin().login(new User(username, password)).canISell())
        .as("sell button visible")
        .isEqualTo(true);
  }
}
