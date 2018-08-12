package com.automation.pageObjects.google;

import com.automation.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleSearchResultPage extends BasePage {

    @FindBy(name = "q")
    WebElement txtBox_SearchBox;

    @FindBy(id = "resultStats")
    WebElement txt_SearchBox;

    public GoogleSearchResultPage(WebDriver driver) {
        super(driver);
    }

    public String getSearchedText(){
        return txtBox_SearchBox.getAttribute("value");
    }
}
