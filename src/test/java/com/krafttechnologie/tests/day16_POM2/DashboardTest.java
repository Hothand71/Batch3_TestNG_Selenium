package com.krafttechnologie.tests.day16_POM2;

import com.krafttechnologie.pages.DashboardPage;
import com.krafttechnologie.pages.LoginPage;
import com.krafttechnologie.tests.TestBase;
import com.krafttechnologie.utilities.BrowserUtils;
import com.krafttechnologie.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DashboardTest extends TestBase {
   /* @Test
    public void hoverTest() {
        driver.get("https://the-internet.herokuapp.com/hovers");
        WebElement img2 = driver.findElement(By.xpath("(//img)[2]"));
        BrowserUtils.hover(img2);

    }
*/
   LoginPage loginPage=new LoginPage();
    DashboardPage dashboardPage=new DashboardPage();
    @Test
    public void dashboardMenu() {
        /** Class Task
         *  Go to https://www.krafttechexlab.com/login
         *  Login with  jhon's/your credetials (get from Configuration.properties)
         *          *  Get the text of the "Dashboard" and verify following menu
         *   Dashboard
         *   Developers
         *   Components
         *   Forms
         *   javaScript
         *
         *
         *
         */
        driver.get("https://www.krafttechexlab.com/login");

        loginPage.login();

        String expectedText="Dashboard";
        Assert.assertEquals(dashboardPage.dashboardMenu.getText(),expectedText,"Verify that dashboard menu");
        Assert.assertEquals(dashboardPage.headerMenu_locators.get(0).getText(),expectedText,"Verify that header menu");
        dashboardPage.checkHeaderMenu();


    }

    @Test
    public void navigateMenu() {
        /** ClassTask
         //Go to https://www.krafttechexlab.com/login
         Login with Jhon/your credentials
         Verify that login is successful with user account name
         Navigate to Developers menu and verify url is https://www.krafttechexlab.com/developers
         Navigate to Dashboard menu and verify url is https://www.krafttechexlab.com/index
         */
        driver.get("https://www.krafttechexlab.com/login");
        loginPage.login();
        String expectedUserAccountName= ConfigurationReader.get("userName");
        Assert.assertEquals(dashboardPage.userAccountName.getText(),expectedUserAccountName,"Verify that account name");

        dashboardPage.headerMenu_locators.get(1).click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.krafttechexlab.com/developers");

        dashboardPage.headerMenu_locators.get(0).click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.krafttechexlab.com/index");

    }

    @Test
    public void navigate2() {
        driver.get("https://www.krafttechexlab.com/login");
        loginPage.login();
        dashboardPage.navigateModule("geralt").click();
        BrowserUtils.waitFor(5);
        Assert.assertEquals( dashboardPage.navigateModule("Components","Alerts").getText(),"Alerts","Verify that alerts");
        dashboardPage.navigateModule("Components","Alerts").click();
        BrowserUtils.waitForPageToLoad(20);
    }

}
