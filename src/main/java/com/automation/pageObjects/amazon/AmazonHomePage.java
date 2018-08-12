package com.automation.pageObjects.amazon;

import com.automation.Utils.SyncUtils;
import com.automation.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonHomePage extends BasePage {
    public AmazonHomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "twotabsearchtextbox")
    WebElement txt_SearchBox;

    @FindBy(css = ".nav-input[type=\"submit\"]")
    WebElement btn_Search;

    public AmazonSearchProductPage searchProduct(String productName){
        txt_SearchBox.sendKeys(productName);
        SyncUtils.wait(3);
        btn_Search.click();
        return PageFactory.initElements(driver(),AmazonSearchProductPage.class);
    }
}
