package com.testing.cura.pages;

import com.testing.cura.base.BasePage;
import com.testing.cura.driver.DriverMangerTL;
import com.testing.cura.utils.PropertyReader;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    public LoginPage() {
        super();
    }

    By makeappointment = By.id("btn-make-appointment");
    By username = By.id("txt-username");
    By password = By.id("txt-password");
    By login = By.id("btn-login");

    By invalidMessage = By.xpath("//p[@class='lead text-danger']");
    public LoginPage validLoginCura() {
        custom_waits();
        clickElement(makeappointment);
        custom_waits();
        enterInput(username, PropertyReader.readKey("validUsername"));
        enterInput(password, PropertyReader.readKey("validPassword"));
        clickElement(login);
        return this;
    }

    public LoginPage openURL(String url) {
        DriverMangerTL.getDriver().get(url);
        return this;
    }

    public String invalidLoginCura() {
        clickElement(makeappointment);
        custom_waits();
        custom_waits();enterInput(username, PropertyReader.readKey("invalidUsername"));
        enterInput(password, PropertyReader.readKey("invalidPassword"));
        clickElement(login);
        custom_waits();
         return getElement(invalidMessage).getText();

    }

    public AppointmentPage afterLogin() {
        return new AppointmentPage();


    }

}
