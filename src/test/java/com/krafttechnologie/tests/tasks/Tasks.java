package com.krafttechnologie.tests.tasks;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Tasks {
    public static void main(String[] args) throws InterruptedException {
        /*//test case-1
	-- go to Amazon
   	-- click on search button
   	-- verify that url is not changed
        -- close the browser
   	("https://www.amazon.com.tr" --> "https://www.amazon.com.tr")*/

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com.tr");
        String currentUrl=driver.getCurrentUrl();
        Thread.sleep(2000);
        WebElement searchButton =driver.findElement(By.id("nav-search-submit-button"));
        searchButton.click();
        Thread.sleep(2000);
        String actualUrl=driver.getCurrentUrl();
        if (currentUrl.equals(actualUrl)){
            System.out.println("PASS");
        }else {
            System.out.println("FAİLED");
        }
        driver.close();

    }
}
