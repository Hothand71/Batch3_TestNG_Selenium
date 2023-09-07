package com.krafttechnologie.tests.day18_extentreports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.krafttechnologie.utilities.ConfigurationReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExtentReportDemo {
    //this class is used for starting and building reports
    ExtentReports report;

    //this class is used to create HTML report file
    ExtentHtmlReporter htmlReporter;

    //this class is define a test, enable adding logs, author and test steps
    ExtentTest extentLogger;

    @BeforeMethod
    public void setUp() {
        //initilaize the class
         report=new ExtentReports();

         //create a report path
        String projectPath= System.getProperty("user.dir");
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

    @Test
    public void test() {
        //give a name to the current test
        extentLogger = report.createTest("TC01 Login Test");

        //Test steps
        extentLogger.info("Open the browser");
        extentLogger.info("go to url-->" + ConfigurationReader.get("url"));
        extentLogger.info("enter username-->" + ConfigurationReader.get("userEmail"));
        extentLogger.info("enter password-->" + ConfigurationReader.get("password"));
        extentLogger.info("click login button");
        extentLogger.info("Verify user logged in");
        //mark as passed
        extentLogger.pass("TC01 Login Test passed");
    }

    @AfterMethod
    public void tearDown() {
        report.flush();
    }
}
