package io.github.martinschneider.appium.advanced.demo4.pickerWheel;

import io.appium.java_client.MobileBy;
import io.appium.java_client.ios.IOSDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class PickerWheel {

    private String APP_IOS = System.getProperty("user.dir") + "/apps/TheApp.app";

    private IOSDriver driver;
    private WebDriverWait wait;

    private static By pickerScreen = MobileBy.AccessibilityId("Picker Demo");
    private static By pickers = MobileBy.className("XCUIElementTypePickerWheel");
    private static By learnMoreBtn = MobileBy.AccessibilityId("learnMore");

    @Before
    public void setUp() throws IOException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("platformVersion", "11.4");
        capabilities.setCapability("deviceName", "iPhone 8");
        capabilities.setCapability("app", APP_IOS);

        driver = new IOSDriver<>(new URL("http://localhost:4723/wd/hub"), capabilities);
        wait = new WebDriverWait(driver, 10);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testPicker() throws InterruptedException {
        // get to the picker view
        wait.until(ExpectedConditions.presenceOfElementLocated(pickerScreen)).click();

        // find the picker elements
        List<WebElement> pickerEls = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(pickers));

        // use the sendKeys method to set the picker wheel values directly
        pickerEls.get(0).sendKeys("March");
        pickerEls.get(1).sendKeys("6");

        Thread.sleep(5000);

    }
}