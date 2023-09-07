package com.krafttechnologie.tests.day05_xpath;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AbsoluteXpath {
    public static void main(String[] args) {
        /*
         * go to https://www.krafttechexlab.com/
         * get the 'Home' webelement by absolute xpath
         * get the 'Dashboard' webelement by absolute xpath
         */
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://www.krafttechexlab.com/");
        WebElement homeLabel=driver.findElement(By.xpath("/html/body/main/div/nav/ol/li[1]"));
        System.out.println(homeLabel.getText());
        WebElement dashboardLabel=driver.findElement(By.xpath("/html/body/main/div/nav/ol/li[2]"));
        System.out.println(dashboardLabel.getText());
        driver.findElement(By.xpath("/html/body/header/nav/ul/li[3]/a/span")).click();
        driver.findElement(By.xpath("/html/body/header/nav/ul/li[3]/ul/li[8]/a")).click();

    }
}
