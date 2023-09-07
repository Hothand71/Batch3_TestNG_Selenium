package com.krafttechnologie.tests.day12_actions_JS_fileUpload;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class JavaScriptExecuterDemo {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    @BeforeMethod
    public void setUp() {
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        actions=new Actions(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testClickWithJS() throws InterruptedException {
        driver.get("https://www.amazon.co.uk/");
        WebElement cookiesAcptBtn = driver.findElement(By.id("sp-cc-accept"));
        cookiesAcptBtn.click();
        WebElement turkey = driver.findElement(By.linkText("Turkey"));
        //ask google to --> how to click with js executor
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", turkey);
        Thread.sleep(5000);
    }

    @Test
    public void typeWithJS() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement inputBox = driver.findElement(By.cssSelector("input[type=\"text\"]"));
        String text="Hello";

        //ask google to=> how to sendKeys with JS executor
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].value='"+ text +"';", inputBox);

        Thread.sleep(5000);
    }

    @Test
    public void myTry() throws InterruptedException {
        driver.get("https://mui.com/material-ui/react-text-field/");
        WebElement disabledInputBox = driver.findElement(By.cssSelector("input[class=\"MuiInputBase-input MuiFilledInput-input Mui-disabled css-2bxn45\"]"));
        String text="Batch 3 Here!";
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].value='"+ text +"';", disabledInputBox);
        Thread.sleep(2000);
    }

    @Test
    public void scrollToElement() throws InterruptedException {
        driver.get("https://www.amazon.co.uk");
        WebElement cookiesAcptBtn = driver.findElement(By.id("sp-cc-accept"));
        cookiesAcptBtn.click();
        JavascriptExecutor jse=(JavascriptExecutor) driver;

        WebElement turkey = driver.findElement(By.linkText("Turkey"));
       // how to scroll into view js executor
        /*jse.executeScript("arguments[0].scrollIntoView(true);", turkey);
        jse.executeScript("arguments[0].click();", turkey);*/
        turkey.click();

        /*actions.moveToElement(turkey).perform();
        actions.release();*/
        Thread.sleep(2000);


    }

    @Test
    public void scrollDownAndUp() throws InterruptedException {
    driver.get("https://www.amazon.co.uk/");
    WebElement cookiesAcptBtn = driver.findElement(By.id("sp-cc-accept"));cookiesAcptBtn.click();
    WebElement searchBar = driver.findElement(By.id("twotabsearchtextbox"));
    searchBar.sendKeys("Graphic Cards");
    searchBar.submit();
    WebElement searchedText = driver.findElement(By.cssSelector("[class=\"a-color-state a-text-bold\"]"));
    String expected = "\"Graphic Cards\"";
    String actual=searchedText.getText();
    Assert.assertEquals(actual,expected,"Verify that \"Graphic Cards\" text");
    JavascriptExecutor jse=(JavascriptExecutor) driver;
        for (int i = 0; i < 10; i++) {
            jse.executeScript("window.scrollBy(0,500)");
            Thread.sleep(1000);
        }
        for (int i = 0; i < 10; i++) {
            jse.executeScript("window.scrollBy(0,-500)");
            Thread.sleep(1000);
        }





    }
}
