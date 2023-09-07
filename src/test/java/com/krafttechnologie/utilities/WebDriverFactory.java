package com.krafttechnologie.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverFactory {
    //Task
    //Write a static method
    //that is named getDriver
    //it takes a string parameter(browserType)
    //it will setup browser
    //it will return a chorme driver or firefox/safari driver based on the parameter that is given

    public static WebDriver getDriver(String browserType){
       WebDriver driver = null;
       switch (browserType.toLowerCase()){
           case "chrome":
               WebDriverManager.chromedriver().setup();
               driver = new ChromeDriver();
               break;
           case "safari":
               WebDriverManager.safaridriver().setup();
               driver =new SafariDriver();
               break;
           case "firefox":
               WebDriverManager.firefoxdriver().setup();
               driver=new FirefoxDriver();
               break;
           case "opera":
               WebDriverManager.operadriver().setup();
               driver=new OperaDriver();
       }
       return driver;
    }
}
