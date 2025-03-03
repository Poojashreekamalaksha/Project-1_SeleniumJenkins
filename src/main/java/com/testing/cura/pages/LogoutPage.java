package com.testing.cura.pages;

import com.testing.cura.base.BasePage;
import org.openqa.selenium.By;

public class LogoutPage extends BasePage {
    public LogoutPage() {
        super();
    }
    By menu = By.id("menu-toggle");
    By logout=By.linkText("Logout");
    public void logOutPage()
    {
        custom_waits();
        clickElement(menu);
       clickElement(logout);
    }
}

