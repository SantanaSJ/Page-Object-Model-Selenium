package com.example.pageobjectmodel.tests;

import com.example.pageobjectmodel.pageObjects.HomePage;
import com.example.pageobjectmodel.pageObjects.LoginPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestLoginPage extends BaseTest {

    @Test
    public void loginPage_is_open() {
        LoginPage loginPage = new LoginPage(this.driver);
        loginPage.open();
        assertTrue(loginPage.isCurrentPageOpen());
    }

    @Test
    public void empty_input_fields() {
        LoginPage loginPage = new LoginPage(this.driver);
        loginPage.open();
        assertEquals("", loginPage.emailField().getText());
        assertEquals("", loginPage.passwordField().getText());

    }

    @Test
    public void login_with_valid_credentials() {
        LoginPage loginPage = new LoginPage(this.driver);
        loginPage.open();

        loginPage.loginUser();

        HomePage homePage = new HomePage(this.driver);
        assertTrue(homePage.isCurrentPageOpen());
        assertEquals("TestUser", homePage.getPageUsernameTitleText());

    }
}
