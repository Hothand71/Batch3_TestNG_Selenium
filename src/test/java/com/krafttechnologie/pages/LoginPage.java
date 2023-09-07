package com.krafttechnologie.pages;

import com.krafttechnologie.utilities.ConfigurationReader;
import com.krafttechnologie.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class LoginPage extends BasePage {

    @FindBy(css ="#email")
    public WebElement userEmailInput_loc;
    @FindBy(css = "#yourPassword")
    public WebElement passwordInput_loc;
    @FindBy(css = " button")
    public WebElement loginBtn_loc;

    @FindBy(xpath = "//*[contains(text(),'Email address is incorrect. Please check')]")
    public WebElement emailWarningMessage_loc;
    @FindBy(xpath ="//*[contains(text(),'Password is incorrect. Please check')]" )
    public WebElement passwordWarningMessage_loc;

    @FindBy(xpath = "//li//span[text()='Components']/../../ul/li")
    public List<WebElement> componentsMenuList;
    @FindBy(xpath = "//span[text()='Components']")
    public WebElement componentsMenu_loc;
// if one of the element is true it is pass => OR
    @FindAll({
            @FindBy(css = "#email"),
            @FindBy(name = "email")
    })
    public WebElement userEmailInput2_loc;
// all locator should be true => AND
    @FindBys({
            @FindBy(css = "#email"),
            @FindBy(name = "email")
    })public WebElement userEmailInput3_loc;


    public void login(){
        String userEmail= ConfigurationReader.get("userEmail");
        String password=ConfigurationReader.get("password");
        userEmailInput_loc.sendKeys(userEmail);
        passwordInput_loc.sendKeys(password);
        loginBtn_loc.click();
    }
    public void loginManuel(String userEmail,String password){
        userEmailInput_loc.sendKeys(userEmail);
        passwordInput_loc.sendKeys(password);
        loginBtn_loc.click();

    }
    public void logOut(){
//my example
        System.out.println("on logout page");
        Driver.get().get("https://www.krafttechexlab.com/logout");
        Driver.get().get("https://www.krafttechexlab.com/login");
    }
}
