package com.krafttechnologie.tests.day12_actions_JS_fileUpload.day13_webtables;

import com.krafttechnologie.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTables {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    @BeforeMethod
    public void setUp(){
        driver= Driver.get();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        actions=new Actions(driver);
        driver.get("http://www.webdriveruniversity.com/Data-Table/index.html");

    }
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
    @Test
    public void printTable(){
        WebElement t01 = driver.findElement(By.id("t01"));
        System.out.println("t01.getText() = " + t01.getText());
    }
    @Test
    public void getAllHeaders(){
        List<WebElement> tableHeadElements = driver.findElements(By.xpath("//table[@id='t01']//th"));
        System.out.println(tableHeadElements.size());
        for (WebElement header:tableHeadElements
             ) {
            System.out.println(header.getText());
        }
    }

    @Test
    public void printTableSize() {
        //number of rows with header
        List<WebElement> allRowsWithHeader = driver.findElements(By.xpath("//table[@id='t01']//tr"));
        System.out.println(allRowsWithHeader.size());

        //number of rows without header (we prefer this)
        List<WebElement> allRowsWithoutHeader = driver.findElements(By.xpath("//table[@id='t01']//td/.."));
        System.out.println(allRowsWithoutHeader.size());
    }

    @Test
    public void getRow() {
        //print second row
       WebElement row2=driver.findElement(By.xpath("(//table[@id='t01']//td/..)[2]"));
        System.out.println(row2.getText());

        System.out.println(" ");

        //get all rows dynamically and print them one by one(without header)
        List<WebElement> allRowsWithoutHeader = driver.findElements(By.xpath("//table[@id='t01']//td/.."));
        for (WebElement element : allRowsWithoutHeader) {
            System.out.println(element.getText());
        }
        System.out.println(" ");
        for (int i = 1; i <= allRowsWithoutHeader.size(); i++) {
                WebElement element = driver.findElement(By.xpath("(//table[@id='t01']//td/..)[" + i + "]"));
                System.out.println(i+"-"+element.getText());
        }


    }

    @Test
    public void getAllCellInRow() {
        List<WebElement> allCellsOneRow = driver.findElements(By.xpath("(//table[@id='t01']//td/..)[1]/td"));
        for (WebElement element : allCellsOneRow) {
            System.out.println(element.getText());
        }
    }

    @Test
    public void getASingleCellInOneRow() {
        //question
        WebElement thirdCellOfFirstRow = driver.findElement(By.xpath("(//table[@id='t01']//td/..)[1]/td[3]"));
        System.out.println(thirdCellOfFirstRow.getText());

        WebElement secondCellOfSecondRow = driver.findElement(By.xpath("(//table[@id='t01']//td/..)[2]/td[2]"));
        System.out.println(secondCellOfSecondRow.getText());

        System.out.println("driver.getWindowHandle() = " + driver.getWindowHandle());
        System.out.println("driver = " + driver);
    }

    @Test
    public void printAllCellsByIndex() {
        //we want to write a code that it will print all cells one by one
        int rowNumber=getNumberOfRows();
        int columNumber=getNumberOfColums();

        for (int i = 1; i <= rowNumber; i++) {
            for (int j = 1; j <= columNumber; j++) {
                WebElement element = driver.findElement(By.xpath("(//table[@id='t01']//td/..)["+i+"]/td["+j+"]"));
                System.out.println(element.getText());
            }
        }

    }

    @Test
    public void testName() {
        int rowNumber=getNumberOfRows();
        int columNumber=getNumberOfColums();
        System.out.println("-------------");
        for (int i = 1; i <= rowNumber; i++) {
            for (int j = 1; j <= columNumber; j++) {
                System.out.println(getSpecificCellBasedOnNumbersThatIsGiven(i, j).getText());
            }
            System.out.println("-------------");
        }

    }

    private WebElement getSpecificCellBasedOnNumbersThatIsGiven(int row, int column){
        return driver.findElement(By.xpath("(//table[@id='t01']//td/..)["+row+"]/td["+column+"]"));
    }
    private int getNumberOfColums() {
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='t01']//th"));
        return headers.size();
    }

    private int getNumberOfRows() {
        //number of rows without header (we prefer this)
        List<WebElement> numberOfRows = driver.findElements(By.xpath("//table[@id='t01']//td/.."));
        return numberOfRows.size();
    }

}
