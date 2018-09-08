package com.automation.pageObjects.DMD;

import com.automation.Utils.SyncUtils;
import com.automation.Utils.WebDriverClient;
import com.automation.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DMDLoginPage extends BasePage {

    public DMDLoginPage(WebDriver driver) { super(driver);
    }

    public WebDriverClient webDriverClient= null;

    @FindBy(css= "#txtUserName[class]")
    private WebElement txt_Login;

    @FindBy(css= "#txtPassword")
    private WebElement txt_Password;

    @FindBy(css= "#cbRememberMe + label")
    private WebElement chk_StayLoggedIn;

    @FindBy(css= "[value='Log in']")
    private WebElement btn_LogIn;

    public DMDAddDealPage LoginToDMD() throws Exception {
        SyncUtils.wait(10);
        try{
            webDriverClient.ClearTextType(txt_Login,"csuser");
        }catch (Exception e){
            throw new Exception("Could not enter Username");
        }
        try{
            webDriverClient.ClearTextType(txt_Password,"password1");
        }catch (Exception e){
            throw new Exception("Could not enter Password");
        }
        try{
            webDriverClient.Click(btn_LogIn);
        }catch (Exception e){
            throw new Exception("Could not click on Save button");
        }

        return PageFactory.initElements(driver(),DMDAddDealPage.class);

    }
}
