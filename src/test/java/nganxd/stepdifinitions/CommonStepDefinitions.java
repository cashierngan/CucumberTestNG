package nganxd.stepdifinitions;

import nganxd.hooks.TestContext;

import io.cucumber.java.en.Given;
import nganxd.pages.CommonPage;
import nganxd.pages.LoginCRMPage;

public class CommonStepDefinitions {
    TestContext testContext;
    LoginCRMPage loginCRMPage;
    CommonPage commonPage;

    public CommonStepDefinitions(TestContext testContext) {
        this.testContext = testContext;
        loginCRMPage = testContext.getLoginCRMPage();
        commonPage = testContext.getCommonPage();
    }

    @Given("user logged in the CRM system with {string} role")
    public void userLoggedInTheCRMSystemWithRole(String arg0) {
        loginCRMPage = new LoginCRMPage();
        loginCRMPage.login("admin@example.com", "123456");
    }

//    @Given("user logged in the CMS system with {string} role")
//    public void userLoggedInTheCMSSystemWithRole(String roleName) {
//        loginCMSPage.loginAdminRole();
//    }
//
//    @Then("the message {string} displays")
//    public void theMessageDisplays(String message) {
//        Assert.assertEquals(commonPage.getMessageNotify(), message, "Message not match.");
//    }
//
//    @And("user should see the notification displays")
//    public void userShouldSeeTheNotificationDisplays() {

//    }
}
