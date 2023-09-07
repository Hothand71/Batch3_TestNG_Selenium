package com.krafttechnologie.tests.pratices;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Random;

public class Pratice01 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");//step1 Launch browser
        driver.manage().window().maximize();
        Random rd=new Random();
        int randomNumber=rd.nextInt(1,101);

       driver.get("https://10minutemail.com/");
        Thread.sleep(1000);
        WebElement tenMinuteMail=driver.findElement(By.id("mail_address"));
        System.out.println(tenMinuteMail.getAttribute("value"));
        String usMail="example";//tenMinuteMail.getAttribute("value");

        driver.get("https://randomwordgenerator.com/name.php");
        Thread.sleep(1000);
        WebElement randomNameGeneratorName=driver.findElement(By.xpath("//span[@class='support-sentence']"));
        String[] nameGeneratorArry=randomNameGeneratorName.getText().split(" ");
        String usName=nameGeneratorArry[0];
        String usSurname=nameGeneratorArry[1];
        System.out.println(usName);
        System.out.println(usSurname);

        /*driver.get("https://passwordsgenerator.net/");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[@class='button GenerateBtn']")).click();
        WebElement randomPasswordGenerator=driver.findElement(By.id("final_pass"));*/
        String usPassword="123456";//randomPasswordGenerator.getText();
        System.out.println("usPassword = " + usPassword);
        Thread.sleep(1000);

        driver.get("http://automationexercise.com");//step2  Navigate to url 'http://automationexercise.com'
        WebElement homeLabelButton=driver.findElement(By.xpath("//a[@href='/' and contains(@style,'color')]"));
        if (homeLabelButton.getAttribute("style").contains("orange")){
            System.out.println("On the Home page PASS");//step3 Verify that home page is visible successfully
        } else System.out.println("On the Home page Fail!");
        WebElement loginLabelButton=driver.findElement(By.xpath("//a[@href='/login']"));
        loginLabelButton.click();//step4 Click on 'Signup / Login' button
        Thread.sleep(1000);
        WebElement newUserSignUpLabel=driver.findElement(By.xpath("//h2[text()='New User Signup!']"));
        if (newUserSignUpLabel.getText().equals("New User Signup!")){
            System.out.println("New User Signup! is visible Pass ");}
        else {System.out.println("New User Signup! is not visible Fail! ");}
        WebElement inputNameBar=driver.findElement(By.xpath("//input[@name='name']"));
        WebElement inputMailBar=driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
        WebElement signUpButton=driver.findElement(By.xpath("//button[@data-qa='signup-button']"));
        Thread.sleep(1000);
        inputNameBar.sendKeys(usName);
        inputMailBar.sendKeys(usMail);
        Thread.sleep(1000);
        signUpButton.click();
        Thread.sleep(1000);
        WebElement enterAccInfo=driver.findElement(By.xpath("//h2/b[1]"));
        System.out.println(enterAccInfo.getText());
        System.out.println("Enter Account Information visible check is "+(enterAccInfo.getText().equals("ENTER ACCOUNT INFORMATION")));
        WebElement maleRadius=driver.findElement(By.id("id_gender1"));
        WebElement femaleRadius=driver.findElement(By.id("id_gender2"));
        WebElement inputPasswordSignInTextBox=driver.findElement(By.id("password"));
        WebElement inputDaySignInBar=driver.findElement(By.id("days"));
        WebElement inputMonthsignInBar=driver.findElement(By.id("months"));
        WebElement inputYearsSignInBar=driver.findElement(By.id("years"));
        WebElement inputNewsletterSignInCheckBox=driver.findElement(By.id("newsletter"));
        WebElement inputOptinSignInCheckBox=driver.findElement(By.id("optin"));
        WebElement inputFirstNameSignInTextBox=driver.findElement(By.id("first_name"));
        WebElement inputLastNameSignInTextBox=driver.findElement(By.id("last_name"));
        WebElement inputCompanySignInTextBox=driver.findElement(By.id("company"));
        WebElement inputAddress1SignInTextBox=driver.findElement(By.id("address1"));
        WebElement inputcountrySignInBar=driver.findElement(By.id("country"));
        WebElement inputStateSignInTextBox=driver.findElement(By.id("state"));
        WebElement inputCitySignInTextBox=driver.findElement(By.id("city"));
        WebElement inputZipCodeSignInTextBox=driver.findElement(By.id("zipcode"));
        WebElement inputMobileNumberSignInTextBox=driver.findElement(By.id("mobile_number"));
        WebElement createAccButton=driver.findElement(By.xpath("//button[contains(text(),'Create')]"));

        if (randomNumber<50){
            maleRadius.click();
        }else {
            femaleRadius.click();
        }
      //  inputPasswordSignInTextBox.sendKeys(usPassword);

        inputDaySignInBar.sendKeys(String.valueOf(rd.nextInt(0,32)));
        inputMonthsignInBar.sendKeys("2");











    }
}
