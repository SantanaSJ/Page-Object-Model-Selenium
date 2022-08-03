package com.example.pageobjectmodel.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {


    public HomePage(WebDriver driver) {
        super(driver);
        this.pageUrl = "https://bookitpets.herokuapp.com/home";
    }

    public WebElement pageUsernameTitle() {
      return this.driver.findElement(By.cssSelector("#navbarDarkProfileMenuLink > span"));
    }

    public String getPageUsernameTitleText() {
      return pageUsernameTitle().getText();
    }

    public void logout() {
        this.driver.findElement(By.id("navbarDarkProfileMenuLink")).click();
        this.driver.findElement(By.linkText("Logout")).click();
    }
}
