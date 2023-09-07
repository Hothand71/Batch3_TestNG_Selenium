package com.krafttechnologie.tests.pratices;

import com.krafttechnologie.pages.DashboardPage;
import com.krafttechnologie.pages.LoginPage;
import com.krafttechnologie.tests.TestBase;
import org.testng.annotations.Test;

public class Pratice04 extends TestBase {/**
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
LoginPage loginPage=new LoginPage();
DashboardPage dashboardPage=new DashboardPage();

@Test
public void test1() {
    driver.get("https://www.krafttechexlab.com/login");
    loginPage.login();
    dashboardPage.navigateModule("geralt").click();
    dashboardPage.navigateModule("geralt","My Profile").click();
    dashboardPage.navigateBtnModule("Edit Profile").click();
}
}
