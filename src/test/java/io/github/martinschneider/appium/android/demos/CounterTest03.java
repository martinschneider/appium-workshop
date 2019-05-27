package io.github.martinschneider.appium.android.demos;

import static org.assertj.core.api.Assertions.assertThat;

import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import io.github.martinschneider.appium.android.base.CounterBaseTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.openqa.selenium.WebElement;

/**
 *
 *
 * <h2>Demo Appium test for Android Counter app #3</h2>
 *
 * Test: Increase the counter by one and verify
 *
 * <p>Learning points:
 *
 * <ul>
 *   <li>different location strategies
 * </ul>
 *
 * @author Martin Schneider, mart.schneider@gmail.com
 */
@TestInstance(Lifecycle.PER_CLASS)
public class CounterTest03 extends CounterBaseTest {

  @AndroidFindBy(id = ID_PREFIX + "counterLabel")
  private WebElement counter;

  @AndroidFindBy(id = ID_PREFIX + "incrementButton")
  private WebElement incrementButtonId;

  @AndroidFindBy(xpath = "//*[@resource-id=\"me.tsukanov.counter:id/incrementButton\"]")
  private WebElement incrementButtonXPath1;

  @AndroidFindBy(
      xpath =
          "//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.widget.FrameLayout[2]/android.support.v4.widget.DrawerLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.Button[1]")
  private WebElement incrementButtonXPath2;

  @AndroidFindBy(
      uiAutomator = "new UiSelector().resourceId(\"me.tsukanov.counter:id/incrementButton\")")
  private WebElement incrementButtonUIAutomator1;

  @AndroidFindBy(uiAutomator = "new UiSelector().text(\"+\")")
  private WebElement incrementButtonUIAutomator2;

  private PointOption<ElementOption> counterCoordinates =
      new PointOption<ElementOption>().withCoordinates(105, 540);

  @Test
  public void testCounterIncreaseId() {
    int oldCount = Integer.parseInt(counter.getText());
    incrementButtonId.click();
    int newCount = Integer.parseInt(counter.getText());
    assertThat(newCount - oldCount).as("check counter increased").isEqualTo(1);
  }

  @Test
  public void testCounterIncreaseXPath1() {
    int oldCount = Integer.parseInt(counter.getText());
    incrementButtonXPath1.click();
    int newCount = Integer.parseInt(counter.getText());
    assertThat(newCount - oldCount).as("check counter increased").isEqualTo(1);
  }

  @Test
  public void testCounterIncreaseXPath2() {
    int oldCount = Integer.parseInt(counter.getText());
    incrementButtonXPath2.click();
    int newCount = Integer.parseInt(counter.getText());
    assertThat(newCount - oldCount).as("check counter increased").isEqualTo(1);
  }

  @Test
  public void testCounterIncreaseUIautomator1() {
    int oldCount = Integer.parseInt(counter.getText());
    incrementButtonUIAutomator1.click();
    int newCount = Integer.parseInt(counter.getText());
    assertThat(newCount - oldCount).as("check counter increased").isEqualTo(1);
  }

  @Test
  public void testCounterIncreaseUIautomator2() {
    int oldCount = Integer.parseInt(counter.getText());
    incrementButtonUIAutomator2.click();
    int newCount = Integer.parseInt(counter.getText());
    assertThat(newCount - oldCount).as("check counter increased").isEqualTo(1);
  }

  @Test
  public void testCounterIncreaseCoordinates() {
    int oldCount = Integer.parseInt(counter.getText());
    new TouchAction(driver).tap(counterCoordinates).perform();
    int newCount = Integer.parseInt(counter.getText());
    assertThat(newCount - oldCount).as("check counter increased").isEqualTo(1);
  }

