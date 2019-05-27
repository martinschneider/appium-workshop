package io.github.martinschneider.appium.android.base;

import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * Base class for Spring based tests
 * 
 * @author Martin Schneider
 */
@SpringJUnitConfig(SpringConfig.class)
public class SpringTest {
  // set this according to your account
  protected String username = "tvm.appium.demo";
  protected String password = "";
}
