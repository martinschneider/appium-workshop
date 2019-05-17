package io.github.martinschneider.appium.android.swipe;

import java.net.MalformedURLException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

/**
 *
 *
 * <h2>Demo Appium Swipe Actions</h2>
 *
 * Test: Swipe up,down, left and right
 *
 * <p>Learning points:
 *
 * <ul>
 *   <li>Detecting coordinates
 *   <li>Different swiping actions
 * </ul>
 *
 * @author Syam Sasi, syamsasi99@gmail.com
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AndroidSwipeTest extends SwipeTest {

  @BeforeAll
  public void setPlatform() throws MalformedURLException {
    launchApp("android");
  }

  @Test
  public void swipeTest() throws InterruptedException {
    goToNativeComponents();

    doSwipe("right");
    doSwipe("down");
    doSwipe("up");
    doSwipe("left");
  }
}
