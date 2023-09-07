package com.krafttechnologie.tests.day10_alerts_multiplewindows_iframe;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IFrames {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void iframes() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/iframe");
        Thread.sleep(2000);
       // WebElement yourTextHereFrame = driver.findElement(By.xpath("//p[.='Your content goes here.']"));
        Thread.sleep(2000);
        //-------------------------------------------------
        //first way
        //name attribute or id attribute
        //driver.switchTo().frame("name" or "id")
        driver.switchTo().frame("mce_0_ifr");
        WebElement yourTextHereFrame = driver.findElement(By.xpath("//p"));
        yourTextHereFrame.clear();
        driver.switchTo().parentFrame();
        Thread.sleep(2000);
        //-------------------------------------------------
        //second way
        //index number
        //index nubmer starts with 0
        //driver.switchTo().frame(indexnumber)
        driver.switchTo().frame(0);
        Thread.sleep(2000);
        yourTextHereFrame.sendKeys("We are here thanks to frame(indexnubmer) method");
        Thread.sleep(2000);
        yourTextHereFrame = driver.findElement(By.xpath("//p"));
        yourTextHereFrame.clear();
        Thread.sleep(2000);
        //go back to the parent frame
        driver.switchTo().defaultContent();//default en başa döndürür
        //-------------------------------------------------
        //third way to switch to frame
        //with locators
        WebElement iframe = driver.findElement(By.cssSelector("#mce_0_ifr"));
        driver.switchTo().frame(iframe);
        Thread.sleep(2000);
        yourTextHereFrame.sendKeys("We are here thanks to frame(index number)");
        Thread.sleep(2000);

    }

    @Test
    public void testNestedFrames() {
        driver.get("https://the-internet.herokuapp.com/nested_frames");

        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");

        System.out.println("driver.findElement(By.cssSelector(\"#content\")).getText() = "
                + driver.findElement(By.cssSelector("#content")).getText());

        // go to Right frame and get text
        driver.switchTo().parentFrame(); // selenium switch the parent
        //driver.switchTo().defaultContent();// selenium switch to directly top
        // driver.switchTo().frame("frame-top");

        driver.switchTo().frame(2);
        System.out.println("driver.findElement(By.tagName(\"body\")).getText() = "
                + driver.findElement(By.tagName("body")).getText());

        //go to bottom frame and get text

        driver.switchTo().defaultContent(); // to go to HTML
        //driver.switchTo().frame(1);
        driver.switchTo().frame("frame-bottom");
        System.out.println("driver.findElement(By.tagName(\"body\")).getText() = "
                + driver.findElement(By.tagName("body")).getText());
    }
}
