package com.vwologin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class lab0201 {
    @Test
    public void vwologin() {
        WebDriver driver = new EdgeDriver();
        driver.navigate().to("https://www.saashub.com/best-ai-tools-software");
        driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
        List<WebElement> getdata = driver.findElements(By.xpath("//div[@class=\"shrink hidden-element\"]"));
//String data=getdata.getAttribute();
        for (WebElement element : getdata) {
            String value = element.getAttribute("");
            System.out.println(value);

        }
    }
}
