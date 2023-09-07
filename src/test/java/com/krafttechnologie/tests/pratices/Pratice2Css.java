package com.krafttechnologie.tests.pratices;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Pratice2Css {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com");
        Thread.sleep(1000);
        WebElement flagSymbol=driver.findElement(By.cssSelector(".icp-nav-flag.icp-nav-flag-us.icp-nav-flag-lop"));
        flagSymbol.click();
        Thread.sleep(1000);
        WebElement amazonLogo = driver.findElement(By.cssSelector("a[aria-label='Amazon']"));
        amazonLogo.click();
        Thread.sleep(1000);
        WebElement searchBar = driver.findElement(By.cssSelector("#twotabsearchtextbox"));
        searchBar.sendKeys(RandomMailFactory.makeEmail("apple"));
        Thread.sleep(1000);
        WebElement searchButton1=driver.findElement(By.cssSelector("input.nav-input.nav-progressive-attribute[value='Go']"));
        searchButton1.click();
        Thread.sleep(1000);
        WebElement firstData = driver.findElement(By.cssSelector("div :nth-of-type(1) h2>a "));
        firstData.click();
        Thread.sleep(1000);
        driver.navigate().back();
        Thread.sleep(1000);
        WebElement secondData = driver.findElement(By.cssSelector("div :nth-of-type(3) h2>a "));
        secondData.click();
        Thread.sleep(1000);
        driver.navigate().back();
        Thread.sleep(1000);
        WebElement thirdData = driver.findElement(By.cssSelector("div :nth-of-type(11) h2>a "));
        thirdData.click();
        Thread.sleep(1000);
        driver.navigate().back();
        for (int i = 1; i <5 ; i++) {
            Thread.sleep(1000);
            WebElement buttonCheck=driver.findElement(By.cssSelector("div#nav-tools a:nth-of-type("+i+")"));
            buttonCheck.click();
            Thread.sleep(1000);
            driver.navigate().back();
        }
        driver.quit();


    }
}
