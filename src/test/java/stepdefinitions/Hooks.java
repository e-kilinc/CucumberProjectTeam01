package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.ConfigReader;
import utilities.Driver;

import java.time.Duration;

import static baseUrl.ManagementOnSchoolBaseUrl.setup;


public class Hooks {
    @Before
    public void setUp() throws Exception {
            setup();
            Driver.getDriver().get(ConfigReader.getProperty("homePageUrl"));
            Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            Driver.getDriver().manage().window().maximize();
        }



    @After
    public void tearDown(Scenario scenario) throws Exception {
        if (scenario.isFailed()) {
            TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
            scenario.attach(ts.getScreenshotAs(OutputType.BYTES), "image/jpeg", "scenario_" + scenario.getName());
            //Driver.closeDriver();
        }


    }

}
