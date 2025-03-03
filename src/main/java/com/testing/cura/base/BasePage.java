package com.testing.cura.base;

import com.testing.cura.driver.DriverMangerTL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    public BasePage() {
    }

    //waits
    public void implicitWait() {
        DriverMangerTL.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void clickElement(By by) {
        DriverMangerTL.getDriver().findElement(by).click();
    }

    public void enterInput(By by,String key) {
        DriverMangerTL.getDriver().findElement(by).sendKeys(key);
    }


    public WebElement getElement(By key) {
        return DriverMangerTL.getDriver().findElement(key);
    }

    public void custom_waits()
    {
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public WebElement visibilityOfElementLocated(By key) {
        WebDriverWait wait = new WebDriverWait(DriverMangerTL.getDriver(), Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(key)); // Pass key directly
    }




}