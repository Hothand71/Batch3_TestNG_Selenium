package com.krafttechnologie.tests.day08_typeOfElement1;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBoxDemo {
    @Test
    public void test1() throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().window().maximize();

        WebElement sportsLabel = driver.findElement(By.xpath("//label[@for=\"hobbies-checkbox-1\"]"));
        WebElement sportsCheckBox = driver.findElement(By.cssSelector("input[id=\"hobbies-checkbox-1\"]"));
        Assert.assertFalse(sportsCheckBox.isSelected(),"Verify that Sports is NOT selected");
        WebElement reading = driver.findElement(By.cssSelector("input[id=\"hobbies-checkbox-2\"]"));
        Assert.assertFalse(reading.isSelected(),"Verify that Reading is NOT selected");
        WebElement music = driver.findElement(By.cssSelector("input[id=\"hobbies-checkbox-3\"]"));
        Assert.assertFalse(music.isSelected(),"Verify that Music is NOT selected");
        Thread.sleep(2000);
        sportsLabel.click();
        Assert.assertTrue(sportsCheckBox.isSelected(),"Verify that Sports is selected");
        driver.close();
    }
}
