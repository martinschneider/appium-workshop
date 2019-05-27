package io.github.martinschneider.appium.android.model.pageobjects.spring;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import io.appium.java_client.MobileBy;

@Component
public class WelcomePage extends BasePage{

  @Autowired
  private LoginPage loginPage;

  private By welcomePageLoginButton =
      MobileBy.id("com.thecarousell.Carousell:id/welcome_page_login_button");

  public LoginPage goToLogin() {
    WebDriverWait wait = new WebDriverWait(driver, 10);
    wait.until(presenceOfElementLocated(welcomePageLoginButton)).click();
    return loginPage;
  }
}
