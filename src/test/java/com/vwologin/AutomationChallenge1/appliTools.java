package com.vwologin.AutomationChallenge1;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
@Test
public class appliTools {
    WebDriver driver;
    public void AppliTools(){
        EdgeOptions options=new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        WebDriver driver =new EdgeDriver();
        driver.get("https://demo.applitools.com/");

        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        WebElement username1 = driver.findElement(By.id("username"));
        username1.sendKeys("Admin");

        WebElement password =driver.findElement((By.id("password")));
        password.sendKeys("Password@123");

        WebElement button =driver.findElement(By.id("log-in"));
        button.click();

        driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
//table[@class="table table-padded"]/tbody/tr/td[5]/span
        List <WebElement> row =driver.findElements(By.xpath("//table[@class=\"table table-padded\"]/tbody/tr"));

        int positiveNum =0;
        int negativeNum=0;
        int sum=0;

        for(WebElement element : row){
            String value =element.getText();
            try {
                String digitNum = value.replaceAll("[^\\d.-]", "");
                if (!digitNum.isEmpty()) {
                    int number = Integer.parseInt(digitNum);
                    if (number >= 0) {
                        positiveNum += number;
                    } else {
                        negativeNum += number;
                    }
                }
                driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
            }catch (NumberFormatException e){
                System.out.println("if non number count" +value);

            }
            System.out.println("sum of positive number" +positiveNum);
            System.out.println("sum of negative number" +negativeNum);
            sum=positiveNum+negativeNum;
            System.out.println(sum);

            driver.quit();

        }
    }
}
