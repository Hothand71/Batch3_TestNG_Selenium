package com.krafttechnologie.tests.day14_properties_singleton;

import com.krafttechnologie.utilities.ConfigurationReader;
import com.krafttechnologie.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class SingletonTest {
//Singleton singleton=new Singleton(); dont work private!



    @Test @Ignore
    public void test1() {

        String driver1=Singleton.getString();
        String driver2=Singleton.getString();
        System.out.println("driver1 = " + driver1);
        System.out.println("driver2 = " + driver2);
    }

    @Test @Ignore
    public void test2() throws InterruptedException {
        //old way
        /*WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/login");*/
        WebDriver driver = Driver.get();
        driver.get(ConfigurationReader.get("url"));
        Thread.sleep(2000);
        Driver.closeDriver();

    }

    @Test
    public void test3() throws InterruptedException {
       // WebDriver driver=WebDriverFactory.getDriver("chrome");
        WebDriver driver = Driver.get();
        driver.get("https://www.krafttechexlab.com/login");
        Thread.sleep(3000);
    }

    @Test
    public void test4() throws InterruptedException {
        //WebDriver driver=WebDriverFactory.getDriver("chrome");
        WebDriver driver = Driver.get();
        driver.get("https://www.amazon.com");
        Thread.sleep(3000);
    }
}
