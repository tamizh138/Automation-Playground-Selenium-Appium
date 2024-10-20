package com.refactorauto.pageobjects;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

public class LoginPage extends LoadableComponent<LoginPage> {

    WebDriver driver;

    @FindBy(id = "ap_email")
    private WebElement userName;
    @FindBy(id = "continue")
    private WebElement contBtn;
    @FindBy(xpath = "//*[@id=\"auth-email-invalid-claim-alert\"]/div/div")
    private WebElement errorMessage;


    public LoginPage(WebDriver driver) {
        this.driver =driver;
        PageFactory.initElements(driver,this);
    }

    public void enterUserName(String text) {
        userName.sendKeys(text);
    }

    public void sumbit() {
        contBtn.click();
    }

    public String getErrorMessage() {
        return  errorMessage.getText();
    }


    @Override
    protected void load() {
        driver.get("https://www.amazon.com/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.com%2Fs%3Fk%3Dhome%2Bstorage%26_encoding%3DUTF8%26content-id%3Damzn1.sym.83009b1f-702c-4be7-814b-0240b8f687d2%26pd_rd_r%3Dcb33a6f8-bfbd-4f74-a1db-9dedbb5180a7%26pd_rd_w%3DRVGYJ%26pd_rd_wg%3DpPj9d%26pf_rd_p%3D83009b1f-702c-4be7-814b-0240b8f687d2%26pf_rd_r%3DFFT8KRDJXK313M82QHM1%26ref%3Dnav_ya_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=usflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
    }

    @Override
    protected void isLoaded() throws Error {
        Assertions.assertTrue(userName.isEnabled());
    }
}
