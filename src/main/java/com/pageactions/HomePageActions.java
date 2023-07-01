package com.pageactions;

import com.pageobjects.HomePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class HomePageActions extends BasePageActions{

    public HomePageActions(WebDriver driver){
        super(driver);
    }

    public void getUrl() throws IOException {
        driver.get(properties.getProperty("url"));
        customWait(30,HomePage.HEADER_SEARCH);
    }


    public void clickSearchButton() {
        jsForceClick(HomePage.HEADER_SEARCH);

    }

    public void enterCourseName(String courseName) {
        clearAndSetField(HomePage.INPUT_SEARCH,courseName);
        pressKeyboardButton(HomePage.INPUT_SEARCH, Keys.ENTER);
    }
}
