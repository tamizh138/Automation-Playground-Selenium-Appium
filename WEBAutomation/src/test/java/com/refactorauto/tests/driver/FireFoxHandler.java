package com.refactorauto.tests.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FireFoxHandler implements BrowserHandler{

    private  WebDriver driver;

    public WebDriver createDriver(FirefoxOptions options) {
        driver = new FirefoxDriver(options);
        return driver;
    }

    @Override
    public WebDriver createDriver() {
        return new FirefoxDriver();
    }

    @Override
    public void quitDriver() {
        driver.quit();
    }
}
