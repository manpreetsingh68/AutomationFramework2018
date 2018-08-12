package com.automation.testcases;

import com.automation.core.BaseTest;
import com.automation.pageObjects.amazon.AmazonHomePage;
import com.automation.pageObjects.amazon.AmazonSearchProductPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AmazonSecondTestCase extends BaseTest {

    @BeforeMethod
    public void openURL() {
        driver().get("http://amazon.in");
    }

    @Parameters(value = {"product_name"})
    @Test
    public void testSearchProductOne(String product) {
        AmazonHomePage homePage = PageFactory.initElements(driver(), AmazonHomePage.class);
        AmazonSearchProductPage resultPage = homePage.searchProduct(product);
        String actualText = resultPage.getSearchedResultText();
        String expectedText = "Showing results in Electronics.Show instead results in All Categories.";
        Assert.assertEquals(actualText, expectedText, "Text result do not match");
    }
}
