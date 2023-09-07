package com.krafttechnologie.tests.day04_basiclocators;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ClassNameLocatorTest {
    public static void main(String[] args) throws InterruptedException {
         /*
    ClassNameLocatorTestClassNameLocatorTest
ClassNameLocatorTest
//TASK
        //go to krafttechexlab and login with the valid credentials
        //email --> test@test.com
        //password --> 12345678
        //VERIFY dashboard button by "class name"
https://www.krafttechexlab.com/login
     */
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/login");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        WebElement inputEmail=driver.findElement(By.id("email"));
        inputEmail.sendKeys("test@test.com");
        WebElement inputPassword =driver.findElement(By.id("yourPassword"));
        inputPassword.sendKeys("12345678");
        Thread.sleep(2000);
        WebElement loginButton = driver.findElement(By.tagName("button"));
        loginButton.click();
        Thread.sleep(2000);
        WebElement dashboard = driver.findElement(By.className("afm"));
        String expected="Dashboard";
        String actual=dashboard.getText();
        Thread.sleep(2000);
        if (expected.equals(actual)){
            System.out.println("PASS");
        }else System.out.println("Fail");

        driver.close();


    }
}
