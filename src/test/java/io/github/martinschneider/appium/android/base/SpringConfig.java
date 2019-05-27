package io.github.martinschneider.appium.android.base;

import static io.appium.java_client.remote.AndroidMobileCapabilityType.APP_ACTIVITY;
import static io.appium.java_client.remote.AndroidMobileCapabilityType.APP_PACKAGE;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import io.appium.java_client.android.AndroidDriver;

@Configuration
@ComponentScan(basePackages = "io.github.martinschneider.appium.android.model.pageobjects.spring")
public class SpringConfig {

  public DesiredCapabilities getCapabilities() throws IOException {
    File classpathRoot = new File(System.getProperty("user.dir"));
    File appDir = new File(classpathRoot, "apps");
    File app = new File(appDir.getCanonicalPath(), "carousell.apk");
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability("deviceName", "Android Emulator");
    capabilities.setCapability("automationName", "UiAutomator2");
    capabilities.setCapability("app", app.getAbsolutePath());
    capabilities.setCapability(APP_PACKAGE, "com.thecarousell.Carousell");
    capabilities.setCapability(APP_ACTIVITY, "com.thecarousell.Carousell.activities.EntryActivity");
    return capabilities;
  }

  @Bean
  public WebDriver webDriver() throws MalformedURLException, IOException {
    return new AndroidDriver<WebElement>(new URL("http://localhost:4723/wd/hub"),
        getCapabilities());
  }
}
