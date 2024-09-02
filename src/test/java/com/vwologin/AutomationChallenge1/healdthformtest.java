package com.vwologin.AutomationChallenge1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class healdthformtest {
    WebDriver driver = new EdgeDriver();
    String url = "https://devmo.evervent.in/form/health-insurance-form";
    String url2 = "https://devmo.evervent.in/form/health-insurance-form";

    @BeforeTest
    public void setbrowser() {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--guest");
    }

   @Test
    public void start1() {
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement adult = driver.findElement(By.xpath("//input[@id=\"One Adult\"]"));
        adult.click();
        // WebElement child =driver.findElement(By.xpath("//input[@id=\"Two Adults\"]"));
        //child.isSelected();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement SelectSon = driver.findElement(By.xpath("//input[@id=\"Son \"]"));
        SelectSon.click();
        WebElement DateofBirth = driver.findElement(By.xpath("//input[@id=\"1st Adult DOB\"]"));
        driver.switchTo().frame(driver.getWindowHandle());
        ////div[@role="dialog"]
       //WebElement selectyear=driver.findElement(By)
        DateofBirth.sendKeys("01/01/1980");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
       /* //WebElement DateofBirth2 = driver.findElement(By.xpath("//input[@id=\"2nd Adult DOB\"]"));
        //DateofBirth2.sendKeys("01/01/2010");
        //id="2nd Adult DOB"
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement DateofBirth3 = driver.findElement(By.xpath("//input[@id=\"Child 1 DOB\"]"));
        DateofBirth3.sendKeys("01/01/1980");*/
        WebElement Gender = driver.findElement(By.xpath("//div[@id=\"Gender\"]"));
        Gender.click();
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
        ////li[@data-value="M"]
        WebElement selectMale = driver.findElement(By.xpath("//li[@data-value=\"M\"]"));
        selectMale.click();
        driver.manage().timeouts().pageLoadTimeout(2000,TimeUnit.SECONDS);
        WebElement button = driver.findElement(By.xpath("//button[@id=\"Continue\"]"));
       // button.click();
    }
@Test
    public void start2() {
        driver.get(url);
           //WebElement child =driver.findElement(By.xpath("//input[@id=\"Two Adults\"]"));
           WebElement child =driver.findElement(By.id("Two Adults"));
        //id="Two Adults"
            child.click();
        WebElement SelectDaughter = driver.findElement(By.xpath("//input[@id=\"Daughter \"]"));
         SelectDaughter.click();
        WebElement DateofBirth = driver.findElement(By.xpath("//input[@id=\"1st Adult DOB\"]"));
        DateofBirth.sendKeys("01/01/1980");
       WebElement Gender = driver.findElement(By.xpath("//div[@id=\"Gender\"]"));
       Gender.click();
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
    ////li[@data-value="M"]
        WebElement selectFemale = driver.findElement(By.xpath("//li[@data-value=\"F\"]"));
        selectFemale.click();
    driver.manage().timeouts().pageLoadTimeout(2000,TimeUnit.SECONDS);
    WebElement button2 = driver.findElement(By.xpath("//button[@id=\"Continue\"]"));
    driver.manage().timeouts().pageLoadTimeout(2000,TimeUnit.SECONDS);
   //  button2.click();
    }
    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }
}
