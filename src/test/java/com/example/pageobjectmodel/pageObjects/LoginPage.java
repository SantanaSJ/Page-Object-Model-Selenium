package com.example.pageobjectmodel.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {


    public LoginPage(WebDriver driver) {
        super(driver);
        super.pageUrl = "https://bookitpets.herokuapp.com/users/login";
    }

    public WebElement emailField() {
      return this.driver.findElement(By.id("email_address"));
    }

    public WebElement passwordField() {
        return this.driver.findElement(By.id("password"));
    }

    public WebElement submitButton() {
       return this.driver.findElement(By.id("submit"));
    }


    public void loginUser() {
        this.emailField().sendKeys("testuser@email.com");
        this.passwordField().sendKeys("a123456789A#");

        JavascriptExecutor executor = (JavascriptExecutor) this.driver;
        executor.executeScript("arguments[0].click()", submitButton());
    }


}
