package com.krafttechnologie.tests.day05_xpath;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RelativeXpath1 {
    public static void main(String[] args) throws InterruptedException {
        //go to amazon.com
        //locate search bar with xpath
        //locate search button with xpath
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com");
        WebElement searchBar=driver.findElement(By.xpath("//input[@type='text']"));
        searchBar.sendKeys("Selenium");
        WebElement searchButton=driver.findElement(By.xpath("//input[@value='Go']"));
        searchButton.click();
        Thread.sleep(1000);
        WebElement searchedValue=driver.findElement(By.xpath("//span[.='\"Selenium\"']"));
        System.out.println((searchedValue.getText()).equals("\"Selenium\""));
        System.out.println(searchedValue.getText());

    }
}
