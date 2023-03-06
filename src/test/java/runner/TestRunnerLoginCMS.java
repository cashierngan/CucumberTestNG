package runner;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.Test;

@CucumberOptions(
        features = "src/test/resources/features/Login/LoginCMS.feature",
        //glue có nhiều thì cách nhau dấu ,
        glue = "stepdifinitions",
        plugin = {"pretty", "html:target/cucumber-html-report.html"},
        tags = "@success and ... or ..."
)
@Test
public class TestRunnerLoginCMS extends AbstractTestNGCucumberTests {

}