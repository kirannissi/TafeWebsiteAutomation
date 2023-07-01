package com.pageactions;
import com.pageobjects.CourseSearchPage;
import com.pageobjects.HomePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CourseSearchActions extends BasePageActions {

    public CourseSearchActions(WebDriver driver) {super(driver);}


    public void validateSearchResults(String skill) {
        WebElement element = findElement(CourseSearchPage.SKILL_TITLE_XPATH);
        Assert.assertEquals(skill,element.getText().trim());
    }

    public void clickDeliveryFilter(String filter) {
        if(filter.equals("Delivery")){
            jsForceClick(CourseSearchPage.DELIVERY_FILTER_XPATH);
        }else{
            customLogger("error", "Invalid filter type. Please update the test data and try again");
        }
    }

    public void selectFilterType(String filterType) {

        if(filterType.equals("On campus")){
            jsForceClick(CourseSearchPage.getFilterTypeXPath("on-campus"));
        }
    }

    public void ValidateFilterResults(String filterType) {
        WebElement element = findElement(CourseSearchPage.DELIVERY_METHOD_XPATH);
        Assert.assertEquals(filterType,element.getText().trim());
    }
}

