package com.refactorauto.tests.driver;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ChromeHandler implements BrowserHandler {


    @Override
    public  WebDriver createDriver() {
        DesiredCapabilities capabilities = getConfigurationFromFile();
        return createDriver(capabilities);
    }

    @Override
    public  WebDriver createDriver(Capabilities options) {
        return new ChromeDriver(new ChromeOptions().merge(options));
    }




}
