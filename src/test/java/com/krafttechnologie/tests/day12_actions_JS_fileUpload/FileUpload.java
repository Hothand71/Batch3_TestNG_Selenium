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

import java.util.concurrent.TimeUnit;

public class FileUpload {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    @BeforeMethod
    public void setUp() {
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        actions=new Actions(driver);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test1() {
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement chooseFileInput = driver.findElement(By.id("file-upload"));
        WebElement uploadBtn = driver.findElement(By.id("file-submit"));
        //to copy file path->Mac option+ hold+rightclick, win: shift hold right click dosya konumu adresi shift sağ tık
        String filePath="C:/Users/KEMAL/Desktop/krafttechB3.txt";
        String expectedFileName="krafttechB3.txt";
        chooseFileInput.sendKeys(filePath);
        //for win use
        //"C:\\Users\\KEMAL\\Desktop\\krafttechB3.txt"
        uploadBtn.click();
        WebElement uploadedText = driver.findElement(By.xpath("//div[@class=\"example\"]/h3[text()='File Uploaded!']"));
        WebElement uploadedFiles = driver.findElement(By.id("uploaded-files"));
        String expected="File Uploaded!";
        String actual=uploadedText.getText();
        Assert.assertEquals(actual,expected,"Verify that File Uploaded! message");
        Assert.assertEquals(uploadedFiles.getText(),expectedFileName,"Verify that uploaded file");



    }

    @Test
    public void test2() {
        driver.get("https://the-internet.herokuapp.com/upload");
        String projectPath=System.getProperty("user.dir");
        String filePath="src/test/resources/krafttechB3.txt";
        String fullPath=projectPath+"/"+filePath;
        fullPath=fullPath.replace("\\","/");
        String[] fileNames =fullPath.split("/");
        System.out.println(fileNames[fileNames.length - 1]);


        System.out.println("fullPath = " + fullPath);
        WebElement chooseFileInput = driver.findElement(By.id("file-upload"));
        WebElement uploadBtn = driver.findElement(By.id("file-submit"));
        chooseFileInput.sendKeys(fullPath);
        uploadBtn.click();
        WebElement uploadedText = driver.findElement(By.xpath("//div[@class=\"example\"]/h3[text()='File Uploaded!']"));
        WebElement uploadedFiles = driver.findElement(By.id("uploaded-files"));
        String expected="File Uploaded!";
        String actual=uploadedText.getText();
        Assert.assertEquals(actual,expected,"Verify that File Uploaded! message");
        Assert.assertEquals(uploadedFiles.getText(), fileNames[fileNames.length-1],"Verify that uploaded file");

    }
}
