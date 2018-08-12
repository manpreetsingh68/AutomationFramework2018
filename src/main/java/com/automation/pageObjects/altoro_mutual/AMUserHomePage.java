package com.automation.pageObjects.altoro_mutual;

import com.automation.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AMUserHomePage extends BasePage {
    public AMUserHomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "listAccounts")
    private WebElement list_Accounts;

    @FindBy(id = "btnGetAccount")
    private WebElement btn_Go;

    @FindBy(tagName = "h1")
    private WebElement txt_WelcomeMsg;

    public String getWelcomeMsg(){
        return txt_WelcomeMsg.getText();
    }

    public void selectAccount(String accountText){
        Select select= new Select(list_Accounts);
        select.selectByVisibleText(accountText);
    }

    public void clickGoButton(){
        btn_Go.click();
    }

    public AMAccountHistoryPage goToAccount(String accountText){
        selectAccount(accountText);
        clickGoButton();
        return PageFactory.initElements(driver(),AMAccountHistoryPage.class);
    }
}
