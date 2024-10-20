package com.refactorauto.tests.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestStatusLogger implements TestWatcher {

    private final WebDriver driver;
    private final String storageLocation;
    private final Logger logger = LogManager.getLogger();

    public TestStatusLogger(WebDriver driver, String storageLocation) {
        this.driver=driver;
        this.storageLocation=storageLocation;
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        String targetLocation =storageLocation+File.separator+context.getClass().getCanonicalName();
        captureScreenshot(driver,targetLocation,context.getDisplayName());
        logger.error("error received :: "+cause.getMessage());
    }

    public void captureScreenshot(WebDriver driver,String basePath, String fileName) {
        try {
            new File(basePath).mkdirs();
            try ( FileOutputStream out = new FileOutputStream(basePath + File.separator + "screenshot-" + fileName + ".png")) {
                out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (WebDriverException e) {
            System.out.println("screenshot failed:" + e.getMessage());
        }
    }
}
