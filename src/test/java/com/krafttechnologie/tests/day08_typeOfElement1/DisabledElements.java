package com.krafttechnologie.tests.day08_typeOfElement1;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisabledElements {
    /* what is disabled element
       u can not interact the elements
       u can not click
       or
       u can not write something
     */
    @Test
    public void test1() throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement disableElement = driver.findElement(By.cssSelector("#input-example>input"));
        Assert.assertFalse(disableElement.isEnabled(),"Verify that disableElement is NOT enable or element is disable");
        //if we click the enable button is disabled
        WebElement enableButton = driver.findElement(By.cssSelector("#input-example>button"));
        enableButton.click();
        Thread.sleep(4000);
        Assert.assertTrue(disableElement.isEnabled(),"Verify that disableElement is enable");
        driver.close();
    }
}
