package com.krafttechnologie.pages;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.krafttechnologie.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class DashboardPage extends BasePage {


    public void checkHeaderMenu(){
        String[] parameters={"Dashboard","Developers","Components","Forms","JavaScript"};
        int i =0;
        for (WebElement headerMenu_locator : headerMenu_locators) {
            Assert.assertEquals(headerMenu_locator.getText(),parameters[i]);
            i++;
        }

    }
    public String getJob(String job){
        return Driver.get().findElement(By.xpath("//div[.='"+job+"']")).getText();
    }
    @FindBy(xpath = "//li[.='Dashboard']")
    public WebElement dashboardPageSubTitle;
}
