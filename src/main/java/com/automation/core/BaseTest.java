package com.automation.core;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.HashMap;
import java.util.Map;

public abstract class BaseTest {
    //private WebDriver driver;
    //Map<String,WebDriver> driverMap= new HashMap<>();
    ThreadLocal<WebDriver> drivers= new ThreadLocal<>();

    @BeforeMethod
    public void beforeMethod(){
        WebDriver driver= BrowserFactory.getDriverInstance();
        //driverMap.put(Thread.currentThread().getName(), driver);
        drivers.set(driver);

    }
    @AfterMethod
    public void tearDown(){
        if(driver() != null){
            driver().close();
        }
    }
    protected WebDriver driver(){
        //return driverMap.get(Thread.currentThread().getName());
        return drivers.get();

    }
}
