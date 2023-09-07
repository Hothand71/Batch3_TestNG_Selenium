package com.krafttechnologie.tests.day11_waits;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ExplicitWaitExample {
    WebDriver driver;
    WebDriverWait wait;
    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait=new WebDriverWait(driver,15);
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void test1() {
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.cssSelector("#start>button")).click();

        WebDriverWait wait=new WebDriverWait(driver,15);
        WebElement hello = driver.findElement(By.xpath("//h4[.='Hello World!']"));
        wait.until(ExpectedConditions.visibilityOf(hello));
        Assert.assertEquals(hello.getText(),"Hello World!");
    }

    @Test
    public void test2() {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement button = driver.findElement(By.cssSelector("#input-example>button"));
        button.click();



        WebElement message = driver.findElement(By.cssSelector("#message"));
       // wait.until(ExpectedConditions.visibilityOf(message));
        Assert.assertEquals(message.getText(),"It's enabled!");

        WebElement textBar = driver.findElement(By.cssSelector("#input-example>input"));
        wait.until(ExpectedConditions.elementToBeClickable(textBar));
        textBar.sendKeys("Batch 3 was here");

    }
}
