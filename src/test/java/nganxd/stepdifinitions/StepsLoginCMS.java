package nganxd.stepdifinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import nganxd.hooks.TestContext;
import nganxd.utils.WebUI;
import nganxd.pages.LoginCMSPage;
import nganxd.pages.LoginPage;
import org.openqa.selenium.By;

public class StepsLoginCMS {
    TestContext testContext;
    LoginPage loginPage;
    LoginCMSPage loginCMSPage;
    public StepsLoginCMS(TestContext testContext){
        this.testContext = testContext;
        loginPage = testContext.getLoginPage();
        loginCMSPage = testContext.getLoginCMSPage();
    }
    @Given("user navigation to Login page {string}")
    public void navigationToLoginPage(String CMSPage) {
        WebUI.openURL(CMSPage);
    }
    @When("user enter email {string} and password {string}")
    public void enterEmailAndPassword(String email, String password) {
        loginPage.enterEmailAndPassword(email, password);
    }

    @And("click on Login button")
    public void clickOnLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("user redirect to admin page {string}")
    public void redirectToAdminPage(String arg0) {
        WebUI.verifyAssertTrueIsDisplayed(By.xpath("//span[normalize-space()='Dashboard']"), "Admin page is NOT displayed");
    }

    @Given("user on the login page")
    public void userOnTheLoginPage() {
        loginCMSPage.openLoginPage();
    }


    @And("click on the login button")
    public void clickOnTheLoginButton() {
    }

    @Then("user should be redirected to the admin page")
    public void userShouldBeRedirectedToTheAdminPage() {
    }

    @When("user enter an invalid username or password")
    public void userEnterAnInvalidUsernameOrPassword() {
    }

    @Then("user should see an error message")
    public void userShouldSeeAnErrorMessage() {
        WebUI.verifyAssertTrueIsDisplayed(By.xpath("//div[normalize-space()='Invalid email or password' and @class = 'text-center alert alert-danger']"), "Error message is NOT displayed");
    }

    @And("stay on the login page")
    public void stayOnTheLoginPage() {
        WebUI.verifyAssertTrueIsDisplayed(By.xpath("//h1[normalize-space()='Login']"), "Login page is NOT displayed");

    }

    @When("user leave the username field empty")
    public void userLeaveTheUsernameFieldEmpty() {
    }

    @And("enter a valid password")
    public void enterAValidPassword() {
    }

    @When("user leave the password field empty")
    public void userLeaveThePasswordFieldEmpty() {
    }

    @And("enter a valid username")
    public void enterAValidUsername() {
    }

    @And("my account has been locked")
    public void myAccountHasBeenLocked() {
    }

    @And("user have forgotten my password")
    public void userHaveForgottenMyPassword() {
    }

    @When("user click on the {string} link")
    public void userClickOnTheLink(String arg0) {
    }

    @And("enter my email address")
    public void enterMyEmailAddress() {
    }

    @And("click on the {string} button")
    public void clickOnTheButton(String arg0) {
    }

    @Then("user should receive an email with instructions to reset my password.")
    public void userShouldReceiveAnEmailWithInstructionsToResetMyPassword() {
    }
}
