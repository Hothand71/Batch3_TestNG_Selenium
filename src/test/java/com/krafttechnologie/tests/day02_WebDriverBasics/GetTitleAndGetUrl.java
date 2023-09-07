package com.krafttechnologie.tests.day02_WebDriverBasics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTitleAndGetUrl {
    public static void main(String[] args) {
        //Task
        //Open chorme and navigate to https://www.krafttechexlab.com
        //get title and display

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.krafttechexlab.com");
        String title = driver.getTitle();
        System.out.println(title);

        //getting current url
        String currentUrl = driver.getCurrentUrl();
        System.out.println("currentUrl = " + currentUrl);

        //getting page source with selenium
        String pageSource=driver.getPageSource();
        System.out.println(pageSource);
    }
}
