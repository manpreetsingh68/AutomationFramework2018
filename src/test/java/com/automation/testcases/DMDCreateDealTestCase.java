package com.automation.testcases;

import com.automation.core.BaseTest;
import com.automation.pageObjects.DMD.DMDAddDealPage;
import com.automation.pageObjects.DMD.DMDLoginPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DMDCreateDealTestCase extends BaseTest {

    @BeforeMethod
    public void openDMDHomePage(){
        driver().get("https://ny-devci-iis01.na.rtdom.net/DMD/website/DIRECTV");
    }

    @Test
    public void DMDAddDealTest() throws Exception {
        DMDLoginPage loginPage= PageFactory.initElements(driver(),DMDLoginPage.class);
        DMDAddDealPage dmdAddDealPage= loginPage.LoginToDMD();
        dmdAddDealPage.CreateNewDMDDeal();

    }

}
