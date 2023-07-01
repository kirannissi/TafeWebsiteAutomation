package stepdefs;

import com.helpers.DriverFactory;
import com.pageactions.HomePageActions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import java.io.IOException;

public class HomeSteps {

    HomePageActions homePageActions = new HomePageActions(DriverFactory.getDriver());

    @Given("I navigate to tafe website")
    public void i_navigate_to_tafe_website() throws IOException {
        homePageActions.getUrl();
    }

    @And("^I click on search button on right top corner$")
    public void i_click_on_search_button_on_right_top_corner () {
        homePageActions.clickSearchButton();
    }
    @Then("^I enter course name as (.*) and click enter$")
    public void i_enter_course_name_as_and_click_enter(String courseName) {
        homePageActions.enterCourseName(courseName);
    }

}
