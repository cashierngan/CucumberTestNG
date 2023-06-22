package nganxd.hooks;

import nganxd.common.BaseTest;
import io.cucumber.java.*;
import nganxd.drivers.DriverManager;
import nganxd.helper.PropertiesHelper;
import nganxd.util.Log;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class CucumberHooks {
    @BeforeAll
    public static void beforeAll() {
        PropertiesHelper.loadAllFiles();
    }

    @AfterAll
    public static void afterAll() {

    }

    @Before
    public void beforeScenario() {
//        BaseTest.createDriver();
    }

    @After
    public void afterScenario(Scenario scenario) {
        BaseTest.closeDriver();
    }

    @BeforeStep
    public void beforeStep(Scenario scenario) {
        Log.info(scenario.getName());
    }

    @AfterStep
    public void afterStep(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Screenshot Failed");
        }
    }

}
