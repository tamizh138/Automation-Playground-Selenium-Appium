package com.refactorauto.tests.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeHandler implements BrowserHandler{

    private WebDriver driver;

    public WebDriver createDriver(ChromeOptions options) {
        driver = new ChromeDriver(options);
        return driver;
    }

    @Override
    public  WebDriver createDriver() {
        driver = new ChromeDriver();
        return driver;
    }

    @Override
    public void quitDriver() {
        driver.quit();
    }
}
