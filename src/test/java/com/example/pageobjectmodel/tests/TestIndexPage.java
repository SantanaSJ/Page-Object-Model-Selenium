package com.example.pageobjectmodel.tests;

import com.example.pageobjectmodel.pageObjects.IndexPage;
import com.example.pageobjectmodel.pageObjects.LoginPage;
import com.example.pageobjectmodel.pageObjects.RegisterPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestIndexPage {

    private WebDriver driver;

    @BeforeAll
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\drivers\\chromedriver.exe");
        this.driver = new ChromeDriver();
    }


    @AfterAll
    public void tearDown() {
        this.driver.quit();
    }

    @Test
    public void test_indexPage_titleAndHeading() {
        IndexPage indexPage = new IndexPage(this.driver);
        indexPage.open();
        assertEquals("BookIt", indexPage.getPageTitle());
        String text = indexPage.indexPageHeading().getText();
        System.out.println(text);
        assertEquals("WELCOME TO BOOKIT PETS", indexPage.getPageHeadingText());
    }

    @Test
    public void test_indexPage_links() {
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
