package com.example.pageobjectmodel.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IndexPage extends BasePage {

    public IndexPage(WebDriver driver) {
        super(driver);
        super.pageUrl = "https://bookitpets.herokuapp.com/";
    }

    public WebElement indexPageHeading() {
        return this.driver.findElement(By.cssSelector("#welcome > div > h1"));
    }

    public String getPageHeadingText() {
        return indexPageHeading().getText();
    }

    public WebElement indexServiceHeading() {
      return this.driver.findElement(By.cssSelector("#services > div > div.section-title > h2"));
    }

    public String getIndexServiceHeadingText() {
       return indexServiceHeading().getText();
    }


}


