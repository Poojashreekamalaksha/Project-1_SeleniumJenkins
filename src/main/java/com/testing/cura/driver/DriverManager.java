package com.testing.cura.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class DriverManager {

    static WebDriver driver;


    public static void init() {
        if (driver == null) {
            driver = new ChromeDriver();
        }
    }


   public static void down() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
    public static WebDriver getDriver()
    {
        return driver;
    }

}