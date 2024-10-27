package com.refactorauto.tests.driver;

import com.refactorauto.tests.utils.BasicConfigProvider;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

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

    private ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        
        return
    }


}
