package io.github.martinschneider.appium.android.model.pageobjects;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WelcomePage {

  private WebDriver driver;

  private By welcomePageLoginButton =
      MobileBy.id("com.thecarousell.Carousell:id/welcome_page_login_button");

  public WelcomePage(WebDriver driver) {
    this.driver = driver;
  }

  public LoginPage goToLogin() {
    WebDriverWait wait = new WebDriverWait(driver, 10);
    wait.until(presenceOfElementLocated(welcomePageLoginButton)).click();
    return new LoginPage(driver);
  }
}
