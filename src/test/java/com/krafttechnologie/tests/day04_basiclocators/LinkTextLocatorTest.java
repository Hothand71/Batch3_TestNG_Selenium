package com.krafttechnologie.tests.day04_basiclocators;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkTextLocatorTest {
    public static void main(String[] args) throws InterruptedException {
        /*
         *TASK
         * go to https://www.krafttechexlab.com/login
         * locate "Create an account" button by linktext
         * click on the button
         * verify that url is "https://www.krafttechexlab.com/register"
         */
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/login");
        driver.manage().window().maximize();
        WebElement createAnAccountButton =driver.findElement(By.linkText("Create an account"));
        Thread.sleep(2000);
        createAnAccountButton.click();
        Thread.sleep(2000);
        String expected="https://www.krafttechexlab.com/register";
        String actual=driver.getCurrentUrl();

        if (expected.equals(actual)){
            System.out.println("PASS");
        }else {
            System.out.println("Fail");
        }
        driver.quit();
    }
}
