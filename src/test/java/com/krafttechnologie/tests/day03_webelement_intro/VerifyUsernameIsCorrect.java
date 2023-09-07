package com.krafttechnologie.tests.day03_webelement_intro;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyUsernameIsCorrect {
    public static void main(String[] args) throws InterruptedException {
        /*
         * TASK
         * open chrome browser
         * go to https://demoqa.com/login
         * enter "test" into the username box
         * VERIFY that "test" is displayed in the username box
         * enter "Test.!123" into the password box
         * tap on login button
         * VERIFY that username is still "test"
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/login");
        Thread.sleep(2000);

        WebElement usernameBox = driver.findElement(By.id("userName"));
        WebElement  passwordBox = driver.findElement(By.id("password"));
        WebElement  loginButton = driver.findElement(By.id("login"));

        String name="test";
        String password="Test.!123";

        usernameBox.sendKeys(name);
        String valueOfUsernameBox= usernameBox.getAttribute("value");
        if (valueOfUsernameBox.equals(name)){
            System.out.println("PASS");
        }else {
            System.out.println("FAİLED");
        }

        passwordBox.sendKeys(password);
        Thread.sleep(2000);
        loginButton.click();

        Thread.sleep(2000);
        WebElement currentUserName=driver.findElement(By.id("userName-value"));
        System.out.println(currentUserName.getText().equals(name));

        driver.close();


    }
}
