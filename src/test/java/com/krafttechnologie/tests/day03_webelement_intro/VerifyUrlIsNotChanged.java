package com.krafttechnologie.tests.day03_webelement_intro;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyUrlIsNotChanged {
    public static void main(String[] args) throws InterruptedException {

        /*
         * TASK
         * open chrome browser
         * go to https://demoqa.com/login
         * click on login button
         * VERIFY that url is not changed
         */
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/login");
        Thread.sleep(2000);
        String firstUrl =driver.getCurrentUrl();
        driver.findElement(By.id("login")).click();
        WebElement loginButton = driver.findElement(By.id("login"));
        loginButton.click();


        Thread.sleep(2000);
        String secondUrl =driver.getCurrentUrl();
        if (firstUrl.equals(secondUrl)){
            System.out.println("PASS");
        }else
        {System.out.println("Failed");}

        driver.close();
    }

}
