package com.refactorauto.tests.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public interface BrowserHandler {

    WebDriver createDriver();

    void quitDriver();

}
