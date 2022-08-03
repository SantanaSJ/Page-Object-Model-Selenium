package com.example.pageobjectmodel.tests;

import com.example.pageobjectmodel.pageObjects.IndexPage;
import com.example.pageobjectmodel.pageObjects.LoginPage;
import com.example.pageobjectmodel.pageObjects.RegisterPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestIndexPage extends BaseTest {

    @Test
    public void indexPage_titleAndHeading() {
        IndexPage indexPage = new IndexPage(this.driver);
        indexPage.open();
        assertEquals("BookIt", indexPage.getPageTitle());
        String text = indexPage.indexPageHeading().getText();
        System.out.println(text);
        assertEquals("WELCOME TO BOOKIT PETS", indexPage.getPageHeadingText());
    }

    @Test
    public void indexPage_links() {
        IndexPage indexPage = new IndexPage(this.driver);
        indexPage.open();

//        indexPage.linkServicesPage().click();
//        assertEquals("SERVICES", indexPage.getIndexServiceHeadingText());

        indexPage.linkRegisterPage().click();
        assertTrue(new RegisterPage(driver).isCurrentPageOpen());
        this.driver.navigate().back();

        indexPage.linkLogInPage().click();
        assertTrue(new LoginPage(driver).isCurrentPageOpen());
        this.driver.navigate().back();
    }
}
