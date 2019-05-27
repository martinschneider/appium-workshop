package io.github.martinschneider.appium.android.model.pageobjects.spring;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

public class BasePage {
  @Autowired protected WebDriver driver;
}
