package nganxd.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@CucumberOptions(
        features = "src/test/resources/features/Customers/Customer.feature",
        glue = {"nganxd/stepdifinitions", "nganxd/hooks"},
        plugin = {"pretty", "html:target/cucumber-html-report.html", "html:target/cucumber-reports/LoginCMS.html",
                "json:target/cucumber-reports/EditCustomer.json", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm", "nganxd.hooks.CucumberListener"},
        tags = "@EditCustomer"
)
@Test
public class TestRunnerEditCustomer extends AbstractTestNGCucumberTests{
}
