package com.automation.testcases;

import com.automation.DataProviders.AltoroMutualDataProvider;
import com.automation.Utils.ExcelWriter;
import com.automation.core.BaseTest;
import com.automation.core.Constants;
import com.automation.pageObjects.altoro_mutual.AMAccountHistoryPage;
import com.automation.pageObjects.altoro_mutual.AMHomePage;
import com.automation.pageObjects.altoro_mutual.AMLoginPage;
import com.automation.pageObjects.altoro_mutual.AMUserHomePage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AltoroFirstTestCase extends BaseTest {
    List<String> status= new ArrayList<>();
    @BeforeMethod
    public void openAMHomePage(){
        driver().get("http://demo.testfire.net");
    }

    @Test(dataProvider = AltoroMutualDataProvider.DP_UNAME_PASS_ACC_EXPBAL, dataProviderClass = AltoroMutualDataProvider.class)
    public void testAccountBalance(String username, String password, String account, String expBalance){
        AMHomePage homePage= PageFactory.initElements(driver(),AMHomePage.class);
        AMLoginPage loginPage= homePage.openLoginPage();
        AMUserHomePage userHomePage= loginPage.performLogin(username, password);
        Assert.assertEquals(userHomePage.getWelcomeMsg(),"Hello John Smith","Welcome message did not match.");
        AMAccountHistoryPage accountHistoryPage= userHomePage.goToAccount(account);
        //Assert.assertTrue(account.contains(accountHistoryPage.getAcctNumber()),account+" did not contain "+accountHistoryPage.getAcctNumber());
        Assert.assertEquals(accountHistoryPage.getAccountBalance(),expBalance,"Account balance did not match.");

    }

    @Test(dataProvider = AltoroMutualDataProvider.DP_MAP_UNAME_PASS_ACC_EXPBAL_FROMEXCEL, dataProviderClass = AltoroMutualDataProvider.class)
    public void testAccountBalanceFromExcel(Map<String,String > params){
        AMHomePage homePage= PageFactory.initElements(driver(),AMHomePage.class);
        AMLoginPage loginPage= homePage.openLoginPage();
        AMUserHomePage userHomePage= loginPage.performLogin(params.get("username"), params.get("password"));
        Assert.assertEquals(userHomePage.getWelcomeMsg(),"Hello John Smith","Welcome message did not match.");
        AMAccountHistoryPage accountHistoryPage= userHomePage.goToAccount(params.get("account"));
        //Assert.assertTrue(account.contains(accountHistoryPage.getAcctNumber()),account+" did not contain "+accountHistoryPage.getAcctNumber());

        double actualBalance= Double.parseDouble(accountHistoryPage.getAccountBalance());
        double expectedBalance= Double.parseDouble(params.get("expected balance"));
        Assert.assertEquals(actualBalance,expectedBalance,"Account balance did not match.");

    }

    @AfterMethod
    public void collectReport(ITestResult result){
        String txtStatus= "passed";
        if(result.getStatus()== ITestResult.FAILURE){
            txtStatus= "failed";
        }
        else if (result.getStatus()== ITestResult.SKIP){
            txtStatus= "skipped";
        }
        status.add(txtStatus);
    }

    @AfterSuite
    public void saveResult(){
        ExcelWriter.saveResult(Constants.ALTORO_MUTUAL_USERS_DATA,"Sheet1", status, 4);
    }
}
