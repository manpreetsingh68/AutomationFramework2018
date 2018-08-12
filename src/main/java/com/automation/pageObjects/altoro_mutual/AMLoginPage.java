package com.automation.pageObjects.altoro_mutual;

import com.automation.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AMLoginPage extends BasePage {
    public AMLoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "uid")
    private WebElement txt_Username;

    @FindBy(name = "passw")
    private WebElement txt_Password;

    @FindBy(name = "btnSubmit")
    private WebElement btn_Login;

    public AMUserHomePage performLogin(String username, String password){
        txt_Username.sendKeys(username);
        txt_Password.sendKeys(password);
        btn_Login.click();
        return PageFactory.initElements(driver(),AMUserHomePage.class);
    }
}
