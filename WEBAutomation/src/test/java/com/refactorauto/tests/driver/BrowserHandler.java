package com.refactorauto.tests.driver;

import com.refactorauto.tests.utils.BasicConfigProvider;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;
import org.yaml.snakeyaml.introspector.BeanAccess;

import java.io.*;

public interface BrowserHandler {

    WebDriver createDriver();

    void quitDriver();

    default BasicConfigProvider platformConfigs() {
        return BasicConfigProvider.loadConfig(System.getProperty("user.dir")+"/automation.yml");
    }

}
