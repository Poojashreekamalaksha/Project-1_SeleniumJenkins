package com.testing.cura.tests;

import com.testing.cura.base.BaseTest;
import com.testing.cura.pages.AppointmentPage;
import com.testing.cura.pages.ConfirmationPage;
import com.testing.cura.pages.LoginPage;
import com.testing.cura.pages.LogoutPage;
import com.testing.cura.utils.PropertyReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CuraTest extends BaseTest {

    private static final Logger logger = LogManager.getLogger(CuraTest.class);
    @Test
    public void test01_invalidLoginTest() {
        logger.info("Initialized driver , launched URL and tested invalid login");
        new LoginPage().openURL(PropertyReader.readKey("url")).invalidLoginCura();
        logger.info("Asserted invalid login error message");
        Assert.assertEquals(new LoginPage().invalidLoginCura(), PropertyReader.readKey("errorMessage"));


    }

    @Test
    public void test02_validLoginTest() {
        logger.info("Initialized driver , launched URL and tested valid login");
        new LoginPage().openURL(PropertyReader.readKey("url")).validLoginCura();


    }

    @Test
    public void test03_appointmentTest() {
        logger.info("Validated book appointment page");
        new LoginPage().openURL(PropertyReader.readKey("url")).validLoginCura();
        new AppointmentPage().bookAppointment();
    }

    @Test
    public void test04_confirmationTest() {
        logger.info("Validated confirmation page");
        new LoginPage().openURL(PropertyReader.readKey("url")).validLoginCura();

        new AppointmentPage().bookAppointment();

        ConfirmationPage cp = new ConfirmationPage();
        Assert.assertEquals(cp.confirmationPage(), PropertyReader.readKey("ConfirmationMessage"));

    }

    @Test
    public void test05_logOutPage() {
        logger.info("Validated logout page");
        new LoginPage().openURL(PropertyReader.readKey("url")).validLoginCura();

        new AppointmentPage().bookAppointment();


        new LogoutPage().logOutPage();

    }
}
