package hooks;

import common.BaseTest;
import io.cucumber.core.gherkin.Step;
import io.cucumber.java.*;
import ngan.xd.driver.DriverManager;
import ngan.xd.helpers.CaptureHelpers;
import ngan.xd.helpers.PropertiesHelpers;
import ngan.xd.utils.Log;

public class CucumberHooks {
    @BeforeAll
    public static void beforeAll() {
//        System.out.println("================ BEFORE ALL ================");
        PropertiesHelpers.loadAllFiles();
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
            CaptureHelpers.takeScreenshot(scenario.getName());
        }
    }
}
