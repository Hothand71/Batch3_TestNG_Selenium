package com.krafttechnologie.tests.day02_WebDriverBasics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationDemo {
    public static void main(String[] args) throws InterruptedException {
        //make ready selenium to talk with chrome
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.google.com/");

        Thread.sleep(2000);

        //navigate() is an other method that takes us to the target website
        driver.navigate().to("https://www.facebook.com/");

        Thread.sleep(2000);


        driver.navigate().back();

        Thread.sleep(2000);


        driver.navigate().forward();

        Thread.sleep(2000);

        ////refreshing the page
        driver.navigate().refresh();


    }
}
