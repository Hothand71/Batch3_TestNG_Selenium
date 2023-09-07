package com.krafttechnologie.tests.day09_findelements_dropdawns;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.List;

public class ListOfElements {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
     driver= WebDriverFactory.getDriver("chrome");
     driver.manage().window().maximize();
    }
    @Test
    public void test(){
        /*
         * go to https://www.krafttechexlab.com/javascript/clicks
         * get all buttons into a list
         * click on third button
         */
        driver.get("https://www.krafttechexlab.com/javascript/clicks");
        List<WebElement> elements = driver.findElements(By.cssSelector("button.btn.btn-primary"));
        //elements.get(0)--> Right Click Me web elementi
        //elements.get(1)-->Double Click Me
        //...
        System.out.println(elements.size());

        //click the third element
        elements.get(2);

        //assert the text of third element
        String expected ="Click Me";
        String actual=elements.get(2).getText();
        Assert.assertEquals(actual,expected,"Verify that Click me text");
    }

    @Test @Ignore
    public void test1() {
        driver.get("https://www.krafttechexlab.com/javascript/clicks");
        driver.findElement(By.cssSelector("#myBtnMousedown")).click();
    }

    @AfterMethod
    public void tearDown(){
    driver.quit();
    }
}
