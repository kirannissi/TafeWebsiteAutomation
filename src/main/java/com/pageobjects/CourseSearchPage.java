package com.pageobjects;

import org.openqa.selenium.By;

public class CourseSearchPage extends BasePage {
    public static final By COURSE_NAME = By.xpath("//h4[contains(text(),'Advanced Barista Skills')]");
}
