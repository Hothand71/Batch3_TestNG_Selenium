package com.krafttechnologie.tests.tasks;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task2 {
    public static void main(String[] args) throws InterruptedException {
        /*//test case-2
   	-- go to Amazon
   	-- write "Apple" on search box
   	-- click on search button
   	-- verify that url is changed
	-- close the browser
   	(https://www.amazon.com.tr --> https://www.amazon.com.tr/s?k=apple&__mk_tr_TR=ÅMÅŽÕÑ&crid=3RN84C0IBL20F&sprefix=apple%2Caps%2C175&ref=nb_sb_noss_1)*/
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.com.tr/");
        driver.manage().window().maximize();
        Thread.sleep(2000);

        WebElement searchBar=driver.findElement(By.id("twotabsearchtextbox"));
        WebElement searchButton=driver.findElement(By.id("nav-search-submit-button"));

        searchBar.sendKeys("apple");
        Thread.sleep(2000);
        searchButton.click();
        Thread.sleep(2000);
        System.out.println(driver.getCurrentUrl().equals("https://www.amazon.com.tr/s?k=apple&__mk_tr_TR=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=HOQ0AQGNFHLT&sprefix=apple%2Caps%2C226&ref=nb_sb_noss_1"));


    }
}
