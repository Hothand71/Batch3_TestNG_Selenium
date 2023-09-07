package com.krafttechnologie.tests.day10_alerts_multiplewindows_iframe;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PopUpAndAlerts {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @Test
    public void testPopOpWithoutJSAlert() throws InterruptedException {
        driver.get("http://primefaces.org/showcase/ui/overlay/confirmDialog.xhtml?jfwid=73437");
        Thread.sleep(2000);
        WebElement confirmBtn = driver.findElement(By.xpath("//span[@class='ui-button-text ui-c'][text()=\"Confirm\"]"));
        confirmBtn.click();
        Thread.sleep(2000);
        WebElement yesPopUpBtn = driver.findElement(By.cssSelector("[id='j_idt343:j_idt348']"));
        yesPopUpBtn.click();
        Thread.sleep(1000);
        WebElement confimrBox = driver.findElement(By.cssSelector("[class='ui-growl ui-widget']"));
        Assert.assertTrue((confimrBox.getText().contains("Confirm")),"Verify that Confirm alert");

    }

    @Test
    public void testPopOpWithJSAlert() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        Thread.sleep(2000);
        WebElement jsAlertBtn = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
        jsAlertBtn.click();
        Thread.sleep(2000);
        Alert alert=driver.switchTo().alert();
        alert.accept();
        Thread.sleep(2000);
        WebElement resultLabel = driver.findElement(By.cssSelector("#result"));
        String actual = resultLabel.getText();
        String expected="You successfully clicked an alert";
        Assert.assertEquals(actual,expected,"Verify that succesfully label");
        Thread.sleep(2000);
        WebElement clickForJSConfirm = driver.findElement(By.cssSelector("button[onclick='jsConfirm()']"));
        clickForJSConfirm.click();
        Thread.sleep(2000);
        alert.dismiss();
        Thread.sleep(2000);
        WebElement result = driver.findElement(By.cssSelector("#result"));
        expected = "You clicked: Cancel";
        actual=result.getText();
        Assert.assertEquals(actual,expected,"Verify that Click for JS Confirm result");
        Thread.sleep(2000);
        WebElement clickForJSPrompt = driver.findElement(By.cssSelector("button[onclick='jsPrompt()']"));
        clickForJSPrompt.click();
        alert.sendKeys("Merhaba");
        Thread.sleep(2000);
        alert.accept();
        Thread.sleep(2000);
        WebElement resultPrompt = driver.findElement(By.cssSelector("#result"));
        actual = resultPrompt.getText();
        expected= "You entered: Merhaba";
        Assert.assertEquals(actual,expected,"Verify that Prompt result");
    }



    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
