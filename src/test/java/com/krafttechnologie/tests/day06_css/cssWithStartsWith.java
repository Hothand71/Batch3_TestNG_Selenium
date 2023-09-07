package com.krafttechnologie.tests.day06_css;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class cssWithStartsWith {
    public static void main(String[] args) {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/login");

        WebElement loginButton = driver.findElement(By.cssSelector("[class^='btn']"));
        System.out.println("loginButton.getText() = " + loginButton.getText());
        driver.quit();

    }
}
