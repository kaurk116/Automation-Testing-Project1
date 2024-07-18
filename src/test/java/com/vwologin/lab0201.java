package com.vwologin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class lab0201 {
    @Test
    public void vwologin(){
        WebDriver driver=new EdgeDriver();
        driver.navigate().to("https://www.google.com");
    }
}
