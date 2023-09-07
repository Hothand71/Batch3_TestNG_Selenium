package com.krafttechnologie.tests.pratices;

import com.krafttechnologie.utilities.BrowserUtils;
import com.krafttechnologie.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class pratice05 {
    @Test
    public void checkBoxBot() {
    /*    Driver.get().get("https://checkboxrace.com/");
        for (WebElement element : Driver.get().findElements(By.xpath("//input"))) {
           BrowserUtils.clickWithJS(element);

        }
        BrowserUtils.waitFor(10);
*/      Driver.get().get("https://checkbox.toys/catch/");
        Driver.get().manage().window().maximize();
        WebElement startBtn = Driver.get().findElement(By.cssSelector("button[class='startButton']"));
        BrowserUtils.clickWithJS(startBtn);
        BrowserUtils.waitFor(3);
        for (WebElement checkboxes : Driver.get().findElements(By.xpath("//div[@class='checkboxes']/input"))) {
            BrowserUtils.clickWithJS(checkboxes);
        }
        BrowserUtils.waitFor(10);
        Driver.get().quit();
    }

}
