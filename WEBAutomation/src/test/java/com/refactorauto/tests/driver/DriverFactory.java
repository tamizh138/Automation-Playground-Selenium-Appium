package com.refactorauto.tests.driver;

import org.openqa.selenium.WebDriver;

public class DriverFactory {

    public static BrowserHandler createWebDriverHandler(Driver type) throws Exception {

        BrowserHandler handler;

        switch (type) {
            case CHROME: {
                handler = new ChromeHandler();
                break;
            }
            case FIREFOX: {
                handler = new FireFoxHandler();
                break;
            }
            case REMOTEDRIVER: {
                handler = new RemoteWebDriverHandler();

            }
           /*
           TODO : If design finalized we can implement below two
           case IE:
                return new IEHandler();
                break;
            case SAFARI:
                return new SafariHandler();
                break;*/
            default:
                throw new Exception("The driver initialized not found");
        }

        return handler;

    }
}
