package io.github.martinschneider.appium.android.model.pageobjects.spring;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import io.appium.java_client.MobileBy;
import io.github.martinschneider.appium.android.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginPage extends BasePage {

  @Autowired private HomePage homePage;

  private By usernameField = MobileBy.xpath("//*[@text=\"email or username\"]");
  private By passwordField = MobileBy.xpath("//*[@text=\"password\"]");
  private By loginButton = MobileBy.id("com.thecarousell.Carousell:id/login_page_login_button");

  public HomePage login(String username, String password) {
    WebDriverWait wait = new WebDriverWait(driver, 10);
    wait.until(presenceOfElementLocated(usernameField)).sendKeys(username);
    driver.findElement(passwordField).sendKeys(password);
    driver.findElement(loginButton).click();
    return homePage;
  }

  public HomePage login(User user) {
    return login(user.getUsername(), user.getPassword());
  }
}
