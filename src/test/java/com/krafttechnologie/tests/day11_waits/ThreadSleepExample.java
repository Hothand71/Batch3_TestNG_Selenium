package com.krafttechnologie.tests.day11_waits;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ThreadSleepExample {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void testName() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
        WebElement startBtn = driver.findElement(By.cssSelector("#start>button"));
        startBtn.click();

        Thread.sleep(5000);
        WebElement helloWorldLabel = driver.findElement(By.xpath("//h4[.='Hello World!']"));
        System.out.println(helloWorldLabel.getText());
    }
}
