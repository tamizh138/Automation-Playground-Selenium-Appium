package com.refactorauto.pageobjects;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

public class HomePage extends LoadableComponent<HomePage> {

    WebDriver driver;
    public static final String HOMEPAGEURL = "https://amazon.com";

    @FindBy(xpath = "//*[@id=\"nav-search-bar-form\"]/div[2]/div[1]/div/label")
    private WebElement logo;
    @FindBy(id="nav-link-accountList-nav-line-1")
    private WebElement signInBtn;
    @FindBy(linkText = "Try different image")
    private WebElement captcha;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public LoginPage signIn() {
        get();
        //captcha.click();
        signInBtn.click();
        return new LoginPage(driver);
    }

    @Override
    protected void load() {
        driver.get(HOMEPAGEURL);
    }

    @Override
    protected void isLoaded() throws Error {
        Assertions.assertEquals("https://www.amazon.com/",driver.getCurrentUrl());
    }


}
