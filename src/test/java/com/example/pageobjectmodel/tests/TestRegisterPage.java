package com.example.pageobjectmodel.tests;

import com.example.pageobjectmodel.pageObjects.HomePage;
import com.example.pageobjectmodel.pageObjects.IndexPage;
import com.example.pageobjectmodel.pageObjects.LoginPage;
import com.example.pageobjectmodel.pageObjects.RegisterPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestRegisterPage extends BaseTest {

    @Test
    public void test_registerPage_is_open() {
        RegisterPage registerPage = new RegisterPage(this.driver);
        registerPage.open();
        assertTrue(registerPage.isCurrentPageOpen());
    }

    @Test
    public void test_registerPageHeading() {
        RegisterPage registerPage = new RegisterPage(this.driver);
        registerPage.open();

        assertEquals("Register", registerPage.getPageHeadingText());
    }

    @Test
    public void test_empty_input_fields() {
        RegisterPage registerPage = new RegisterPage(this.driver);
        registerPage.open();
        assertEquals("", registerPage.firstNameField().getText());
        assertEquals("", registerPage.lastNameField().getText());
        assertEquals("", registerPage.petNameField().getText());
        assertEquals("", registerPage.petKgField().getText());
        assertEquals("", registerPage.phoneField().getText());
        assertEquals("", registerPage.emailField().getText());
        assertEquals("", registerPage.passwordField().getText());
        assertEquals("", registerPage.confirmPasswordField().getText());
        assertEquals("Register", registerPage.registerButton().getText());
    }

    @Test
    public void test_indexPage_links() {
        RegisterPage registerPage = new RegisterPage(this.driver);
        registerPage.open();

//        indexPage.linkServicesPage().click();
//        assertEquals("SERVICES", indexPage.getIndexServiceHeadingText());

        registerPage.linkHomePage().click();
        assertTrue(new IndexPage(driver).isCurrentPageOpen());

        registerPage.linkRegisterPage().click();
        assertTrue(new RegisterPage(driver).isCurrentPageOpen());
        this.driver.navigate().back();

        registerPage.linkLogInPage().click();
        assertTrue(new LoginPage(driver).isCurrentPageOpen());
        this.driver.navigate().back();
    }

    @Test
    public void test_register_valid_user() {
        RegisterPage registerPage = new RegisterPage(this.driver);
        registerPage.open();
        String newUserName = getNewUserName();
        registerPage.addValidUser(newUserName, "TestUser",
                "Bren", "12",
                "0884433654", getNewEmail(),
                "a123456789A#", "a123456789A#");

        HomePage homePage = new HomePage(this.driver);
        assertTrue(homePage.isCurrentPageOpen());
        assertEquals(newUserName, homePage.getPageUsernameTitleText());


    }

    private String getNewUserName() {
        int n = (int) Math.floor(Math.random() * 100);
        String newUser = "newTestUser" + n;
        return newUser;
    }
    private String getNewEmail() {
        int n = (int) Math.floor(Math.random() * 100);
        String newEmail = "newTestUser" + n + "@email.com";
        return newEmail;
    }






}
