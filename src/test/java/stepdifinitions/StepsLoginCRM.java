package stepdifinitions;

import common.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ngan.xd.constants.ConstantGlobal;
import ngan.xd.driver.DriverManager;
import org.openqa.selenium.By;

public class StepsLoginCRM {
    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        BaseTest.createDriver("chrome");
        DriverManager.getDriver().get(ConstantGlobal.URL);
    }

    @When("I enter my username and password")
    public void iEnterMyUsernameAndPassword() {
        DriverManager.getDriver().findElement(By.xpath("//input[@id='email']")).sendKeys(ConstantGlobal.USERNAME);
        DriverManager.getDriver().findElement(By.xpath("//input[@id='password']")).sendKeys(ConstantGlobal.PASSWORD);
    }

    //
    @And("I click the Login button")
    public void iClickTheLoginButton() {
        DriverManager.getDriver().findElement(By.xpath("//button[normalize-space() = 'Login']")).click();
    }

    @Then("I should be taken to the Dashboard page")
    public void iShouldBeTakenToTheDashboardPage() {
        BaseTest.closeDriver();
    }
//
//    @And("I should see the {string} menu")
//    public void iShouldSeeTheMenu(String arg0) {
//    }

}
