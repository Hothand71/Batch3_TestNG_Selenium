package com.krafttechnologie.tests.day19_reviewAnd_xmlRunner;

import com.krafttechnologie.tests.TestBase;
import com.krafttechnologie.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class StaleElement extends TestBase {
    @Test
    public void staleProblem() {
        driver.get("https://freecrm.com/");
        WebElement loginBtn = driver.findElement(By.xpath("//span[.='Log In']"));
        loginBtn.click();

        WebElement emailInput = driver.findElement(By.xpath("//input[@name='email']"));
        emailInput.sendKeys("email@gmail.com");

        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys("email@gmail.com");

        BrowserUtils.waitFor(2);
        driver.navigate().refresh();
        emailInput.sendKeys("email@gmail.com");

    }

    @Test
    public void staleFix() {
        driver.get("https://freecrm.com/");
        BrowserUtils.waitFor(2);

        WebElement loginBtn = driver.findElement(By.xpath("//span[.='Log In']"));
        loginBtn.click();

        WebElement emailInput = driver.findElement(By.xpath("//input[@name='email']"));
        emailInput.sendKeys("email@gmail.com");

        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys("123456");

        BrowserUtils.waitFor(2);
        driver.navigate().refresh();

        try{
            emailInput.sendKeys("email@gmail.com");
        }catch (StaleElementReferenceException e){
             emailInput = driver.findElement(By.xpath("//input[@name='email']"));
            emailInput.sendKeys("email@gmail.com");

            passwordInput = driver.findElement(By.name("password"));
            passwordInput.sendKeys("123456");
        }

    }
}
