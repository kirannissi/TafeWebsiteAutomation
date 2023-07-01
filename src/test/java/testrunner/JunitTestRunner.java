package testrunner;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "@all",
        features = {"src/test/resources/appfeatures"},
        glue = {"stepdefs","apphooks"},
        plugin = {"pretty",
                "html:target/test-output/cucumber-reports/CucumberReport.html"
        }
)
public class JunitTestRunner {
}

