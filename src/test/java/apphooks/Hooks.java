package apphooks;

import com.helpers.ConfigReader;
import com.helpers.DriverFactory;
import com.pageactions.BasePageActions;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static com.pageactions.BasePageActions.testData;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class Hooks {
    private final Logger logger = LoggerFactory.getLogger(BasePageActions.class);
    private WebDriver driver;
    DriverFactory driverFactory = new DriverFactory();
    private final ConfigReader configReader = new ConfigReader();
    Properties properties = configReader.init_prop();
    BasePageActions basePageActions = new BasePageActions(driver);
    private int currentStepNumber;

    @Before(order = 0)
    public void startDriver(){
        System.out.println("-----Test Started-------");
        driver = driverFactory.initDriver(properties.getProperty("browser"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        logger.info("Driver initialised successfully");
        /*Map<String, String> data = new HashMap<>();
        testData.put("Data", data);*/
    }

    @BeforeStep
    public void beforeCucumberStep(Scenario scenario){
        /*List<String> stepValidationList = new ArrayList<String>();
        testData.put("stepValidationList", stepValidationList);*/
        currentStepNumber++;
        System.out.println("-------------*****************--------------------");
        System.out.println("Running Step Number: " + currentStepNumber);

    }

    @AfterStep
    public void captureStep(Scenario scenario){
        String screenshotName = scenario.getName().replaceAll(" ", "_");
        byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(sourcePath, "image/png", screenshotName);

        /*List<String> stepValidationList = (ArrayList<String>) testData.get("stepValidationList");
        if(!stepValidationList.isEmpty()){
            scenario.attach(stepValidationList.toString(), "text/plain", "Step Validations: ");
            testData.put("stepValidationList", new ArrayList<String>());
        }*/

    }

    @After(order = 0)
    public void tearDown(Scenario scenario){
        /*if(scenario.isFailed()){
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath, "image/png", screenshotName);
        }*/
        String testData = "";

        Map<String, String> data = BasePageActions.testData;

        for (Map.Entry<String, String> entry : data.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            testData = testData+key+" - "+value+", ";
        }
        scenario.attach(testData, "text/plain", "Test Data: ");
    }

    @After(order = 1)
    public void quitBrowser(){

        logger.info("-----------------------*********************----------------------------");
        logger.info("Test Data used in this test case:");

        Map<String, String> data = BasePageActions.testData;

        for (Map.Entry<String, String> entry : data.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            System.out.println(key+" - "+value);

        }
        driver.quit();
        logger.info("-----------------------*********************----------------------------");
        logger.info("Browser closed successfully");
    }


}
