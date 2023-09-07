package com.krafttechnologie.tests.day02_WebDriverBasics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloseAndQuit {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();

        driver.navigate().to("https://www.krafttechexlab.com");
        driver.manage().window().maximize();

        Thread.sleep(2000);

        //close the driver
        driver.close();

      //  Thread.sleep(2000);

        //create
       // driver = new ChromeDriver();
       // driver.get("https://www.amazon.com");

        WebDriver driver1=new ChromeDriver();
        driver1.get("https://www.krafttechexlab.com");
        driver1.manage().window().maximize();
        Thread.sleep(2000);

        //close the driver quit()
        driver1.quit();
    }
}
