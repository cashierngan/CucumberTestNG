package nganxd.stepdifinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import nganxd.drivers.DriverManager;
import nganxd.helper.PropertiesHelper;
import nganxd.util.WebUI;
import org.openqa.selenium.By;

import static nganxd.constants.constantGlobal.URL;

public class StepsLoginCRM {
    @Given("User navigate to Login {string} Page")
    public void iAmOnTheLoginPage(String page) {
        WebUI.openURL(PropertiesHelper.getValue("URL"));
    }

    @And("User click on the Login button")
    public void iClickTheLoginButton() {
        WebUI.clickElement(By.xpath("//button[normalize-space() = 'Login']"));
    }

    @When("User input email {string} and {string}")
    public void enteringEmailAnd(String arg0, String arg1) {
        WebUI.setText(By.xpath("//input[@id='email']"), arg0);
        WebUI.setText(By.xpath("//input[@id='password']"), arg1);
    }

    @Then("The Customers page should be displayed")
    public void iShouldBeTakenToTheCustomersPage() {
        WebUI.waitForElementVisible(By.xpath("//span[normalize-space()='Customers']"));
    }

    @Then("The invalid message {string} should be displayed")
    public void shouldBeDisplayed(String message) {
        WebUI.waitForElementVisible(By.xpath("//div[normalize-space()='" + message + "']"));
    }


    @Then("The verification message should be displayed")
    public void theVerifyMessageShouldBeDisplayed() {
        System.out.println("________________________________________________-");
        System.out.println(DriverManager.getDriver().findElement(By.id("email")).getAttribute("validationMessage"));
        WebUI.verifyEquals(DriverManager.getDriver().findElement(By.id("email")).getAttribute("validationMessage"), "Please include an '@' in the email address. 'admin' is missing an '@'.");
    }
}