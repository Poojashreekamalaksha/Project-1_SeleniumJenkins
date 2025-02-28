package com.testing.cura.pages;

import com.testing.cura.base.BasePage;
import com.testing.cura.utils.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class AppointmentPage extends BasePage {
    public AppointmentPage() {
        super();
    }

    By facility = By.id("combo_facility");
    By readmission = By.id("chk_hospotal_readmission");
    By healthcareProgram = By.xpath("(//label[@class='radio-inline'])[3]");
    By visitDate = By.id("txt_visit_date");
    By comment = By.id("txt_comment");
    By bookAppointment = By.id("btn-book-appointment");

    public void bookAppointment() {

        Select select = new Select(getElement(facility));
        select.selectByVisibleText(PropertyReader.readKey("facilityName"));
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
