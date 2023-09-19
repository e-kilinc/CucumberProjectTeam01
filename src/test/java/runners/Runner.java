package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty",
        "html:target/default-cucumber-reports.html",
        "json:target/json-reports/cucumber.json",
        "junit:target/xml-report/cucumber1.xml",
        "rerun:TestOutput/failed_scenario.txt"},

        features = "src/test/resources",
        glue = {"stepdefinitions"},
        tags = "@E2E_US13",
        dryRun = false
)

public class Runner {

}
