package com.example.pageobjectmodel.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage extends BasePage {


    public RegisterPage(WebDriver driver) {
        super(driver);
        super.pageUrl = "https://bookitpets.herokuapp.com/users/register";
    }

    public WebElement getPageHeading() {
       return this.driver.findElement(By.cssSelector("#register > div > div > div > div > div.card-header"));
    }

    public String getPageHeadingText() {
        return getPageHeading().getText();
    }

    public WebElement firstNameField() {
       return this.driver.findElement(By.id("first-name"));
    }

    public WebElement lastNameField() {
        return this.driver.findElement(By.id("last-name"));
    }
    public WebElement petNameField() {
        return this.driver.findElement(By.id("pet-name"));
    }
    public WebElement petKgField() {
        return this.driver.findElement(By.id("pet-kg"));
    }
    public WebElement phoneField() {
        return this.driver.findElement(By.id("phone"));
    }
    public WebElement emailField() {
        return this.driver.findElement(By.id("email_address"));
    }
    public WebElement passwordField() {
        return this.driver.findElement(By.id("password"));
    }
    public WebElement confirmPasswordField() {
        return this.driver.findElement(By.id("confirm-password"));
    }

    public WebElement registerButton() {
        return this.driver.findElement(By.id("submit"));
    }

    public void addValidUser(String fName, String lName, String petName, String kg,
                             String phone, String email, String password, String confirmPassword) {
        this.firstNameField().sendKeys(fName);
        this.lastNameField().sendKeys(lName);
        this.petNameField().sendKeys(petName);
        this.petKgField().sendKeys(kg);
        this.phoneField().sendKeys(phone);
        this.emailField().sendKeys(email);
        this.passwordField().sendKeys(password);
        this.confirmPasswordField().sendKeys(confirmPassword);
//        Element is not clickable at point (551, 728)
//        this.registerButton().click();
        JavascriptExecutor executor = (JavascriptExecutor) this.driver;
        executor.executeScript("arguments[0].click()", this.registerButton());
    }

    public WebElement getUniqueEmailError() {
       return this.driver.findElement(By.id("email_addressError"));
    }

    public String getUniqueEmailErrorText() {
       return getUniqueEmailError().getText();
    }













}
