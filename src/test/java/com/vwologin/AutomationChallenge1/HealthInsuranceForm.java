package com.vwologin.AutomationChallenge1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class HealthInsuranceForm {
    WebDriver driver = new EdgeDriver();
    String url = "https://devmo.evervent.in";
    String url2 = "https://devmo.evervent.in/form/health-insurance-form";

    @BeforeTest
    public void setbrowser() {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--guest");
    }

    @Test
    public void start1() {
        driver.get(url+"/form/health-insurance-form");
       driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id=\"One Adult\"]")));
       /* WebElement selectAdult = driver.findElement(By.xpath("//input[@id=\"One Adult\"]"));
        selectAdult.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement SelectSon = driver.findElement(By.xpath("//input[@id=\"Son \"]"));
        SelectSon.click();*/
        WebElement AdultDOB = driver.findElement(By.xpath("//input[@id=\"1st Adult DOB\"]"));
        AdultDOB.click();
        driver.switchTo().activeElement().findElement(By.xpath("//div[@role=\"dialog\"]"));
        //WebElement select=driver.findElement(By.xpath("//div[@role=\"dialog\"]"));
        ////label[@id="1st Adult DOB-label"]
        ////button[@type="button"]
        driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement switchViewButton = driver.findElement(By.xpath("//button[@aria-label=\"calendar view is open, switch to year view\"]"));
        switchViewButton.click();
        WebElement selectYear1990=driver.findElement(By.xpath("//button[contains(@class, 'MuiPickersYear-yearButton') and text()='1990']"));
        selectYear1990.click();
        WebElement selectmonth=driver.findElement(By.xpath("//button[@aria-label='Next month']"));
        selectmonth.click();
        selectmonth.click();
        selectmonth.click();
        selectmonth.click();
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement dateButton = wait2.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[@role=\"gridcell\"][text()='3']")
        ));
        dateButton.click();
    }
    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }
}
