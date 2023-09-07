package com.krafttechnologie.tests.pratices;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class Pratice03 {
    WebDriver driver;
    WebDriverWait wait;
    @BeforeMethod
    public void setUp() {
    driver= WebDriverFactory.getDriver("chrome");
    driver.manage().window().maximize();
    wait=new WebDriverWait(driver,15);
    }

    @AfterMethod
    public void tearDown() {
    driver.quit();
    }

    @Test
    public void test1() {
        driver.get("https://demoqa.com/links");
        WebElement homeLabelHref = driver.findElement(By.cssSelector("a#simpleLink"));
        homeLabelHref.click();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(driver.getWindowHandle())){
                driver.switchTo().window(windowHandle);
            }
        }
        driver.findElement(By.cssSelector("svg[viewBox=\"0 0 448 512\"]")).click();
        System.out.println(driver.getCurrentUrl());
        WebElement actualLabel = driver.findElement(By.cssSelector("div[class=\"col-12 mt-4 col-md-6\"]"));
        String expected = "Please select an item from left to start practice.";
        String actual=actualLabel.getText();
        Assert.assertEquals(actual,expected,"Verify that Please select an item from left to start practice. text");
    }

    @Test
    public void test2() {
        driver.get("https://demoqa.com/browser-windows");
        WebElement newWindowBtn = driver.findElement(By.cssSelector("button#windowButton"));
        newWindowBtn.click();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            System.out.println(windowHandle);
            if (!windowHandle.equals(driver.getWindowHandle())){
                driver.switchTo().window(windowHandle);
            }
        }
        WebElement newWindowLabel = driver.findElement(By.cssSelector("#sampleHeading"));
        System.out.println(newWindowLabel.getText());

    }

    @Test
    public void test3() {
        driver.get("https://demoqa.com/alerts");
        WebElement fiveSecWaitBtn = driver.findElement(By.cssSelector("button#timerAlertButton"));
        fiveSecWaitBtn.click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert=driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
    }

    @Test
    public void test4() {
        driver.get("https://demoqa.com/frames");
        WebElement iframeLocation = driver.findElement(By.cssSelector("iframe#frame1"));
        driver.switchTo().frame(iframeLocation);
        WebElement iframeLabels = driver.findElement(By.cssSelector("h1#sampleHeading"));
        System.out.println(iframeLabels.getText());
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame2");
        iframeLabels=driver.findElement(By.cssSelector("h1#sampleHeading"));
        System.out.println(iframeLabels.getText());
    }

    @Test
    public void test5() {

    }
}
