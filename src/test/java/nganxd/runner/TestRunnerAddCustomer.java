package nganxd.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@CucumberOptions(
        features = "src/test/resources/features/Customers/AddCustomer.feature",
        glue = {"nganxd/stepdifinitions", "nganxd/hooks"},
        plugin = {"pretty", "html:target/cucumber-html-report.html", "html:target/cucumber-reports/LoginCMS.html",
                "json:target/cucumber-reports/LoginCMS.json", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
        tags = "@InvalidAddCustomers"
)
@Test
public class TestRunnerAddCustomer extends AbstractTestNGCucumberTests{
}