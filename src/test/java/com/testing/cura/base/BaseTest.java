package com.testing.cura.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.testing.cura.driver.DriverMangerTL;

public class BaseTest {
    @AfterMethod
    protected void setUp() {
        DriverMangerTL.down();
    }

    @BeforeMethod
    protected void tearDown() {

        DriverMangerTL.init();
    }
}
