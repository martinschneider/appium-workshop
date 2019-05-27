package io.github.martinschneider.appium.android.base;

import static io.appium.java_client.remote.AndroidMobileCapabilityType.APP_ACTIVITY;
import static io.appium.java_client.remote.AndroidMobileCapabilityType.APP_PACKAGE;

/**
 * Base class for testing the Carousell (www.carousell.com) app.
 *
 * @author Martin Schneider, mart.schneider@gmail.com
 */
public class CarousellBaseTest extends BaseTest {

  // set this according to your account
  protected String username = "tvm.appium.demo";
  protected String password = "654321";

  public CarousellBaseTest() {
    super();
    capabilities.setCapability(APP_PACKAGE, "com.thecarousell.Carousell");
    capabilities.setCapability(APP_ACTIVITY, "com.thecarousell.Carousell.activities.EntryActivity");
    appPath = "carousell.apk";
  }
}
