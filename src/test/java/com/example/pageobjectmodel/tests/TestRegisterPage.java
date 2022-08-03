package com.example.pageobjectmodel.tests;

import com.example.pageobjectmodel.pageObjects.HomePage;
import com.example.pageobjectmodel.pageObjects.LoginPage;
import com.example.pageobjectmodel.pageObjects.RegisterPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestRegisterPage extends BaseTest {

    @Test
    public void registerPage_is_open() {
        RegisterPage registerPage = new RegisterPage(this.driver);
        registerPage.open();
        assertTrue(registerPage.isCurrentPageOpen());
    }

    @Test
    public void registerPageHeading() {
        RegisterPage registerPage = new RegisterPage(this.driver);
        registerPage.open();

        assertEquals("Register", registerPage.getPageHeadingText());
    }

    @Test
    public void empty_input_fields() {
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
    public void indexPage_links() {
        RegisterPage registerPage = new RegisterPage(this.driver);
        registerPage.open();

//        indexPage.linkServicesPage().click();
//        assertEquals("SERVICES", indexPage.getIndexServiceHeadingText());

        registerPage.linkHomePage().click();
        assertTrue(new LoginPage(driver).isCurrentPageOpen());

        registerPage.linkRegisterPage().click();
        assertTrue(new RegisterPage(driver).isCurrentPageOpen());
        this.driver.navigate().back();

        registerPage.linkLogInPage().click();
        assertTrue(new LoginPage(driver).isCurrentPageOpen());
        this.driver.navigate().back();
    }

    @Test
    public void register_valid_user() {
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

        homePage.logout();


    }

    @Test
    public void register_user_with_non_unique_email() {
        RegisterPage registerPage = new RegisterPage(this.driver);

        registerPage.open();
        registerPage.addValidUser("TestUser", "TestUser",
                "Rex", "12",
                "0885544333", "testuser@email.com",
                "a123456789A#", "a123456789A#");

        assertEquals("Email already exists. Please log in.", registerPage.getUniqueEmailErrorText());
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
