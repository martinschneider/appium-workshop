package io.github.martinschneider.appium.android;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.martinschneider.appium.android.model.User;
import io.github.martinschneider.appium.android.model.pageobjects.WelcomePage;
import org.junit.jupiter.api.Test;

/**
 * INSPIRATIONAL TEST (won't run)
 *
 * <p>The implementation details go beyond the scope of our workshop but these are some ideas to
 * consider to bring your test framework to the next level.
 *
 * <ol>
 *   <li>automatically instantiate page objects and the WebDriver, hint: use some DI framework like
 *       Spring
 *   <li>separate test data from the test code, hint: load it from an external source (JSON, YAML,
 *       Excel, DB etc.)
 * </ol>
 *
 * Let the framework do the heavy lifting!
 *
 * <p>Make it as easy as possible to write and edit tests (ideally, this does not require
 * engineers).
 *
 * <p>Next level:
 *
 * <ol>
 *   <li>extract the test case definition into a human-readable format (gherkin, yaml etc.)
 * </ol>
 *
 * @author Martin Schneider, mart.schneider@gmail.com
 */
public class LoginTest07 extends CarousellBaseTest {

  private WelcomePage welcome;

  @Test
  public void testLogin() {
    assertThat(welcome.goToLogin().login(testdata(User.class, "loginTestUser")))
        .as("sell button visible")
        .isEqualTo(true);
  }
}
