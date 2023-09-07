package com.krafttechnologie.tests;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.krafttechnologie.utilities.BrowserUtils;
import com.krafttechnologie.utilities.ConfigurationReader;
import com.krafttechnologie.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestBase {
    protected WebDriver driver;
    protected WebDriverWait webDriverWait;
    protected Actions actions;

    //extent report
    protected ExtentReports report;
    protected ExtentHtmlReporter htmlReporter;
    protected ExtentTest extentLogger;

    @BeforeMethod
    public void setUp() {
        driver= Driver.get();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        webDriverWait=new WebDriverWait(driver,7);
        actions=new Actions(driver);

    }

    //ITestResult class describes
    @AfterMethod
    public void tearDown(ITestResult result) throws IOException, InterruptedException {
        //if test fails
        if(result.getStatus() == ITestResult.FAILURE){
            //record the name of failed test
            extentLogger.fail(result.getName());
            //take the screen shot and return the location of screenshot
            String screenShotPath = BrowserUtils.getScreenshot(result.getName());
            //add the screenshot to the report
            extentLogger.addScreenCaptureFromPath(screenShotPath);
            //capture the exception and put inside the report
            extentLogger.fail(result.getThrowable());
            report.flush();
        }
        Thread.sleep(2000);
        Driver.closeDriver();
    }


    @BeforeTest
    public void setUpTest(){
        //before test
        //initilaize the class
        report=new ExtentReports();

        //create a report path
        String projectPath= System.getProperty("user.dir");
        //String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        //String reportPath= projectPath+"/test-output/report"+date+".html";
        String reportPath= projectPath+"/test-output/report.html";

        //initialize the html report with the reportPath
        htmlReporter= new ExtentHtmlReporter(reportPath);

        //attach the html report to the report object
        report.attachReporter(htmlReporter);

        //title in report
        htmlReporter.config().setReportName("Batch 3 Smoke Test");

        report.setSystemInfo("Environment","Test");
        report.setSystemInfo("Browser", ConfigurationReader.get("browser"));
        report.setSystemInfo("OS",System.getProperty("os.name"));
        report.setSystemInfo("Test Engineer","Mustafa Kemal");

    }
    @AfterTest
    public void tearDownTest(){
        //after test
        report.flush();
    }
}


