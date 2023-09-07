package com.krafttechnologie.pages;

import com.krafttechnologie.utilities.ConfigurationReader;
import com.krafttechnologie.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class MyProfilePage extends BasePage{
    @FindBy (id = "email")
    public WebElement emailTextBar_loc;
    @FindBy (id = "yourPassword")
    public WebElement passswordTextBar_loc;
    @FindBy(xpath = "//button[text()='Login']")
    public WebElement loginButton_loc;

    @FindBy(css = "form textarea#about")
    public WebElement aboutTextArea_loc;
    @FindBy(id="company")
    public WebElement companyTextBar_loc;
    @FindBy(css = "#job option")
    public List<WebElement> jobOptions_loc;
    @FindBy(css = "#website")
    public WebElement websiteTextBar_loc;
    @FindBy(id = "location")
    public WebElement locationTextBar_loc;
    @FindBy(id = "skills")
    public WebElement skillsTextBar_loc;
    @FindBy(xpath = "//button[text()='Save Changes']")
    public WebElement saveChangesBtn_loc;
    @FindBy(css = "div [class=\"alert alert-success bg-success text-light border-0 alert-dismissible fade show\"]")
    public WebElement profileUpdatedAlertBox_loc;
    @FindBy(id = "job")
    public WebElement jobsDropDownMenu_loc;




    public void login(){
        String email= ConfigurationReader.get("userEmail");
        String password=ConfigurationReader.get("password");
        emailTextBar_loc.sendKeys(email);
        passswordTextBar_loc.sendKeys(password);
        loginButton_loc.click();

    }
    public WebElement navigateModuleMenu(String tab){
        String tabLoc="//span[text()='"+tab+"']";
        return Driver.get().findElement(By.xpath(tabLoc));
    }

    public WebElement navigateModuleMenu(String tab,String module){
        String tabLoc="//span[text()='"+tab+"']";
        Driver.get().findElement(By.xpath(tabLoc)).click();
        String menuLoc=tabLoc+"/../..//span[text()='"+module+"']";
        return Driver.get().findElement(By.xpath(menuLoc));
    }
    public WebElement navigateModuleButton(String btnName){
        return Driver.get().findElement(By.xpath("//button[text()='"+btnName+"']"));
    }
    public void enterNewValue(WebElement element,String value){
        element.clear();
        element.sendKeys(value);
    }
    public void selectJob(String jobName){
        Select select=new Select(jobsDropDownMenu_loc);
        select.selectByValue(jobName);
    }public String selectJob(){
        Select select=new Select(jobsDropDownMenu_loc);
       return select.getFirstSelectedOption().getText();
    }
}
