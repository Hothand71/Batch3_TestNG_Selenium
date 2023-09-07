package com.krafttechnologie.tests.day08_typeOfElement1;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisplayedDemo {
    @Test
    public void test1() throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.manage().window().maximize();
        WebElement startButton = driver.findElement(By.xpath("//button[text()='Start']"));
        WebElement hello = driver.findElement(By.xpath("//*[text()='Hello World!']"));
        Assert.assertFalse(hello.isDisplayed(),"Verify that Hello text's NOT displayed ");
        Thread.sleep(1000);
        startButton.click();
        Thread.sleep(6000);
        Assert.assertTrue(hello.isDisplayed(),"Verify that Hello text's displayed");

        driver.close();
    }

    @Test
    public void test2() throws InterruptedException {
        /*
        /**  HOME TASK
        https://the-internet.herokuapp.com/dynamic_loading
        Example 2: Element rendered after the fact -->click
        verify that hello world is not displayed
        click start button
        verify that hello element is displayed
        and verify that "Hello World!" text is present
         */
       WebDriver driver=WebDriverFactory.getDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/dynamic_loading");
        driver.manage().window().maximize();
        WebElement secondLink = driver.findElement(By.xpath("//a[@href=\"/dynamic_loading/2\"]"));
        secondLink.click();
        Thread.sleep(1000);
        WebElement finishScript = driver.findElement(By.cssSelector("  div script"));
        WebElement startBtn = driver.findElement(By.cssSelector("#start>button"));
        Assert.assertFalse(finishScript.isDisplayed(),"Verify that finish is NOT displayed");
        startBtn.click();
        Thread.sleep(6000);
        WebElement finish = driver.findElement(By.cssSelector("#finish"));
        Assert.assertTrue(finish.isDisplayed(),"Verify that finish is displayed ");
        driver.close();

    }
}
