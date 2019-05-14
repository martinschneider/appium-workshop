package io.github.martinschneider.appium.android;

public class CounterBaseTest extends BaseTest {

  protected static final String ID_PREFIX = "me.tsukanov.counter:id/";

  public CounterBaseTest() {
    super();
    appPath = "counter.apk";
  }
}
