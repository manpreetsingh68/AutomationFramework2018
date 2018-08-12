package com.automation.testcases;

import com.automation.core.BaseTest;
import com.automation.pageObjects.amazon.AmazonHomePage;
import com.automation.pageObjects.amazon.AmazonSearchProductPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AmazonFirstTestCase extends BaseTest {

    @BeforeMethod
    public void openURL(){
        driver().get("http://amazon.in");
    }

    @Test
    public void testSearchProductOne(){
        AmazonHomePage homePage= PageFactory.initElements(driver(),AmazonHomePage.class);
        AmazonSearchProductPage resultPage= homePage.searchProduct("pixel");
        String actualText= resultPage.getSearchedResultText();
        String expectedText= "Showing results in Electronics.Show instead results in All Categories.";
        Assert.assertEquals(actualText, expectedText, "Text result do not match");
    }

    @Test
    public void testSearchProductTwo(){
        AmazonHomePage homePage= PageFactory.initElements(driver(),AmazonHomePage.class);
        AmazonSearchProductPage resultPage= homePage.searchProduct("Mi");
        String actualText= resultPage.getSearchedResultText();
        String expectedText= "Showing results in Electronics.Show instead results in All Categories.";
        Assert.assertEquals(actualText, expectedText, "Text result do not match");
    }

    @Test
    public void testSearchProductThree(){
        AmazonHomePage homePage= PageFactory.initElements(driver(),AmazonHomePage.class);
        AmazonSearchProductPage resultPage= homePage.searchProduct("iPhone");
        String actualText= resultPage.getSearchedResultText();
        String expectedText= "Showing results in Electronics.Show instead results in All Categories.";
        Assert.assertEquals(actualText, expectedText, "Text result do not match");
    }

    @Test
    public void testSearchProductFour(){
        AmazonHomePage homePage= PageFactory.initElements(driver(),AmazonHomePage.class);
        AmazonSearchProductPage resultPage= homePage.searchProduct("nexus");
        String actualText= resultPage.getSearchedResultText();
        String expectedText= "Showing results in Electronics.Show instead results in All Categories.";
        Assert.assertEquals(actualText, expectedText, "Text result do not match");
    }
}