  @Test
  public void testCounterIncreaseImage() {
    int oldCount = Integer.parseInt(counter.getText());
    driver
        .findElementByImage(
            // "iVBORw0KGgoAAAANSUhEUgAAAQwAAABbCAYAAACGcLtoAAABfGlDQ1BJQ0MgUHJvZmlsZQAAKJFjYGAqSSwoyGFhYGDIzSspCnJ3UoiIjFJgv8PAzcDDIMRgxSCemFxc4BgQ4MOAE3y7xsAIoi/rgsxK8/x506a1fP4WNq+ZclYlOrj1gQF3SmpxMgMDIweQnZxSnJwLZOcA2TrJBUUlQPYMIFu3vKQAxD4BZIsUAR0IZN8BsdMh7A8gdhKYzcQCVhMS5AxkSwDZAkkQtgaInQ5hW4DYyRmJKUC2B8guiBvAgNPDRcHcwFLXkYC7SQa5OaUwO0ChxZOaFxoMcgcQyzB4MLgwKDCYMxgwWDLoMjiWpFaUgBQ65xdUFmWmZ5QoOAJDNlXBOT+3oLQktUhHwTMvWU9HwcjA0ACkDhRnEKM/B4FNZxQ7jxDLX8jAYKnMwMDcgxBLmsbAsH0PA4PEKYSYyjwGBn5rBoZt5woSixLhDmf8xkKIX5xmbARh8zgxMLDe+///sxoDA/skBoa/E////73o//+/i4H2A+PsQA4AJHdp4IxrEg8AAAGcaVRYdFhNTDpjb20uYWRvYmUueG1wAAAAAAA8eDp4bXBtZXRhIHhtbG5zOng9ImFkb2JlOm5zOm1ldGEvIiB4OnhtcHRrPSJYTVAgQ29yZSA1LjQuMCI+CiAgIDxyZGY6UkRGIHhtbG5zOnJkZj0iaHR0cDovL3d3dy53My5vcmcvMTk5OS8wMi8yMi1yZGYtc3ludGF4LW5zIyI+CiAgICAgIDxyZGY6RGVzY3JpcHRpb24gcmRmOmFib3V0PSIiCiAgICAgICAgICAgIHhtbG5zOmV4aWY9Imh0dHA6Ly9ucy5hZG9iZS5jb20vZXhpZi8xLjAvIj4KICAgICAgICAgPGV4aWY6UGl4ZWxYRGltZW5zaW9uPjI2ODwvZXhpZjpQaXhlbFhEaW1lbnNpb24+CiAgICAgICAgIDxleGlmOlBpeGVsWURpbWVuc2lvbj45MTwvZXhpZjpQaXhlbFlEaW1lbnNpb24+CiAgICAgIDwvcmRmOkRlc2NyaXB0aW9uPgogICA8L3JkZjpSREY+CjwveDp4bXBtZXRhPgot3xRXAAAFd0lEQVR4Ae3dPU4cSRQA4J6fEIkEEROSEXMGDgMRR7KvsJzCS+BxQELgHVISkAiAnVeoSzZST1cbS96d941kGU+9sXlfl8qvfrqZfV2tXl9eXrr5fN7NZrPOiwABAkMC82hYLBZD7d4nQIBAFZhHVfH6+lrf8AUBAgSGBOYxWMSUxHRkiMj7BAj0AmVKEusXXgQIEBgTKCNFVBdRZXgRIEBgm0BdwzAl2cakjQCBEChrGLGOYcDQIQgQGBMoFUYE2SkZo9JOgIBFT32AAIFmgTolUWE0mwkkkFZg2a9d9L+nlZA4AQKjAmVKEluqtlVHrQQQSC9QpiSqi/T9AACBJoG6S+K0Z5OXIAKpBeb9fSSmJKn7geQJNAnUNQwVRpOXIAKpBZb9QOG0Z+p+IHkCTQK1wrDw2eQliEBqgfnz83N5PF9qBckTINAksJmRlCLDvSRNXIII5BYoo0WsXzganrsjyJ5Ai0B9HkZfabR8SAwBAjkF3uYjm9xVGDk7gKwJTBFYxoEt1cUUMrEE8gqUKUkMGiqMvJ1A5gRaBcqAERWGo+GtZOII5BWoB7dMS/J2ApkTaBWot7c76dlKJo5AXoF6DsOUJG8nkDmBVoFSYcR0RIXRSiaOQF6B+kzP2CUxaOTrCOv1uru6uhpM/PT0tDs+Ph5s15BLYBnpugEt10X/Mdv7+/vu86dPP77109eHh4cGjJ9Ecv+hrGEsFovcCrInQKBJoN5L0hQtiACB1AJl0TN2SKxfpO4HkifQJFCmJA5tNVkJIpBeoAwYUV04h5G+LwAgMCpQ1zBMSUatBBBIL1DWMJzBSN8PABBoEigVRkS6vb3JSxCB1AIWPVNffskTmCZQpyQqjGlwoglkFKj3klj0zHj55UxgmkC5l6TfUnUeYxrefzH65uame3x8bP7Wbm9vt8b+8/17d319vTXmfePJycn7t/x5RwRmX1er18glpiQGjP//Vb28vOz+/vLljyUSfeivLXe//rFvzD/8WwTqLonB4rd4+ksI7LTAvL+PpJ+W7HS2kiNA4EMCZVs1BgsVxoccfZhACoFlP1A47ZniekuSwIcEaoVhW/VDjj5MIIXAMh7P54lbu3Ot45F6R0dHzQk9PT11d3d3g/EHBwfd3t7eYPv7htlml8RrdwXKtmpUF6Yku3uRt2W2Wq26i/PzwZDzi4vu7OxssF1DLoHy30EMFvHLiwABAtsE6vMw+sXPbcHaCBDILVAnnCqM3B1B9gRaBJbOYLQwiSFAIATKlCQGDRWGDkGAwJhAGTBi/cLR8DEq7QQI1INbFj11BgIExgTKE7fiHIaTnmNU2gkQqOcwTEl0BgIExgRKhRHTERXGGJV2AgTqA3TskugMBAiMCZQpSdyApsIYo9JOgEAZMNytqiMQINAiMFt9+7aZjbzdeKbKaCHbrZiHh4duvV4PJhW3y+/v7w+2a8glUG5vjx0SVUauCy9bAr8iUKYkDm39Cp3PEMgnUAaMmIo4h5Hv4suYwFSB+jwM6xdT6cQTyCdQfxizASPfxZcxgakCDm5NFRNPILGARc/EF1/qBKYK1ClJfxZj6l8gngCBPALLfu2i/z1P6jIlQGCqQJmSxJaqbdWpdOIJ5BOoD9DJl7qMCRCYKlB3SZz2nEonnkA+gXlMRWL9wpQk38WXMYGpAnUNQ4UxlU48gXwCy36giG1VOyX5OoCMCUwRqBWGwWIKm1gCOQXm8Xi+vsrISSBrAgRaBTZjRSky/KjEVjFxBBILlNEi1i8cDU/cC6ROoFGgPg+jrzQaPyeMAIGEAm/zkU3iKoyEV1/KBCYKLOPAlupioppwAkkFypQkBg0VRtIeIG0CEwTKgBEVhqPhE9SEEkgq8C/CE3BIA3f7JwAAAABJRU5ErkJggg==")
            "iVBORw0KGgoAAAANSUhEUgAAAGgAAABgCAYAAADxTzfMAAAMSWlDQ1BJQ0MgUHJvZmlsZQAASImVVwdYU8kWnltSSWiBCEgJvYlSpEsJoUUQkCrYCEkgocSYEETsyLIKrl1EwIauiii6FkDWirrWRbG7lociKsq6WLCh8iYFdN3vvfe9831z758z5/ynZO69MwDo1PCk0lxUF4A8Sb4sPiKENSE1jUXqBARAAgygDSx5fLmUHRcXDaAM3v8ub28ARHm/6qLk+uf8fxU9gVDOBwCJgzhDIOfnQXwAALyEL5XlA0D0gXrrGflSJZ4EsYEMJgixVImz1LhEiTPUuFJlkxjPgXgXAGQajyfLAkC7GepZBfwsyKN9C2JXiUAsAUCHDHEgX8QTQBwJ8Yi8vGlKDO2AQ8Y3PFl/48wY4uTxsoawuhaVkEPFcmkub+b/2Y7/LXm5isEYdnDQRLLIeGXNsG+3cqZFKTEN4h5JRkwsxPoQvxcLVPYQo1SRIjJJbY+a8uUc2DPAhNhVwAuNgtgU4nBJbky0Rp+RKQ7nQgxXCFoozucmanwXCeVhCRrOGtm0+NhBnCnjsDW+DTyZKq7S/pQiJ4mt4b8lEnIH+d8UiRJT1Dlj1AJxcgzE2hAz5TkJUWobzKZIxIkZtJEp4pX520DsJ5REhKj5sSmZsvB4jb0sTz5YL7ZIJObGaHBVvigxUsOzi89T5W8EcbNQwk4a5BHKJ0QP1iIQhoapa8cuCyVJmnqxDml+SLzG95U0N05jj1OFuRFKvRXEpvKCBI0vHpgPF6SaH4+R5sclqvPEM7J5Y+PU+eCFIBpwQChgAQUcGWAayAbitp6mHvhLPRMOeEAGsoAQuGg0gx4pqhkJvCaAIvAnREIgH/ILUc0KQQHUfx7Sqq8uIFM1W6DyyAGPIc4DUSAX/laovCRD0ZLBI6gR/yM6H+aaC4dy7p86NtREazSKQV6WzqAlMYwYSowkhhMdcRM8EPfHo+E1GA533Af3Hcz2qz3hMaGd8JBwndBBuD1VXCz7rh4WGAc6YIRwTc0Z39aM20FWTzwED4D8kBtn4ibABR8NI7HxIBjbE2o5msyV1X/P/bcavum6xo7iSkEpwyjBFIfvPbWdtD2HWJQ9/bZD6lwzhvrKGZr5Pj7nm04L4D3qe0tsEbYfO4OdwM5hh7EmwMKOYc3YReyIEg+tokeqVTQYLV6VTw7kEf8jHk8TU9lJuWu9a7frJ/VcvrBQ+X4EnGnSmTJxliifxYZvfiGLK+GPHMFyd3XzBUD5HVG/pl4zVd8HhHn+q65YB4AxHwYGBg5/1UXbAnCgFADq4686h1r4OlgAwNlyvkJWoNbhygsBUIEOfKKMgTmwBg6wHnfgBfxBMAgDY0EsSASpYArssgiuZxmYAWaDBaAUlIPlYA2oAhvBFrAD7Ab7QBM4DE6A38AFcBlcB3fg6ukCz0EveAv6EQQhIXSEgRgjFogt4oy4Iz5IIBKGRCPxSCqSjmQhEkSBzEYWIuXISqQK2YzUIb8gh5ATyDmkHbmNPEC6kVfIRxRDaagBaobaoaNQH5SNRqGJ6GQ0C52OFqEl6FK0Eq1Fd6GN6An0Anod7UCfo30YwLQwJmaJuWA+GAeLxdKwTEyGzcXKsAqsFmvAWuD/fBXrwHqwDzgRZ+As3AWu4Eg8Cefj0/G5+BK8Ct+BN+Kn8Kv4A7wX/0KgE0wJzgQ/ApcwgZBFmEEoJVQQthEOEk7Dp6mL8JZIJDKJ9kRv+DSmErOJs4hLiOuJe4jHie3ETmIfiUQyJjmTAkixJB4pn1RKWkfaRTpGukLqIr0na5EtyO7kcHIaWUIuJleQd5KPkq+Qn5D7KboUW4ofJZYioMykLKNspbRQLlG6KP1UPao9NYCaSM2mLqBWUhuop6l3qa+1tLSstHy1xmuJteZrVWrt1Tqr9UDrA02f5kTj0CbRFLSltO2047TbtNd0Ot2OHkxPo+fTl9Lr6Cfp9+nvtRnaI7W52gLtedrV2o3aV7Rf6FB0bHXYOlN0inQqdPbrXNLp0aXo2ulydHm6c3WrdQ/p3tTt02PouenF6uXpLdHbqXdO76k+Sd9OP0xfoF+iv0X/pH4nA2NYMzgMPmMhYyvjNKPLgGhgb8A1yDYoN9ht0GbQa6hvONow2bDQsNrwiGEHE2PaMbnMXOYy5j7mDebHYWbD2MOEwxYPaxh2Zdg7o+FGwUZCozKjPUbXjT4as4zDjHOMVxg3Gd8zwU2cTMabzDDZYHLapGe4wXD/4fzhZcP3Df/DFDV1Mo03nWW6xfSiaZ+ZuVmEmdRsndlJsx5zpnmwebb5avOj5t0WDItAC7HFaotjFs9Yhiw2K5dVyTrF6rU0tYy0VFhutmyz7Leyt0qyKrbaY3XPmmrtY51pvdq61brXxsJmnM1sm3qbP2wptj62Itu1tmds39nZ26XY/WjXZPfU3siea19kX29/14HuEOQw3aHW4Zoj0dHHMcdxveNlJ9TJ00nkVO10yRl19nIWO693bh9BGOE7QjKidsRNF5oL26XApd7lwUjmyOiRxSObRr4YZTMqbdSKUWdGfXH1dM113ep6x03fbaxbsVuL2yt3J3e+e7X7NQ+6R7jHPI9mj5ejnUcLR28YfcuT4TnO80fPVs/PXt5eMq8Gr25vG+907xrvmz4GPnE+S3zO+hJ8Q3zn+R72/eDn5Zfvt8/vL38X/xz/nf5Px9iPEY7ZOqYzwCqAF7A5oCOQFZgeuCmwI8gyiBdUG/Qw2DpYELwt+AnbkZ3N3sV+EeIaIgs5GPKO48eZwzkeioVGhJaFtoXphyWFVYXdD7cKzwqvD++N8IyYFXE8khAZFbki8ibXjMvn1nF7x3qPnTP2VBQtKiGqKuphtFO0LLplHDpu7LhV4+7G2MZIYppiQSw3dlXsvTj7uOlxv44njo8bXz3+cbxb/Oz4MwmMhKkJOxPeJoYkLku8k+SQpEhqTdZJnpRcl/wuJTRlZUrHhFET5ky4kGqSKk5tTiOlJadtS+ubGDZxzcSuSZ6TSifdmGw/uXDyuSkmU3KnHJmqM5U3dX86IT0lfWf6J14sr5bXl8HNqMno5XP4a/nPBcGC1YJuYYBwpfBJZkDmysynWQFZq7K6RUGiClGPmCOuEr/MjszemP0uJzZne85AbkrunjxyXnreIYm+JEdyapr5tMJp7VJnaam0Y7rf9DXTe2VRsm1yRD5Z3pxvADfsFxUOih8UDwoCC6oL3s9InrG/UK9QUnhxptPMxTOfFIUX/TwLn8Wf1TrbcvaC2Q/msOdsnovMzZjbOs96Xsm8rvkR83csoC7IWfB7sWvxyuI3C1MWtpSYlcwv6fwh4of6Uu1SWenNH/1/3LgIXyRe1LbYY/G6xV/KBGXny13LK8o/LeEvOf+T20+VPw0szVzatsxr2YblxOWS5TdWBK3YsVJvZdHKzlXjVjWuZq0uW/1mzdQ15ypGV2xcS12rWNtRGV3ZvM5m3fJ1n6pEVderQ6r31JjWLK55t16w/sqG4A0NG802lm/8uEm86dbmiM2NtXa1FVuIWwq2PN6avPXMzz4/120z2Va+7fN2yfaOHfE7TtV519XtNN25rB6tV9R375q06/Lu0N3NDS4Nm/cw95TvBXsVe5/9kv7LjX1R+1r3++xvOGB7oOYg42BZI9I4s7G3SdTU0Zza3H5o7KHWFv+Wg7+O/HX7YcvD1UcMjyw7Sj1acnTgWNGxvuPS4z0nsk50tk5tvXNywslrp8afajsddfrsb+G/nTzDPnPsbMDZw+f8zh0673O+6YLXhcaLnhcP/u75+8E2r7bGS96Xmi/7Xm5pH9N+9ErQlRNXQ6/+do177cL1mOvtN5Ju3Lo56WbHLcGtp7dzb7/8o+CP/jvz7xLult3TvVdx3/R+7b8c/7Wnw6vjyIPQBxcfJjy808nvfP5I/uhTV8lj+uOKJxZP6p66Pz3cHd59+dnEZ13Ppc/7e0r/1Puz5oXDiwN/Bf91sXdCb9dL2cuBV0teG7/e/mb0m9a+uL77b/Pe9r8re2/8fscHnw9nPqZ8fNI/4xPpU+Vnx88tX6K+3B3IGxiQ8mQ81VYAgwPNzATg1XYA6KkAMC7D/cNE9TlPJYj6bKpC4D9h9VlQJV4ANMCbcrvOOQ7AXjjsIabPB0C5VU8MBqiHx9DQiDzTw13NRYMnHsL7gYHXZgCQWgD4LBsY6F8/MPB5K0z2NgDHp6vPl0ohwrPBJhXHFWbhfPCd/BsSGH8u3tstQwAAAAlwSFlzAAAWJQAAFiUBSVIk8AAAAZxpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IlhNUCBDb3JlIDUuNC4wIj4KICAgPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4KICAgICAgPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIKICAgICAgICAgICAgeG1sbnM6ZXhpZj0iaHR0cDovL25zLmFkb2JlLmNvbS9leGlmLzEuMC8iPgogICAgICAgICA8ZXhpZjpQaXhlbFhEaW1lbnNpb24+MTA0PC9leGlmOlBpeGVsWERpbWVuc2lvbj4KICAgICAgICAgPGV4aWY6UGl4ZWxZRGltZW5zaW9uPjk2PC9leGlmOlBpeGVsWURpbWVuc2lvbj4KICAgICAgPC9yZGY6RGVzY3JpcHRpb24+CiAgIDwvcmRmOlJERj4KPC94OnhtcG1ldGE+CvKNUSUAAAAcaURPVAAAAAIAAAAAAAAAMAAAACgAAAAwAAAAMAAAAaarQVNaAAABcklEQVR4AeyasXHCUBBEP4WoBJMCVSBFODDKUUlqBFdiulCoUPbIbkD7Oc+ePY94/+3pvbmM3cfj8Vn4pSWwQ1BaN9+LISi3n4IgBCUnkHw9LghByQkkX48LQlByAsnX44IQlJxA8vW4IAQlJ5B8PS4IQXEE5nkuXdtWD7wNQ2mfeF9d/MTDP3VBq6D2fK7+3GEV1HXV7x0PEeSgLnQiSIDliCLIQV3oRJAAyxFFkIO60IkgAZYjiiAHdaETQQIsRxRBDupCJ4IEWI4oghzUhU4ECbAcUQQ5qAudCBJgOaIIclAXOhEkwHJEEeSgLnQiSIDliCLIQV3oRJAAyxFFkIO60IkgAZYjiiAHdaETQQIsRzRM0PqnwnEcf/UblmUp7/d7dcfLfl+apql+v+Xh8XAox9NpS3RTJkzQNE3l9XLZVPqfQ2/Xa+n7PuwTERSG8mcQgoKBRo9DUDTR4HkICgYaPQ5B0USD5yEoGGj0uGhBXwAAAP//MvGfGwAAAYxJREFU7dYxioNgEAXgSe1ZvIGtdZIqKRI3ZDvP5Lk2hxAsBbFw2a3CKxwMA/OEJwQy+XVmfF+Tw8/rtVjANQyDXS+XgE77bnG7361pmrCXOAgoLMv/RgKKzTO8m4DCI41tKKDYPMO7CSg80tiGAorNM7wbLdCyLNb3ffgLvzecpsm+n8/3nzZ9/3o8rK7rTc9svbkoCvv7RF1hf7OjFlrrM46jnY7HtVtWz9q2tdP5vHoP26GA2ERgHwFBIGylgNhEYB8BQSBspYDYRGAfAUEgbKWA2ERgHwFBIGylgNhEYB8BQSBspYDYRGAfAUEgbKWA2ERgHwFBIGylgNhEYB8BQSBspYDYRGAfAUEgbKWA2ERgHwFBIGylgNhEYB8BQSBspYDYRGAfAUEgbKWA2ERgHwFBIGzlroDmebau6z7OsKoqK8vy4+czHtwVUEZA2TMFlC3gzBeQE1D2sYCyBZz5AnICyj4WULaAM19ATkDZxwLKFnDmC8gJKPtYQNkCznwBOQFlHwsoW8CZ/wtAxwGuD04CNAAAAABJRU5ErkJggg==")
        .click();
    int newCount = Integer.parseInt(counter.getText());
    assertThat(newCount - oldCount).as("check counter increased").isEqualTo(1);
  }
}
