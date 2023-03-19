package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@CucumberOptions(
        features = "src/test/resources/features/Customers/DeleteCustomer.feature",
        glue = {"stepdifinitions", "hooks"},
        plugin = {"pretty", "html:target/cucumber-html-report.html"}
)
@Test
public class TestRunnerDeleteCustomers extends AbstractTestNGCucumberTests {

}