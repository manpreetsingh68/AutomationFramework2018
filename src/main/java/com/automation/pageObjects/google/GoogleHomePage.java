package com.automation.pageObjects.google;

import com.automation.Utils.SyncUtils;
import com.automation.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleHomePage extends BasePage {

    @FindBy(name = "q")
    WebElement txt_SearchBox;

    @FindBy(name = "btnk")
    WebElement btn_SearchButton;

    public GoogleHomePage(WebDriver driver) {
        super(driver);
    }

    public GoogleSearchResultPage performSearch(){
        txt_SearchBox.sendKeys("Vikas Thange");
        txt_SearchBox.submit();
        SyncUtils.wait(3);
        return PageFactory.initElements(driver(),GoogleSearchResultPage.class);
    }

}
