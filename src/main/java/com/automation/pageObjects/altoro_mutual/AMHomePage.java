package com.automation.pageObjects.altoro_mutual;

import com.automation.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AMHomePage extends BasePage {
    public AMHomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "ONLINE BANKING LOGIN")
    private WebElement link_LoginPage;

    public AMLoginPage openLoginPage(){
        link_LoginPage.click();
        return PageFactory.initElements(driver(),AMLoginPage.class);
    }
}
