package io.github.martinschneider.appium.android.model.pageobjects;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import io.appium.java_client.MobileBy;
import io.github.martinschneider.appium.android.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

  private WebDriver driver;

  private By usernameField = MobileBy.xpath("//*[@text=\"email or username\"]");
  private By passwordField = MobileBy.xpath("//*[@text=\"password\"]");
  private By loginButton = MobileBy.id("com.thecarousell.Carousell:id/login_page_login_button");

  public LoginPage(WebDriver driver) {
    this.driver = driver;
  }

  public HomePage login(String username, String password) {
    WebDriverWait wait = new WebDriverWait(driver, 10);
    wait.until(presenceOfElementLocated(usernameField)).sendKeys(username);
    driver.findElement(passwordField).sendKeys(password);
    driver.findElement(loginButton).click();
    return new HomePage(driver);
  }

  public HomePage login(User user) {
    return login(user.getUsername(), user.getPassword());
  }
}
