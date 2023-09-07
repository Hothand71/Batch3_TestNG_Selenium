package com.krafttechnologie.tests.day05_xpath;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RelativeXpath3 {
    public static void main(String[] args) throws InterruptedException {
        //TASK
        //go to https://www.krafttechexlab.com/forms/elements
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/forms/elements");
        driver.manage().window().maximize();
        Thread.sleep(1000);
        WebElement textLabel=driver.findElement(By.xpath("//label[contains(@for,'putText')]"));
        System.out.println(textLabel.getText());
        WebElement colorPickerLabel=driver.findElement(By.xpath("//label[contains(@for,'Color')]"));
        System.out.println(colorPickerLabel.getText());
        driver.quit();

    }
}
