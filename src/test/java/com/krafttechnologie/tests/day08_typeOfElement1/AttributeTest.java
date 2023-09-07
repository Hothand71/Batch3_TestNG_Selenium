package com.krafttechnologie.tests.day08_typeOfElement1;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class AttributeTest {
    @Test
    public void test1() throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://demoqa.com/text-box");
        WebElement userInputBox = driver.findElement(By.cssSelector("#userName"));
        System.out.println("userInputBox.getAttribute(\"value\") = " + userInputBox.getAttribute("value"));
        System.out.println("userInputBox.getAttribute(\"placeholder\") = " + userInputBox.getAttribute("placeholder"));
        System.out.println("userInputBox.getAttribute(\"type\") = " + userInputBox.getAttribute("type"));
        System.out.println("userInputBox.getAttribute(\"id\") = " + userInputBox.getAttribute("id"));
        System.out.println("userInputBox.getAttribute(\"class\") = " + userInputBox.getAttribute("class"));
        System.out.println("userInputBox.getAttribute(\"outerHTML\") = " + userInputBox.getAttribute("outerHTML"));
        System.out.println("userInputBox.getAttribute(\"innerHTML\") = " + userInputBox.getAttribute("InnerHTML"));
        Thread.sleep(1000);
        userInputBox.sendKeys("Mustafa Kemal Altun");
        System.out.println("userInputBox.getAttribute(\"value\") = " + userInputBox.getAttribute("value"));
        Thread.sleep(1000);
        driver.close();
    }
}
