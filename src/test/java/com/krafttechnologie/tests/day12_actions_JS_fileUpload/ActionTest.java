package com.krafttechnologie.tests.day12_actions_JS_fileUpload;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ActionTest {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    @BeforeMethod
    public void setUp() {
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        wait=new WebDriverWait(driver,10);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        actions=new Actions(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void doubleClick() {
        driver.get("https://demoqa.com/buttons");
        WebElement doubleClickBtn = driver.findElement(By.cssSelector("button#doubleClickBtn"));
        actions.doubleClick(doubleClickBtn).perform();

        WebElement doubleClickMessage = driver.findElement(By.id("doubleClickMessage"));
        String expected = "You have done a double click";
        String actual=doubleClickMessage.getText();
        Assert.assertEquals(actual,expected,"Verify that double click text");
    }

    @Test
    public void rightClick() {
        driver.get("https://demoqa.com/buttons");
        WebElement rightClickBtn = driver.findElement(By.id("rightClickBtn"));
        //perform() unutma olmadan calısmaz; perform the action;
        actions.contextClick(rightClickBtn).perform();

        WebElement rightClickMessage = driver.findElement(By.id("rightClickMessage"));
        String actual =rightClickMessage.getText();
        String expected="You have done a right click";
        Assert.assertEquals(actual,expected,"Verify That Right Click Button Text");
    }

    @Test
    public void hoverTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/hovers");
        WebElement img2 = driver.findElement(By.xpath("(//img)[2]"));
        //moveToElement()=>>> move your mouse to the web element(hover over)
        //perform()=> perform the action, complete the action
        actions.moveToElement(img2).perform();



        WebElement img2NameLabel = driver.findElement(By.xpath("(//img)[2]/..//div/h5"));
        WebElement img2ProfileHref = driver.findElement(By.xpath("(//img)[2]/../div/a"));
        String expected="name: user1";
        String actual=img2NameLabel.getText();
        Assert.assertEquals(actual,expected,"Verify that name: user1 text hovers");
        Assert.assertTrue(img2ProfileHref.isDisplayed(),"Verify that Profile Link");


    }

    @Test
    public void homeTask() {
        /**  Hover class Task
         *      go to https://the-internet.herokuapp.com/hovers url
         *      and get "div a[href='/users/2']" elements' text (all of them)
         *      and verify element is displayed (one by one)
         *
         *      hind: Use list and for loop
         */
        driver.get("https://the-internet.herokuapp.com/hovers");
        List<WebElement> avatars = driver.findElements(By.cssSelector("div img[src*='avatar']"));
        int i=1;
        WebElement viewProfile;
        String expected="View profile";
        for (WebElement avatar : avatars) {
            actions.moveToElement(avatar).perform();
            String viewProfileCss="div a[href='/users/"+i+"']";
            viewProfile=driver.findElement(By.cssSelector(viewProfileCss));
            Assert.assertTrue(viewProfile.isDisplayed(),"Verify that viewProfile is displayed");
            Assert.assertEquals(viewProfile.getText(),expected,"Verify that view profile text");
            i++;
            actions.release().perform();
        }

    }

    @Test
    public void dragAndDrop() {
        driver.get("https://demoqa.com/droppable");
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.xpath("//p[.='Drop here'][1]"));

        //actions.dragAndDrop(source,target).perform();
        //actions.clickAndHold(source).moveToElement(target).perform(); actions.perform();
        actions.dragAndDrop(source,target).perform();
        actions.release().perform();//bırakma
        WebElement dropText = driver.findElement(By.xpath("//p[.='Dropped!']"));
        String expected="Dropped!";
        String actual=dropText.getText();
        Assert.assertEquals(actual,expected,"Verify that Dropped! text");
    }

    @Test
    public void dragAndDrop2() {
        driver.get("https://demoqa.com/droppable");
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.xpath("//p[.='Drop here'][1]"));
        //another way
        actions.clickAndHold(source).moveToElement(target).pause(3000).release().perform();

    }
}
