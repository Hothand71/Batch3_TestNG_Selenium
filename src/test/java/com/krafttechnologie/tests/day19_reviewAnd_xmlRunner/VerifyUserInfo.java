package com.krafttechnologie.tests.day19_reviewAnd_xmlRunner;

import com.krafttechnologie.pages.DashboardPage;
import com.krafttechnologie.pages.LoginPage;
import com.krafttechnologie.pages.MyProfilePage;
import com.krafttechnologie.tests.TestBase;
import com.krafttechnologie.utilities.BrowserUtils;
import com.krafttechnologie.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyUserInfo extends TestBase {
    /** Class task
     * login as a mike
     * verify that login is successful
     * click on my profile
     * verify that job is
     * click on go back button
     * verify that dashboard is displayed
     */
    LoginPage loginPage=new LoginPage();
    DashboardPage dashboardPage=new DashboardPage();
    MyProfilePage myProfilePage=new MyProfilePage();
    @Test
    public void classTaskTest() {
        extentLogger=report.createTest("Class Task");
        extentLogger.info("Open to browser-->");
        driver.get("https://www.krafttechexlab.com/login");

        extentLogger.info("Enter email");
        loginPage.userEmailInput_loc.sendKeys(ConfigurationReader.get("userEmail"));

        extentLogger.info("Enter password");
        loginPage.passwordInput_loc.sendKeys(ConfigurationReader.get("password"));

        extentLogger.info("Click login button");
        loginPage.loginBtn_loc.click();

        extentLogger.info("Verify that login is successful");
        String expectedAccountName=ConfigurationReader.get("userName");
        Assert.assertEquals(dashboardPage.getAccountName(),expectedAccountName);
        Assert.assertTrue(dashboardPage.userAccountName.isDisplayed());

        extentLogger.info("Click on my profile");
        BrowserUtils.clickWithJS(dashboardPage.navigateModule(expectedAccountName,"My Profile"));
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.krafttechexlab.com/myprofile");

        extentLogger.info("Click on edit profile");
        BrowserUtils.clickWithJS(myProfilePage.navigateModuleButton("Edit Profile"));

        String expectedjob="QA";
        extentLogger.info("Verify expected job is"+expectedjob);
        Assert.assertEquals(myProfilePage.selectJob(),expectedjob);

        extentLogger.info("Click on go back button");
        driver.navigate().back();

        extentLogger.info("verify that dashboard is displayed");
        Assert.assertEquals(dashboardPage.dashboardPageSubTitle.getText(),"Dashboard");

        extentLogger.pass("PASSED");

    }
}
