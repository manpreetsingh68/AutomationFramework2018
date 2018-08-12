package com.automation.testcases;

import com.automation.core.BaseTest;
import com.automation.pageObjects.google.GoogleHomePage;
import com.automation.pageObjects.google.GoogleSearchResultPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.uncommons.reportng.HTMLReporter;

@Listeners(value= HTMLReporter.class)
public class GoogleSecondTestCase extends BaseTest {

    @Test(description = "To search and assert a keyword in Google homepage")
    public void SearchAndAssertTest(){
        driver().get("http://www.google.com");

        GoogleHomePage googleHomePage= PageFactory.initElements(driver(),GoogleHomePage.class);
        GoogleSearchResultPage searchPage= googleHomePage.performSearch();

        String expectedUrl= "https://www.google.com/search";
        Assert.assertTrue(searchPage.getUrl().startsWith(expectedUrl),"Page Url"+driver().getCurrentUrl()+"did not start with expected URL ");
        Assert.assertEquals(searchPage.getSearchedText(),"Vikas Thange","Text search did not match");
    }

}
