package com.automation.pageObjects.altoro_mutual;

import com.automation.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AMAccountHistoryPage extends BasePage {
    public AMAccountHistoryPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[@id=\"_ctl0__ctl0_Content_Main_accountid\"]")
    private WebElement txt_CurrentAcctNumber;

    @FindBy(xpath = "//*[contains(text(),'Available balance')]/following-sibling::td/span")
    private WebElement txt_CurrentAcctBalance;

    public String getAcctNumber(){
        return txt_CurrentAcctNumber.getText();
    }

    public String getAccountBalance(){
        return txt_CurrentAcctBalance.getText();
    }
}
