package com.refactorauto.tests.driver;

import com.refactorauto.tests.utils.BasicConfigProvider;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;
import org.yaml.snakeyaml.introspector.BeanAccess;

import java.io.*;
import java.util.List;

public interface BrowserHandler {

    WebDriver createDriver();
    WebDriver createDriver(Capabilities options);


    default BasicConfigProvider platformConfigs() {
        if(new File(System.getProperty("user.dir")+"/automation.yml").exists()) {
            return BasicConfigProvider.loadConfig(System.getProperty("user.dir") + "/automation.yml");
        }
        else {
            throw new RuntimeException("Configuration is not found in the project path user.dir");
        }
    }

    default DesiredCapabilities getConfigurationFromFile() {
        BasicConfigProvider basicConfigProvider = platformConfigs();
        List<BasicConfigProvider.Platform> platforms = basicConfigProvider.getPlatforms();
        BasicConfigProvider.Platform platform = platforms.getFirst();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(platform.getBrowserName());
        switch (platform.getOs()) {
            case "linux":
                capabilities.setPlatform(Platform.UNIX);
                break;
            case "OS X":
                capabilities.setPlatform(Platform.MAC);
                break;
            default:
                throw new RuntimeException("Specified platform is not supported platformName["+platform.getOs()+"]");
        }
        return capabilities;
    }

}
