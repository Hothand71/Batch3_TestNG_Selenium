package com.krafttechnologie.tests.day03_webelement_intro;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyUrlIsChanged {
    public static void main(String[] args) throws InterruptedException {

        /*
         * TASK
         * open chrome browser
         * go to https://demoqa.com/login
         * enter "test" into the username box
         * enter "Test.!123" into the password box
         * tap on login button
         * VERIFY that url is changed as "https://demoqa.com/profile"
         */
        String actual;
        String current="https://demoqa.com/profile";

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/login");
        Thread.sleep(2000);
        String usernameValue="test";
        String passwordValue="test.!123";
        WebElement inputUsername=driver.findElement(By.id("userName"));
        WebElement inputPassword=driver.findElement(By.id("password"));


        inputUsername.sendKeys(usernameValue);
        Thread.sleep(2000);
        inputPassword.sendKeys(passwordValue);
        Thread.sleep(2000);
        driver.findElement(By.id("login")).click();
        Thread.sleep(2000);
        actual=driver.getCurrentUrl();

        if (actual.equals(current)){
            System.out.println("PASS");
        }else {
            System.out.println("FAİLED");
        }
        driver.close();


    }
}
