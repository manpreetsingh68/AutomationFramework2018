package com.automation.testcases;

import com.automation.core.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class GoogleFirstTestCase extends BaseTest {

    @Test(description = "To open google page and enter text")
    public void testCase1() throws InterruptedException {
        driver().get("http://www.google.com");
        driver().manage().window().maximize();
        driver().findElement(By.xpath("//input[@title='Search']")).sendKeys("Selenium");
        Thread.sleep(3000);
    }

    @Test(description = "To open news website")
    public void testCase2() throws InterruptedException {
        driver().get("http://www.thehindu.com");
        driver().manage().window().maximize();
        Thread.sleep(3000);
    }
}
