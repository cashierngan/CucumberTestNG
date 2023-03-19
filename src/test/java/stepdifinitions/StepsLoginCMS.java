package stepdifinitions;

import common.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ngan.xd.utils.WebUI;
import org.testng.annotations.BeforeClass;
import pages.LoginPage;

import static ngan.xd.constants.ConstantGlobal.URL;

public class StepsLoginCMS {
    public LoginPage loginPage;
    @Given("navigation to Login page {string}")
    public void navigationToLoginPage(String arg0) {
        BaseTest.createDriver("chrome");
        WebUI.openURL(URL);
    }
    @When("enter email {string} and password {string}")
    public void enterEmailAndPassword(String email, String password) {
        loginPage = new LoginPage();
        loginPage.enterEmailAndPassword(email, password);
    }

    @And("click on Login button")
    public void clickOnLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("redirect to admin page {string}")
    public void redirectToAdminPage(String arg0) {
    }
}
