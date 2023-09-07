package com.krafttechnologie.tests.day04_basiclocators;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TagNameLocatorTest {
    public static void main(String[] args) throws InterruptedException {
        /*
         *TASK
         * go to https://www.krafttechexlab.com/login
         * locate "Enter your email & password to login" string by tag name
         * locate login button by tag name
         * click on login button
         * VERIFY that the string is the same
         */

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://www.krafttechexlab.com/login");
        Thread.sleep(1000);

        WebElement enterYourEmailElement=driver.findElement(By.tagName("p"));
        System.out.println(enterYourEmailElement.getText());

        WebElement loginButton=driver.findElement(By.tagName("button"));
        loginButton.click();
        Thread.sleep(1000);
        String actual=enterYourEmailElement.getText();
        String expected="Enter your email & password to login";

        if (actual.equals(expected)){
            System.out.println("PASS");
        }else {
            System.out.println("Fail");
        }

        driver.quit();

    }
}
