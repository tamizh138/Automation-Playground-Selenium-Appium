package com.refactorauto.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestLoginActions extends AbstractBaseTest{

    private static final Logger logger = LogManager.getLogger();
    @Test
    public void testInvalidUserName() {
        logger.info("Executing invalid username case");
        loginPage.enterUserName("sdlkfjdk");
        loginPage.sumbit();
        assertEquals("Enter a valid email address or phor",loginPage.getErrorMessage());

    }
}
