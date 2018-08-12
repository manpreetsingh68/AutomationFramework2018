package com.automation.pageObjects.amazon;

import com.automation.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AmazonSearchProductPage extends BasePage {
    public AmazonSearchProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@id=\"centerPlus\"]")
    WebElement div_ShowingResultText;

    public String getSearchedResultText(){
        return div_ShowingResultText.getText();
    }
}
