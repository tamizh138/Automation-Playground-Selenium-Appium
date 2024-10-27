package com.refactorauto.tests;

import com.refactorauto.pageobjects.HomePage;
import com.refactorauto.pageobjects.LoginPage;
import com.refactorauto.tests.driver.BrowserHandler;
import com.refactorauto.tests.driver.Driver;
import com.refactorauto.tests.driver.DriverFactory;
import com.refactorauto.tests.utils.TestStatusLogger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public abstract class AbstractBaseTest {

    protected static BrowserHandler handler = null;
    protected static WebDriver driver;
    protected static HomePage homePage;
    protected static LoginPage loginPage;
    @RegisterExtension
    TestStatusLogger screenShotExtention = new TestStatusLogger(driver,System.getProperty("user.dir")+"/build/images");

    @BeforeAll
    public static void init() throws Exception {
        handler = DriverFactory.createWebDriverHandler(Driver.CHROME);
        ChromeOptions options = new ChromeOptions();
        options.getCapabilityNames();
        driver = handler.createDriver();
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
        homePage = new HomePage(driver);
        loginPage = homePage.signIn();

    }

    @AfterAll
    public static void end() {
        driver.quit();
    }

}
