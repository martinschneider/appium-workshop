package io.github.martinschneider.appium.android;

/**
 * Base class for testing the counter app.
 *
 * @author Martin Schneider, mart.schneider@gmail.com
 */
public class CounterBaseTest extends BaseTest {

  protected static final String ID_PREFIX = "me.tsukanov.counter:id/";

  public CounterBaseTest() {
    super();
    appPath = "counter.apk";
  }
}
