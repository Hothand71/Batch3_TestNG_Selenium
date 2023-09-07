package com.krafttechnologie.tests.day08_typeOfElement1;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButtonTest {

    @Test
    public void test1(){
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://demo.aspnetawesome.com/");
        WebElement cookiesOk=driver.findElement(By.cssSelector("#btnCookie"));
        cookiesOk.click();
        WebElement vegetablesRadio=driver.findElement(By.xpath("//div[text()='Vegetables']/..//input"));
        WebElement legumeRadio=driver.findElement(By.xpath("//div[text()='Legumes']/..//input"));
        WebElement legume=driver.findElement(By.xpath("//div[text()='Legumes']/../div[1]"));
        Assert.assertTrue(vegetablesRadio.isSelected(),"Verify that vegetablesRadio is selected");
        legume.click();
        Assert.assertTrue(legumeRadio.isSelected(),"Verify that legumeRadio is selected");
        Assert.assertFalse(vegetablesRadio.isSelected(),"Verify that vegetablesRadio is NOT selected");
        driver.close();
    }
    @Test
    public void test2() throws InterruptedException {
        WebDriver driver=WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        WebElement checkBox1= driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]"));
        WebElement checkBox2= driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]"));
        Assert.assertFalse(checkBox1.isSelected(),"checkBox1 is selected verify that");
        Assert.assertTrue(checkBox2.isSelected(),"checkBox2 is NOT selected verify that");
        Thread.sleep(2000);
        checkBox1.click();
        Thread.sleep(2000);
        checkBox2.click();
        Assert.assertFalse(checkBox2.isSelected(),"Verify that checkbox2 is NOT selected");
        Assert.assertTrue(checkBox1.isSelected(),"Verify that checkbox1 is selected");
        driver.close();
    }
}
