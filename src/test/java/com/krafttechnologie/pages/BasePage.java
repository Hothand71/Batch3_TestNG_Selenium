package com.krafttechnologie.pages;

import com.krafttechnologie.utilities.BrowserUtils;
import com.krafttechnologie.utilities.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class BasePage {
    @FindBy(xpath = "//li[text()='Dashboard']")
    public WebElement dashboardMenu;
    @FindAll({
            @FindBy(xpath = "//span[@class=\"afm\"]"),
            @FindBy(css = "span[class=\"d-md-block dropdown-toggle afm\"]")
    })
    public List<WebElement> headerMenu_locators;
    @FindBy(xpath = "//span[@class=\"d-none d-md-block dropdown-toggle ps-2\"]")
    public WebElement userAccountName;
   public BasePage(){
       PageFactory.initElements(Driver.get(),this);

   }

    public WebElement navigateModule(String tab){
        String tabLoc="//span[.='"+tab+"']";
        BrowserUtils.waitForClickablility(Driver.get().findElement(By.xpath(tabLoc)),5);
        return Driver.get().findElement(By.xpath(tabLoc));


    }
   public WebElement navigateModule(String tab,String module){
      String tabLoc="//span[.='"+tab+"']";
      String moduleLoc="/../../ul//span[.='"+module+"']";
      BrowserUtils.clickWithJS(Driver.get().findElement(By.xpath(tabLoc)));
      BrowserUtils.waitForClickablility(Driver.get().findElement(By.xpath(tabLoc+moduleLoc)),5);
      return Driver.get().findElement(By.xpath(tabLoc+moduleLoc));

   }
   public WebElement navigateBtnModule(String text){
       String btnLoc="//button[.="+text+"]";
       return Driver.get().findElement(By.xpath(btnLoc));
   }
    public String getAccountName(String accountName){
       return Driver.get().findElement(By.xpath("//span[.='"+accountName+"']")).getText();
    }
public String getAccountName(){
       return userAccountName.getText();
    }



}

/**
 * Abstract class:
 * * is a restricted class that cannot be used to create objects
 * * (to access it, it must be inherited from another class).
 * Abstract method:
 * * can only be used in an abstract class,
 * * and it does not have a body.
 * * The body is provided by the subclass (inherited from).
 */