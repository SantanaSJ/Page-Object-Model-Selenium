package com.example.pageobjectmodel.pageObjects;

import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {


    public LoginPage(WebDriver driver) {
        super(driver);
        super.pageUrl = "https://bookitpets.herokuapp.com/users/login";
    }
}
