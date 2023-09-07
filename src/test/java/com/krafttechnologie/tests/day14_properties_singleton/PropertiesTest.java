package com.krafttechnologie.tests.day14_properties_singleton;

import com.krafttechnologie.utilities.ConfigurationReader;
import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class PropertiesTest {
    @Test
    public void getDataFromConfigurationProperties() {
        String browser = ConfigurationReader.get("browser");
        System.out.println("browser = " + browser);
        String url = ConfigurationReader.get("url");
        System.out.println("url = " + url);
        String userEmail = ConfigurationReader.get("userEmail");
        System.out.println("userEmail = " + userEmail);
        String password = ConfigurationReader.get("password");
        System.out.println("password = " + password);
    }

    @Test
    public void loginWithConfigurationReader() throws InterruptedException {
        WebDriver driver =WebDriverFactory.getDriver(ConfigurationReader.get("browser"));
        driver.manage().window().maximize();
        driver.get(ConfigurationReader.get("url"));
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#email")).sendKeys(ConfigurationReader.get("userEmail"));
        driver.findElement(By.cssSelector("#yourPassword")).sendKeys(ConfigurationReader.get("password"));
        driver.findElement(By.cssSelector(" button")).click();
        Thread.sleep(2000);



        driver.quit();
    }
}
