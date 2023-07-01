package com.pageactions;
import com.pageobjects.CourseSearchPage;
import com.pageobjects.HomePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class CourseSearchActions extends BasePageActions {

    public CourseSearchActions(WebDriver driver) {super(driver);}


    public void verifySearchResults() {
       isDisplayed(CourseSearchPage.COURSE_NAME);
    }

    public void clickOnDeliveryFilter() {
        click(CourseSearchPage.COURSE_NAME);
    }

    public void selectOption(String deliveryOption) {
        selectOptionFromDropdown(CourseSearchPage.COURSE_NAME,deliveryOption);
    }

    public void VerifySearchResultsHasDeliveryOption(String deliveryOption) {
        isDisplayed(CourseSearchPage.COURSE_NAME);
    }
}

