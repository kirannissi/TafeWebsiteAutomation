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

    @Then("I verify Results have relevant skills")
    public void i_verify_results_have() {
        courseSearchActions.verifySearchResults();
    }
    @Then("I click on delivery filter")
    public void i_click_on_delivery_filter() {

        courseSearchActions.clickOnDeliveryFilter();
    }

    @And("select {string} from the options")
    public void select_from_the_options(String deliveryOption) {
        courseSearchActions.selectOption(deliveryOption);
    }

    @Then("I have seen deivery as {string} from results")
    public void i_have_seen_deivery_as_from_results(String deliveryOption) {
        courseSearchActions.VerifySearchResultsHasDeliveryOption(deliveryOption);
    }
}
