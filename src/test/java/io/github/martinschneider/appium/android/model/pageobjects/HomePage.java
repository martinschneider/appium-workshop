package io.github.martinschneider.appium.android.model.pageobjects;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

  private WebDriver driver;

  private By sellButton = MobileBy.id("com.thecarousell.Carousell:id/button_sell");

  public HomePage(WebDriver driver) {
    this.driver = driver;
  }

  public boolean canISell() {
    WebDriverWait wait = new WebDriverWait(driver, 10);
    return wait.until(presenceOfElementLocated(sellButton)).isDisplayed();
  }
}
