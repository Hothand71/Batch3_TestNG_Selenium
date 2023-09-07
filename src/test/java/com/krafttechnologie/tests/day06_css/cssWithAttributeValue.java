package com.krafttechnologie.tests.day06_css;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class cssWithAttributeValue {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/login");
        //attribute+value
        WebElement emailBox = driver.findElement(By.cssSelector("[type='text']"));

        //tagName + attribute value
        WebElement emailBoxithTagName = driver.findElement(By.cssSelector("input[type='text']"));
        emailBox.sendKeys("kraft@");
        emailBoxithTagName.sendKeys("gmail.com");
        Thread.sleep(2000);

        driver.close();


    }
}
