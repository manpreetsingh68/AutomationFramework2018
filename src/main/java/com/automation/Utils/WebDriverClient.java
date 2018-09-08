package com.automation.Utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WebDriverClient {
    public void SelectByVisibleText(WebElement element, String text){
        Select select= new Select(element);
        select.selectByVisibleText(text);
    }

    public void ClearTextType(WebElement element, String text){
        element.clear();
        element.sendKeys(text);
    }

    public void Click(WebElement element){
        element.click();
    }

}
