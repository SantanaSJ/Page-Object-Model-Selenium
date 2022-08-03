package com.example.pageobjectmodel.tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {

    protected WebDriver driver;

    @BeforeAll
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\drivers\\chromedriver.exe");
        this.driver = new ChromeDriver();
    }


    @AfterAll
    public void tearDown() {
        this.driver.quit();
    }
}
