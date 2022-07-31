package com.example.pageobjectmodel.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class BasePage {

    protected String pageUrl;

    protected final WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

//    common elements for all pages

    public WebElement linkHomePage() {
        return this.driver.findElement(By.xpath("//*[@id=\"navbarNavDarkDropdown\"]/ul/li[1]/a"));
    }

    public WebElement linkServicesPage() {
        return this.driver.findElement(By.xpath("//*[@id=\"navbarNavDarkDropdown\"]/ul/li[2]/a"));
    }

    public WebElement linkLogInPage() {
        return this.driver.findElement(By.xpath("//*[@id=\"navbarNavDarkDropdown\"]/ul/li[4]/a/span"));
    }

    public WebElement linkRegisterPage() {
        return this.driver.findElement(By.xpath("//*[@id=\"navbarNavDarkDropdown\"]/ul/li[3]/a/span"));
    }

    public void open() {
        this.driver.get(this.pageUrl);

        System.out.println();
    }

    //    is current page open
    public boolean isCurrentPageOpen() {
        return this.driver.getCurrentUrl().equals(this.pageUrl);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}
