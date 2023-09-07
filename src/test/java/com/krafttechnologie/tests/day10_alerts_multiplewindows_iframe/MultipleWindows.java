package com.krafttechnologie.tests.day10_alerts_multiplewindows_iframe;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindows {

    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @Test
    public void switchBetweenTwoWindows() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/windows");
        Thread.sleep(2000);
        //get the id of current window
        // System.out.println(driver.getWindowHandles());
        WebElement clickHereBtn = driver.findElement(By.cssSelector("#content>div>a"));
        clickHereBtn.click();
        Thread.sleep(2000);
        System.out.println(driver.getWindowHandle());
        System.out.println(driver.getCurrentUrl());
        String currentWindow = driver.getWindowHandle();
        //System.out.println(driver.getWindowHandles());
        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            if (!currentWindow.equals(windowHandle)){
                driver.switchTo().window(windowHandle);
            }
        }
        System.out.println(driver.getWindowHandle());
        WebElement label = driver.findElement(By.xpath("//H3"));
        String actual = label.getText();
        String expected="New Window";
        Assert.assertEquals(actual,expected,"Verify that new window text");

    }

    @Test
    public void switchBetweenMultipleWindows() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/windows");
        Thread.sleep(2000);
        //get the id of current window
        // System.out.println(driver.getWindowHandles());
        WebElement clickHereBtn = driver.findElement(By.cssSelector("#content>div>a"));
        clickHereBtn.click();
        clickHereBtn.click();
        clickHereBtn.click();
        clickHereBtn.click();
        Thread.sleep(2000);

        String expectedUrls = "https://the-internet.herokuapp.com/windows/new";
        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);
            if (driver.getCurrentUrl().equals(expectedUrls)){
                break;
            }
        }

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
