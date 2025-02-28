package com.testing.cura.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.util.Objects;

import static com.testing.cura.driver.DriverManager.driver;

public class DriverMangerTL {
    public static final ThreadLocal<WebDriver> dr = new ThreadLocal<>();

    public static void setDriver(WebDriver driverRef) {
        dr.set(driverRef);
    }

    public static WebDriver getDriver() {
       return dr.get();


    }

    public static void unLoad() {
        dr.remove();
    }

    public static void init() {
        if (Objects.isNull(DriverMangerTL.getDriver())) {
            ChromeOptions options=new ChromeOptions();
            options.addArguments("--guest");
            options.addArguments("--remote-allow-origins=*");
            WebDriver driver=new ChromeDriver(options);
            setDriver(driver);


        }
    }


    public static void down() {
        if (Objects.nonNull(DriverMangerTL.getDriver())) {

            getDriver().quit();
            unLoad();
        }
    }
}
