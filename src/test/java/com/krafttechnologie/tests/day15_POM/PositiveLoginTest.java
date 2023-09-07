package com.krafttechnologie.tests.day15_POM;

import com.krafttechnologie.pages.LoginPage;
import com.krafttechnologie.tests.TestBase;
import com.krafttechnologie.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLoginTest extends TestBase {
LoginPage loginPage=new LoginPage();


    @Test
    public void loginTest() throws InterruptedException {
        driver.get(ConfigurationReader.get("url"));
        loginPage.userEmailInput_loc.sendKeys(ConfigurationReader.get("userEmail"));
        loginPage.passwordInput_loc.sendKeys(ConfigurationReader.get("password"));
        loginPage.loginBtn_loc.click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.krafttechexlab.com/index","Verify that succesfull login");

        System.out.println(loginPage.componentsMenuList.size());

    }

    @Test
    public void testName() throws InterruptedException {
        driver.get(ConfigurationReader.get("url"));
       loginPage.login();
       loginPage.logOut();


        loginPage.loginManuel("blabla@gmail.com","123456");

        Thread.sleep(2000);
    }


}
