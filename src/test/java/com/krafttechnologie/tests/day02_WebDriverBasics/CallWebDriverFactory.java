package com.krafttechnologie.tests.day02_WebDriverBasics;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class CallWebDriverFactory {
    public static void main(String[] args) throws InterruptedException {
        //Task
        //go to https://www.krafttechexlab.com with chrome by using getDriver() method
        //verify that the url is "https://www.krafttechexlab.com/"

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com");
        driver.manage().window().maximize();

        Thread.sleep(2000);

        String actual = driver.getCurrentUrl();
        String expected ="https://www.krafttechexlab.com/";

        if (actual.equals(expected)){
            System.out.println("PASS");
        } else {
            System.out.println("Failed");
        }
        driver.close();
    }
}
