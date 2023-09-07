package com.krafttechnologie.tests.day06_css;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class cssWithId {
    public static void main(String[] args) {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/login");
        //WebElement emailBox = driver.findElement(By.id("email"));
        //WebElement emailBox = driver.findElement(By.cssSelector("#email"));
        //emailBox.sendKeys("example@example.com");
    }
}
