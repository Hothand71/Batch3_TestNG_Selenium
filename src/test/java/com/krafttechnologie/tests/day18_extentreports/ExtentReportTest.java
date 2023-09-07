package com.krafttechnologie.tests.day18_extentreports;

import com.krafttechnologie.pages.LoginPage;
import com.krafttechnologie.tests.TestBase;
import com.krafttechnologie.utilities.BrowserUtils;
import com.krafttechnologie.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExtentReportTest extends TestBase {
    LoginPage loginPage = new LoginPage();

    @Test
    public void wrongUserEmailTest(){
        extentLogger = report.createTest("wrong user email test");

        extentLogger.info("go to login page --> " + ConfigurationReader.get("url"));
        driver.get(ConfigurationReader.get("url"));

        //LoginPage loginPage = new LoginPage();
        loginPage = new LoginPage();

        extentLogger.info("enter wrong email");
        loginPage.userEmailInput_loc.sendKeys("wrong email");

        extentLogger.info("enter right password");
        loginPage.passwordInput_loc.sendKeys(ConfigurationReader.get("password"));

        extentLogger.info("click on login button");
        BrowserUtils.clickWithJS(loginPage.loginBtn_loc);

        BrowserUtils.waitFor(3);

        String actual = loginPage.emailWarningMessage_loc.getText();

        extentLogger.info("verify that not logged in");
        Assert.assertEquals(actual, "Email address is incorrect. Please checkkk");

        extentLogger.pass("PASSED");
    }

    @Test
    public void wrongPasswordTest(){
        extentLogger = report.createTest("wrong password test");

        extentLogger.info("go to krafttech --> " + ConfigurationReader.get("url"));
        driver.get(ConfigurationReader.get("url"));

        //LoginPage loginPage = new LoginPage();
        loginPage = new LoginPage();

        extentLogger.info("enter right user email");
        loginPage.userEmailInput_loc.sendKeys(ConfigurationReader.get("userEmail"));

        extentLogger.info("enter wrong password");
        loginPage.passwordInput_loc.sendKeys("wrong password");

        extentLogger.info("click on login button");
        BrowserUtils.clickWithJS(loginPage.loginBtn_loc);

        BrowserUtils.waitFor(3);

        String actual = loginPage.passwordWarningMessage_loc.getText();

        extentLogger.info("verify that not logged in");
        Assert.assertEquals(actual,"Password is incorrect. Please check");

        extentLogger.pass("PASSED");
    }

}