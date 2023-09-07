package com.krafttechnologie.tests.day17_POM3;

import com.krafttechnologie.pages.MyProfilePage;
import com.krafttechnologie.tests.TestBase;
import com.krafttechnologie.utilities.BrowserUtils;
import com.krafttechnologie.utilities.ConfigurationReader;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyProfileTest extends TestBase {
    /**
    //TASK
    //THIS TASK WILL BE IMPLEMENTED USING POM which means we will have one test class for the test and one corresponding page having all locators and actions for the page
    //go to https://www.krafttechexlab.com/login
    //login with valid credentials
    //      --> john@gmail.com
    //      --> John1234.
    //go to John --> myProfile
    //create a method that navigate you to specific module based on the given parameter
    //go to edit Profile page using the method just mentioned above
    //fill out the fields
    //      --> about --> Excellent QA, graduated from KraftTech
    //      --> company --> Apple
    //      --> job --> QA
    //      --> website --> Test
    //      --> location --> Turkey
    //      --> skills --> Automation Master
    //tap on Save Changes button
    //verify that "Profile Updated" appears*/
    MyProfilePage myProfilePage=new MyProfilePage();
    Select select;

    @Test
    public void test1() {
        driver.get(ConfigurationReader.get("url"));
        myProfilePage.login();
        BrowserUtils.waitForVisibility(myProfilePage.navigateModuleMenu(ConfigurationReader.get("userName")),7);
        myProfilePage.navigateModuleMenu(ConfigurationReader.get("userName"),"My Profile").click();
        myProfilePage.navigateModuleButton("Edit Profile").click();
        myProfilePage.enterNewValue(myProfilePage.aboutTextArea_loc,"Excellent QA, graduated from KraftTech");
        myProfilePage.enterNewValue(myProfilePage.companyTextBar_loc,"Apple");
        myProfilePage.selectJob("QA");
        myProfilePage.enterNewValue(myProfilePage.websiteTextBar_loc,"Test");
        myProfilePage.enterNewValue(myProfilePage.locationTextBar_loc, "Turkey");
        myProfilePage.enterNewValue(myProfilePage.skillsTextBar_loc,"Automation Master");
        BrowserUtils.waitFor(5);
        myProfilePage.saveChangesBtn_loc.click();
        String expected="Profile Updated";
        Assert.assertEquals(myProfilePage.profileUpdatedAlertBox_loc.getText(),expected,"Verify that Profile Updated alert");
        BrowserUtils.waitFor(5);
    }
}
