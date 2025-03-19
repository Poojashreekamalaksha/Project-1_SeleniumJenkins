package com.testing.cura.pages;

import com.testing.cura.base.BasePage;
import com.testing.cura.utils.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class AppointmentPage extends BasePage {
    public AppointmentPage() {
        super();
    }

    By facility = By.xpath("//select[@id='combo_facility']");

    private By readmission = By.id("chk_hospotal_readmission");
    private By healthcareProgram = By.xpath("(//label[@class='radio-inline'])[3]");
    private By visitDate = By.id("txt_visit_date");
    private By comment = By.id("txt_comment");
    private By bookAppointment = By.id("btn-book-appointment");

    public void bookAppointment() {
        visibilityOfElementLocated(facility);
        Select select = new Select(getElement(facility));

        select.selectByValue(PropertyReader.readKey("facilityName"));
        custom_waits();
        clickElement(readmission);
        clickElement(healthcareProgram);
        enterInput(visitDate, PropertyReader.readKey("visitDate"));
        enterInput(comment, PropertyReader.readKey("comment"));
        clickElement(bookAppointment);
    }
    public ConfirmationPage afterAppointment () {
        return new ConfirmationPage();
    }

}
