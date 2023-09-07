package com.krafttechnologie.tests.day04_basiclocators;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NameLocatorTest {
    public static void main(String[] args) throws InterruptedException {
        /*
         *TASK
         * go to https://www.krafttechexlab.com/login
         * locate email box by name
         * locate password box by name
         * enter data:
         *   1. email --> test@test.com
         *   2. password box --> 12345678
         * VERIFY THAT INPUT BOXES HAVE THE SAME VALUES
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        Thread.sleep(1000);
        driver.get("https://www.krafttechexlab.com/login");
        Thread.sleep(1000);
        WebElement emailBox =driver.findElement(By.name("email"));
        emailBox.sendKeys("test@test.com");
        WebElement passwordBox= driver.findElement(By.name("password"));
        passwordBox.sendKeys("12345678");
        Thread.sleep(1000);

        String actualEmailString= emailBox.getAttribute("value");
        String actualPasswordString=passwordBox.getAttribute("value");

        String expectedEmailString="test@test.com";
        String expectedPasswordString="12345678";

        if ((actualEmailString.equals(expectedEmailString))&&(actualPasswordString.equals(expectedPasswordString))){
            System.out.println("PASS");
        }else System.out.println("Fail");

        driver.close();
    }
}
