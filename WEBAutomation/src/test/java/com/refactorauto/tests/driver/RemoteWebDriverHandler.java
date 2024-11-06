package com.refactorauto.tests.driver;

import com.refactorauto.tests.utils.BasicConfigProvider;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class RemoteWebDriverHandler implements BrowserHandler{

    private String gridURL = null;

    @Override
    public  WebDriver createDriver()  {
        DesiredCapabilities capabilities = getConfigurationFromFile();
        return createDriver(capabilities);
    }

    @Override
    public  WebDriver createDriver(Capabilities options) {
        setGridURL();
        try{
            return new RemoteWebDriver(new URL(getGridURL()),options);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public String getGridURL() {
        return gridURL;
    }

    public void setGridURL() {
        BasicConfigProvider basicConfigProvider = platformConfigs();
        this.gridURL = "http://"+basicConfigProvider.getHostName()+":"+basicConfigProvider.getPort();
    }
}
