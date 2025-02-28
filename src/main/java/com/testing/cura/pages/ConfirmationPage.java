package com.testing.cura.pages;

import com.testing.cura.base.BasePage;
import org.openqa.selenium.By;

public class ConfirmationPage extends BasePage {

    public ConfirmationPage() {
        super();
    }
    By facility = By.xpath("//h2[normalize-space()='Appointment Confirmation']");
    public String confirmationPage()
    {
       return getElement(facility).getText();
    }
}

