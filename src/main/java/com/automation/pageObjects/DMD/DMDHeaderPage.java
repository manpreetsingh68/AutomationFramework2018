package com.automation.pageObjects.DMD;

import com.automation.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DMDHeaderPage extends BasePage {
    public DMDHeaderPage(WebDriver driver) {super(driver);
    }

    @FindBy(css = "#deals-menu-link.icon-parent-right")
    WebElement btn_DealsDropDown;

    @FindBy(css= ".submenu-deals > li:first-child > a")
    WebElement btn_Deals;

    @FindBy(css = ".submenu-deals > li:last-child > a")
    WebElement btn_AddDeal;

    public void createNewDeal(){
        btn_DealsDropDown.click();
        btn_AddDeal.click();

    }


}
