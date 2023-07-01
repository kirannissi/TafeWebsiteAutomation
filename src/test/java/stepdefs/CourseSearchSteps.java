package stepdefs;
import com.helpers.DriverFactory;
import com.pageactions.CourseSearchActions;
import com.pageactions.HomePageActions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import java.io.IOException;

public class CourseSearchSteps {

    CourseSearchActions courseSearchActions = new CourseSearchActions(DriverFactory.getDriver());

    @Then("^I validate the results with (.*)$")
    public void i_validate_the_results_with_advanced_barista_skills(String skill) {
        courseSearchActions.validateSearchResults(skill);
    }

    @Then("^I select a (.*)$")
    public void i_select_a(String filter) {
        courseSearchActions.clickDeliveryFilter(filter);
    }

    @Then("^I select (.*) from the options$")
    public void i_select_filter_type_from_the_options(String filterType) {
        courseSearchActions.selectFilterType(filterType);
    }

    @Then("^I validate the (.*) from results$")
    public void i_validate_the_filter_type_from_results(String filterType) {
        courseSearchActions.ValidateFilterResults(filterType);
    }
}
