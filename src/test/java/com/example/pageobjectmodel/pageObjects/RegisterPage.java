package com.example.pageobjectmodel.pageObjects;

import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage {


    public RegisterPage(WebDriver driver) {
        super(driver);
        super.pageUrl = "https://bookitpets.herokuapp.com/users/register";
    }


}
