package com.krafttechnologie.tests.day09_findelements_dropdawns;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class DropDownWithSelectTag {
WebDriver driver;

@BeforeMethod
    public void setUp(){
    driver= WebDriverFactory.getDriver("chrome");
    driver.manage().window().maximize();
}

    @Test
    public void test_getOptions() throws InterruptedException {
        // Old Style Select Menu
        // go to https://demoqa.com/select-menu
        // get all options(web elements) as a list
        driver.get("https://demoqa.com/select-menu");
        Thread.sleep(2000);
        WebElement oldSelectMenu = driver.findElement(By.xpath("//select[@id='oldSelectMenu']"));
        Select select = new Select(oldSelectMenu);

        //getOptions()
        List<WebElement> options=select.getOptions();

        //how many elements options bucket have
        System.out.println("options.size() = " + options.size());

        //print all  the text of web elements
        for (WebElement option:options
             ) {
            System.out.println(option.getText());
        }
            int expected=11;
            int actual = options.size();
        Assert.assertEquals(actual,expected,"Verify that options size");
    }

    @Test
    public void test_selectByVisibleText() throws InterruptedException {
        // Old Style Select Menu
        // go to https://demoqa.com/select-menu
        // get the blue thru visible text option and make verification
        driver.get("https://demoqa.com/select-menu");
        Thread.sleep(2000);
        WebElement dropDownMenu = driver.findElement(By.cssSelector("select#oldSelectMenu"));
        Select select=new Select(dropDownMenu);
        select.selectByVisibleText("Blue");
        Thread.sleep(2000);

        WebElement firstSelectedOption = select.getFirstSelectedOption();
        System.out.println(firstSelectedOption.getText());

    }

    @Test
    public void test_selectByIndexNumber() throws InterruptedException {
        // Old Style Select Menu
        // go to https://demoqa.com/select-menu
        // get the green option thru visible index number and make verification
        driver.get("https://demoqa.com/select-menu");
        WebElement dropDownMenu = driver.findElement(By.cssSelector("select#oldSelectMenu"));
        Select select=new Select(dropDownMenu);
        select.selectByIndex(2);
        Thread.sleep(2000);
        WebElement firstSelectedOption = select.getFirstSelectedOption();
        String actual=firstSelectedOption.getText();
        String expected="Green";
        Assert.assertEquals(actual,expected,"Verify that dropDownMenu index of 2");
    }

    @Test
    public void testByValueAttribute() {
        // Old Style Select Menu
        // go to https://demoqa.com/select-menu
        // get the voilet thru value option and make verification
        driver.get("https://demoqa.com/select-menu");
        WebElement dropDownMenu = driver.findElement(By.cssSelector("select#oldSelectMenu"));
        Select select=new Select(dropDownMenu);
        select.selectByValue("7");
        //select.selectByVisibleText("Voilet");
        WebElement firstSelectedOption = select.getFirstSelectedOption();
        String expected="Voilet";
        String actual= firstSelectedOption.getText();
        Assert.assertEquals(actual,expected,"Verify that Voliet option");

    }

    @Test
    public void test_getOneOptionsFindElement() throws InterruptedException {
        // locate the "Select Title" web element
        // click on it
        // click on 'Mrs.'
        driver.get("https://demoqa.com/select-menu");
        Thread.sleep(2000);
        WebElement selectTitleMenu = driver.findElement(By.xpath("(//div[.=\"Select Title\"])[3]"));
        selectTitleMenu.click();
        Thread.sleep(2000);
        WebElement mrsWebElement = driver.findElement(By.cssSelector("#react-select-3-option-0-2"));
        mrsWebElement.click();
        Thread.sleep(2000);
        String expected="Mrs.";
        String actual=driver.findElement(By.cssSelector(" div[class=\" css-1uccc91-singleValue\"]")).getText();
        Thread.sleep(2000);
        Assert.assertEquals(actual,expected,"Verify that Mrs.");
       // System.out.println(selectTitleMenu.getText());
    }

    @Test
    public void test_getAllOfOptionsWithFindElements() throws InterruptedException {
        // locate the "Select Title" web element
        // click on it
        // get all options with findElements()
        driver.get("https://demoqa.com/select-menu");
        Thread.sleep(2000);
        WebElement selectTitleMenu = driver.findElement(By.xpath("(//div[.=\"Select Title\"])[3]"));
        selectTitleMenu.click();
        Thread.sleep(2000);
        List<WebElement> elements = driver.findElements(By.xpath("//div[contains(@id,'-option')]"));
        System.out.println(elements.size());
        System.out.println(elements.get(1).getText());
        elements.get(1).click();

    }

    @AfterMethod
    public void tearDown(){
    driver.close();
}


}
