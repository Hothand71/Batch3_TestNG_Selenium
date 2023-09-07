package com.krafttechnologie.tests.day20_DDF;

import com.krafttechnologie.pages.DashboardPage;
import com.krafttechnologie.pages.LoginPage;
import com.krafttechnologie.tests.TestBase;
import com.krafttechnologie.utilities.BrowserUtils;
import com.krafttechnologie.utilities.ConfigurationReader;
import com.krafttechnologie.utilities.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDF_LoginTest extends TestBase {
    @DataProvider
    public Object[][] userData(){
        ExcelUtil testData=new ExcelUtil("src/test/resources/KT_B3 DDF test.xlsx","Test Data");
        return testData.getDataArrayWithoutFirstRow();
    }

    @Test(dataProvider = "userData")
    public void ddfLoginTest(String username,String password,String job,String name) {
        LoginPage loginPage=new LoginPage();
        DashboardPage dashboardPage=new DashboardPage();
        extentLogger=report.createTest(name+"'s Login Test");

        extentLogger.info("Go this site-->"+ConfigurationReader.get("url"));
        driver.get(ConfigurationReader.get("url"));

        extentLogger.info("Enter Username-->"+username);
        loginPage.userEmailInput_loc.sendKeys(username);

        extentLogger.info("enter password-->"+password);
        loginPage.passwordInput_loc.sendKeys(password);

        extentLogger.info("Click login button");
        BrowserUtils.clickWithJS(loginPage.loginBtn_loc);

        extentLogger.info("Verify login name-->"+name);
        Assert.assertEquals(dashboardPage.userAccountName.getText(),name,"Verify name");
        extentLogger.info("Verify "+name+"'s job-->"+job);
        Assert.assertEquals(dashboardPage.getJob(job),job);

        extentLogger.pass("PASSED");

    }
}
