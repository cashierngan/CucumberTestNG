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
//        System.out.println("================ BEFORE ALL ================");
        PropertiesHelper.loadAllFiles();
    }

    @AfterAll
    public static void afterAll() {
//        System.out.println("================ AFTER ALL ================");

    }

    @Before
    public void beforeScenario() {
//        System.out.println("================ beforeScenario ================");
        BaseTest.createDriver();
    }

    @After
    public void afterScenario(Scenario scenario) {
//        System.out.println("================ afterScenario ================");
        BaseTest.closeDriver();
    }

    @BeforeStep
    public void beforeStep(Scenario scenario) {
//        System.out.println("================ BeforeStep ================");
        Log.info(scenario.getName());
    }

    @AfterStep
    public void afterStep(Scenario scenario) {
//        System.out.println("================ AfterStep ================");
        //validate if scenario has failed then Screenshot
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Screenshot Failed");
            //AllureManager.saveScreenshotPNG();
        }
    }

}
