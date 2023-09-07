package com.krafttechnologie.tests.day14_properties_singleton;

import com.krafttechnologie.tests.TestBase;
import com.krafttechnologie.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {


    @Test
    public void testpositiveLoginTest() throws InterruptedException {
        driver.get(ConfigurationReader.get("url"));
        driver.findElement(By.cssSelector("#email")).sendKeys(ConfigurationReader.get("userEmail"));
        driver.findElement(By.cssSelector("#yourPassword")).sendKeys(ConfigurationReader.get("password")+Keys.TAB+ Keys.TAB+Keys.ENTER);
        Thread.sleep(2000);
      //  webDriverWait.until(ExpectedConditions.elementToBeClickable( By.cssSelector(" button")));
      //  driver.findElement(By.cssSelector(" button")).click();
    }
}
