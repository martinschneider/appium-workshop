package io.github.martinschneider.appium.android.model.pageobjects.spring;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

@Component
public class HomePage extends BasePage {

  private By sellButton = MobileBy.id("com.thecarousell.Carousell:id/button_sell");

  public boolean canISell() {
    WebDriverWait wait = new WebDriverWait(driver, 10);
    return wait.until(presenceOfElementLocated(sellButton)).isDisplayed();
  }
}
