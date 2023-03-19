package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@CucumberOptions(
        features = "src/test/resources/features/Login/Categories.feature",
        //glue có nhiều thì cách nhau dấu ,
        glue = "stepdifinitions",
        plugin = {"pretty", "html:target/cucumber-html-report.html"}

)

    @Test
    public class TestRunnerCategoryCMS extends AbstractTestNGCucumberTests {

    }
