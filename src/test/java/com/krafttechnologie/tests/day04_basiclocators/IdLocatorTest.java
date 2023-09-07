package com.krafttechnologie.tests.day04_basiclocators;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IdLocatorTest {
    public static void main(String[] args) throws InterruptedException {
        /*
         * TASK
         * go to https://www.krafttechexlab.com/login
         * locate the email box by id
         * locate password box by id
         * enter data:
         *   1.email --> test@test.com
         *   2.password --> 12345678
         * VERIFY THAT INPUT BOXES HAVE THE SAME VALUES
         */
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        Thread.sleep(1000);

        driver.get("https://www.krafttechexlab.com/login");
        WebElement emailBox =driver.findElement(By.id("email"));
        WebElement passwordBox =driver.findElement(By.id("yourPassword"));
        Thread.sleep(1000);
        emailBox.sendKeys("test@test.com");
        passwordBox.sendKeys("12345678");
        Thread.sleep(1000);

        String actualEmailString=emailBox.getAttribute("value");
        String actualPasswordString=passwordBox.getAttribute("value");

        String expectedEmailString="test@test.com";
        String expectedPasswordString="12345678";

        if ((actualEmailString.equals(expectedEmailString))&&(actualPasswordString.equals(expectedPasswordString))){
            System.out.println("PASS");
        }else System.out.println("Fail");


    }
}
