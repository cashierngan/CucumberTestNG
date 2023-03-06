package stepdifinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepsLoginCMS {
    @Given("navigation to Login page {string}")
    public void navigationToLoginPage(String arg0) {
    }
    @When("enter email {string} and password {string}")
    public void enterEmailAndPassword(String arg0, String arg1) {
    }

    @And("click on Login button")
    public void clickOnLoginButton() {
    }

    @Then("redirect to admin page {string}")
    public void redirectToAdminPage(String arg0) {
    }
}
