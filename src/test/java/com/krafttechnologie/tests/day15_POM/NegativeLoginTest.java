package com.krafttechnologie.tests.day15_POM;

import com.krafttechnologie.pages.LoginPage;
import com.krafttechnologie.tests.TestBase;
import com.krafttechnologie.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTest extends TestBase {
    @Test
    public void negativeLoginTest() throws InterruptedException {
        driver.get(ConfigurationReader.get("url"));/*
        WebElement userEmailInput = driver.findElement(By.cssSelector("#email"));
        userEmailInput.sendKeys(ConfigurationReader.get("userEmail"));
        WebElement passwordInput = driver.findElement(By.cssSelector("#yourPassword"));
        passwordInput.sendKeys("wrongpassword");
        driver.findElement(By.cssSelector(" button")).click();
        WebElement warningMessage = driver.findElement(By.xpath("//*[contains(text(),\"Password is incorrect. Please check\")]"));
        Assert.assertEquals(warningMessage.getText(),"Password is incorrect. Please check","Verify alert");
*/
        LoginPage loginPage=new LoginPage();
        loginPage.userEmailInput_loc.sendKeys(ConfigurationReader.get("userEmail"));
        loginPage.passwordInput_loc.sendKeys("randomPssword");
        loginPage.loginBtn_loc.click();
        Assert.assertTrue(loginPage.passwordWarningMessage_loc.isDisplayed(),"Verify wrong password message");


        Thread.sleep(2000);


    }
}
