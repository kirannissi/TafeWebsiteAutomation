package com.pageobjects;

import org.openqa.selenium.By;

public class CourseSearchPage extends BasePage {

    public static final By SKILL_TITLE_XPATH = By.xpath("//h4");
    public static final By DELIVERY_FILTER_XPATH = By.xpath("//em[text()='Refine results by method of course delivery.']/../..");
    public static final By DELIVERY_METHOD_XPATH = By.xpath("//p[contains(text(),'On campus')]");

    public static By getFilterTypeXPath(String filterType) {
        return By.xpath("//input[@id = '"+filterType+"']");
    }
}
